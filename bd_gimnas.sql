drop database if exists gimnas;
create database gimnas;
use gimnas;


CREATE TABLE `Clients` (
	`DNI` varchar(9) NOT NULL,
	`nom` varchar(30) NOT NULL,
	`cognom1` varchar(30) NOT NULL,
    `cognom2` varchar(30) NOT NULL,
    `sexe` char(1) NOT NULL,
    `comunicaciocomercial` varchar(2),
    `datanaixement` date NOT NULL,
    `email` varchar(60) NOT NULL,
    `domicili` varchar(60),
	`telefon` varchar(9) NOT NULL,
	`condiciofisica` varchar(255),
    `ccc` varchar(24) NOT NULL,
    `username` varchar(24) NOT NULL,
    `passwd` varchar(32) NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Sala` (
	`id_sala` int NOT NULL AUTO_INCREMENT,
	`descripcio` varchar(255) NOT NULL,
	`aforament` int(2) NOT NULL,
	`DNI_monitor` varchar(30) NOT NULL,
	PRIMARY KEY (`id_sala`)
);

CREATE TABLE `Activitat` (
	`id_act` int NOT NULL AUTO_INCREMENT,
	`hora_inici` time(6) NOT NULL,
    `hora_final` time(6) NOT NULL,
    `nom` varchar(30) NOT NULL,
    `dia` int(1) NOT NULL,
    `id_sala` int NOT NULL,
    `imatge` varchar(50) NOT NULL,
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

CREATE TABLE `Realitzacio` (
    `idrealitzacio` int NOT NULL AUTO_INCREMENT,
	`data` DATE DEFAULT null,
	`hora` time(6) NOT NULL,
	`id_act` int NOT NULL,
	`id_sala` int NOT NULL,
	`DNI` varchar(9) NOT NULL,
    PRIMARY KEY (`idrealitzacio`)
);

CREATE TABLE `Altes` (
	`data_alta` DATE NOT NULL,
	`data_baixa` DATE,
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

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Activitat_lliure` ADD CONSTRAINT `Activitat_lliure_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Activitat_colectiva` ADD CONSTRAINT `Activitat_colectiva_fk0` FOREIGN KEY (`id_act`) REFERENCES `Activitat`(`id_act`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk1` FOREIGN KEY (`id_sala`) REFERENCES `Sala`(`id_sala`);

ALTER TABLE `Realitzacio` ADD CONSTRAINT `Realitzacio_fk2` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Altes` ADD CONSTRAINT `Altes_fk0` FOREIGN KEY (`dni`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk0` FOREIGN KEY (`id_cursa`) REFERENCES `Curses`(`id_cursa`);

ALTER TABLE `Participa` ADD CONSTRAINT `Participa_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Activitat` ADD CONSTRAINT `Activitat_fk0` FOREIGN KEY (`id_sala`) REFERENCES `Sala`(`id_sala`);

SET SQL_SAFE_UPDATES = 0;

#PROCEDURE

DELIMITER //
CREATE PROCEDURE calcul_aforament ()
BEGIN
SELECT SUM(aforament)/(sum(aforament)+(SELECT count(*) FROM Realitzacio WHERE data <>'2999-1-1'))*100 as "percentatge d'aforament"
FROM Sala;
END
//

# TRIGGER

DELIMITER $$
CREATE TRIGGER restar_aforament
AFTER INSERT ON Realitzacio
FOR EACH ROW
BEGIN
UPDATE Sala NATURAL JOIN Realitzacio
SET Sala.aforament = Sala.aforament - 1;
END$$
DELIMITER ;


INSERT INTO Clients (DNI, nom, cognom1, cognom2, sexe, comunicaciocomercial, datanaixement, email, telefon, condiciofisica, ccc, username, passwd) VALUES 
('47137446G', 'Bruno', 'Tomé', 'Arias', 'M', 'SI', '2003-08-09', 'brunota.dam1@alumnescostafreda.cat', '628093249', null, "ES2412491614145851007544", 'BrunoTA', MD5('1234')),
('77383544K', 'Pau', 'Rubio', 'Silva', 'H', 'SI', '2003-08-09', 'paurs.dam1@alumnescostafreda.cat', '662672907', null, "ES6815257321906273010242", 'PauR', MD5('1234')),
('54126466Z', 'Ignasi', 'Cabrera', 'Fernandez', 'M', 'NO', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '646721702', null, "ES5600368145265920955294", 'IgnasiC', MD5('1234')),
('51833470A', 'Myriam', 'Mari', 'Mari', 'H', 'NO', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '600269857', null, "ES3631901491813119440760", 'MyriamM', MD5('1234')),
('67289921V', 'Ayoub', 'Rosales', 'Sanches', 'M', 'SI', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '625166765', null, "ES0420405698814239157974", 'AyoubR', MD5('1234')),
('00046319C', 'Sergio', 'Caceres', 'Rodriguez', 'M', 'SI', '2003-08-09','brunota.dam1@alumnescostafreda.cat', '620323809', null, "ES6330726229373463442372", 'SergioC', MD5('1234'));

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


INSERT INTO Activitat (hora_inici, hora_final, nom, dia, id_sala, imatge) VALUES 
('12:30:00', '13:30:00', 'piscina', 1, 1, '../img/1.png'),
('14:00:00', '15:00:00', 'fitness', 1, 2, '../img/2.png'),
('12:30:00', '13:30:00', 'padel', 1, 4, '../img/3.png'),
('14:00:00', '15:00:00', 'bici', 2, 4, '../img/4.png'),
('12:30:00', '13:30:00', 'cinta de correr', 2, 2, '../img/5.png'),
('14:00:00', '15:00:00', 'cycling', 2, 2, '../img/6.png'),
('12:30:00', '13:30:00', 'body pump', 3, 2, '../img/7.png'),
('14:00:00', '15:00:00', 'pilates', 3, 3, '../img/8.png'),
('12:30:00', '13:30:00', 'natació', 3, 1, '../img/9.png'),
('14:00:00', '15:00:00', 'aquagym', 4, 1, '../img/10.png'),
('12:30:00', '13:30:00', 'running', 4, 3, '../img/11.png'),
('14:00:00', '15:00:00', 'zumba', 4, 3, '../img/12.png'),
('12:30:00', '13:30:00', 'boxa', 5, 2, '../img/13.png'),
('14:00:00', '15:00:00', 'ioga', 5, 3, '../img/14.png');


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

INSERT INTO Altes(data_alta, data_baixa, DNI) VALUES
('2022-02-24', null, '47137446G'),
('2022-01-24', '2022-02-24', '77383544K'),
('2022-01-20', null, '54126466Z'),
('2022-01-10', '2022-02-20', '51833470A'),
('2022-02-04', null, '67289921V'),
('2022-01-15', null, '00046319C');


INSERT INTO Curses (descripcio, distancia, durada) VALUES 
('Cursa solidaria a peu al voltant de Tarrega', 12, '4 hores'),
('Cursa amb bici per Cervera', 15, '4,5 hores'),
('Cursa de natació a Lleida', 10, '5 hores'),
('Cursa de triatló a Barcelona', 12, '4,5 hores');


INSERT INTO Participa (data, hora, id_cursa, DNI) VALUES
('2022-02-17', '12:00:00', 1, '47137446G'),
('2022-02-17', '12:00:00', 1, '54126466Z'),
('2022-02-17', '12:00:00', 1, '51833470A');


INSERT INTO Realitzacio (data, hora, id_act, id_sala, dni) VALUES
('2022-02-28', '13:30:00', '1', 1, '47137446G'),
(null, '13:30:00', '1', 1, '47137446G'),
('2022-02-28', '13:30:00', '1', 1, '00046319C');

DELIMITER $$
CREATE TRIGGER sumar_aforament
AFTER UPDATE ON Realitzacio
FOR EACH ROW
BEGIN
UPDATE Sala NATURAL JOIN Realitzacio
SET Sala.aforament = Sala.aforament + 1;
END$$
DELIMITER ;

call calcul_aforament();

SELECT * FROM CLIENTS;
