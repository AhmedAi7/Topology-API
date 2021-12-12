package com.example.demo.serviceInterface;

import com.example.demo.model.Device;
import com.example.demo.model.Topology;

import java.util.ArrayList;

public interface ITopologyService {
    void addTopology(Topology topology);
    Topology getTopology(String id);
    void deleteTopology(String id);
    ArrayList<Topology> getTopologies();
    ArrayList<Device> getDeviceses(String topologyId);
    ArrayList<Device> getDeviceswithNetlistNode(String topologyId, String netlistNodeId);
}
