DROP SCHEMA IF EXISTS XF CASCADE;

CREATE SCHEMA XF;

BEGIN;

CREATE TABLE XF.Country (
  CountryID SERIAL PRIMARY KEY,
  Name      TEXT
);

CREATE TABLE XF.City (
  CityID     SERIAL PRIMARY KEY,
  CountryID  INT REFERENCES XF.Country ON DELETE CASCADE,
  Name       TEXT,
  Population INT
);

CREATE TABLE XF.Building (
  BuildingID SERIAL PRIMARY KEY,
  CityID     INT REFERENCES XF.City ON DELETE CASCADE,
  Name       TEXT,
  Floors     INT
);

INSERT INTO XF.Country (CountryID, Name) VALUES
  (DEFAULT, 'Poland'),
  (DEFAULT, 'Germany'),
  (DEFAULT, 'France');
INSERT INTO XF.City (CityID, CountryID, Name, Population) VALUES
  (DEFAULT, 1, 'Cracow', 100),
  (DEFAULT, 1, 'Warsaw', 250),
  (DEFAULT, 2, 'Berlin', 300),
  (DEFAULT, 2, 'Cologne', 200),
  (DEFAULT, 3, 'Paris', 350),
  (DEFAULT, 3, 'Lyon', 150);
INSERT INTO XF.Building (BuildingID, CityID, Name, Floors) VALUES
  (DEFAULT, 1, 'City hall', 3),
  (DEFAULT, 2, 'School', 2),
  (DEFAULT, 3, 'Mall', 1);

COMMIT;