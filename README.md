<!-- PROJECT LOGO -->
<br />
<p align="center">
  
  <h2 align="center">Topology-API</h2>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
     <a href="#general-overview">General Overview</a>
    </li>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#project-architecture">Project Architecture</a></li>
        <li><a href="#apis-main-functions">APIs Main functions</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
      <a href="#testing-screenshots">Testing Screenshots</a>
      <ul>
        <li><a href="#main-functions-testing">Main Functions Testing</a></li>
        <li><a href="#some-error-messages-for-any-not-vaild-input">Error Messages</a></li>
      </ul>
    </li>
  </ol>
</details>

<!-- GENERAL OVERVIEW -->
## General Overview
A topology is a set of electronic components that are connected together.


<!-- ABOUT THE PROJECT -->
## About The Project
This API provides Provide functionality to access, manage and store device topologies including:
* readJson() "/readJSON"
* writeJson() "/writeJSON"
* getAllTopologies() "/Topologies"
* deleteTopology() "/Delete"
* getDevices() "/Devices"
* getDeviceswithNetlistNode() "/DevicesWith"

### Built With

This section list any major frameworks that is used in buliding the project:
* [Spring Boot](https://spring.io/)
* [MySQL](https://www.mysql.com/)

### Project Architecture
The project contains of main components:
* Controller
* Interfaces for Services
* Service
* Repository : To act as a middleware between the service layer and memory, it provides the basic functions to add and delete Topology from memory.
* MemoryStore : Act as a data base and store Topologies in ArrayList.
* Payload: Objects of messages that should be sent from or to user, including JSON types the system deal with and Error Messages type.
* Exceptions: Contains a Global Exception handler and a Set of all the error messages passed by ath APIs

### APIs Main Functions
* readJson(): This function is responsible for reading a new Topology from JSON file, it takes a JSON file name and then read the file and map it to TopologyJSON object and then to Topology Object (to handle devices types)in case there is already Topology with same ID a BAD_REQUEST with a message explain what is the wrong will be returned, Else it save this Topology in Memory and returns HttpStatus.OK.
* writeJson(): This function is responsible for writing a Topology to JSON file, it takes a topology ID and then write it to the file, in case there is no Topology with the ID a BAD_REQUEST with a message explain what is the wrong will be returned, Else it save the file with name ("Output.json") and returns HttpStatus.OK.
* deleteTopology(): This function is responsible for deleting a Topology, it takes a topology ID and then remove it, in case there is no Topology with the ID a BAD_REQUEST with a message explain what is the wrong will be returned, Else it update the memory atfer deleting the topology and returns HttpStatus.OK.
* getAllTopologies(): This function is responsible for view all Topologies stored in memory.
* getDevices(): This function is responsible for getting devices are in a given topology, it takes a topology ID and then get devices are in it, in case there is no Topology with the ID a BAD_REQUEST with a message explain what is the wrong will be returned, Else it returns HttpStatus.OK with the devices.
* getDeviceswithNetlistNode(): This function is responsible for getting devices are connected to a given netlist node in a given topology, it takes a topology ID and netlist node key, then get devices.

<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

This is a list of things you need to use the software and how to install them.
* Spring Boot
* MySQL

### Installation

1. Install Spring Boot using this Link [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html)
2. Download and install ```MySQL Installer 8.0.26``` using this link [MYSQL](https://dev.mysql.com/downloads/installer/)  


<!-- TESTING SCREENSHOTS -->
## Testing Screenshots


### Main Functions Testing
* "/readJSON" 
![image](https://user-images.githubusercontent.com/36490859/145710714-0aa0a678-2962-4a0b-bc9f-65f8be4efc80.png)

* "/writeJson"
![image](https://user-images.githubusercontent.com/36490859/145710747-08d3860f-d4c2-4ee4-ad4a-edd3ea3746e7.png)

* "/Topologies"
![image](https://user-images.githubusercontent.com/36490859/145710766-cb1f6c42-cccb-4d27-b5f2-be3e8c3062ee.png)

* "/Delete"
![image](https://user-images.githubusercontent.com/36490859/145710798-755c8adb-6ad0-49fc-9269-7ad7e4cab7ee.png)

* "/Devices"
![image](https://user-images.githubusercontent.com/36490859/145710820-9cccad12-8247-4b8d-a117-9ef54ad7b221.png)

* "/DevicesWith"
![image](https://user-images.githubusercontent.com/36490859/145710840-d505e679-46de-41d3-8fde-4858b1f36468.png)


#### Some Error Messages for any not vaild input
* Trying to read Topology with exist ID
![image](https://user-images.githubusercontent.com/36490859/145710865-f9296733-c064-455d-b8fd-ddd3e6c8f548.png)

* Read unexist JSON file 
![image](https://user-images.githubusercontent.com/36490859/145710889-bb74ed82-966e-44df-97d6-f4476b3c7f86.png)

* Delete unexist Topology
![image](https://user-images.githubusercontent.com/36490859/145710907-f9841da5-d334-4cab-a21d-6ef1ad034790.png)


