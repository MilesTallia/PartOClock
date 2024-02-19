-- STRUCTURE
DROP TABLE IF EXISTS parts;
DROP TABLE IF EXISTS assemblies;
DROP TABLE IF EXISTS subsystems;
DROP TABLE IF EXISTS cars;
-- CONNECTIONS                                      -- sooooooo many of these - one for each componenet -> assembly / componenet -> subsytem connection
DROP TABLE IF EXISTS subsystemToCar;
DROP TABLE IF EXISTS assemblyToSubsystem;
DROP TABLE IF EXISTS assemblyToAssembly;
DROP TABLE IF EXISTS partToSubsystem;
DROP TABLE IF EXISTS partToAssembly;
-- TIME
DROP TABLE IF EXISTS runtimeTypes;
DROP TABLE IF EXISTS runtimes;
-- TIME CONNECTIONS                                 -- also a lot of these, one for each time the car is run and for each individual part
DROP TABLE IF EXISTS timeToPart;
DROP TABLE IF EXISTS timeToAssembly;
DROP TABLE IF EXISTS timeToCar;




-- STRUCTURE

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




-- CONNECTIONS

CREATE TABLE subsystemToCar(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);

CREATE TABLE assemblyToSubsystem(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);

CREATE TABLE assemblyToAssembly(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);

CREATE TABLE partToSubsystem(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);

CREATE TABLE partToAssembly(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);




-- TIME

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




-- TIME CONNECTIONS

CREATE TABLE runtimeToPart(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);

CREATE TABLE runtimeToCar(
    ID SERIAL PRIMARY KEY,
    childID INTEGER NOT NULL,
    parentID INTEGER NOT NULL
);