package com.example.demo.service;

import com.example.demo.model.Component;
import com.example.demo.model.Device;
import com.example.demo.model.Topology;
import com.example.demo.repository.TopologyRepo;
import com.example.demo.serviceInterface.ITopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopologyService implements ITopologyService {
    @Autowired
    TopologyRepo topologyRepo;
    @Override
    public void addTopology(Topology topology) {
         topologyRepo.save(topology);
    }

    @Override
    public Topology getTopology(String id) {
        return topologyRepo.getTopology(id);
    }

    @Override
    public void deleteTopology(String id) {
        Topology topology= topologyRepo.getTopology(id);
         topologyRepo.delete(topology);
    }

    @Override
    public ArrayList<Topology> getTopologies() {
        return topologyRepo.getTopologies();
    }

    @Override
    public ArrayList<Device> getDeviceses(String topologyId) {
        Topology topology = topologyRepo.getTopology(topologyId);
        ArrayList<Device> devices = new ArrayList<>();
        for(Component component : topology.getComponents()){
            devices.add(component.getDevice());

        }
        return devices;
    }

    @Override
    public ArrayList<Device> getDeviceswithNetlistNode(String topologyId, String netlistNodeId) {
        Topology topology = topologyRepo.getTopology(topologyId);
        ArrayList<Device> devices = new ArrayList<>();
        for(Component component : topology.getComponents()){
            if (component.getNetlist().containsKey(netlistNodeId)){
                devices.add(component.getDevice());
            }
        }
        return devices;
    }
}
