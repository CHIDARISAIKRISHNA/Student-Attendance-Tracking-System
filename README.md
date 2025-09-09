# Student Attendance Tracking System

## Project Overview
The **Student Attendance Tracking System** is a console-based Java application designed to help educational institutions record, update, and view student attendance efficiently. The system interacts with a MySQL database to manage student and attendance data, ensuring data integrity through structured tables and proper foreign key relationships. This project demonstrates the use of JDBC and object-oriented programming principles for robust backend management.

---

## Features
- Record new attendance for students.
- Update existing attendance records.
- View attendance records for all students.
- Manage student data including adding and retrieving student information.
- Efficient data retrieval with proper database design for accuracy and reliability.

---

## Technologies Used
- **Java** – Core language for application development.
- **JDBC** – Java Database Connectivity for connecting Java to MySQL.
- **MySQL** – Database for storing student and attendance information.
- **OOP (Object-Oriented Programming)** – For modular and maintainable code.
- **Console I/O** – Command-line interface for user interaction.

---

## Database Schema
### Students Table
```sql
Create table students (
    student_id int primary key auto_increment,
    name varchar(100) not null,
    email varchar(100) not null
);
```
### Attendance Table
```sql
create table attendance (
    attendance_id int primary key auto_increment,
    student_id int not null,
    attendance_date date not null,
    status varchar(10) not null,
    foreign key (student_id) references students(student_id)
);
```
---

## Setup Instructions

1. Clone the repository
```
git clone https://github.com/CHIDARISAIKRISHNA/Student-Attendance-Tracking-System.git
cd Student Attendance Tracking System
```
2. Set up MySQL database

- Create a database named attendance_system.
- Execute the SQL scripts above to create students and attendance tables.
- Add MySQL Connector
- Download mysql-connector-j-9.4.0.jar and place it in the lib/ folder.

3. Compile Java files
```
javac -cp ".;lib/mysql-connector-j-9.4.0.jar" -d bin src\Main.java src\dao\*.java src\model\*.java src\util\*.java
```
4. Run the application
```
java -cp ".;lib/mysql-connector-j-9.4.0.jar;bin" Main
```

---

### Usage

1. On running the program, a menu will appear with options to:
- Add a new student
- View all students
- Mark attendance for students
- View all attendance records
- Exit the program

2. Input the option number to perform the corresponding action.

---
### License

This project is open source and available under the MIT License.
