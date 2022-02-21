drop database if exists gimnas;
create database gimnas;
use gimnas;


CREATE TABLE `Clients` (
	`DNI` varchar(9) NOT NULL,
	`nom` varchar(255) NOT NULL,
	`cognom1` varchar(255) NOT NULL,
    `cognom2` varchar(255) NOT NULL,
    `datanaixement` date,
    `edat` int(255),
    `email` varchar(255),
    `domicili` varchar(255),
	`telefon` varchar(9) NOT NULL,
	`condiciofisica` varchar(255),
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Activitat` (
	`id_act` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`durada` varchar(255) NOT NULL,
	`tipus` varchar(255) NOT NULL,
    `nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id_act`)
);

CREATE TABLE `Monitor` (
	`DNI` varchar(9) NOT NULL,
	`NSS` varchar(14) NOT NULL UNIQUE,
	`telefon` varchar(9) NOT NULL UNIQUE,
	`nom` varchar(255) NOT NULL,
	`cognom` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Sala` (
	`id_sala` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`aforament` int(255) NOT NULL,
	`nom_monitor` varchar(255) NOT NULL,
	PRIMARY KEY (`id_sala`)
);

CREATE TABLE `Realitzacio` (
	`data` DATE NOT NULL,
	`hora` varchar(255) NOT NULL,
	`idact` int NOT NULL UNIQUE,
	`id_sala` int NOT NULL UNIQUE,
	`DNI` varchar(9) NOT NULL UNIQUE
);

CREATE TABLE `Registre` (
	`nom` varchar(255) NOT NULL,
	`cognom` varchar(255) NOT NULL,
	`compte_bancari` varchar(23) NOT NULL,
	`dni` varchar(9) NOT NULL
);

CREATE TABLE `Altes` (
	`data_alta` DATE NOT NULL,
	`data_baixa` DATE NOT NULL,
	`dni` varchar(9) NOT NULL
);

CREATE TABLE `Usuari_web` (
	`username` varchar(255) NOT NULL,
	`passwd` varchar(40) NOT NULL,
	`DNI` varchar(9) NOT NULL
);

CREATE TABLE `Curses` (
	`id_cursa` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`durada` varchar(255) NOT NULL,
	PRIMARY KEY (`id_cursa`)
);

CREATE TABLE `Participa` (
	`data` DATE NOT NULL,
	`hora` varchar(255) NOT NULL,
	`id_cursa` int NOT NULL,
	`DNI` varchar(9) NOT NULL
);


ALTER TABLE `Sala` ADD CONSTRAINT `Sala_fk0` FOREIGN KEY (`nom_monitor`) REFERENCES `Monitor`(`DNI`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk0` FOREIGN KEY (`idact`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk1` FOREIGN KEY (`id_sala`) REFERENCES `Sala`(`id_sala`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk2` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Registre` ADD CONSTRAINT `Registre_fk0` FOREIGN KEY (`dni`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Altes` ADD CONSTRAINT `Altes_fk0` FOREIGN KEY (`dni`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Usuari_web` ADD CONSTRAINT `Usuari_web_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk0` FOREIGN KEY (`id_cursa`) REFERENCES `Curses`(`id_cursa`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);


INSERT INTO Clients (DNI, nom, cognom1, cognom2, telefon, condiciofisica) VALUES ('47137446G', 'Bruno', 'Tomé', 'Arias', '628093249', null);
INSERT INTO Clients (DNI, nom, cognom1, cognom2, telefon, condiciofisica) VALUES ('77383544K', 'Janire', 'Quiles', 'cognom', '662672907', null);
INSERT INTO Clients (DNI, nom, cognom1, cognom2, telefon, condiciofisica) VALUES ('54126466Z', 'Ignasi', 'Cabrera', 'cognom', '646721702', null);
INSERT INTO Clients (DNI, nom, cognom1, cognom2, telefon, condiciofisica) VALUES ('51833470A', 'Myriam', 'Mari', 'cognom', '600269857', null);
INSERT INTO Clients (DNI, nom, cognom1, cognom2, telefon, condiciofisica) VALUES ('67289921V', 'Ayoub', 'Rosales', 'cognom', '625166765', null);
INSERT INTO Clients (DNI, nom, cognom1, cognom2, telefon, condiciofisica) VALUES ('00046319C', 'Sergio', 'Caceres', 'cognom', '620323809', null);

INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('BrunoTA', '1234', '47137446G');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('JanireQ', '1234', '77383544K');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('IgnasiC', '1234', '54126466Z');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('MyriamM', '1234', '51833470A');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('AyoubR', '1234', '67289921V');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('SergioC', '1234', '00046319C');

    
INSERT INTO Activitat (descripcio, durada, tipus, nom) VALUES ('bicicleta','30 min','lliure','bici');
INSERT INTO Activitat (descripcio, durada, tipus, nom) VALUES ('nadar','30 min','lliure','natacio');
INSERT INTO Activitat (descripcio, durada, tipus, nom) VALUES ('aixecament de peses','30 min','lliure','peses');



































