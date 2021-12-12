package com.example.demo.repository;

import com.example.demo.model.Topology;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TopologyRepo {
    void save(Topology topology);
    void delete(Topology topology);
    Topology getTopology(String id);
    ArrayList<Topology> getTopologies();
}
