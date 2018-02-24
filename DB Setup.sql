CREATE DATABASE IF NONE EXISTS ItemStorage;

USE ItemStorage;

CREATE TABLE IF NONE EXISTS [User] (
    UserID int NOT NULL AUTO_INCREMENT,
    UserName varchar(20),
    PRIMARY KEY (UserID)
);

CREATE TABLE IF NONE EXISTS Product (
    ProdID int NOT NULL AUTO_INCREMENT,
    ProdNAME varchar(30),
    ProdType varchar(20),
    ProdDescription varchar(100),
    PRIMARY KEY (ProdID)
);

CREATE TABLE IF NONE EXISTS Cupboard (
    CupID int NOT NULL AUTO_INCREMENT,
    CupType Varchar (20),
    CupLocation varchar (40),
    PRIMARY KEY (CupID)
);

CREATE TABLE IF NONE EXISTS ProdInstance (
    CupID int FOREIGN KEY REFERENCES Cupboard(cupID),
    ProdID int FOREIGN KEY REFERENCES Product(ProductID),
    UserID int FOREIGN KEY REFERENCES [User](UserID),
    ExpiryDate date,
    Amount int,
    DateAdded date,
    PRIMARY KEY (CupID, ProdID, UserID)
);