# JDBC Delete Operation Guide

This guide explains how to set up, compile, and run the JDBC program to delete records from a MySQL database.

---

## 1. Prerequisites
- **Java JDK** installed (JDK 8 or higher)
- **MySQL Server** installed and running
- **MySQL Connector/J** (`mysql-connector-j-x.x.x.jar`)

---

## 2. Sample Database Setup
Before running the program, ensure the database and table exist:

```sql
-- Create database
CREATE DATABASE testdb;
USE testdb;

-- Create students table
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50)
);

-- Insert sample records
INSERT INTO students (id, name, department) VALUES 
(101, 'Alice', 'Computer Science'),
(102, 'Bob', 'Electrical'),
(103, 'Charlie', 'Mechanical');
```

---

## 3. Configuration
Open [DeleteRecordJDBC.java](file:///c:/Users/DELL/Desktop/java_lab/DeleteRecordJDBC.java) and adjust the connection parameters if needed:
- `URL`: `jdbc:mysql://localhost:3306/testdb`
- `USER`: your MySQL username (default: `root`)
- `PASSWORD`: your MySQL password

---

## 4. Compile and Run

### Windows Command Prompt / PowerShell:
```powershell
# 1. Compile:
javac DeleteRecordJDBC.java

# 2. Run with the MySQL Connector JAR in classpath:
java -cp ".;mysql-connector-j-8.x.x.jar" DeleteRecordJDBC
```
*(Replace `mysql-connector-j-8.x.x.jar` with the actual filename of your MySQL JDBC driver JAR)*
