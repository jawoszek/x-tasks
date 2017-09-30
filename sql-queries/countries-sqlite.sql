-- Select countries with population greater than 400
SELECT Country.*
FROM Country
  JOIN City USING (CountryID)
GROUP BY CountryID
HAVING sum(Population) > 400;

-- Select countries with no buildings
SELECT Name
FROM Country
WHERE CountryID NOT IN (SELECT DISTINCT CountryID
                        FROM Country
                          JOIN City USING (CountryID)
                          JOIN Building USING (CityID));