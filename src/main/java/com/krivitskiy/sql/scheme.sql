--table of clients
DROP TABLE IF EXISTS client;
CREATE TABLE client(
uid serial PRIMARY KEY,
  cname character varying(200),
  phone character varying(30),
  city character varying(50),
  address character varying(50)
);

--table of pets
DROP TABLE IF EXISTS pet;
CREATE TABLE pet(
  uid serial primary key,
  client_id int not null references client(uid),
  ptype varchar(50),
  pname varchar(200)
);
