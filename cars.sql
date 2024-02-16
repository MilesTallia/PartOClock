DROP TABLE IF EXISTS parts;
DROP TABLE IF EXISTS assemblies;
DROP TABLE IF EXISTS subsystems;
DROP TABLE IF EXISTS cars;

DROP TABLE IF EXISTS runtimeTypes;
DROP TABLE IF EXISTS runtimes;

DROP TABLE IF EXISTS childToParent;      -- sooooooo many of these - one for each part -> assembly / assembly->subsytem connection
DROP TABLE IF EXISTS timeToComponent;     -- also a lot of these, one for each time the car is run and for each individual component

CREATE TABLE parts(
    ID SERIAL PRIMARY KEY,
    serialNumber TEXT NOT NULL,
    identifyer TEXT NOT NULL,
    timeLimit int
);

CREATE TABLE assemblies(
    ID SERIAL PRIMARY KEY,
    identifyer TEXT NOT NULL,
    timeLimit TEXT 
);

CREATE TABLE subsystems(
    ID SERIAL PRIMARY KEY,
    identifyer TEXT NOT NULL
);

CREATE TABLE cars(
    ID SERIAL PRIMARY KEY,
    identifyer TEXT NOT NULL
);

CREATE TABLE runtimeTypes(
    ID SERIAL PRIMARY KEY,
    runtimeType TEXT NOT NULL
);

CREATE TABLE runtimes(
    ID SERIAL PRIMARY KEY,
    typeID INTEGER NOT NULL,
    timeAmmount INTEGER NOT NULL,
    dateRan TIMESTAMP NOT NULL
);

CREATE TABLE childToParent(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);

CREATE TABLE timeToComponent(
    ID SERIAL PRIMARY KEY,
    timeID INTEGER NOT NULL,
    componentID INTEGER NOT NULL
);