package com.example.demo.controller;

import com.example.demo.model.Device;
import com.example.demo.model.Topology;
import com.example.demo.payload.TopologyJSON;
import com.example.demo.serviceInterface.ITopologyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TopologyController {
    @Autowired
    ITopologyService iTopologyService;

    @PostMapping("/readJSON")
    public ResponseEntity<?> readJson(@RequestParam String fileName) throws FileNotFoundException {
        Map<String, String> mp = new HashMap<>();
        TopologyJSON topologyJSON = jsonToTopology(fileName);
        Topology topology = new Topology(topologyJSON);
        iTopologyService.addTopology(topology);
        mp.put("message","Topologies Added Successfully");
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
    private TopologyJSON jsonToTopology(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        JsonReader jsonReader = new JsonReader(new FileReader(file));
        Gson gson = new Gson();
        return gson.fromJson(jsonReader, TopologyJSON.class);
    }
    @GetMapping("/writeJSON")
    public ResponseEntity<?> writeJson(@RequestParam String topologyID) throws IOException {
        Map<String, String> mp = new HashMap<>();
        Topology topology = iTopologyService.getTopology(topologyID);
        Writer writer = new FileWriter("Output.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(topology, writer);
        writer.close();
        mp.put("message",topology.toString());
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
    @GetMapping("/Topologies")
    public ResponseEntity<?> getAllTopologies(){
        Map<String, String> mp = new HashMap<>();
        for (Topology topology: iTopologyService.getTopologies()){
            mp.put(topology.getId(),topology.toString());
        }
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
    @PostMapping("/Delete")
    public ResponseEntity<?> getAllTopologies(@RequestParam String topologyID){
        Map<String, String> mp = new HashMap<>();
        iTopologyService.deleteTopology(topologyID);
        mp.put("message","Topology deleted successfully");
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
    @GetMapping("/Devices")
    public ResponseEntity<?> getDevices(@RequestParam String topologyID){
        Map<String, String> mp = new HashMap<>();
        int count=0;
        for (Device device: iTopologyService.getDeviceses(topologyID)){
            mp.put("Device"+ count +" :",device.toString());
            count ++;
        }
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
    @GetMapping("/DevicesWith")
    public ResponseEntity<?> getDeviceswithNetlistNode(@RequestParam String topologyID, @RequestParam String netlistNodeID){
        Map<String, String> mp = new HashMap<>();
        int count=0;
        for (Device device: iTopologyService.getDeviceswithNetlistNode(topologyID,netlistNodeID)){
            mp.put("Device"+count +" :",device.toString());
            count++;
        }
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
}
