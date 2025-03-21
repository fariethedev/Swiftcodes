Swift Codes Application
This is a Spring Boot application that manages SWIFT codes data. It provides RESTful APIs to retrieve, add, and delete SWIFT code entries. The application uses MySQL as the database and is containerized using Docker.

Table of Contents
Prerequisites

Setup

Running the Application

Testing the Application

API Documentation

Docker Deployment

Contributing

License

Prerequisites
Before you begin, ensure you have the following installed:

Java Development Kit (JDK) 11 or higher

Apache Maven

MySQL

Docker (optional, for containerized deployment)

Postman or any API testing tool (optional, for testing endpoints)

Setup
1. Clone the Repository
Clone this repository to your local machine:

bash
Copy
git clone https://github.com/your-username/swift-codes-app.git
cd swift-codes-app
2. Configure MySQL Database
Start MySQL and create a database named swift_codes:

sql
Copy
CREATE DATABASE swift_codes;
Update the database configuration in src/main/resources/application.properties:

properties
Copy
spring.datasource.url=jdbc:mysql://localhost:3306/swift_codes
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
3. Build the Project
Build the project using Maven:

bash
Copy
mvn clean install
Running the Application
1. Run the Application Locally
To run the application locally, use the following command:

bash
Copy
mvn spring-boot:run
The application will start on http://localhost:8080.

2. Run Using Docker
To run the application using Docker, follow these steps:

Build the Docker image:

bash
Copy
docker build -t swift-codes-app .
Run the Docker container:

bash
Copy
docker run -p 8080:8080 swift-codes-app
Access the application at http://localhost:8080.

Testing the Application
1. Unit Tests
Run the unit tests using Maven:

bash
Copy
mvn test
2. API Testing
Use Postman or any API testing tool to test the RESTful endpoints. Below are the available endpoints:

Endpoint 1: Retrieve Details of a Single SWIFT Code
GET: /v1/swift-codes/{swift-code}

Example: http://localhost:8080/v1/swift-codes/ABCDEFGHXXX

Endpoint 2: Retrieve All SWIFT Codes for a Specific Country
GET: /v1/swift-codes/country/{countryISO2}

Example: http://localhost:8080/v1/swift-codes/country/US

Endpoint 3: Add a New SWIFT Code
POST: /v1/swift-codes

Request Body:

json
Copy
{
  "address": "123 Main St",
  "bankName": "Example Bank",
  "countryISO2": "US",
  "countryName": "United States",
  "isHeadquarter": true,
  "swiftCode": "ABCDEFGHXXX"
}
Endpoint 4: Delete a SWIFT Code
DELETE: /v1/swift-codes/{swift-code}

Example: http://localhost:8080/v1/swift-codes/ABCDEFGHXXX

API Documentation
Response Structures
Retrieve Details of a Single SWIFT Code (Headquarters)
json
Copy
{
    "address": "123 Main St",
    "bankName": "Example Bank",
    "countryISO2": "US",
    "countryName": "United States",
    "isHeadquarter": true,
    "swiftCode": "ABCDEFGHXXX",
    "branches": [
        {
            "address": "456 Elm St",
            "bankName": "Example Bank Branch",
            "countryISO2": "US",
            "isHeadquarter": false,
            "swiftCode": "ABCDEFGH001"
        }
    ]
}
Retrieve All SWIFT Codes for a Specific Country
json
Copy
{
    "countryISO2": "US",
    "countryName": "United States",
    "swiftCodes": [
        {
            "address": "123 Main St",
            "bankName": "Example Bank",
            "countryISO2": "US",
            "isHeadquarter": true,
            "swiftCode": "ABCDEFGHXXX"
        },
        {
            "address": "456 Elm St",
            "bankName": "Example Bank Branch",
            "countryISO2": "US",
            "isHeadquarter": false,
            "swiftCode": "ABCDEFGH001"
        }
    ]
}
Docker Deployment
1. Build and Run Using Docker Compose
Create a docker-compose.yml file:

yaml
Copy
version: '3'
services:
  db:
    image: mysql:5.7
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: swift_codes
      MYSQL_USER: user
      MYSQL_PASSWORD: password
    ports:
      - "3306:3306"
  app:
    image: swift-codes-app
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/swift_codes
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: password
Build and run the application:

bash
Copy
docker-compose up
Access the application at http://localhost:8080.

Contributing
Contributions are welcome! Please follow these steps:

Fork the repository.

Create a new branch (git checkout -b feature/YourFeatureName).

Commit your changes (git commit -m 'Add some feature').

Push to the branch (git push origin feature/YourFeatureName).

Open a pull request.
