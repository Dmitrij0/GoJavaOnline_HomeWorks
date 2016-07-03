package com.gojavaonline3.dlenchuk.module04.temperature;

import java.util.Arrays;

import static com.gojavaonline3.dlenchuk.module04.temperature.Temperature.Units.*;

/**
 * Created by Dmitrij Lenchuk on 02.06.2016.
 * Class ThermometerRunner
 */
public class ThermometerRunner {
    public static void main(String[] args) throws OutOfBoundsThermometerException, IllegalUnitOfTemperatureException,
            IllegalTemperatureException {

        Thermometer thermometer1 = new Thermometer();
        System.out.println("thermometer1: " + thermometer1);

        Thermometer thermometer2 = new Thermometer("240K");
        System.out.println("thermometer2: " + thermometer2);

        System.out.println("thermometer2: " + thermometer2.temperature(CELSIUS));
        System.out.println("thermometer2: " + thermometer2.temperature(FAHRENHEIT));
        System.out.println("thermometer2: " + thermometer2.temperature(KELVIN));
        thermometer2.delta("20K");
        System.out.println("thermometer2 +20K: " + thermometer2);
        thermometer2.delta("10C");
        System.out.println("thermometer2 +10C: " + thermometer2);
        try {
            thermometer2.delta("100C");
            System.out.println("thermometer2 +100C: " + thermometer2);
        } catch (OutOfBoundsThermometerException e) {
            System.out.println("Temperature '" + e.getTemperature() + "' is out of thermometer's bounds: " + Arrays.toString(Thermometer.TemperatureRange.values()));
        }
        thermometer2.delta("-5K");
        System.out.println("thermometer2 -5K: " + thermometer2);

        try {
            thermometer2.delta("-7R");
            System.out.println("thermometer2 -7F: " + thermometer2);
        } catch (IllegalUnitOfTemperatureException e) {
            System.out.println("The unit '" + e.getUnitName() + "' is not supported");
        } catch (OutOfBoundsThermometerException e) {
            System.out.println("Temperature '" + e.getTemperature() + "' is out of thermometer's bounds: " + Arrays.toString(Thermometer.TemperatureRange.values()));
        }

        System.out.println("Compare: " + thermometer2.getTemperature().compareTo(thermometer1.getTemperature()));
        System.out.println("Compare: " + thermometer2.getTemperature().compareTo(null));
    }
}
