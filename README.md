# Employee Data Management 
A full-stack employee management application built using Java Servlets, JSP, JDBC, and MySQL to manage employee records efficiently.
It provides complete CRUD (Create, Read, Update, Delete) functionality through an interactive UI.
## Live Demo
Check out: http://localhost:8082/EmployeeManagementSystem/index.html
## Prerequisites
Before running the project, make sure you have:
- Java JDK 17 or higher
- Apache Tomcat v10.1
- MySQL Server installed locally
- Eclipse IDE
- jakarta.servlet.jsp.jstl_2021.jar file library
- mysql-connector-8.0.33-jar
## Database Setup
1. Open MySQL and create a new database:
- CREATE DATABASE employeedb;
- USE employeedb;
2. Create the emp table:
- CREATE TABLE emp (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    position VARCHAR(100),
    country VARCHAR(100)
);
3. Update your DB credentials in EmpDao.java:
- con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "your password");
## Getting Started
1. Clone the Repository
git clone https://github.com/yourusername/employee-management-system.git
cd employee-management-system
2. Import the Project
- Open your Eclipse IDE
- Import as Dynamic Web Project
- Configure the project to use Tomcat 10.1 Server runtime
- Import jakarta.jar file
- Also import mysql connector jar from build path
3. Configure Database
- Make sure MySQL is running
- Update connection details in EmpDao.java
4. Run the Application
- Deploy the project on Tomcat
## Environment Variables
- DB_URL=jdbc:mysql://localhost/employeedb
- DB_USER=root
- DB_PASSWORD=your password



