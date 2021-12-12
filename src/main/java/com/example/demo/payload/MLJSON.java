package com.example.demo.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MLJSON {
    @JsonProperty("default")
    public double defaultValue;
    public double min;
    public double max;
}
