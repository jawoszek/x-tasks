BEGIN;

DROP TABLE IF EXISTS Country;
DROP TABLE IF EXISTS City;
DROP TABLE IF EXISTS Building;

CREATE TABLE Country (
  CountryID INTEGER PRIMARY KEY,
  Name      TEXT
);

CREATE TABLE City (
  CityID     INTEGER PRIMARY KEY,
  CountryID  INTEGER,
  Name       TEXT,
  Population INTEGER,
  FOREIGN KEY (CountryID) REFERENCES Country
);

CREATE TABLE Building (
  BuildingID INTEGER PRIMARY KEY,
  CityID     INTEGER,
  Name       TEXT,
  Floors     INTEGER,
  FOREIGN KEY (CityID) REFERENCES City
);

INSERT INTO Country (CountryID, Name) VALUES
  (1, 'Poland'),
  (2, 'Germany'),
  (3, 'France');
INSERT INTO City (CityID, CountryID, Name, Population) VALUES
  (1, 1, 'Cracow', 100),
  (2, 1, 'Warsaw', 250),
  (3, 2, 'Berlin', 300),
  (4, 2, 'Cologne', 200),
  (5, 3, 'Paris', 350),
  (6, 3, 'Lyon', 150);
INSERT INTO Building (BuildingID, CityID, Name, Floors) VALUES
  (1, 1, 'City hall', 3),
  (2, 2, 'School', 2),
  (3, 3, 'Mall', 1);

COMMIT;