use gimnas;

DELIMITER $$

DROP TRIGGER IF EXISTS Sala_controlaforament;
CREATE TRIGGER Sala_controlaforament
AFTER INSERT ON Realitzacio
FOR EACH ROW
BEGIN
	UPDATE Sala SET aforament = aforament -1
    WHERE Sala.id_sala=Realitzacio.id_sala;
END;

DELIMITER $$

SELECT sum(aforament)
FROM sala;
