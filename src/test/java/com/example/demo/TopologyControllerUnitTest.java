package com.example.demo;

import com.example.demo.controller.TopologyController;
import com.example.demo.model.Component;
import com.example.demo.model.Resistance;
import com.example.demo.model.Topology;
import com.example.demo.service.TopologyService;
import com.example.demo.serviceInterface.ITopologyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TopologyController.class)
public class TopologyControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ITopologyService iTopologyService;

    private void insert(){
        HashMap<String,String> netlist= new HashMap<>();
        netlist.put("t1","vdd");
        Resistance resistance=new Resistance(100,10,1000);
        Component component = new Component("resistor","res1",resistance,netlist);
        ArrayList<Component> components = new ArrayList<>();
        Topology topology = new Topology("top1",components);
        iTopologyService.addTopology(topology);
    }

    @Test
    public void readJson() throws Exception {
        mockMvc.perform(post("/readJSON?fileName=topology.json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void readJson2() throws Exception {
        //Wrong file
        mockMvc.perform(post("/readJSON?fileName=ty.json"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void getAllTopologies() throws Exception {
        mockMvc.perform(get("/Topologies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void delete() throws Exception{
        mockMvc.perform(post("/Delete?topologyID=top1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
