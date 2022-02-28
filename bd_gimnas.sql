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
    `ccc` varchar(24) NOT NULL,
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
	`DNI_monitor` varchar(9) NOT NULL,
	`NSS` varchar(12) NOT NULL UNIQUE,
	`telefon` varchar(9) NOT NULL UNIQUE,
	`nom` varchar(30) NOT NULL,
	`cognom` varchar(30) NOT NULL,
	`email` varchar(60) NOT NULL UNIQUE,
	PRIMARY KEY (`DNI_monitor`)
);

CREATE TABLE `Sala` (
	`id_sala` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`aforament` int(2) NOT NULL,
	`DNI_monitor` varchar(30) NOT NULL,
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
	`data_baixa` DATE,
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
    `distancia` int(255) NOT NULL,
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


ALTER TABLE `Sala` ADD CONSTRAINT `Sala_fk0` FOREIGN KEY (`DNI_monitor`) REFERENCES `Monitor`(`DNI_monitor`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk0` FOREIGN KEY (`idact`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Activitat_lliure` ADD CONSTRAINT `Activitat_lliure_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Activitat_colectiva` ADD CONSTRAINT `Activitat_colectiva_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk1` FOREIGN KEY (`id_sala`) REFERENCES `Sala`(`id_sala`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk2` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Altes` ADD CONSTRAINT `Altes_fk0` FOREIGN KEY (`dni`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Usuari_web` ADD CONSTRAINT `Usuari_web_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk0` FOREIGN KEY (`id_cursa`) REFERENCES `Curses`(`id_cursa`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);


# INSERTS


INSERT INTO Clients (DNI, nom, cognom1, cognom2, datanaixement, email, telefon, condiciofisica, ccc) VALUES 
('47137446G', 'Bruno', 'Tomé', 'Arias', '2003-08-09', 'brunota.dam1@alumnescostafreda.cat', '628093249', null, "ES2412491614145851007544"),
('77383544K', 'Janire', 'Quiles', 'cognom', '2003-08-09', 'brunota.dam1@alumnescostafreda.cat', '662672907', null, "ES6815257321906273010242"),
('54126466Z', 'Ignasi', 'Cabrera', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '646721702', null, "ES5600368145265920955294"),
('51833470A', 'Myriam', 'Mari', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '600269857', null, "ES3631901491813119440760"),
('67289921V', 'Ayoub', 'Rosales', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '625166765', null, "ES0420405698814239157974"),
('00046319C', 'Sergio', 'Caceres', 'cognom', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '620323809', null, "ES6330726229373463442372");


INSERT INTO Activitat (hora_inici, hora_final, nom, dia) VALUES 
('12:30:00', '13:30:00', 'piscina', 1),
('14:00:00', '15:00:00', 'fitness', 1),
('12:30:00', '13:30:00', 'padel', 2),
('14:00:00', '15:00:00', 'bici', 2),
('12:30:00', '13:30:00', 'cinta de correr', 3),
('14:00:00', '15:00:00', 'cycling', 3),
('12:30:00', '13:30:00', 'body pump', 4),
('14:00:00', '15:00:00', 'pilates', 4),
('12:30:00', '13:30:00', 'natació', 5),
('14:00:00', '15:00:00', 'aquagym', 5),
('12:30:00', '13:30:00', 'running', 6),
('14:00:00', '15:00:00', 'zumba', 6),
('12:30:00', '13:30:00', 'boxa', 7),
('14:00:00', '15:00:00', 'ioga', 7);


INSERT INTO Activitat_lliure(id_act, descripcio) VALUES
(1, 'Piscina'),
(2, 'Fitness'),
(3, 'Partits de padel'),
(4, 'Bici'),
(5, 'Cinta de correr'),
(13, 'Boxa');


INSERT INTO Activitat_colectiva(id_act, descripcio) VALUES
(6, 'Cycling'),
(7, 'Body pump'),
(8, 'Pilates'),
(9, 'Natació en piscina descoberta'),
(10, 'Aquagym'),
(11, 'Running'),
(12, 'Zumba'),
(14, 'Ioga');


INSERT INTO Monitor(DNI_monitor, NSS, telefon, nom, cognom, email) VALUES
('08578598N', '408472140491', '623792716', 'Rafael', 'Luz', 'rafaell@gmail.com'),
('70134652Q', '302866612208', '667881156', 'José', 'Antonio', 'josea@gmail.com'),
('90758723X', '315152690913', '777672774', 'Andrea', 'Requena', 'andrear@gmail.com'),
('17504793E', '350060969692', '692445785', 'Laura', 'Macias', 'lauram@gmail.com');


INSERT INTO Sala(descripcio, aforament, DNI_monitor) VALUES
('Sala de piscina', 40, '08578598N'),
('Sala de maquines de exercicis', 40, '70134652Q'),
('Sala de zumba', 40, '90758723X'),
('Sala de maquines de exercicis Num 2', 40, '17504793E');


INSERT INTO Altes(data_alta, data_baixa, DNI) VALUES
('2022-02-24', null, '47137446G'),
('2022-01-24', '2022-02-24', '77383544K'),
('2022-01-20', null, '54126466Z'),
('2022-01-10', '2022-02-20', '51833470A'),
('2022-02-04', null, '67289921V'),
('2022-01-15', null, '00046319C');


INSERT INTO Usuari_web (username, passwd, DNI) VALUES 
('BrunoTA', '1234', '47137446G'),
('JanireQ', '1234', '77383544K'),
('IgnasiC', '1234', '54126466Z'),
('MyriamM', '1234', '51833470A'),
('AyoubR', '1234', '67289921V'),
('SergioC', '1234', '00046319C');


INSERT INTO Curses (descripcio, distancia, durada) VALUES 
('Cursa solidaria a peu al voltant de Tarrega', 12, '4 hores'),
('Cursa amb bici per Cervera', 15, '4,5 hores'),
('Cursa a peu a Lleida', 10, '5 hores');


INSERT INTO Participa (data, hora, id_cursa, DNI) VALUES
('2022-02-17', '12:00:00', 1, '47137446G'),
('2022-02-17', '12:00:00', 1, '54126466Z'),
('2022-02-17', '12:00:00', 1, '51833470A');



