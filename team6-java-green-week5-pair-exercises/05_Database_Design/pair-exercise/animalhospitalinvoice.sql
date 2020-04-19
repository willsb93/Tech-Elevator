drop table Invoice;

drop table Pet_Name;

drop table VisitDate;

drop table PetOwner;

drop table Amount;

drop table Address;

drop table Hospital;

drop table Procedure;


BEGIN TRANSACTION; 

CREATE TABLE Procedure (

             procedureId serial,
             procedureName varchar (150) not null,
             procedureCost varchar (100) not null,
             
             constraint pk_procedure primary key (procedureId)
             
           );
           
CREATE TABLE Hospital(

             hospitalId serial,
             hospitalName varchar(50) not null,
             
             constraint pk_hospitalId primary key (hospitalId)   
           );           

CREATE TABLE Address (

             addressId serial,
             street varchar(100) not null,
             city varchar (50) not null,
             state varchar(50) not null,
             zipCode varchar (50) not null,
             
             constraint pk_address primary key (addressId)
          );
          
          
CREATE TABLE Amount (

             amountId serial,
             tax varchar(50),
             procedureId int,
             
             constraint pk_Amount primary key (amountId),
             constraint fk_Amount_Procedure foreign key (procedureId) references Procedure (procedureId)
             
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
             visitId int,
             
             constraint pk_Pet_Name_petID primary key (petID),
             constraint fk_Pet_Name_petowner foreign key (ownerID) references PetOwner (ownerID),
             constraint fk_Pet_Name_procedure foreign key (procedureId) references Procedure (procedureId),
            
             constraint fk_Pet_Name_visitdate foreign key (visitId) references VisitDate (visitId)
             
            );
            
            
CREATE TABLE Invoice (

             invoiceId serial,
             visitId int,
             addressId int,
             petID int,
             amountId int,
             hospitalId int,
             ownerID int,  
             
             
             
             constraint pk_Invoice primary key (invoiceId),
             
             constraint fk_Invoice_visitdate foreign key (visitId) references VisitDate (visitId),
             constraint fk_Invoice_Address foreign key (addressId) references Address (addressId),
             constraint fk_Invoice_Pet_Name foreign key (petID) references Pet_Name (petID),
             constraint fk_Invoice_Amount foreign key (amountId) references Amount (amountId),
             constraint fk_Invoice_Hospital foreign key (hospitalId) references Hospital (hospitalId), 
             constraint fk_Invoice_petowner foreign key (ownerID) references PetOwner (ownerID)
             );                   
       
COMMIT TRANSACTION; 





        

        

          
             
                       


   