package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.util.HashMap;

public class Component {
    private String type;
    private String id;
    private Device device;
    @JsonProperty("netlist")
    private HashMap<String,String> netlist;

    public Component() {
    }

    public Component(String type, String id, Device device, HashMap<String, String> netList) {
        this.type = type;
        this.id = id;
        this.device = device;
        this.netlist = netList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    public HashMap<String, String> getNetlist() {
        return netlist;
    }

    public void setNetlist(HashMap<String, String> netlist) {
        this.netlist = netlist;
    }

    @Override
    public String toString() {
        return "type='" + this.type + '\'' +
                ", id='" + this.id + '\'' +
                ", "+this.device.toString()+
                ", netList=" + this.netlist ;
    }
}
