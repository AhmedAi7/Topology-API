package com.example.demo.memoryStore;

import com.example.demo.model.Topology;
import com.example.demo.repository.TopologyRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TopologyRepoImpl implements TopologyRepo {
    private MemoryDb memoryDb=new MemoryDb();
    private ArrayList<Topology> topologies =memoryDb.getTopologies();

    @Override
    public void save(Topology topology) {
        for (Topology t:topologies){
            if (t.getId().equals(topology.getId())){
                throw new ArrayStoreException("Topology with same ID is Exist, try different ID");
            }
        }
        topologies.add(topology); //Add topology to the array list (save it)
        }

    @Override
    public void delete(Topology topology) {
        boolean isExists= topologies.contains(topology);
        if(!isExists){
        throw new ArrayStoreException("Topology is not exists , try different ID");
        }
        topologies.remove(topology); //remove topology from the array list (delete it)
    }

    @Override
    public Topology getTopology(String id) {
        for (Topology topology : topologies){
            if(topology.getId().equals(id)){
                return topology;
            }
        }
        throw new ArrayStoreException("Topology is not exists , try different ID");
    }

    @Override
    public ArrayList<Topology> getTopologies() {
        return topologies;
    }
}
