package com.nunam.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nunam.exception.AllException;
import com.nunam.models.Vehicle;
import com.nunam.models.VehicleDetails;
import com.nunam.models.VehicleStatistics;
import com.nunam.repository.VehicleDetailsRepository;
import com.nunam.repository.VehicleRepository;
import com.nunam.repository.VehicleStatisticRepository;

@Service
public class VehicleStatisticsServiceImpl implements VehicleStatisticsService {
    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private VehicleStatisticRepository statisticRepository;
//    This method is create the stats and it will be called everyday at 23:59
    @Override
    public String addVehicleStatistics() throws AllException {
        // Get the current date and set start and end times for the day
        LocalDate date1 = LocalDate.now();
        LocalDateTime startTime = LocalDateTime.of(date1.getYear(), date1.getMonth(), date1.getDayOfMonth(), 0, 0);
        LocalDateTime endTime = LocalDateTime.of(date1.getYear(), date1.getMonth(), date1.getDayOfMonth(), 23, 59);
        
        
        List<Vehicle> vehicles= vehicleRepository.findAll();
        vehicles.
        	forEach((v)->{
        	List<VehicleDetails> details = vehicleDetailsRepository.findAllByVehicleAndTimestampBetweenOrderByTimestampAsc(v, startTime, endTime);
            
            // Calculate distance traveled, minutes idle, and minutes in movement
            int distance = details.get(details.size() - 1).getDistance() - details.get(0).getDistance();
            long minutesOfIdle = details.stream().filter((dd) -> dd.getStatus().equals("idle")).count();
            long minutesOfRunning = details.size() - minutesOfIdle;
            
            // Create a new VehicleStatistics object with calculated values
            VehicleStatistics stats = new VehicleStatistics();
            stats.setDate(date1);
            stats.setDistanceTravelled(distance);
            stats.setNumberOfMinutesIdle(minutesOfIdle);
            stats.setNumberOfMinutesInMovement(minutesOfRunning);
            stats.setVehicle(v);
            
            // Save the statistics and return the result
            statisticRepository.save(stats);
        });
        return "Stats Updated successfully";
        // Retrieve vehicle details for the specified day within the given time range
        
    }

    @Override
    public List<VehicleStatistics> getStatistics(long vehicleId) throws AllException {
        // Find the vehicle by its ID or throw an exception if not found
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new AllException("Vehicle not found"));
        
        // Retrieve statistics reports for the specified vehicle
        List<VehicleStatistics> reports = statisticRepository.findByVehicle(vehicle);
        
        // If no reports are available, throw an exception
        if (reports.isEmpty()) {
            throw new AllException("Reports not available");
        }
        
        // Return the list of reports
        return reports;
    }
}

