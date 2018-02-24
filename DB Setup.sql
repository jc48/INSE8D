CREATE DATABASE IF NONE EXISTS ItemStorage;

USE ItemStorage;

CREATE TABLE IF NONE EXISTS [User] (
    UserID int,
    UserName varchar(20)
    )

CREATE TABLE IF NONE EXISTS Product (
    ProdID int,
    ProdNAME varchar(30),
    ProdType varchar(20),
    ProdDescription varchar(100)
)

CREATE TABLE IF NONE EXISTS Cupboard (
    CupID int,
    CupType Varchar (20),
    CupLocation varchar (40)
)

CREATE TABLE IF NONE EXISTS ProdInstance (
    CupID int FOREIGN KEY REFERENCES Cupboard(cupID),
    ProdID int FOREIGN KEY REFERENCES Product(ProductID),
    UserID int FOREIGN KEY REFERENCES [User](UserID),
    ExpiryDate date,
    Amount int
)