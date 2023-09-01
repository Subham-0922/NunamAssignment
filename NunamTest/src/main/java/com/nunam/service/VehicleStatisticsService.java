package com.nunam.service;

import java.util.List;

import com.nunam.exception.AllException;
import com.nunam.models.VehicleStatistics;

//A interface containing the methods for Statistics management
public interface VehicleStatisticsService {
	
	String addVehicleStatistics() throws AllException;
	List<VehicleStatistics> getStatistics(long vehicleId) throws AllException;
}
