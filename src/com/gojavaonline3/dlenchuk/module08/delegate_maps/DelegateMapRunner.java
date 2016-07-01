package com.gojavaonline3.dlenchuk.module08.delegate_maps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class DelegateMapRunner {

    public static void main(String[] args) {
        NavigableMap<String, Integer> treeMap = new DelegateSimpleTreeMap<>();

        System.out.println("treeMap.size() == " + treeMap.size());
        System.out.println("treeMap.isEmpty() == " + treeMap.isEmpty());

        System.out.println();
        System.out.println("treeMap.put(\"70\", 71) == " + treeMap.put("70", 71));
        System.out.println("treeMap.put(\"30\", 31) == " + treeMap.put("30", 31));
        System.out.println("treeMap.put(\"50\", 51) == " + treeMap.put("50", 51));
        System.out.println("treeMap.put(\"20\", 21) == " + treeMap.put("20", 21));
        System.out.println("treeMap.put(\"30\", 32) == " + treeMap.put("30", 32));
        System.out.println("treeMap.put(\"10\", 11) == " + treeMap.put("10", 11));
        System.out.println("treeMap.put(\"60\", 61) == " + treeMap.put("60", 61));

        System.out.println();
        System.out.println(treeMap);

        System.out.println();
        System.out.println("treeMap.size() == " + treeMap.size());
        System.out.println("treeMap.isEmpty() == " + treeMap.isEmpty());

        System.out.println();
        System.out.println("treeMap.findEntry(\"30\") == " + ((DelegateSimpleTreeMap<String, Integer>) treeMap).findEntry("30"));
        System.out.println("treeMap.findEntry(\"333\") == " + ((DelegateSimpleTreeMap<String, Integer>)treeMap).findEntry("333"));

        System.out.println();
        System.out.println("treeMap.containsKey(\"30\") == " + treeMap.containsKey("30"));
        System.out.println("treeMap.containsKey(30) == " + treeMap.containsKey(30));
        System.out.println("treeMap.containsKey(\"333\") == " + treeMap.containsKey("333"));

        System.out.println();
        System.out.println("treeMap.containsValue(32) == " + treeMap.containsValue(32));
        System.out.println("treeMap.containsValue(\"32\") == " + treeMap.containsValue("32"));
        System.out.println("treeMap.containsValue(333) == " + treeMap.containsValue(333));

        System.out.println();
        System.out.println("treeMap.get(\"30\") == " + treeMap.get("30"));
        System.out.println("treeMap.get(30) == " + treeMap.get(30));
        System.out.println("treeMap.get(\"333\") == " + treeMap.get("333"));

        System.out.println();
        System.out.println("treeMap.remove(\"30\") == " + treeMap.remove("30"));
        System.out.println("treeMap.remove(\"50\") == " + treeMap.remove("50"));
        System.out.println("treeMap.remove(30) == " + treeMap.remove(30));
        System.out.println("treeMap.remove(\"333\") == " + treeMap.remove("333"));

        System.out.println();
        System.out.println(treeMap);

        Map<String, Integer> subMap = new TreeMap<>();

        System.out.println();
        System.out.println("subMap.put(\"30\", 31) == " + subMap.put("30", 31));
        System.out.println("subMap.put(\"50\", 51) == " + subMap.put("50", 51));

        treeMap.putAll(subMap);
        System.out.println("treeMap.putAll(subMap) => " + treeMap);

        System.out.println();
        System.out.println("treeMap.keySet() == " + treeMap.keySet());
        System.out.println("treeMap.values() == " + treeMap.values());
        System.out.println("treeMap.entrySet() == " + treeMap.entrySet());


        System.out.println();
        System.out.println("treeMap.lowerEntry(\"05\") == " + treeMap.lowerEntry("05"));
        System.out.println("treeMap.lowerKey(\"05\") == " + treeMap.lowerKey("05"));
        System.out.println("treeMap.lowerEntry(\"10\") == " + treeMap.lowerEntry("10"));
        System.out.println("treeMap.lowerKey(\"10\") == " + treeMap.lowerKey("10"));
        System.out.println("treeMap.lowerEntry(\"30\") == " + treeMap.lowerEntry("30"));
        System.out.println("treeMap.lowerKey(\"30\") == " + treeMap.lowerKey("30"));
        System.out.println("treeMap.lowerEntry(\"70\") == " + treeMap.lowerEntry("70"));
        System.out.println("treeMap.lowerKey(\"70\") == " + treeMap.lowerKey("70"));
        System.out.println("treeMap.lowerEntry(\"80\") == " + treeMap.lowerEntry("80"));
        System.out.println("treeMap.lowerKey(\"80\") == " + treeMap.lowerKey("80"));


        System.out.println();
        System.out.println("treeMap.floorEntry(\"05\") == " + treeMap.floorEntry("05"));
        System.out.println("treeMap.floorKey(\"05\") == " + treeMap.floorKey("05"));
        System.out.println("treeMap.floorEntry(\"10\") == " + treeMap.floorEntry("10"));
        System.out.println("treeMap.floorKey(\"10\") == " + treeMap.floorKey("10"));
        System.out.println("treeMap.floorEntry(\"30\") == " + treeMap.floorEntry("30"));
        System.out.println("treeMap.floorKey(\"30\") == " + treeMap.floorKey("30"));
        System.out.println("treeMap.floorEntry(\"70\") == " + treeMap.floorEntry("70"));
        System.out.println("treeMap.floorKey(\"70\") == " + treeMap.floorKey("70"));
        System.out.println("treeMap.floorEntry(\"80\") == " + treeMap.floorEntry("80"));
        System.out.println("treeMap.floorKey(\"80\") == " + treeMap.floorKey("80"));

        System.out.println();
        System.out.println("treeMap.ceilingEntry(\"05\") == " + treeMap.ceilingEntry("05"));
        System.out.println("treeMap.ceilingKey(\"05\") == " + treeMap.ceilingKey("05"));
        System.out.println("treeMap.ceilingEntry(\"10\") == " + treeMap.ceilingEntry("10"));
        System.out.println("treeMap.ceilingKey(\"10\") == " + treeMap.ceilingKey("10"));
        System.out.println("treeMap.ceilingEntry(\"30\") == " + treeMap.ceilingEntry("30"));
        System.out.println("treeMap.ceilingKey(\"30\") == " + treeMap.ceilingKey("30"));
        System.out.println("treeMap.ceilingEntry(\"70\") == " + treeMap.ceilingEntry("70"));
        System.out.println("treeMap.ceilingKey(\"70\") == " + treeMap.ceilingKey("70"));
        System.out.println("treeMap.ceilingEntry(\"80\") == " + treeMap.ceilingEntry("80"));
        System.out.println("treeMap.ceilingKey(\"80\") == " + treeMap.ceilingKey("80"));

        System.out.println();
        System.out.println("treeMap.higherEntry(\"05\") == " + treeMap.higherEntry("05"));
        System.out.println("treeMap.higherKey(\"05\") == " + treeMap.higherKey("05"));
        System.out.println("treeMap.higherEntry(\"10\") == " + treeMap.higherEntry("10"));
        System.out.println("treeMap.higherKey(\"10\") == " + treeMap.higherKey("10"));
        System.out.println("treeMap.higherEntry(\"30\") == " + treeMap.higherEntry("30"));
        System.out.println("treeMap.higherKey(\"30\") == " + treeMap.higherKey("30"));
        System.out.println("treeMap.higherEntry(\"70\") == " + treeMap.higherEntry("70"));
        System.out.println("treeMap.higherKey(\"70\") == " + treeMap.higherKey("70"));
        System.out.println("treeMap.higherEntry(\"80\") == " + treeMap.higherEntry("80"));
        System.out.println("treeMap.higherKey(\"80\") == " + treeMap.higherKey("80"));


        System.out.println();
        System.out.println("treeMap.firstEntry() == " + treeMap.firstEntry());
        System.out.println("treeMap.firstKey() == " + treeMap.firstKey());
        System.out.println("treeMap.lastEntry() == " + treeMap.lastEntry());
        System.out.println("treeMap.lastKey() == " + treeMap.lastKey());


        System.out.println();
        System.out.println("treeMap.navigableKeySet() == " + treeMap.navigableKeySet());
        System.out.println("treeMap.descendingKeySet() == " + treeMap.descendingKeySet());


        System.out.println();
        System.out.println("treeMap.subMap(\"01\", true, \"01\", true) == " + treeMap.subMap("01", true, "01", true));
        System.out.println("treeMap.subMap(\"01\", false, \"01\", false) == " + treeMap.subMap("01", false, "01", false));
        System.out.println("treeMap.subMap(\"05\", true, \"80\", true) == " + treeMap.subMap("05", true, "80", true));
        System.out.println("treeMap.subMap(\"05\", false, \"80\", false) == " + treeMap.subMap("05", false, "80", false));
        System.out.println("treeMap.subMap(\"10\", true, \"70\", true) == " + treeMap.subMap("10", true, "70", true));
        System.out.println("treeMap.subMap(\"10\", false, \"70\", false) == " + treeMap.subMap("10", false, "70", false));
        System.out.println("treeMap.subMap(\"30\", true, \"60\", true) == " + treeMap.subMap("30", true, "60", true));
        System.out.println("treeMap.subMap(\"30\", false, \"60\", false) == " + treeMap.subMap("30", false, "60", false));
        System.out.println("treeMap.subMap(\"50\", true, \"50\", true) == " + treeMap.subMap("50", true, "50", true));
        System.out.println("treeMap.subMap(\"50\", false, \"50\", false) == " + treeMap.subMap("50", false, "50", false));
        System.out.println("treeMap.subMap(\"333\", true, \"333\", true) == " + treeMap.subMap("333", true, "333", true));
        System.out.println("treeMap.subMap(\"333\", false, \"333\", false) == " + treeMap.subMap("333", false, "333", false));
        System.out.println("treeMap.subMap(\"60\", true, \"30\", true) == " + treeMap.subMap("60", true, "30", true));
        System.out.println("treeMap.subMap(\"60\", false, \"30\", false) == " + treeMap.subMap("60", false, "30", false));

        System.out.println();
        System.out.println("treeMap.headMap(\"05\", true) == " + treeMap.headMap("05", true));
        System.out.println("treeMap.headMap(\"05\", false) == " + treeMap.headMap("05", false));
        System.out.println("treeMap.headMap(\"10\", true) == " + treeMap.headMap("10", true));
        System.out.println("treeMap.headMap(\"10\", false) == " + treeMap.headMap("10", false));
        System.out.println("treeMap.headMap(\"30\", true) == " + treeMap.headMap("30", true));
        System.out.println("treeMap.headMap(\"30\", false) == " + treeMap.headMap("30", false));
        System.out.println("treeMap.headMap(\"70\", true) == " + treeMap.headMap("70", true));
        System.out.println("treeMap.headMap(\"70\", false) == " + treeMap.headMap("70", false));
        System.out.println("treeMap.headMap(\"80\", true) == " + treeMap.headMap("80", true));
        System.out.println("treeMap.headMap(\"80\", false) == " + treeMap.headMap("80", false));

        System.out.println();
        System.out.println("treeMap.tailMap(\"05\", true) == " + treeMap.tailMap("05", true));
        System.out.println("treeMap.tailMap(\"05\", false) == " + treeMap.tailMap("05", false));
        System.out.println("treeMap.tailMap(\"10\", true) == " + treeMap.tailMap("10", true));
        System.out.println("treeMap.tailMap(\"10\", false) == " + treeMap.tailMap("10", false));
        System.out.println("treeMap.tailMap(\"30\", true) == " + treeMap.tailMap("30", true));
        System.out.println("treeMap.tailMap(\"30\", false) == " + treeMap.tailMap("30", false));
        System.out.println("treeMap.tailMap(\"70\", true) == " + treeMap.tailMap("70", true));
        System.out.println("treeMap.tailMap(\"70\", false) == " + treeMap.tailMap("70", false));
        System.out.println("treeMap.tailMap(\"80\", true) == " + treeMap.tailMap("80", true));
        System.out.println("treeMap.tailMap(\"80\", false) == " + treeMap.tailMap("80", false));

        System.out.println();
        System.out.println("treeMap.subMap(\"01\", \"01\") == " + treeMap.subMap("01", "01"));
        System.out.println("treeMap.subMap(\"05\", \"80\") == " + treeMap.subMap("05", "80"));
        System.out.println("treeMap.subMap(\"10\", \"70\") == " + treeMap.subMap("10", "70"));
        System.out.println("treeMap.subMap(\"30\", \"60\") == " + treeMap.subMap("30", "60"));
        System.out.println("treeMap.subMap(\"50\", \"50\") == " + treeMap.subMap("50", "50"));
        System.out.println("treeMap.subMap(\"333\", \"333\") == " + treeMap.subMap("333", "333"));

        System.out.println();
        System.out.println("treeMap.headMap(\"05\") == " + treeMap.headMap("05"));
        System.out.println("treeMap.headMap(\"10\") == " + treeMap.headMap("10"));
        System.out.println("treeMap.headMap(\"30\") == " + treeMap.headMap("30"));
        System.out.println("treeMap.headMap(\"70\") == " + treeMap.headMap("70"));
        System.out.println("treeMap.headMap(\"80\") == " + treeMap.headMap("80"));

        System.out.println();
        System.out.println("treeMap.tailMap(\"05\") == " + treeMap.tailMap("05"));
        System.out.println("treeMap.tailMap(\"10\") == " + treeMap.tailMap("10"));
        System.out.println("treeMap.tailMap(\"30\") == " + treeMap.tailMap("30"));
        System.out.println("treeMap.tailMap(\"70\") == " + treeMap.tailMap("70"));
        System.out.println("treeMap.tailMap(\"80\") == " + treeMap.tailMap("80"));


        System.out.println();
        System.out.println("treeMap == " + treeMap);
        System.out.println("treeMap.pollFirstEntry() == " + treeMap.pollFirstEntry());
        System.out.println("treeMap.pollLastEntry() == " + treeMap.pollLastEntry());
        System.out.println("treeMap == " + treeMap);

        System.out.println();
        treeMap.clear();
        System.out.println("treeMap.clear() => " + treeMap);
        System.out.println("treeMap.descendingKeySet() == " + treeMap.descendingKeySet());
    }

}
