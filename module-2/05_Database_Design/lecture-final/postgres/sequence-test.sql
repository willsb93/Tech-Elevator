DROP SEQUENCE IF EXISTS ourid;
DROP TABLE IF EXISTS seqtest;
DROP TABLE IF EXISTS ouridtest;


-- This creates a new sequence --
-- You do not need to create a sequence if you use serial data type. Serial data type will create a sequence for you
CREATE SEQUENCE ourid START 100;

-- The nextval function will retur the next available number in the sequence called 'ourid'
SELECT nextval('ourid');

-- This table uses sequence to show you that we do not need to pass in a value for id. It will automagically create a new one!
CREATE TABLE seqtest (
id serial not null,
name varchar(35)
);

select * FROM seqtest;

-- See? No value for id needed...
INSERT INTO seqtest (name) VALUES ('c');


-- This is an alternate way NOT using a serial for id but using the sequence we created above... Not sure why we would do this, but the SELECT statement below can be useful in some
-- situations if you need to autoincrement by one and pass that in to a field..
CREATE TABLE ouridtest (
id int not null,
name varchar(35)
);

select * from ouridtest;
INSERT INTO ouridtest (id, name) VALUES ((SELECT nextval('ourid')), 'testA');