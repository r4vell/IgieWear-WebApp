-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema IgieWear Database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema IgieWear Database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `IgieWear Database` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
USE `IgieWear Database` ;

-- -----------------------------------------------------
-- Table `IgieWear Database`.`DeliveryAddress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`DeliveryAddress` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`DeliveryAddress` (
  `deliveryAddressID` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `surname` VARCHAR(45) NULL COMMENT '',
  `city` VARCHAR(45) NULL COMMENT '',
  `street` VARCHAR(45) NULL COMMENT '',
  `postalCode` VARCHAR(45) NULL COMMENT '',
  `apartmentNumber` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`deliveryAddressID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`User` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`User` (
  `userID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `surname` VARCHAR(45) NULL COMMENT '',
  `deliveryAddress` INT NOT NULL COMMENT '',
  `email` VARCHAR(255) NULL COMMENT '',
  `password` VARCHAR(255) NULL COMMENT '',
  `active` TINYINT(1) NULL COMMENT '',
  `dateCreated` TIMESTAMP NULL COMMENT '',
  `admin` TINYINT(1) NULL COMMENT '',
  PRIMARY KEY (`userID`, `deliveryAddress`)  COMMENT '',
  UNIQUE INDEX `idUser_UNIQUE` (`userID` ASC)  COMMENT '',
  INDEX `fk_User_DeliveryAddress1_idx` (`deliveryAddress` ASC)  COMMENT '',
  CONSTRAINT `fk_User_DeliveryAddress1`
    FOREIGN KEY (`deliveryAddress`)
    REFERENCES `IgieWear Database`.`DeliveryAddress` (`deliveryAddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'User Representation in DB';


-- -----------------------------------------------------
-- Table `IgieWear Database`.`ProductCategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`ProductCategory` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`ProductCategory` (
  `productCategoryID` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`productCategoryID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`Product` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`Product` (
  `productID` INT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` TEXT NULL COMMENT '',
  `price` DECIMAL(10,0) NULL COMMENT '',
  `productCategory` INT NOT NULL COMMENT '',
  PRIMARY KEY (`productID`, `productCategory`)  COMMENT '',
  INDEX `fk_Product_ProductCategory1_idx` (`productCategory` ASC)  COMMENT '',
  UNIQUE INDEX `productID_UNIQUE` (`productID` ASC)  COMMENT '',
  CONSTRAINT `fk_Product_ProductCategory1`
    FOREIGN KEY (`productCategory`)
    REFERENCES `IgieWear Database`.`ProductCategory` (`productCategoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`Payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`Payment` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`Payment` (
  `paymentID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `state` VARCHAR(45) NULL COMMENT '',
  `method` VARCHAR(45) NULL COMMENT '',
  `timestamp` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`paymentID`)  COMMENT '',
  UNIQUE INDEX `paymentID_UNIQUE` (`paymentID` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`Order` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`Order` (
  `orderID` INT NOT NULL COMMENT '',
  `userID` INT NOT NULL COMMENT '',
  `deliveryAddress` INT NOT NULL COMMENT '',
  `paymentID` INT NOT NULL COMMENT '',
  `state` VARCHAR(45) NULL COMMENT '',
  `comment` TEXT NULL COMMENT '',
  `orderDate` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`orderID`, `userID`, `deliveryAddress`, `paymentID`)  COMMENT '',
  UNIQUE INDEX `idOrder_UNIQUE` (`orderID` ASC)  COMMENT '',
  INDEX `fk_Order_User1_idx` (`userID` ASC)  COMMENT '',
  INDEX `fk_Order_DeliveryAddress1_idx` (`deliveryAddress` ASC)  COMMENT '',
  INDEX `fk_Order_Payment1_idx` (`paymentID` ASC)  COMMENT '',
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`userID`)
    REFERENCES `IgieWear Database`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_DeliveryAddress1`
    FOREIGN KEY (`deliveryAddress`)
    REFERENCES `IgieWear Database`.`DeliveryAddress` (`deliveryAddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Payment1`
    FOREIGN KEY (`paymentID`)
    REFERENCES `IgieWear Database`.`Payment` (`paymentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`ShirtSize`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`ShirtSize` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`ShirtSize` (
  `shirtSizeID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`shirtSizeID`)  COMMENT '',
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)  COMMENT '',
  UNIQUE INDEX `shirtSizeID_UNIQUE` (`shirtSizeID` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`Color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`Color` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`Color` (
  `colorID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`colorID`)  COMMENT '',
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)  COMMENT '',
  UNIQUE INDEX `colorID_UNIQUE` (`colorID` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`OrderedShirts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`OrderedShirts` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`OrderedShirts` (
  `orderedProductsID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `productID` INT NOT NULL COMMENT '',
  `orderID` INT NOT NULL COMMENT '',
  `quantity` INT NULL COMMENT '',
  `totalPrice` DECIMAL(10,0) NULL COMMENT '',
  `shirtSizeID` INT NOT NULL COMMENT '',
  `colorID` INT NOT NULL COMMENT '',
  PRIMARY KEY (`orderedProductsID`, `productID`, `orderID`, `shirtSizeID`, `colorID`)  COMMENT '',
  UNIQUE INDEX `idOrderedProducts_UNIQUE` (`orderedProductsID` ASC)  COMMENT '',
  INDEX `fk_OrderedShirts_Shirt1_idx` (`productID` ASC)  COMMENT '',
  INDEX `fk_OrderedShirts_Order1_idx` (`orderID` ASC)  COMMENT '',
  INDEX `fk_OrderedShirts_ShirtSize1_idx` (`shirtSizeID` ASC)  COMMENT '',
  INDEX `fk_OrderedShirts_Color1_idx` (`colorID` ASC)  COMMENT '',
  CONSTRAINT `fk_OrderedShirts_Shirt1`
    FOREIGN KEY (`productID`)
    REFERENCES `IgieWear Database`.`Product` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderedShirts_Order1`
    FOREIGN KEY (`orderID`)
    REFERENCES `IgieWear Database`.`Order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderedShirts_ShirtSize1`
    FOREIGN KEY (`shirtSizeID`)
    REFERENCES `IgieWear Database`.`ShirtSize` (`shirtSizeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderedShirts_Color1`
    FOREIGN KEY (`colorID`)
    REFERENCES `IgieWear Database`.`Color` (`colorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`Comment` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`Comment` (
  `commentID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `userID` INT NOT NULL COMMENT '',
  `productID` INT NOT NULL COMMENT '',
  `text` TEXT NULL COMMENT '',
  `timestamp` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`commentID`, `userID`, `productID`)  COMMENT '',
  INDEX `fk_Comment_User1_idx` (`userID` ASC)  COMMENT '',
  INDEX `fk_Comment_Product1_idx` (`productID` ASC)  COMMENT '',
  UNIQUE INDEX `CommentID_UNIQUE` (`commentID` ASC)  COMMENT '',
  CONSTRAINT `fk_Comment_User1`
    FOREIGN KEY (`userID`)
    REFERENCES `IgieWear Database`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Product1`
    FOREIGN KEY (`productID`)
    REFERENCES `IgieWear Database`.`Product` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IgieWear Database`.`Avability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IgieWear Database`.`Avability` ;

CREATE TABLE IF NOT EXISTS `IgieWear Database`.`Avability` (
  `productID` INT NOT NULL COMMENT '',
  `shirtSizeID` INT NOT NULL COMMENT '',
  `colorID` INT NOT NULL COMMENT '',
  PRIMARY KEY (`productID`, `shirtSizeID`, `colorID`)  COMMENT '',
  INDEX `fk_Shirt_has_ShirtSize_ShirtSize1_idx` (`shirtSizeID` ASC)  COMMENT '',
  INDEX `fk_Shirt_has_ShirtSize_Shirt1_idx` (`productID` ASC)  COMMENT '',
  INDEX `fk_Avability_Color1_idx` (`colorID` ASC)  COMMENT '',
  CONSTRAINT `fk_Shirt_has_ShirtSize_Shirt1`
    FOREIGN KEY (`productID`)
    REFERENCES `IgieWear Database`.`Product` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shirt_has_ShirtSize_ShirtSize1`
    FOREIGN KEY (`shirtSizeID`)
    REFERENCES `IgieWear Database`.`ShirtSize` (`shirtSizeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avability_Color1`
    FOREIGN KEY (`colorID`)
    REFERENCES `IgieWear Database`.`Color` (`colorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
