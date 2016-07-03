package com.gojavaonline3.dlenchuk.module05.lists;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleArrayListTest {

    private Integer[] array = new Integer[]{70, 30, 50, 20, 10, 60, 100, 40, 80, 90};
    private Integer[] sortedArray = new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    private SimpleArrayList<Integer> simpleArrayList;

    @Before
    public void setUp() throws Exception {
        simpleArrayList = new SimpleArrayList<>(new Integer[]{70, 30, 50, 20, 10, 60, 100, 40, 80, 90});
    }

    @Test
    public void getList() throws Exception {
        assertArrayEquals(array, simpleArrayList.getList());
    }

    @Test
    public void indexOf() throws Exception {
        assertEquals(-1, simpleArrayList.indexOf(-10));
        assertEquals(3, simpleArrayList.indexOf(20));
    }

    @Test
    public void addLast() throws Exception {
        assertTrue(simpleArrayList.add(110));
        assertEquals((Integer)110, simpleArrayList.getList()[simpleArrayList.getList().length - 1]);
    }

    @Test
    public void addItemByIndex() throws Exception {
        simpleArrayList.add(5, 75);
        assertEquals((Integer)75, simpleArrayList.getList()[5]);
    }

    @Test
    public void addArray() throws Exception {
        Integer[] array = new Integer[]{270, 230, 250, 220, 210, 260, 300, 240, 280, 290};
        simpleArrayList.add(array);
        assertArrayEquals(array,
                Arrays.copyOfRange(simpleArrayList.getList(), 10, simpleArrayList.getList().length));
    }

    @Test
    public void removeByIndex() throws Exception {
        assertEquals((Integer)20, simpleArrayList.remove(3));
        assertArrayEquals(new Integer[]{70, 30, 50, 10, 60, 100, 40, 80, 90}, simpleArrayList.getList());
    }

    @Test
    public void remove1() throws Exception {
        assertTrue(simpleArrayList.remove((Integer)100));
        assertArrayEquals(new Integer[]{70, 30, 50, 20, 10, 60, 40, 80, 90}, simpleArrayList.getList());
    }

    @Test
    public void length() throws Exception {
        assertEquals(10, simpleArrayList.length());
    }

    @Test
    public void bubbleSort() throws Exception {
        assertArrayEquals(sortedArray, simpleArrayList.bubbleSort().getList());
    }

    @Test
    public void mergeSort() throws Exception {
        assertArrayEquals(sortedArray, simpleArrayList.mergeSort().getList());
    }

    @Test
    public void min() throws Exception {
        assertEquals((Integer) 10, simpleArrayList.min());
    }

    @Test
    public void max() throws Exception {
        assertEquals((Integer) 100, simpleArrayList.max());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("IntSimpleArrayList(min=" + 10 + ";max=" + 100 + "){" +
                "list=" + Arrays.toString(array) +
                '}', simpleArrayList.toString());
    }

}