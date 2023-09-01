package com.nunam.service;

import com.nunam.exception.AllException;
import com.nunam.models.Vehicle;

//An interface for vehicle operation
public interface VehicleService {

	public Vehicle addVehicle(Vehicle vehicle) throws AllException;
	public Vehicle removeVehicle(long vehicleId)throws AllException;
	
}
