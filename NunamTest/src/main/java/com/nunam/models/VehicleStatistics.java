package com.nunam.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleStatistics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vehicleStatisticId;
	private LocalDate date;
	private long numberOfMinutesIdle;
	private long numberOfMinutesInMovement;
	private double distanceTravelled;
	@ManyToOne(cascade = CascadeType.ALL)
	private Vehicle vehicle;
	
	
}
