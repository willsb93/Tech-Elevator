BEGIN TRANSACTION;
-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
INSERT INTO city (name, countrycode, district, population)
VALUES ('Smallville', 'USA', 'Kansas', 45001)
SELECT * FROM city WHERE district = 'Kansas'


-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Kryptonese', false, 0.0001)
SELECT * FROM countrylanguage WHERE countrycode = 'USA'


-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
UPDATE countrylanguage SET language = 'Krypto-babble' WHERE language = 'Kryptonese'

-- 4. Set the US captial to Smallville, Kansas in the country table.
UPDATE country SET capital = 4081 WHERE code = 'USA'
-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE FROM city WHERE id = 4081

-- [Code: 0, SQL State: 23503]  ERROR: update or delete on table "city" violates foreign key constraint "country_capital_fkey" on table "country"
  Detail: Key (id)=(4081) is still referenced from table "country".

COMMIT;
-- 6. Return the US captial to Washington.
UPDATE country SET capital = 3813 WHERE code = 'USA'

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE FROM city WHERE id = 4081
-- BEcause we set a new capital and changed the id.

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
UPDATE countrylanguage SET isofficial = not isofficial
WHERE countrycode IN (SELECT code FROM country WHERE indepyear BETWEEN 1800 AND 1972);

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
UPDATE city SET population = CAST ((population / 1000) AS INT)

-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to 
-- square meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
UPDATE country SET surfacearea = surfacearea* 2.59e+6 WHERE code IN (SELECT countrycode FROM countrylanguage 
WHERE percentage > 20 AND language = 'French');



ROLLBACK;