package com.gojavaonline3.dlenchuk.module04.temperature;

import org.junit.Before;
import org.junit.Test;

import static com.gojavaonline3.dlenchuk.module04.temperature.Temperature.Units.*;
import static org.junit.Assert.*;

public class ThermometerTest {

    private Thermometer thermometer;

    private final String STRING_VALUE_OF_TEMPERATURE = "25C";
    private final double TEMPERATURE_IN_KELVIN = 25 + 273.15;
    private final double TEMPERATURE_IN_CELSIUS = 25;
    private final double TEMPERATURE_IN_FAHRENHEIT = 9 * 25 / 5 + 32;

    private final double VALID_TEMPERATURE_SET = 300;
    private final String DELTA_OF_TEMPERATURE = "-10C";

    private final String FINAL_TEMPERATURE = "15C";


    @Before
    public void setUp() throws Exception {
        thermometer = new Thermometer(STRING_VALUE_OF_TEMPERATURE);
    }

    @Test
    public void getTemperature() throws Exception {
        assertEquals(new Temperature(STRING_VALUE_OF_TEMPERATURE), thermometer.getTemperature());
    }

    @Test
    public void setTemperature() throws Exception {
        thermometer.setTemperature(new Temperature(VALID_TEMPERATURE_SET));
        assertEquals(new Temperature(VALID_TEMPERATURE_SET), thermometer.getTemperature());
    }

    @Test
    public void fahrenheit() throws Exception {
        assertEquals(TEMPERATURE_IN_FAHRENHEIT, thermometer.fahrenheit(), 0);
    }

    @Test
    public void celsius() throws Exception {
        assertEquals(TEMPERATURE_IN_CELSIUS, thermometer.celsius(), 0);
    }

    @Test
    public void temperatureCelsius() throws Exception {
        assertEquals(String.format("%.2f", TEMPERATURE_IN_CELSIUS) + '\u00B0' + CELSIUS.name(),
                thermometer.temperature(CELSIUS));
    }

    @Test
    public void temperatureFahrenheit() throws Exception {
        assertEquals(String.format("%.2f", TEMPERATURE_IN_FAHRENHEIT) + '\u00B0' + FAHRENHEIT.name(),
                thermometer.temperature(FAHRENHEIT));
    }

    @Test
    public void temperatureKelvin() throws Exception {
        assertEquals(String.format("%.2f", TEMPERATURE_IN_KELVIN) + '\u00B0' + KELVIN.name(),
                thermometer.temperature(KELVIN));
    }

    @Test
    public void delta() throws Exception {
        thermometer.delta(DELTA_OF_TEMPERATURE);
        assertEquals(new Temperature(FINAL_TEMPERATURE), thermometer.getTemperature());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Thermometer{" +
                "celsiusT = " + String.format("%.2f", TEMPERATURE_IN_CELSIUS) +
                "; fahrenheitT = " + String.format("%.2f", TEMPERATURE_IN_FAHRENHEIT) +
                '}', thermometer.toString());
    }

}