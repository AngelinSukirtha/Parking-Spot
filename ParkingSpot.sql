show databases;
create database parking_spot_database;
use parking_spot_database;
drop database parking_spot_database;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(50),
    user_password VARCHAR(50),
    phone_number VARCHAR(50),
    email VARCHAR(100) UNIQUE);
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Angelin','Angelin2','9876543211','angelin@parkingspot.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Selena','Selena11','9876543212','selena@gmail.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Taylor','Taylor22','6789765434','taylor@gmail.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Hailey','Hailey33','9898987678','hailey@gmail.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Ariana','Ariana44','6767678798','ariana@gmail.com');
    
select * from Users;
drop table Users;

CREATE TABLE Parking_Spots (
    location_id INT PRIMARY KEY AUTO_INCREMENT,
    location_name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    spot_number VARCHAR(50) NOT NULL,
    spot_status VARCHAR(50) NOT NULL);
    
select * from Parking_Spots;
drop table Parking_Spots;

CREATE TABLE Reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    size VARCHAR(100) NOT NULL,
    number_plate VARCHAR(20) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    reservation_status VARCHAR(100) NOT NULL,
    payment_status VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id));

select * from Reservations;
drop table Reservations;

CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    reservation_id INT,
    price INT,
    payment_method VARCHAR(50) NOT NULL,
    transaction_time DATETIME NOT NULL,
    payment_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id));
    
select * from Transactions;
drop table Transactions;
