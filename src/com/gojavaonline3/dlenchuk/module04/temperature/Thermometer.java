package com.gojavaonline3.dlenchuk.module04.temperature;

import static com.gojavaonline3.dlenchuk.module04.temperature.Temperature.ABSOLUTE_ZERO_IN_CELSIUS;
import static com.gojavaonline3.dlenchuk.module04.temperature.Temperature.*;

/**
 * Created by Dmitrij Lenchuk on 02.06.2016.
 * Class Thermometer
 */
public class Thermometer {

    /* ToDo
    *  Класс реализует сразу две сущности "Температура" и "Термометр",
    *  что является антипаттерном Blob.
    *  Вариант решения - переписать в виде двух классов
    * */

    public static enum TemperatureRange {
        MIN(-40 - ABSOLUTE_ZERO_IN_CELSIUS),
        MAX(40 - ABSOLUTE_ZERO_IN_CELSIUS);

        private double value;

        public double getValue() {
            return value;
        }

        TemperatureRange(double value) {
            this.value = value;
        }
    }

    private Temperature temperature;

    Thermometer() throws OutOfBoundsThermometerException, IllegalTemperatureException {
        setTemperature(new Temperature(TemperatureRange.MIN.getValue()));
    }

    Thermometer(String temperature) throws IllegalUnitOfTemperatureException, OutOfBoundsThermometerException, IllegalTemperatureException {
        setTemperature(new Temperature(temperature));
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) throws OutOfBoundsThermometerException {
        if (temperature.getKelvinT() < TemperatureRange.MIN.getValue() || temperature.getKelvinT() > TemperatureRange.MAX.getValue()) {
            throw new OutOfBoundsThermometerException(temperature.getKelvinT());
        }
        this.temperature = temperature;
    }

    public double fahrenheit() {
        return getTemperature().fahrenheit();
    }

    public double celsius() {
        return getTemperature().celsius();
    }

    public String temperature(Units unit) throws IllegalUnitOfTemperatureException {
        switch (unit) {
            case KELVIN:
                return String.format("%.2f", getTemperature().getKelvinT()) + '\u00B0' + unit.name();
            case CELSIUS:
                return String.format("%.2f", getTemperature().celsius()) + '\u00B0' + unit.name();
            case FAHRENHEIT:
                return String.format("%.2f", getTemperature().fahrenheit()) + '\u00B0' + unit.name();
        }
        throw new IllegalUnitOfTemperatureException(unit.name());
    }

    public Temperature delta(String delta) throws IllegalUnitOfTemperatureException, OutOfBoundsThermometerException, IllegalTemperatureException {
        temperature = getTemperature().delta(delta);
        return temperature;
    }

    @Override
    public String toString() {
        return "Thermometer{" +
                "celsiusT = " + String.format("%.2f", celsius()) +
                "; fahrenheitT = " + String.format("%.2f", fahrenheit()) +
                '}';
    }

}
