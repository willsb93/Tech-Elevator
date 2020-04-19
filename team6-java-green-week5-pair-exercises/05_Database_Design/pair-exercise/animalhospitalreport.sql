drop table Pet_Name;

drop table VisitDate;

drop table PetOwner;

drop table Address;

drop table Pet_Type;

drop table Procedure;


BEGIN TRANSACTION; 

CREATE TABLE Procedure (

             procedureID serial,
             procedureName varchar (150) not null,
             
             constraint pk_procedure primary key (procedureID)
             
           );
           
CREATE TABLE Pet_Type (

             petTypeId serial,
             petType varchar(50) not null,
             
             constraint pk_pettype primary key (petTypeId)   
           );           

CREATE TABLE Address (

             addressId serial,
             street varchar(100) not null,
             city varchar (50) not null,
             state varchar(50) not null,
             zipCode varchar (50) not null,
             
             constraint pk_address primary key (addressId)
          );

CREATE TABLE PetOwner (
               
             ownerID serial,
             firstName varchar(40) not null,
             lastName varchar (80) not null,
             phone varchar (40) not null,
             addressId int, 
             
             constraint pk_owner primary key (ownerID),
             constraint fk_PetOwner_Address foreign key (addressId) references Address (addressId)    
           );

CREATE TABLE VisitDate (

             visitId serial,
             visitDate timestamp not null, 
             procedureId int,
             
             constraint pk_visitId primary key (visitId),
             constraint fk_VisitDate_procedure foreign key (procedureID) references Procedure (procedureID)
          );  


CREATE TABLE Pet_Name (

             petID serial,
             Name varchar(50) not null,
             Age varchar(3) not null,
             ownerID int,
             procedureID int,
             petTypeId int,
             visitId int,
             
             constraint pk_Pet_Name_petID primary key (petID),
             constraint fk_Pet_Name_petowner foreign key (ownerID) references PetOwner (ownerID),
             constraint fk_Pet_Name_procedure foreign key (procedureID) references Procedure (procedureID),
             constraint fk_Pet_Name_pettype foreign key (petTypeId) references Pet_Type (petTypeId),
             constraint fk_Pet_Name_visitdate foreign key (visitId) references VisitDate (visitId)
             
            );
       
COMMIT TRANSACTION; 





        

        

          
             
                       


   