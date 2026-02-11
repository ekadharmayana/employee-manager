# Employee Management API
![Java CI with Maven](https://github.com/ekadharmayana/employee-manager/actions/workflows/maven.yml/badge.svg)

A professional backend system for managing employees. Developed with Java 21, Spring Boot 3, and PostgreSQL.

## Technologies
* **Java 21** (LTS)
* **Spring Boot 3** (Web, Data, JPA)
* **PostgreSQL** (Database)
* **Docker & Docker Compose** (Containerization)
* **GitHub Actions** (CI/CD)

## Requirements
* JDK 21
* Docker Engine + Compose
* Git

## Installation & Startup
### 1. Clone Repository
```
git clone https://github.com/ekadharmayana/employee-manager.git
cd employee-manager
```

### 2. Starting the Database (Docker)
We use Docker Compose to start PostgreSQL in isolation:
```
docker-compose up -d
```

The database is now accessible at localhost:5432

### 3. Start the Application
Use the Maven wrapper to build and start the application (no local Maven installation required).

**Mac / Linux:**
```
./mvnw spring-boot:run
```

**Windows (CMD/PowerShell):**
```
mvnw spring-boot:run
```

## Configuration
The settings are located in `src/main/resources/application.properties`.
* **Database:** PostgreeSQL (via Docker)
* **Port:** 8080(default)

## Architecture
The project follows a clean layered architecture:
* **Entity:** Database model (Employee)
* **DTO:** Data Transfer Object (EmployeeDTO) for decoupling the API and security



