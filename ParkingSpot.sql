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
	INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Angelin','Angelin1','9344868945','angelin@parkingspot.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Selena','Selena11','9876543212','selena@gmail.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Taylor','Taylor22','6789765434','taylor@gmail.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Hailey','Hailey33','9898987678','hailey@gmail.com');
    INSERT INTO Users (user_name,user_password,phone_number,email) VALUES ('Ariana','Ariana44','6767678798','ariana@gmail.com');
    
select * from Users;
drop table Users;

CREATE TABLE Parking_Spots (
    user_id INT,
    location_name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    vehicle_type VARCHAR(50) NOT NULL,
    spot_number VARCHAR(50) NOT NULL,
    spot_status BOOLEAN NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    UNIQUE KEY (location_name, spot_number));
    
select * from Parking_Spots;
drop table Parking_Spots;

CREATE TABLE Reservations (
    user_id INT,
    number_plate VARCHAR(20) NOT NULL,
    start_date_time VARCHAR(100) NOT NULL,
    end_date_time VARCHAR(100) NOT NULL,
    reservation_status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending',
    FOREIGN KEY (user_id) REFERENCES Users(user_id));

select * from Reservations;
drop table Reservations;

CREATE TABLE Transactions (
    user_id INT,
    price INT,
    payment_method VARCHAR(50) NOT NULL,
    transaction_time DATETIME NOT NULL,
    payment_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id));    
select * from Transactions;

drop table Transactions;
