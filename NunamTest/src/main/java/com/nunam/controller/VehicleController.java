package com.nunam.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunam.dto.VehicleDetailsDto;
import com.nunam.exception.AllException;
import com.nunam.models.Vehicle;
import com.nunam.models.VehicleDetails;
import com.nunam.models.VehicleStatistics;
import com.nunam.service.VehicleDetailsService;
import com.nunam.service.VehicleService;
import com.nunam.service.VehicleStatisticsService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private VehicleDetailsService vehicleDetailsService;
    
    @Autowired
    private VehicleStatisticsService vehicleStatisticsService;
    
    @PostMapping("/addvehicle")
    public ResponseEntity<Vehicle> addVehicle(Vehicle vehicle) throws AllException {
        // Add a new vehicle and return a response with the saved vehicle and status code
        return new ResponseEntity<Vehicle>(vehicleService.addVehicle(vehicle), HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/removevehicle/{vehicleId}")
    public ResponseEntity<Vehicle> removeVehicle(@PathVariable long vehicleId) throws AllException {
        // Remove a vehicle by ID and return a response with the removed vehicle and status code
        return new ResponseEntity<Vehicle>(vehicleService.removeVehicle(vehicleId), HttpStatus.OK);
    }
    
    @PostMapping("/adddetails/{vehicleId}")
    public ResponseEntity<VehicleDetails> addDetailsVehicle(@RequestBody VehicleDetailsDto vhdto, @PathVariable long vehicleId) throws AllException {
        // Add vehicle details and return a response with the added details and status code
        return new ResponseEntity<VehicleDetails>(vehicleDetailsService.addVehicleDetails(vhdto, vehicleId), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/getstats/{vehicleId}")
    public ResponseEntity<List<VehicleStatistics>> getVehicleStatistics(@PathVariable long vehicleId) throws AllException {
        // Get vehicle statistics and return a response with the statistics list and status code
        return new ResponseEntity<List<VehicleStatistics>>(vehicleStatisticsService.getStatistics(vehicleId), HttpStatus.OK);
    }
}

