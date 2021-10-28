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
    sentence varchar(255) NOT NULL,
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
    FOREIGN KEY (crime_id) REFERENCES crime(crime_id),
    FOREIGN KEY (ethnicity_id) REFERENCES ethnicity(ethnicity_id)
);


INSERT INTO `ethnicity` (`ethnicity`)
VALUES
    ("white");

INSERT INTO `plz` (`plz`,`ort`)
VALUES
    (8804,"AU");

INSERT INTO `address` (`plz`,`address`)
VALUES
    (8804,"Alte Landstrasse 120b");



INSERT INTO `crime` (`crime`,`sentence`,`victim`,`location`,`weapon`)
VALUES
    ("Murder","Death","Jan Loeliger","TBZ","Laptop");


INSERT INTO `criminals` (`address_id`,`crime_id`,`ethnicity_id`,`first_name`,`last_name`,`age`,`height`,`weight`)
VALUES
  (1,1,1,"Aline","Nicholson",68,171,121),
  (1,1,1,"Audra","Hendricks",38,156,50),
  (1,1,1,"Kermit","Kent",69,165,60),
  (1,1,1,"Steven","Myers",57,180,140),
  (1,1,1,"Lillian","Bentley",51,181,133);

