drop database if exists gimnas;
create database gimnas;
use gimnas;


CREATE TABLE `Clients` (
	`DNI` varchar(9) NOT NULL,
	`nom` varchar(255) NOT NULL,
	`cognom` varchar(255) NOT NULL,
	`telefon` int(9) NOT NULL,
	`condicio_fisica` varchar(255),
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



































