package com.nunam.service;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nunam.dto.VehicleDetailsDto;
import com.nunam.exception.AllException;
import com.nunam.models.Vehicle;
import com.nunam.models.VehicleDetails;
import com.nunam.repository.VehicleDetailsRepository;
import com.nunam.repository.VehicleRepository;
@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {
	@Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepo;
    
    @Override
    public VehicleDetails addVehicleDetails(VehicleDetailsDto vdto, long vehicleId) throws AllException {
        VehicleDetails details = new VehicleDetails();
        
        // Setting details using values from the provided VehicleDetailsDto
        details.setLoadINKg(vdto.getLoad());
        details.setLocation(vdto.getLocation());
        details.setSpeed(vdto.getSpeed());
        details.setStatus(vdto.getStatus());
        details.setTimestamp(vdto.getTimestamp());
        
        // Finding the existing Vehicle based on its ID or throwing an exception if not found
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new AllException("Vehicle Not found"));
        
        // Setting the Vehicle in details
        details.setVehicle(existingVehicle);
        
        // Calculating and setting the distance
        details.setDistance(getDistance(vdto.getLocation(), existingVehicle));
        
        // Saving the details in the repository and returning the result
        return vehicleDetailsRepo.save(details);
    }
    
    private int getDistance(String newLocation, Vehicle vehicle) throws AllException {
        List<VehicleDetails> details = vehicleDetailsRepo.findAllByVehicle(vehicle);
        
        if (details.isEmpty()) {
            return 0;
        }
        
        // Finding the previous VehicleDetails with the latest timestamp
        VehicleDetails previousDetails = vehicleDetailsRepo.findTopByVehicleOrderByTimestampDesc(vehicle)
                .orElseThrow(() -> new AllException("Old reference not found"));
        
        // Parsing the coordinates from location strings
        double[] firstCoordinate = parseCoordinates(previousDetails.getLocation());
        double[] lastCoordinate = parseCoordinates(newLocation);
        
        // Calculating the distance and returning it
        return previousDetails.getDistance() + (int) calculateDistance(firstCoordinate[0], firstCoordinate[1],
                lastCoordinate[0], lastCoordinate[1]);
    }
    
    private static double[] parseCoordinates(String location) {
        double[] coords = new double[2];
        StringTokenizer tokenizer = new StringTokenizer(location, ",");
        coords[0] = Double.parseDouble(tokenizer.nextToken()); // Longitude
        coords[1] = Double.parseDouble(tokenizer.nextToken()); // Latitude
        return coords;
    }

    // Calculate the distance using the Haversine formula
    private static double calculateDistance(double lon1, double lat1, double lon2, double lat2) {
        final int R = 6371; // Radius of the Earth in kilometers

        double dLon = Math.toRadians(lon2 - lon1);
        double dLat = Math.toRadians(lat2 - lat1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

}
