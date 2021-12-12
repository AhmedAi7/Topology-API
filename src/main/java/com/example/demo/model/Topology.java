package com.example.demo.model;

import com.example.demo.payload.ComponentJSON;
import com.example.demo.payload.TopologyJSON;

import java.util.ArrayList;

public class Topology {
    String id;
    ArrayList<Component> components;

    public Topology() {
    }

    public Topology(TopologyJSON topologyJSON) {
        this.id=topologyJSON.id;
        this.components=new ArrayList<>();
        for(ComponentJSON componentJSON: topologyJSON.components){
            if (componentJSON.resistance!=null){
                Resistance resistance = new Resistance(componentJSON.resistance);
                this.components.add(new Component(componentJSON.type,componentJSON.id,resistance,componentJSON.netlist));
            }
            if (componentJSON.mL!=null){
                ML ml = new ML(componentJSON.mL);
                this.components.add(new Component(componentJSON.type,componentJSON.id,ml,componentJSON.netlist));
            }
        }
    }
    public Topology(String id, ArrayList<Component> components) {
        this.id = id;
        this.components = components;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        for (Component c: components){
            System.out.println(c);
        }
        this.components = components;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", components=" + components ;
    }
}
