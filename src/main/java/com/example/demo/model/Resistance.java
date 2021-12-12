package com.example.demo.model;

import com.example.demo.payload.ResistanceJSON;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

public class Resistance extends Device {
    public Resistance(ResistanceJSON resistanceJSON){
        this.defaultValue=resistanceJSON.defaultValue;
        this.max=resistanceJSON.max;
        this.min=resistanceJSON.min;
    }

    public Resistance(double defaultValue, double min, double max) {
        super(defaultValue, min, max);
    }

    @Override
    public String toString() {
        return "resistance{" +
                "default=" + defaultValue +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
