package com.nunam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nunam.models.Vehicle;
import com.nunam.models.VehicleStatistics;
@Repository
public interface VehicleStatisticRepository extends JpaRepository<VehicleStatistics, Long> {
//	A query method to get the stats for a vehicle
	List<VehicleStatistics> findByVehicle(Vehicle vehicle);

}
