# NunamAssignment
Certainly! Here's a README file for your Spring Boot application that you can upload to GitHub:

```markdown
# Spring Boot Application README

This is a Spring Boot application that manages vehicle data and statistics. It provides APIs for adding vehicles, adding vehicle details, removing vehicles, and retrieving vehicle statistics.

## Project Structure

The project is organized into the following packages:

- `com.nunam.models`: Contains the entity classes for vehicles, vehicle details, and vehicle statistics.
- `com.nunam.repository`: Contains repository interfaces for interacting with the database.
- `com.nunam.exception`: Contains exception classes and a global exception handler.
- `com.nunam.dto`: Contains a DTO class for adding new vehicle details.
- `com.nunam.service`: Contains service interfaces and their implementations.
- `com.nunam.controller`: Contains the REST API controllers.

## Features

### Vehicle Management

- Add a new vehicle.
- Remove a vehicle by ID.

### Vehicle Details Management

- Add vehicle details, including status, location, speed, load, timestamp, and distance.
- Calculate and update distance based on location coordinates.
- Retrieve the latest vehicle details for a specific vehicle.
- Retrieve vehicle details within a specified date and time range.

### Vehicle Statistics

- Automatically calculate and update daily vehicle statistics.
- Retrieve vehicle statistics for a specific vehicle.

## Running the Application

1. Clone the repository to your local machine:

```shell
git clone <repository_url>
```

2. Navigate to the project directory:

```shell
cd <project_directory>
```

3. Build and run the application using Maven:

```shell
mvn spring-boot:run
```

The application will start on the default port `8080`.

## API Endpoints

- **POST /vehicle/addvehicle**: Add a new vehicle.
- **DELETE /vehicle/removevehicle/{vehicleId}**: Remove a vehicle by ID.
- **POST /vehicle/adddetails/{vehicleId}**: Add vehicle details.
- **GET /vehicle/getstats/{vehicleId}**: Retrieve vehicle statistics.

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database (for demonstration purposes; you can replace it with your preferred database)
- Lombok (for generating boilerplate code)
- Maven (for project build)

## Author

[Subham Kr Burnwal]

