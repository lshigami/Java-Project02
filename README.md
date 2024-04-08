# Java-Project02
Small project during learning java

# Building Information Search API

This project is a Spring Boot application that uses JDBC to retrieve data based on user search criteria. The application provides a REST endpoint that accepts GET requests to retrieve building information.

## Endpoint
The endpoint is available at `http://localhost:8081/api/building`. It accepts the following query parameters:

- `typeCode`: (optional) a list of type codes to filter the results by.

The endpoint returns a list of `BuildingDTO` objects, which contain the relevant building information.

## Architecture
This project follows the 3-layer architecture pattern:

1. **Controller Layer**: The `NewAPI` class is the controller layer, which handles the incoming HTTP requests and delegates the processing to the service layer.
2. **Service Layer**: The `ImplementBuildingService` class is the service layer, which encapsulates the business logic for retrieving the building information.
3. **Data Access Layer**: The data access layer uses JDBC to interact with the underlying data source and fetch the building information.

## Running the Application
To run the application, follow these steps:

1. Ensure that you have Java and Maven installed on your system.
2. Clone the repository and navigate to the project directory.
3. Build the application with Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. The application will be available at `http://localhost:8081/api/building`.

## Usage
To use the API, send a GET request to `http://localhost:8081/api/building`. You can optionally include the `typeCode` query parameter to filter the results by type code.

For example, to retrieve all buildings with type codes "A" and "B":

```
http://localhost:8081/api/building?typeCode=A&typeCode=B
```

The API will respond with a JSON array of `BuildingDTO` objects containing the relevant building information.
