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
CREATE SCHEMA IF NOT EXISTS `usel` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `usel` ;

-- -----------------------------------------------------
-- Table `usel`.`Vessels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`vessels` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  `customer_id`INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `vessels_idx_fk` 
  FOREIGN KEY (`id`) 
  REFERENCES `customers` (`id`))
  ENGINE = InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
  


-- -----------------------------------------------------
-- Table `usel`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `own_po` INT NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  `vessel_id` INT NULL,
  `purchase_id`INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `customers_idx_fk` 
  FOREIGN KEY (`purchase_id`) 
  REFERENCES `purchases` (`po`))
  ENGINE = InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
  


-- -----------------------------------------------------
-- Table `usel`.`Jobs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`jobs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(120) NOT NULL,
  `dueDate` DATE NOT NULL,
  `mSSale` VARCHAR(45) NOT NULL,
  `status` TINYINT(1) NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `jobs_idx_fk` 
  FOREIGN KEY (`id`) 
  REFERENCES `customers` (`id`))
  ENGINE = InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
  
-- -----------------------------------------------------
-- Table `usel`.`Vendors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`vendors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  `purchase_id`INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `vendors_idx_fk` 
  FOREIGN KEY (`purchase_id`) 
  REFERENCES `purchases` (`po`))
  ENGINE = InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `usel`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `short_name` VARCHAR(3) NOT NULL,
  `is_enabled` TINYINT(1) NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  `purchase_id`INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `users_idx_fk` 
  FOREIGN KEY (`purchase_id`) 
  REFERENCES `purchases` (`po`))
  ENGINE = InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `usel`.`Purchases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usel`.`purchases` (
  `po` INT NOT NULL AUTO_INCREMENT,
  `final_po_number` VARCHAR(15) NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  PRIMARY KEY (`po`))
  ENGINE = InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; 