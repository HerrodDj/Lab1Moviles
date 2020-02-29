-- Funciones para Lab1 Moviles
-- CRUD para cursos

USE `Universidad`;
DROP procedure IF EXISTS crearCurso;
DELIMITER $$
USE `Universidad`$$
CREATE PROCEDURE crearCurso(IN codigo VARCHAR(45),IN nombre VARCHAR(45), IN creditos INT, IN horas INT, )
