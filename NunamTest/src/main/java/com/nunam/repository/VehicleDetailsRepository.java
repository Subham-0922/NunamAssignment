package com.nunam.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nunam.models.Vehicle;
import com.nunam.models.VehicleDetails;
@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Long> {
	// Find the latest VehicleDetails entry for a specific Vehicle
    Optional<VehicleDetails> findTopByVehicleOrderByTimestampDesc(Vehicle vehicle);

    // Find all VehicleDetails entries associated with a specific Vehicle
    List<VehicleDetails> findAllByVehicle(Vehicle vehicle);

    // Find all VehicleDetails entries for a specific Vehicle within a given date and time range,
    // ordered by timestamp in ascending order
    List<VehicleDetails> findAllByVehicleAndTimestampBetweenOrderByTimestampAsc(
        Vehicle vehicle,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime
    );
}
