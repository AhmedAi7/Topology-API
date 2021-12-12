package com.example.demo.memoryStore;

import com.example.demo.model.Topology;

import java.util.ArrayList;

public class MemoryDb {
    private ArrayList<Topology> topologies= new ArrayList<>();


    //default Access Modifier (can be accessed from the same package only)
    ArrayList<Topology> getTopologies() {
        return topologies;
    }
}
