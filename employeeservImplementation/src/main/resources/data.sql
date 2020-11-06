DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS address;
CREATE TABLE employee (
  id INT AUTO_INCREMENT NOT NULL,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  dateOfBirth VARCHAR(250) NOT NULL,
  addressId INT NOT NULL
);
CREATE TABLE address (
   id INT AUTO_INCREMENT NOT NULL,
   line1 VARCHAR(40) NOT NULL,
   line2 VARCHAR(40) default NULL,
   city VARCHAR(40) NOT NULL,
   state VARCHAR(40) NOT NULL,
   country VARCHAR(40) NOT NULL,
   zipCode VARCHAR(40) NOT NULL
);
INSERT INTO address (line1, line2, city, state, country, zipCode) VALUES
  ('Downtown', 'Beside Hedge Street', 'Austin', 'Texas', 'USA', '12345'),
  ('Lake side', 'Park lane', 'Georgia', 'Atlanta', 'USA', '50001');
INSERT INTO employee (firstName, lastName, dateOfBirth, addressId) VALUES
  ('Aliko', 'Dangote', '10-13-1993', 1),
  ('Bill', 'Gates', '11-02-1993', 2);