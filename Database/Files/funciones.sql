-- Funciones para Lab1 Moviles
-- =============================
-- CRUD para carreras
-- =============================

USE `universidad`;
DROP procedure IF EXISTS crearCarrera;
DELIMITER $$
USE `universidad`$$
CREATE PROCEDURE crearCarrera (IN _codigo VARCHAR(20), IN _nombre VARCHAR(45), IN _titulo VARCHAR(45))
begin
INSERT INTO carrera (codigo, nombre, titulo)
VALUES (_codigo, _nombre, _titulo);
commit; 
END$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS buscarCarreraCodigo;
DELIMITER $$
USE `universidad`$$
create procedure buscarCarreraCodigo(in _codigo VARCHAR(20))
begin 
select codigo, nombre, titulo from carrera where carrera.codigo=_codigo; 
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS buscarCarreraNombre;
DELIMITER $$
USE `universidad`$$
create procedure buscarCarreraNombre(in _nombre VARCHAR(20))
begin 
select codigo, nombre, titulo from carrera where carrera.nombre=_nombre; 
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS listarTodaCarrera;
DELIMITER $$
USE `universidad`$$
create procedure listarTodaCarrera()
begin 
select codigo, nombre, titulo from carrera;
end $$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS actualizarCarrera;
DELIMITER $$
USE `universidad`$$
create procedure actualizarCarrera( in _codigo VARCHAR(20), in _nombre VARCHAR(45), in _titulo VARCHAR(45))
begin
UPDATE carrera set nombre=_nombre, titulo=_titulo WHERE codigo=_codigo;
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS eliminarCarrera;
DELIMITER $$
USE `universidad`$$
create procedure eliminarCarrera( in _codigo VARCHAR(20))
begin
delete from carrera where carrera.codigo=_codigo;
end$$
DELIMITER ;

-- =============================
-- CRUD de curso
-- =============================

USE `universidad`;
DROP procedure IF EXISTS crearCurso;
DELIMITER $$
USE `universidad`$$
CREATE PROCEDURE crearCurso (in _codigo VARCHAR(20), in  _nombre VARCHAR(45), in _creditos INT(11), in _horas INT(11), in _carrera_codigo VARCHAR(20), in _ciclo INT(11), in _anio INT(11))
begin
INSERT INTO curso (codigo, nombre, creditos, horas, carrera_codigo, ciclo, anio)
VALUES (_codigo, _nombre, _creditos, _horas, _carrera_codigo, _ciclo, _anio);
commit; 
END$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS buscarCursoCodigo;
DELIMITER $$
USE `universidad`$$
create procedure buscarCursoCodigo(in _codigo VARCHAR(20))
begin 
select codigo, nombre, creditos, horas, carrera_codigo, ciclo, anio from curso where curso.codigo=_codigo; 
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS buscarCursoNombre;
DELIMITER $$
USE `universidad`$$
create procedure buscarCursoNombre(in _nombre VARCHAR(20))
begin 
select codigo, nombre, creditos, horas, carrera_codigo, ciclo, anio from curso where curso.nombre=_nombre; 
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS listarTodoCurso;
DELIMITER $$
USE `universidad`$$
create procedure listarTodoCurso()
begin 
select codigo, nombre, creditos, horas, carrera_codigo, ciclo, anio from curso;
end $$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS actualizarCurso;
DELIMITER $$
USE `universidad`$$
create procedure actualizarCurso( in _codigo VARCHAR(20), in  _nombre VARCHAR(45), in _creditos INT(11), in _horas INT(11), in _carrera_codigo VARCHAR(20), in _ciclo INT(11), in _anio INT(11))
begin
UPDATE curso set nombre=_nombre, creditos=_creditos, horas=_horas, carrera_codigo=_carrera_codigo, ciclo=_ciclo, anio=_anio WHERE codigo=_codigo;
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS eliminarCurso;
DELIMITER $$
USE `universidad`$$
create procedure eliminarCurso( in _codigo VARCHAR(20))
begin
delete from curso where curso.codigo=_codigo;
end$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS listarCursoPorCarrera;
DELIMITER $$
USE `universidad`$$
create procedure listarCursoPorCarrera(in _carrera_codigo VARCHAR(20))
begin 
select codigo, nombre, creditos, horas, carrera_codigo, ciclo, anio from curso where curso.carrera_codigo=_carrera_codigo;
end $$
DELIMITER ;

-- =============================
-- Procedimientos para usuarios
-- =============================

USE `universidad`;
DROP procedure IF EXISTS creaUsuario;
DELIMITER $$
USE `universidad`$$
create procedure creaUsuario(in _cedula VARCHAR(10), in _nombre VARCHAR(20), in _apellido1 VARCHAR(20), in _apellido2 VARCHAR(20), in _contrasenia VARCHAR(45))
begin 
insert into usuarios(cedula, nombre, apellido1, apellido2,  contrasenia ) values(_cedula, _nombre, _apellido1, _apellido2, _contrasenia);
commit;
END$$
DELIMITER ;

USE `universidad`;
DROP procedure IF EXISTS getUsuario;
DELIMITER $$
USE `universidad`$$
create procedure getUsuario(in _cedula VARCHAR(10), in _contrasenia VARCHAR(45))
begin 
select cedula, nombre, apellido1, apellido2, contrasenia from usuarios where usuarios.cedula=_cedula and usuarios.contrasenia=_contrasenia; 
end$$
DELIMITER ;

