drop database if exists gimnas;
create database gimnas;
use gimnas;


CREATE TABLE `Clients` (
	`DNI` varchar(9) NOT NULL,
	`nom` varchar(30) NOT NULL,
	`cognom1` varchar(30) NOT NULL,
    `cognom2` varchar(30) NOT NULL,
    `datanaixement` date NOT NULL,
    `email` varchar(60) NOT NULL,
    `domicili` varchar(60),
	`telefon` varchar(9) NOT NULL,
	`condiciofisica` varchar(255),
    `ccc` varchar(23) NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Activitat` (
	`id_act` int NOT NULL AUTO_INCREMENT,
	`hora_inici` time(6) NOT NULL,
    `hora_final` time(6) NOT NULL,
    `nom` varchar(30) NOT NULL,
    `dia` int(1) NOT NULL,
	PRIMARY KEY (`id_act`)
);

CREATE TABLE `Activitat_lliure` (
    `id_act` INT NOT NULL UNIQUE,
    `descripcio` varchar(255) NOT NULL,
    PRIMARY KEY (`id_act`)
);

CREATE TABLE `Activitat_colectiva` (
    `id_act` INT NOT NULL UNIQUE,
    `descripcio` varchar(255) NOT NULL,
    PRIMARY KEY (`id_act`)
);

CREATE TABLE `Monitor` (
	`DNI` varchar(9) NOT NULL,
	`NSS` varchar(14) NOT NULL UNIQUE,
	`telefon` varchar(9) NOT NULL UNIQUE,
	`nom` varchar(30) NOT NULL,
	`cognom` varchar(30) NOT NULL,
	`email` varchar(60) NOT NULL UNIQUE,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Sala` (
	`id_sala` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`aforament` int(2) NOT NULL,
	`nom_monitor` varchar(30) NOT NULL,
	PRIMARY KEY (`id_sala`)
);

CREATE TABLE `Realitzacio` (
	`data` DATE NOT NULL,
	`hora` time(6) NOT NULL,
	`idact` int NOT NULL UNIQUE,
	`id_sala` int NOT NULL UNIQUE,
	`DNI` varchar(9) NOT NULL UNIQUE,
    PRIMARY KEY (`DNI`)
);

CREATE TABLE `Altes` (
	`data_alta` DATE NOT NULL,
	`data_baixa` DATE NOT NULL,
	`DNI` varchar(9) NOT NULL,
    PRIMARY KEY (`DNI`)
);

CREATE TABLE `Usuari_web` (
	`username` varchar(16) NOT NULL,
	`passwd` varchar(34) NOT NULL,
	`DNI` varchar(9) NOT NULL,
    PRIMARY KEY (`DNI`)
);

CREATE TABLE `Curses` (
	`id_cursa` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`durada` varchar(20) NOT NULL,
	PRIMARY KEY (`id_cursa`)
);

CREATE TABLE `Participa` (
	`data` DATE NOT NULL,
	`hora` time(6) NOT NULL,
	`id_cursa` int NOT NULL,
	`DNI` varchar(9) NOT NULL,
    PRIMARY KEY (`DNI`)
);


ALTER TABLE `Sala` ADD CONSTRAINT `Sala_fk0` FOREIGN KEY (`nom_monitor`) REFERENCES `Monitor`(`DNI`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk0` FOREIGN KEY (`idact`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Activitat_lliure` ADD CONSTRAINT `Activitat_lliure_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Activitat_colectiva` ADD CONSTRAINT `Activitat_colectiva_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk1` FOREIGN KEY (`id_sala`) REFERENCES `Sala`(`id_sala`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk2` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Altes` ADD CONSTRAINT `Altes_fk0` FOREIGN KEY (`dni`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Usuari_web` ADD CONSTRAINT `Usuari_web_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk0` FOREIGN KEY (`id_cursa`) REFERENCES `Curses`(`id_cursa`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES ('47137446G', 'Bruno', 'Tomé', 'Arias', '2003-08-09', 'brunota.dam1@alumnescostafreda.cat', '628093249', null, "ES00 0000 0000 0000 000");
INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES ('77383544K', 'Janire', 'Quiles', 'cognom', '2003-08-09', 'brunota.dam1@alumnescostafreda.cat', '662672907', null, "ES00 0000 0000 0000 000");
INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES ('54126466Z', 'Ignasi', 'Cabrera', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '646721702', null, "ES00 0000 0000 0000 000");
INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES ('51833470A', 'Myriam', 'Mari', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '600269857', null, "ES00 0000 0000 0000 000");
INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES ('67289921V', 'Ayoub', 'Rosales', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '625166765', null, "ES00 0000 0000 0000 000");
INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES ('00046319C', 'Sergio', 'Caceres', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '620323809', null, "ES00 0000 0000 0000 000");

INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('BrunoTA', '1234', '47137446G');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('JanireQ', '1234', '77383544K');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('IgnasiC', '1234', '54126466Z');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('MyriamM', '1234', '51833470A');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('AyoubR', '1234', '67289921V');
INSERT INTO Usuari_web (username, passwd, DNI) VALUES ('SergioC', '1234', '00046319C');

    
INSERT INTO Activitat (hora_inici, hora_final, nom, dia) VALUES ('12:30:00', '13:30:00', 'bici', 1);
INSERT INTO Activitat (hora_inici, hora_final, nom, dia) VALUES ('12:30:00', '13:30:00', 'natacio', 1);
INSERT INTO Activitat (hora_inici, hora_final, nom, dia) VALUES ('12:30:00', '13:30:00', 'peses', 2);

SELECT *
FROM Activitat;






























