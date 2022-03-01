use gimnas;

DELIMITER $$
CREATE TRIGGER restar_aforament
AFTER INSERT ON Realitzacio
FOR EACH ROW
BEGIN
UPDATE Sala NATURAL JOIN Realitzacio
SET Sala.aforament = Sala.aforament - 1;
END$$
DELIMITER ;


SELECT SUM(aforament)/160*100 as "percentatge d'aforament"
FROM Sala;
