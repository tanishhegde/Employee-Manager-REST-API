# Employee Manager REST API

A RESTful API built with **Spring Boot** and **MySQL** for managing employee records. Supports full CRUD operations with input validation and proper HTTP status codes.

---

## Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Maven**

---

## Features

- Full CRUD operations for employee management
- Input validation using Bean Validation (`@NotBlank`, `@Email`)
- Proper HTTP status codes (`200`, `400`, `404`, `500`)
- Global exception handling with `@ControllerAdvice`
- Automatic schema generation via Hibernate

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/employees` | Get all employees |
| `GET` | `/employees/{id}` | Get a specific employee |
| `POST` | `/employees` | Add a new employee |
| `PUT` | `/employees/{id}` | Update an existing employee |
| `DELETE` | `/employees/{id}` | Delete an employee |

---

## Request Body (POST / PUT)

```json
{
  "employee_id": "E001",
  "first_name": "Test",
  "last_name": "One",
  "email": "test1@test.com",
  "title": "First"
}
```

---

## Getting Started

### Prerequisites
- Java 17+
- MySQL
- Maven

### Setup

**1. Clone the repository**
```bash
git clone https://github.com/tanishhegde/EmployeeManager.git
cd EmployeeManager
```

**2. Create the database**
```sql
CREATE DATABASE employee_db;
```

**3. Configure environment variables**

Set the following environment variables before running:
```
DB_URL=jdbc:mysql://localhost:3306/employee_db
DB_USERNAME={your_mysql_username}
DB_PASSWORD={your_mysql_password}
```

**4. Run the application**
```bash
./mvnw spring-boot:run
```

The API will start at `http://localhost:8080`

---

## Example Requests

**Add an employee**
```bash
curl -X POST http://localhost:8080/employees \
-H "Content-Type: application/json" \
-d '{"employee_id":"E001","first_name":"Test","last_name":"One","email":"test1@test.com","title":"First"}'
```

**Get all employees**
```bash
curl http://localhost:8080/employees
```

**Update an employee**
```bash
curl -X PUT http://localhost:8080/employees/E001 \
-H "Content-Type: application/json" \
-d '{"first_name":"Test","last_name":"One","email":"test@testing.com","title":"1st"}'
```

**Delete an employee**
```bash
curl -X DELETE http://localhost:8080/employees/E001
```

---

## Project Structure

```
src/
└── main/
    └── java/Project/EmployeeManager/
        ├── Employee.java                 
        ├── EmployeeRepository.java        
        ├── EmployeeManager.java          
        ├── EmployeeController.java
        ├── GlobalExceptionHandler.java    
        └── EmployeeManagerApplication.java
```
