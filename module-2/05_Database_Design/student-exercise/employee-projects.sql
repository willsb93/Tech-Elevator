BEGIN TRANSACTION; 

CREATE TABLE Job_Titles (

        jobtitleID serial,
        job_title_name varchar(200) not null,
        
        constraint pk_job_title_ID primary key (jobtitleID)
        
        );


CREATE TABLE Department (

        departmentID serial,
        department_name varchar(200) not null,
        
        constraint pk_departmentID primary key (departmentID)
        
        );


        
CREATE TABLE Gender (

        genderID serial,
        gender varchar (100),
        
        constraint pk_genderID primary key (genderID)
        
        );        
        
CREATE TABLE Employees (

        employeeID serial,
        jobtitleID integer not null,
        departmentID integer not null,
        last_name varchar(200) not null,
        first_name varchar (200) not null,
        genderID int not null,
        employee_birthday date not null,
        employee_hire_date date not null,
        
        constraint pk_employeeID primary key (employeeID),
        constraint fk_jobtitleID foreign key (jobtitleID) references Job_Titles (jobtitleID),
        constraint fk_departmentID foreign key (departmentID) references Department (departmentID),
        constraint fk_genderID foreign key (genderID) references Gender (genderID)
        );   
        
CREATE TABLE Projects (
        
        projectID serial,
        project_name varchar (200) not null,
        employeeID int not null,
        start_date date not null,
        
        constraint pk_projectID primary key (projectID),
        constraint fk_employeeID foreign key (employeeID) references Employees (employeeID)
        
        );            


INSERT INTO Department (department_name) VALUES ('Marketing');
INSERT INTO Department (department_name) VALUES ('Sales');  
INSERT INTO Department (department_name) VALUES ('Human Resources');  
INSERT INTO Department (department_name) VALUES ('IT');
INSERT INTO Department (department_name) VALUES ('Accounting');

INSERT INTO Job_Titles (job_title_name) VALUES ('Manager');
INSERT INTO Job_Titles (job_title_name) VALUES ('Sale Representative'); 
INSERT INTO Job_Titles (job_title_name) VALUES ('Accountant'); 
INSERT INTO Job_Titles (job_title_name) VALUES ('HR Rpresentative'); 
INSERT INTO Job_Titles (job_title_name) VALUES ('Software Developer'); 
INSERT INTO Job_Titles (job_title_name) VALUES ('Media Strategist');  

INSERT INTO Gender (gender) VALUES ('Male');
INSERT INTO Gender (gender) VALUES ('Female');
INSERT INTO Gender (gender) VALUES ('Other');
INSERT INTO Gender (gender) VALUES ('Prefer not to say');

INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (1, 1, 'Baker', 'Anna', 2, '1967-01-01', '2010-10-11');    
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (2, 1, 'Smith', 'Jane', 2, '1969-01-01', '2013-08-11');
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (3, 5, 'Dirt', 'Joe', 1, '1983-01-11', '2011-01-07');
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (4, 5, 'Computer', 'Windows', 3, '1985-11-20', '1985-11-20');      
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (5, 3, 'Cheese', 'Mac', 4, '1989-11-20', '2015-11-11'); 
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (6, 3, 'Salami', 'Sandwich', 3, '2000-10-12', '2019-11-09');                    
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (6, 4, 'Cheese', 'Sandwich', 2, '1992-11-10', '2016-11-09'); 
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (6, 4, 'Pastrami', 'Sandwich', 1, '1993-03-10', '2017-11-09');
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (5, 2, 'BGood', 'Johnny', 1, '1990-12-10', '2015-11-09');
INSERT INTO Employees (jobtitleID, departmentID, last_name, first_name, genderID, employee_birthday, employee_hire_date ) VALUES (3, 2, 'White', 'Walter', 1, '1958-07-09', '2008-01-10');

INSERT INTO Projects (project_name, employeeID, start_date) VALUES ('Top Secret', 10, '2008-01-10');
INSERT INTO Projects (project_name, employeeID, start_date) VALUES ('Sandwich', 6, '2009-01-10');
INSERT INTO Projects (project_name, employeeID, start_date) VALUES ('Pasta', 5, '2008-01-10');
INSERT INTO Projects (project_name, employeeID, start_date) VALUES ('Blue Screen', 4, '2001-01-10');

SELECT * FROM Department;
SELECT * FROM Job_Titles;
SELECT * FROM Gender; 
SELECT * FROM Employees;
SELECT * FROM Projects;

COMMIT TRANSACTION;

ROLLBACK;           