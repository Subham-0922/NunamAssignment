package com.nunam.service;

import com.nunam.dto.VehicleDetailsDto;
import com.nunam.exception.AllException;
import com.nunam.models.VehicleDetails;

// Interface for handling the request from the vehicle 
public interface VehicleDetailsService {
	public VehicleDetails addVehicleDetails(VehicleDetailsDto vdto,long vehicleId) throws AllException;
}
