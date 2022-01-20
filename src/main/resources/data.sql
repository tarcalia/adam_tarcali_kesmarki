CREATE TABLE person (
	person_id int IDENTITY(1,1) NOT NULL,
	person_name varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__person__543848DFB06FDC6F PRIMARY KEY (person_id)
);

CREATE TABLE address (
	address_id int IDENTITY(0,1) NOT NULL,
	address_name varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	person_id_person_id int NULL,
	CONSTRAINT PK__address__CAA247C8C56F7B63 PRIMARY KEY (address_id)
);
ALTER TABLE master.dbo.address ADD CONSTRAINT FK3pqv4wd0ij0uftfl1h8g6vdxh FOREIGN KEY (person_id_person_id) REFERENCES person(person_id) ON DELETE CASCADE;

CREATE TABLE contact (
	contact_id int IDENTITY(1,1) NOT NULL,
	phone_number int NULL,
	address_id_address_id int NULL,
	CONSTRAINT PK__contact__024E7A86D2ECF36A PRIMARY KEY (contact_id)
);
ALTER TABLE master.dbo.contact ADD CONSTRAINT FKa8jpdhxbah1wb1c6a18piwf1y FOREIGN KEY (address_id_address_id) REFERENCES address(address_id) ON DELETE CASCADE;

INSERT INTO master.dbo.person(person_name)VALUES('Sample Person');
INSERT INTO master.dbo.person(person_name)VALUES('Sample Person_2');
INSERT INTO master.dbo.address(address_name, person_id_person_id)VALUES('Address_1', 1);
INSERT INTO master.dbo.address(address_name, person_id_person_id)VALUES('Address_2', 1);
INSERT INTO master.dbo.address(address_name, person_id_person_id)VALUES('Address_3', 2);
INSERT INTO master.dbo.address(address_name, person_id_person_id)VALUES('Address_4', 2);

