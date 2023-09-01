package com.nunam.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// A dto class for adding new vehicle
public class VehicleDetailsDto {
	private String status;
	private String location;
	private int speed;
	private double load;
	private LocalDateTime timestamp;
	private int distance;
}
