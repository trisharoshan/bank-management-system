# Bank Management System (ATM Simulator)

A simple ATM simulator built using Java and MySQL.  
This project demonstrates core banking operations like account creation, deposits, withdrawals, and transaction history.

## Features

- Account creation
- Secure login using PIN
- Deposit money
- Withdraw money with balance validation
- Balance enquiry
- Mini statement (transaction history)
- MySQL database integration

## Tech Stack

- Java
- Java Swing (GUI)
- MySQL
- JDBC

## Project Structure

bank-management-system
│
├── database
│   └── Conn.java
│
├── ui
│   ├── CreateAccount.java
│   ├── Login.java
│   ├── ATMMenu.java
│   ├── Deposit.java
│   ├── Withdraw.java
│   ├── BalanceEnquiry.java
│   └── MiniStatement.java

## Database Setup

Create database:
CREATE DATABASE bankdb;

Create customer table:
CREATE TABLE customer(
account_no INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
pin VARCHAR(10),
balance DOUBLE
);

Create transactions table:
CREATE TABLE transactions(
id INT AUTO_INCREMENT PRIMARY KEY,
account_no INT,
type VARCHAR(20),
amount DOUBLE,
date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

## How to Run

1. Clone repository
2. Configure MySQL connection in Conn.java
3. Run CreateAccount.java
4. Run Login.java
5. Use ATM features

## Author

Trisha Roshan

