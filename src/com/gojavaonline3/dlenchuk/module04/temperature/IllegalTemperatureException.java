package com.gojavaonline3.dlenchuk.module04.temperature;

public class IllegalTemperatureException extends TemperatureException {

    private String temperature;

    public IllegalTemperatureException(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }
}
