package com.nunam.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotating the class as an Entity, indicating it's a JPA entity
@Entity

//Using Lombok annotations for generating getters, setters, equals, hashCode, and toString methods
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
 // Defining the primary key field and its generation strategy
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long vehicleId;

 // Defining a column with unique constraint
 @Column(unique = true)
 private String vehicleNumber;

 // Additional fields for the Vehicle entity
 private String model;
 private String brand;
}
