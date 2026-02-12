# Employee Management API
![Java CI with Maven](https://github.com/ekadharmayana/employee-manager/actions/workflows/maven.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED)
A professional, production-ready RESTful backend system for managing employee records.
Built with **modern Java standards**, focusing on clean architecture, separation of concerns (DTO pattern), and automated testing pipelines.

---

## Features
* **CRUD Operations:** Create, Read (All/Single), Update, and Delete employees.
* **Clean Architecture:** Strict separation between `Controller`, `Service`, and `Repository` layers.
* **DTO Pattern:** Uses Data Transfer Objects to decouple the internal database model from the public API (hiding sensitive data).
* **Global Error Handling:** Centralized exception handling returning structured JSON errors (RFC 7807).
* **Containerization:** Fully Dockerized database setup for easy local development.
* **CI/CD:** Automated build and verification pipeline using GitHub Actions.
---

## 🛠 Tech Stack
* **Core:** Java 21 (LTS)
* **Frameworks:** Spring Boot 3 (Spring Web, Spring Data JPA)
* **Database:** PostgreSQL 16
* **DevOps:** Docker, Docker Compose, GitHub Actions
* **Tools:** Maven, Git
---

## 🚀 Getting Started
### Prerequisites
* JDK 21
* Docker Engine + Compose
* Git

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

The database is now accessible at `localhost:5432`, Default credentials are configured in `application.properties`.

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
The API will start at: `http://localhost:8080`

---

## 🔌API Documentation
You can test the API using Postman, curl, or any HTTP client.

### Endpoints
| Method | Endpoints | Description | Status Code |
|--------|-----------|-------------|-------------|
| `GET`  | `/api/employees` | Retrieve a list of all employee | 200 OK |
| `GET` | `/api/employees/{id}` | Get specific employee details | 200 OK / 404 |
| `POST` | `/api/employees` | Create a new employee | 201 Created |

### 📝 JSON Examples
### Create Employee (Request)
`POST /api/employees`
```
{
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max.mustermann@example.com"
}
```

### Employee Response (Success)
Note: The `salary` field is hidden by design (DTO Pattern).
```
{
  "id": 1,
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max.mustermann@example.com"
}
```

### Error Response (Not Found)
`GET /api/employees/999`
```
{
  "timestamp": "2026-02-11T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Employee not found with id: 999",
  "path": "uri=/api/employees/999"
}
```
---

## 🏗 Architecture
The project follows a **Layered Architecture** to ensure maintainability and scalability.
```
src/main/java/com/codingpartner/employeemanager
├── api           # Global Exception Handling & Error Response Wrappers
├── controller    # REST Controllers (Handles HTTP Requests)
├── dto           # Data Transfer Objects (API Contract)
├── entity        # JPA Entities (Database Schema)
├── exception     # Custom Exceptions (e.g., NotFoundException)
├── repository    # Spring Data Repositories (Database Access)
└── service       # Business Logic (Validation, Mapping Entity <-> DTO)
```
---

## ⚙️ Configuration
Application settings are located in `src/main/resources/application.properties`.
* **Server Port:** `8080`
* **Database URL:** `jdbc:postgresql://localhost:5432/employeedb`
* **DDL Auto:** `update` (Automatically creates schema)

### 👤 Autor
**Eka Dharma Yana**

