-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Urna_BD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Urna_BD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Urna_BD` DEFAULT CHARACTER SET utf8 ;
USE `Urna_BD` ;

-- -----------------------------------------------------
-- Table `Urna_BD`.`Mesario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Urna_BD`.`Mesario` (
  `TituloMesario` VARCHAR(20) NOT NULL,
  `NomeMesario` VARCHAR(45) NOT NULL,
  `zonaEleitoral` VARCHAR(5) NOT NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`zonaEleitoral`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Urna_BD`.`Eleitor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Urna_BD`.`Eleitor` (
  `TituloEleitor` INT NOT NULL,
  `NomeEleitor` VARCHAR(45) NOT NULL,
  `data` DATE NULL,
  `status` VARCHAR(1) NULL DEFAULT 'B',
  `hora` TIME NULL,
  `Mesario_zonaEleitoral` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`TituloEleitor`, `Mesario_zonaEleitoral`),
  INDEX `fk_Eleitor_Mesario1_idx` (`Mesario_zonaEleitoral` ASC),
  CONSTRAINT `fk_Eleitor_Mesario1`
    FOREIGN KEY (`Mesario_zonaEleitoral`)
    REFERENCES `Urna_BD`.`Mesario` (`zonaEleitoral`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Urna_BD`.`Candidato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Urna_BD`.`Candidato` (
  `NumeroCandidato` INT NOT NULL,
  `NomeCandidato` VARCHAR(45) NOT NULL,
  `Votos` INT NULL DEFAULT 0,
  `Mesario_zonaEleitoral` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`NumeroCandidato`, `Mesario_zonaEleitoral`),
  INDEX `fk_Candidato_Mesario1_idx` (`Mesario_zonaEleitoral` ASC),
  CONSTRAINT `fk_Candidato_Mesario1`
    FOREIGN KEY (`Mesario_zonaEleitoral`)
    REFERENCES `Urna_BD`.`Mesario` (`zonaEleitoral`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
