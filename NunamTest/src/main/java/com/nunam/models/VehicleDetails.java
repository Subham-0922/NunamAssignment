package com.nunam.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VehicleDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleDetailsId;

    private String status;

    // Using a regular expression pattern to validate the location string
    @Pattern(regexp = "^[-+]?\\d*\\.?\\d+\\s*,\\s*[-+]?\\d*\\.?\\d+$")
    private String location;

    // Adding constraints for speed field (must be between 0 and 140)
    @Min(0)
    @Max(140)
    private int speed;

    private double loadINKg;

    private LocalDateTime timestamp;
    private int distance;

    // Establishing a many-to-one relationship with the Vehicle entity
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
	
}
