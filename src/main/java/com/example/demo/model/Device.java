package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;

public abstract class Device {
    @JsonProperty("default")
    protected double defaultValue;
    protected double min;
    protected double max;

    public Device() {
    }

    public Device(double defaultValue, double min, double max) {
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
    }

    public double getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
