DROP DATABASE IF EXISTS criminal_records;
CREATE DATABASE criminal_records;
USE criminal_records;

CREATE TABLE plz(
    plz int(4) NOT NULL,
    ort varchar(255) NOT NULL,
    PRIMARY KEY (plz)
);

CREATE TABLE address(
    address_id int NOT NULL AUTO_INCREMENT,
    plz int(4) NOT NULL,
    address varchar(255) NOT NULL,
    PRIMARY KEY (address_id),
    FOREIGN KEY (plz) REFERENCES plz(plz)
);

CREATE TABLE crime(
    crime_id int NOT NULL AUTO_INCREMENT,
    crime varchar(255) NOT NULL,
    sentence int NOT NULL,
    victim varchar(255) NULL,
    location varchar(255) NULL,
    weapon varchar(255) NULL,
    PRIMARY KEY (crime_id)
);

CREATE TABLE ethnicity(
    ethnicity_id int NOT NULL AUTO_INCREMENT,
    ethnicity varchar(255),
    PRIMARY KEY (ethnicity_id)
);

CREATE TABLE criminals(
    criminal_id int NOT NULL AUTO_INCREMENT,
    address_id int NOT NULL,
    crime_id int NOT NULL,
    ethnicity_id int NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    age int NOT NULL,
    height int NOT NULL,
    weight int NOT NULL,
    PRIMARY KEY (criminal_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    /*FOREIGN KEY (crime_id) REFERENCES crime(crime_id),*/
    FOREIGN KEY (ethnicity_id) REFERENCES ethnicity(ethnicity_id)
);




