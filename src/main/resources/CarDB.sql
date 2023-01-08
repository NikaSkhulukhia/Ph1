-- MySQL Script generated by MySQL Workbench
-- Mon Jan  9 00:32:20 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `id_number` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_brands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_brands` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Brand_Models`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Brand_Models` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `Car_brands_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Brand_Models_Car_brands1_idx` (`Car_brands_id` ASC) VISIBLE,
  CONSTRAINT `fk_Brand_Models_Car_brands1`
    FOREIGN KEY (`Car_brands_id`)
    REFERENCES `mydb`.`Car_brands` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` DATE NOT NULL,
  `user_id` INT NOT NULL,
  `Car_brands_id` INT NOT NULL,
  `Brand_Models_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cars_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_Cars_Car_brands1_idx` (`Car_brands_id` ASC) VISIBLE,
  INDEX `fk_Cars_Brand_Models1_idx` (`Brand_Models_id` ASC) VISIBLE,
  CONSTRAINT `fk_cars_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cars_Car_brands1`
    FOREIGN KEY (`Car_brands_id`)
    REFERENCES `mydb`.`Car_brands` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cars_Brand_Models1`
    FOREIGN KEY (`Brand_Models_id`)
    REFERENCES `mydb`.`Brand_Models` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_part_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_part_categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Shops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Shops` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_Parts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_Parts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `serial_number` VARCHAR(45) NOT NULL,
  `price` DECIMAL(2) NOT NULL,
  `Car_part_categories_id` INT NOT NULL,
  `Shops_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Car_Parts_Car_part_categories1_idx` (`Car_part_categories_id` ASC) VISIBLE,
  INDEX `fk_Car_Parts_Shops1_idx` (`Shops_id` ASC) VISIBLE,
  CONSTRAINT `fk_Car_Parts_Car_part_categories1`
    FOREIGN KEY (`Car_part_categories_id`)
    REFERENCES `mydb`.`Car_part_categories` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Car_Parts_Shops1`
    FOREIGN KEY (`Shops_id`)
    REFERENCES `mydb`.`Shops` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Service_Stations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Service_Stations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Shop_Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Shop_Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Users_id` INT NOT NULL,
  `Shops_id` INT NOT NULL,
  `Car_Parts_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `Users_id`, `Shops_id`),
  INDEX `fk_Users_has_Shops_Shops1_idx` (`Shops_id` ASC) VISIBLE,
  INDEX `fk_Users_has_Shops_Users1_idx` (`Users_id` ASC) VISIBLE,
  INDEX `fk_Shop_Orders_Car_Parts1_idx` (`Car_Parts_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_Shops_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Shops_Shops1`
    FOREIGN KEY (`Shops_id`)
    REFERENCES `mydb`.`Shops` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shop_Orders_Car_Parts1`
    FOREIGN KEY (`Car_Parts_id`)
    REFERENCES `mydb`.`Car_Parts` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_Services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Service_Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Service_Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Service_Stations_id` INT NOT NULL,
  `Cars_id` INT NOT NULL,
  `Car_Services_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `Service_Stations_id`, `Cars_id`),
  INDEX `fk_Service_Stations_has_Cars_Cars1_idx` (`Cars_id` ASC) VISIBLE,
  INDEX `fk_Service_Stations_has_Cars_Service_Stations1_idx` (`Service_Stations_id` ASC) VISIBLE,
  INDEX `fk_Service_Orders_Car_Services1_idx` (`Car_Services_id` ASC) VISIBLE,
  CONSTRAINT `fk_Service_Stations_has_Cars_Service_Stations1`
    FOREIGN KEY (`Service_Stations_id`)
    REFERENCES `mydb`.`Service_Stations` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Service_Stations_has_Cars_Cars1`
    FOREIGN KEY (`Cars_id`)
    REFERENCES `mydb`.`Cars` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Service_Orders_Car_Services1`
    FOREIGN KEY (`Car_Services_id`)
    REFERENCES `mydb`.`Car_Services` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Models_Parts_compatibility`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Models_Parts_compatibility` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Brand_Models_id` INT NOT NULL,
  `Car_Parts_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Brand_Models_id`, `Car_Parts_id`),
  INDEX `fk_Brand_Models_has_Car_Parts_Car_Parts1_idx` (`Car_Parts_id` ASC) VISIBLE,
  INDEX `fk_Brand_Models_has_Car_Parts_Brand_Models1_idx` (`Brand_Models_id` ASC) VISIBLE,
  CONSTRAINT `fk_Brand_Models_has_Car_Parts_Brand_Models1`
    FOREIGN KEY (`Brand_Models_id`)
    REFERENCES `mydb`.`Brand_Models` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Brand_Models_has_Car_Parts_Car_Parts1`
    FOREIGN KEY (`Car_Parts_id`)
    REFERENCES `mydb`.`Car_Parts` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
