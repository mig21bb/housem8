-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema housem8_schema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema housem8_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `housem8_schema` DEFAULT CHARACTER SET utf8 COLLATE utf8_latvian_ci ;
USE `housem8_schema` ;

-- -----------------------------------------------------
-- Table `housem8_schema`.`HOUSE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`HOUSE` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`HOUSE` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(45) NULL,
  `number` INT NULL,
  `floor` INT NULL,
  `apartment` VARCHAR(45) NULL,
  `other` VARCHAR(45) NULL,
  `square_meters` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`ROOM_CLASS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`ROOM_CLASS` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`ROOM_CLASS` (
  `id` INT NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`ROOM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`ROOM` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`ROOM` (
  `id` INT NOT NULL,
  `square_meters` FLOAT NOT NULL,
  `windows` TINYINT(1) NULL,
  `HOUSE_id` INT NOT NULL,
  `ROOM_CLASS_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ROOM_HOUSE_idx` (`HOUSE_id` ASC),
  INDEX `fk_ROOM_ROOM_CLASS1_idx` (`ROOM_CLASS_id` ASC),
  CONSTRAINT `fk_ROOM_HOUSE`
    FOREIGN KEY (`HOUSE_id`)
    REFERENCES `housem8_schema`.`HOUSE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROOM_ROOM_CLASS1`
    FOREIGN KEY (`ROOM_CLASS_id`)
    REFERENCES `housem8_schema`.`ROOM_CLASS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`MATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`MATE` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`MATE` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname1` VARCHAR(45) NULL,
  `surname2` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `nationality` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `user` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`OCUPATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`OCUPATION` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`OCUPATION` (
  `id` INT NOT NULL,
  `ROOM_id` INT NOT NULL,
  `MATE_id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_OCUPATION_ROOM1_idx` (`ROOM_id` ASC),
  INDEX `fk_OCUPATION_MATE1_idx` (`MATE_id` ASC),
  CONSTRAINT `fk_OCUPATION_ROOM1`
    FOREIGN KEY (`ROOM_id`)
    REFERENCES `housem8_schema`.`ROOM` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OCUPATION_MATE1`
    FOREIGN KEY (`MATE_id`)
    REFERENCES `housem8_schema`.`MATE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`COST_FAMILY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`COST_FAMILY` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`COST_FAMILY` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `period` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`COST`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`COST` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`COST` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `period` INT NULL,
  `datetime` DATETIME NULL,
  `amount` FLOAT NULL,
  `MATE_id` INT NOT NULL,
  `HOUSE_id` INT NOT NULL,
  `COST_FAMILY_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_COST_MATE1_idx` (`MATE_id` ASC),
  INDEX `fk_COST_HOUSE1_idx` (`HOUSE_id` ASC),
  INDEX `fk_COST_COST_FAMILY1_idx` (`COST_FAMILY_id` ASC),
  CONSTRAINT `fk_COST_MATE1`
    FOREIGN KEY (`MATE_id`)
    REFERENCES `housem8_schema`.`MATE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_HOUSE1`
    FOREIGN KEY (`HOUSE_id`)
    REFERENCES `housem8_schema`.`HOUSE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COST_COST_FAMILY1`
    FOREIGN KEY (`COST_FAMILY_id`)
    REFERENCES `housem8_schema`.`COST_FAMILY` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`COMPENSATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`COMPENSATION` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`COMPENSATION` (
  `id` INT NOT NULL,
  `amount` FLOAT NOT NULL,
  `datetime` DATETIME NOT NULL,
  `payer` INT NOT NULL,
  `receiver` INT NOT NULL,
  `notes` LONGTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_COMPENSATION_MATE1_idx` (`payer` ASC),
  INDEX `fk_COMPENSATION_MATE2_idx` (`receiver` ASC),
  CONSTRAINT `fk_COMPENSATION_MATE1`
    FOREIGN KEY (`payer`)
    REFERENCES `housem8_schema`.`MATE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_COMPENSATION_MATE2`
    FOREIGN KEY (`receiver`)
    REFERENCES `housem8_schema`.`MATE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`TABLE_NAME`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`TABLE_NAME` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`TABLE_NAME` (
  `id` INT NOT NULL,
  `table_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `housem8_schema`.`PICTURES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housem8_schema`.`PICTURES` ;

CREATE TABLE IF NOT EXISTS `housem8_schema`.`PICTURES` (
  `id` INT NOT NULL,
  `url` VARCHAR(100) NULL,
  `datetime` DATETIME NULL,
  `active` BINARY NULL DEFAULT 1,
  `TABLE_NAME_id` INT NOT NULL,
  `data_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PICTURES_TABLE_NAME1_idx` (`TABLE_NAME_id` ASC),
  CONSTRAINT `fk_PICTURES_TABLE_NAME1`
    FOREIGN KEY (`TABLE_NAME_id`)
    REFERENCES `housem8_schema`.`TABLE_NAME` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
