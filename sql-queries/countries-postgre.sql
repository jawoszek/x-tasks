-- Select countries with population greater than 400
SELECT Country.*
FROM XF.Country
  JOIN XF.City USING (CountryID)
GROUP BY CountryID
HAVING sum(Population) > 400;

-- Select countries with no buildings
SELECT Name
FROM XF.Country
WHERE CountryID NOT IN (SELECT DISTINCT CountryID
                        FROM XF.Country
                          JOIN XF.City USING (CountryID)
                          JOIN XF.Building USING (CityID));