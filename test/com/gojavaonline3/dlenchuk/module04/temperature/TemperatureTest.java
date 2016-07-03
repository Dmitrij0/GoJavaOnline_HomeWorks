package com.gojavaonline3.dlenchuk.module04.temperature;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.gojavaonline3.dlenchuk.module04.temperature.Temperature.ABSOLUTE_ZERO_IN_CELSIUS;
import static org.junit.Assert.*;

public class TemperatureTest {

    Temperature temperature;

    private final double VALID_TEMPERATURE_IN_KELVIN = 290;
    private final double VALID_TEMPERATURE_IN_CELSIUS = 290 - 273.15;
    private final double VALID_TEMPERATURE_IN_FAHRENHEIT = 9 * (290 - 273.15) / 5 + 32;

    private final double LESS_TEMPERATURE_IN_KELVIN = 200;
    private final double BIGGER_TEMPERATURE_IN_KELVIN = 310;

    private final double VALID_TEMPERATURE_SET = 300;

    private final String VALID_TEMPERATURE_K = "240K";
    private final String VALID_TEMPERATURE_C = "15C";
    private final String VALID_TEMPERATURE_F = "98F";

    private final String VALID_DELTA_K = "10K";
    private final String VALID_DELTA_C = "10C";
    private final String VALID_DELTA_F = "10F";

    private final double VALID_RESULT_DELTA_K = 300;
    private final double VALID_RESULT_DELTA_C = 300;
    private final double VALID_RESULT_DELTA_F = (5 * ((9 * (290 - 273.15) / 5 + 32 + 10) - 32) / 9) + 273.15;

    private final String INVALID_UNIT = "98R";
    private final String INVALID_TEMPERATURE = "-100K";
    private final String INVALID_NUMBER_TEMPERATURE = "ABC";

    @BeforeClass
    public static void testAbsoluteZero() throws Exception {
        assertEquals(-273.15, ABSOLUTE_ZERO_IN_CELSIUS, 0.0000001);
    }

    @Before
    public void setUp() throws Exception {
        temperature = new Temperature(VALID_TEMPERATURE_IN_KELVIN);
    }

    @Test(expected = IllegalUnitOfTemperatureException.class)
    public void testCreateInvalidUnit() throws Exception {
        new Temperature(INVALID_UNIT);
    }

    @Test(expected = IllegalTemperatureException.class)
    public void testCreateInvalidTemperature() throws Exception {
        new Temperature(INVALID_TEMPERATURE);
    }

    @Test(expected = NumberFormatException.class)
    public void testCreateInvalidNumber() throws Exception {
        new Temperature(INVALID_NUMBER_TEMPERATURE);
    }

    @Test
    public void getKelvinT() throws Exception {
        assertEquals(VALID_TEMPERATURE_IN_KELVIN, temperature.getKelvinT(), 0.001);
    }

    @Test
    public void setKelvinT() throws Exception {
        temperature.setKelvinT(VALID_TEMPERATURE_SET);
        assertEquals(VALID_TEMPERATURE_SET, temperature.getKelvinT(), 0.001);
    }

    @Test
    public void deltaK() throws Exception {
        temperature = temperature.delta(VALID_DELTA_K);
        assertEquals(VALID_RESULT_DELTA_K, temperature.getKelvinT(), 0);
    }

    @Test
    public void deltaС() throws Exception {
        temperature = temperature.delta(VALID_DELTA_C);
        assertEquals(VALID_RESULT_DELTA_C, temperature.getKelvinT(), 0);
    }

    @Test
    public void deltaF() throws Exception {
        temperature = temperature.delta(VALID_DELTA_F);
        assertEquals(VALID_RESULT_DELTA_F, temperature.getKelvinT(), 0);
    }

    @Test
    public void fahrenheit() throws Exception {
        assertEquals(VALID_TEMPERATURE_IN_FAHRENHEIT, temperature.fahrenheit(), 0);
    }

    @Test
    public void celsius() throws Exception {
        assertEquals(VALID_TEMPERATURE_IN_CELSIUS, temperature.celsius(), 0);
    }

    @Test
    public void compareToBigger() throws Exception {
        assertTrue(temperature.compareTo(new Temperature(BIGGER_TEMPERATURE_IN_KELVIN)) < 0);
    }

    @Test
    public void compareToEquals() throws Exception {
        assertTrue(temperature.compareTo(new Temperature(VALID_TEMPERATURE_IN_KELVIN)) == 0);
    }

    @Test
    public void compareToLess() throws Exception {
        assertTrue(temperature.compareTo(new Temperature(LESS_TEMPERATURE_IN_KELVIN)) > 0);
    }

}