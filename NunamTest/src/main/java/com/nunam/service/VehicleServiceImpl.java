package com.nunam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nunam.exception.AllException;
import com.nunam.models.Vehicle;
import com.nunam.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
    
    @Autowired
    private VehicleRepository repository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) throws AllException {
        // Check if the provided vehicle is valid
        if (vehicle == null) {
            throw new AllException("Vehicle details are not valid");
        }
        
        // Save the vehicle using the repository
        return repository.save(vehicle);
    }

    @Override
    public Vehicle removeVehicle(long vehicleId) throws AllException {
        // Find the existing vehicle by its ID or throw an exception if not found
        Vehicle existingVehicle = repository.findById(vehicleId)
                .orElseThrow(() -> new AllException("No Vehicle found with this ID"));
        
        // Delete the existing vehicle using the repository
        repository.delete(existingVehicle);
        
        // Return the deleted vehicle
        return existingVehicle;
    }
}

