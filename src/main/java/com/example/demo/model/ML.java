package com.example.demo.model;

import com.example.demo.payload.MLJSON;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.stereotype.Component;


public class ML extends Device {

    public ML(MLJSON mljson){
        this.defaultValue=mljson.defaultValue;
        this.max=mljson.max;
        this.min=mljson.min;
    }

    @Override
    public String toString() {
        return "mL{" +
                "default=" + defaultValue +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
