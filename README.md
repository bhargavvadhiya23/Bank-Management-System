# Bank Management System

This project is a Bank Management System created using Java Swing for the graphical user interface (GUI) and JFrame. It also uses MySQL as the database for storing and managing the data.

## Features
- User-friendly GUI for managing bank operations
- Secure login for bank employees
- Account creation and management
- Transaction processing (deposits, withdrawals, transfers)
- Balance inquiry
- Customer information management

## Technologies Used
- Java (Java Swing, JFrame)
- MySQL

## Screenshots
![Screenshot 1](src/icons/atm.jpg)

## Setup Instructions
1. Clone the repository:
    ```
    git clone https://github.com/bhargavvadhiya23/Bank-Management-System.git
    ```
2. Set up the MySQL database using the provided SQL scripts.
3. Update the database connection details in the project.
4. Compile and run the application using your preferred IDE or command line.

## Usage
1. Run the application.
2. Log in using your credentials.
3. Use the GUI to perform bank management operations.

Feel free to explore and contribute to the project!


## Database SQL Script

Below is the SQL script for creating the required database and tables for the Bank Management System:

```sql
drop database if exists bankmanagementsystem;
create database if not exists bankmanagementsystem;

use bankmanagementsystem;


-- SIGNUP ONE FORM 
create table signup(
no varchar(10) primary key,
fullname varchar(80),
dob varchar(30),
gender varchar(10),
email varchar(70),
maritial varchar(15),
city varchar(50),
address varchar(100),
state varchar(50),
pincode varchar(10));


-- SIGNUP TWO FORM

create table signup2 (
number varchar(10),
category varchar(10),
income varchar(20),
education varchar(20),
occupation varchar(20),
pan varchar(20),
adhar varchar(16),
scitizen varchar(5),
existingAccount varchar(5)
);


-- SIGNUP THREE FORM 
create table signup3(
no varchar(10),
accountType varchar(20),
cardNumber varchar(20),
pin varchar(20),
Facility varchar(100)
);



-- FOR BANKING OPERATION

create table banking(
cardNum varchar(20),
date varchar(30),
type varchar(30),
amount varchar(100));






```

## Important Note

If you are running the project on a different MySQL port or host, please update the connection details in the `Conn.java` file accordingly.  
By default, it is set to use `localhost` with the default MySQL port (usually 3306).  
If your MySQL server is running on another port, change the port number in `Conn.java` to match your configuration.
