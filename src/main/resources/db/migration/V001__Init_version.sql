-- MySQL Script generated by MySQL Workbench
-- Mon Aug 13 13:55:52 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SET sql_mode='STRICT_TRANS_TABLES,NO_ZERO_DATE,NO_ZERO_IN_DATE';

-- -----------------------------------------------------
-- Schema usel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema usel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usel` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `usel` ;

-- -----------------------------------------------------
-- Table `usel`.`Vessels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`Vessels` (
  `id` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `createdAt` TINYINT NULL,
  `updatedAt` TINYINT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `usel`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`Customers` (
  `id` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `own_po` INT NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  `vessel_id` INT NOT NULL,
  PRIMARY KEY (`id`, `vessel_id`),
  INDEX `vessel_fk_idx` (`vessel_id` ASC),
  CONSTRAINT `vessel_fk`
    FOREIGN KEY (`vessel_id`)
    REFERENCES `usel`.`Vessels` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `usel`.`Jobs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`Jobs` (
  `id` INT NOT NULL,
  `description` VARCHAR(120) NOT NULL,
  `dueDate` DATE NOT NULL,
  `mSSale` VARCHAR(20) NOT NULL,
  `status` TINYINT NOT NULL,
  `createdAt` TINYINT NULL,
  `updatedAt` TINYINT NULL,
  `customerId` INT NOT NULL,
  PRIMARY KEY (`id`, `customerId`),
  INDEX `customer_fk_idx` (`customerId` ASC),
  CONSTRAINT `customer_fk`
    FOREIGN KEY (`customerId`)
    REFERENCES `usel`.`Customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `usel`.`Vendors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`Vendors` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `createdAt` TINYINT NULL,
  `updatedAt` TINYINT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `usel`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`Users` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `shortName` VARCHAR(3) NOT NULL,
  `isEnabled` TINYINT NULL,
  `createdAt` TINYINT NULL,
  `updatedAt` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usel`.`Purchases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`Purchases` (
  `po` INT NOT NULL AUTO_INCREMENT,
  `finalPoNumber` INT NOT NULL,
  `createdAt` TINYINT NULL,
  `updatedAt` TINYINT NULL,
  `userId` INT NOT NULL,
  `jobId` INT NOT NULL,
  `vendorId` INT NOT NULL,
  PRIMARY KEY (`po`),
  INDEX `vendor_fk_idx` (`vendorId` ASC),
  INDEX `user_fk_idx` (`userId` ASC),
  INDEX `job_fk_idx` (`jobId` ASC),
  CONSTRAINT `vendor_fk`
    FOREIGN KEY (`vendorId`)
    REFERENCES `usel`.`Vendors` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`userId`)
    REFERENCES `usel`.`Users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `job_fk`
    FOREIGN KEY (`jobId`)
    REFERENCES `usel`.`Jobs` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; 