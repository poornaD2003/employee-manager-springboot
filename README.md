# Employee Management System

## Project Description

The Employee Management System is a web application developed using Spring Boot, Java, MySQL, and Thymeleaf. It allows users to manage employee information easily.

The application supports CRUD operations (Create, Read, Update, and Delete) to manage employee records. It also provides a REST API that can be tested using Postman.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Thymeleaf
- Lombok
- HTML and CSS
- Maven
- Postman
- Git and GitHub

## Features

- Add new employees.
- View all employee records.
- Search employees by name.
- Update employee information.
- Delete employee records.
- Validate employee details.
- Store employee information in a MySQL database.
- Test REST API endpoints using Postman.

## Project Structure

```text
employee-manager/
├── src/
│   └── main/
│       ├── java/com/example/employeemanager/
│       │   ├── EmployeeManagerApplication.java
│       │   ├── model/
│       │   │   └── Employee.java
│       │   ├── repository/
│       │   │   └── EmployeeRepository.java
│       │   ├── service/
│       │   │   └── EmployeeService.java
│       │   └── controller/
│       │       ├── EmployeeController.java
│       │       └── EmployeeRestController.java
│       └── resources/
│           ├── application.properties
│           ├── templates/
│           │   ├── employees.html
│           │   └── edit-employee.html
│           └── static/css/
│               └── style.css
├── secrets.properties
├── .gitignore
├── pom.xml
└── README.md
```

## Requirements

Install the following software before running the project:

- Java JDK 17 or 21, depending on the Java version configured in `pom.xml`.
- MySQL Server or XAMPP with MySQL.
- Maven (or use the Maven Wrapper included in the project).
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code.

## Database Setup

1. Start MySQL Server or MySQL from XAMPP.
2. Open MySQL Workbench or phpMyAdmin.
3. Execute the following SQL command:

```sql
CREATE DATABASE IF NOT EXISTS employee_db;
```

The application is configured to create or update the `employees` table automatically when it starts.

## Database Configuration

Create a `secrets.properties` file in the project root, next to `pom.xml`.

Add your MySQL credentials:

```properties
DB_USERNAME=root
DB_PASSWORD=
```

If your MySQL account has a password, enter it after `DB_PASSWORD=`.

**Security note:** Do not upload `secrets.properties` or your database password to GitHub.

## How to Run the Project

### Step 1: Clone the Repository

Open a terminal and run:

```bash
git clone https://github.com/YOUR-USERNAME/employee-manager-springboot.git
cd employee-manager-springboot
```

Replace `YOUR-USERNAME` with your GitHub username.

If you already have the project on your computer, open its root folder instead.

### Step 2: Configure the Database

Make sure MySQL is running and the `employee_db` database exists.

Check that your `secrets.properties` file contains the correct database username and password.

### Step 3: Run the Application

Open a terminal in the project root and run:

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

If the Maven Wrapper is not included, use:

```bash
mvn spring-boot:run
```

**Linux or macOS:**

```bash
./mvnw spring-boot:run
```

Alternatively, open the project in your IDE and run `EmployeeManagerApplication.java`.

### Step 4: Open the Application

After the application starts successfully, open your browser and visit:

http://localhost:8080/employees

The employee management page will appear.

## REST API Endpoints

The REST API can be tested using Postman.

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees/{id}` | Retrieve an employee by ID |
| POST | `/api/employees` | Add a new employee |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |

### Example JSON Request

Use the following JSON body for a POST request to `/api/employees`:

```json
{
  "fullName": "Kamal Perera",
  "email": "kamal@example.com",
  "phone": "0771234567",
  "department": "IT",
  "salary": 75000.00
}
```

In Postman, select **Body → raw → JSON** before sending the request.

## Verify the Database

Run the following SQL commands in MySQL:

```sql
USE employee_db;
SELECT * FROM employees;
```

This displays the employee records stored in the database.

## Troubleshooting

- **Database connection error:** Make sure MySQL is running and the credentials are correct.
- **Port 8080 already in use:** Stop the other application using that port or configure a different server port.
- **Application fails to start:** Check the Java version, Maven dependencies, and Spring Boot console logs.
- **Page not found:** Make sure the application is running and visit `http://localhost:8080/employees`.


