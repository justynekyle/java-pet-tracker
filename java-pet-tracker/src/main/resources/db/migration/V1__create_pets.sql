DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  species VARCHAR(255) NOT NULL,
  breed VARCHAR(255) NOT NULL,
  age INTEGER NOT NULL,
  neutered BOOLEAN NOT NULL
);

INSERT INTO pets (name, species, breed, age, neutered) VALUES ('Rory', 'Dog', 'Golden Retriever', 10, true);
INSERT INTO pets (name, species, breed, age, neutered) VALUES ('Maisy', 'Cat', 'Tabby', 3, false);