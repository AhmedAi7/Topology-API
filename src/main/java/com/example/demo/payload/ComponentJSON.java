package com.example.demo.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class ComponentJSON {
   public String type;
   public String id;
   public ResistanceJSON resistance;
   public HashMap<String,String> netlist;

//   @JsonProperty("m(l)")
   public MLJSON mL;
   }

