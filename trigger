use gimnas;

# PROCEDURE

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


# CRIDEM AL TRIGGER

call calcul_aforament();
