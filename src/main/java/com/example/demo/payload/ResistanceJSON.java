package com.example.demo.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResistanceJSON {
    @JsonProperty("default")
    public double defaultValue;
    public double min;
    public double max;
}
