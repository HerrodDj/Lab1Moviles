-- MySQL Script generated by MySQL Workbench
-- Fri Feb 21 15:23:14 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema universidad
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema universidad
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `universidad` DEFAULT CHARACTER SET utf8 ;
USE `universidad` ;

-- -----------------------------------------------------
-- Table `universidad`.`carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidad`.`carrera` ;

CREATE TABLE IF NOT EXISTS `universidad`.`carrera` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `titulo` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `universidad`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universidad`.`curso` ;

CREATE TABLE IF NOT EXISTS `universidad`.`curso` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `creditos` INT NULL,
  `horas` INT NULL,
  `inicio` DATE NULL,
  `final` DATE NULL,
  `carrera_codigo` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_curso_carrera_idx` (`carrera_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_curso_carrera`
    FOREIGN KEY (`carrera_codigo`)
    REFERENCES `mydb`.`carrera` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
