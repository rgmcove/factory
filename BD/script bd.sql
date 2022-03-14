-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema factory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `factory` ;

-- -----------------------------------------------------
-- Schema factory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `factory` DEFAULT CHARACTER SET utf8 ;
USE `factory` ;

-- -----------------------------------------------------
-- Table `factory`.`ESTADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`ESTADO` (
  `id_estado` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `factory`.`PRODUCTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`PRODUCTO` (
  `id_producto` BIGINT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `valor_unidad` DECIMAL NOT NULL,
  `fk_estado` INT NOT NULL,
  PRIMARY KEY (`id_producto`),
  INDEX `fk_PRODUCTO_ESTADO_idx` (`fk_estado` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_ESTADO`
    FOREIGN KEY (`fk_estado`)
    REFERENCES `factory`.`ESTADO` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `factory`.`TIPO_DOCUMENTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`TIPO_DOCUMENTO` (
  `id_tipo_documento` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_documento`),
  UNIQUE INDEX `descripcion_UNIQUE` (`descripcion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `factory`.`CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`CLIENTE` (
  `id_cliente` BIGINT NOT NULL AUTO_INCREMENT,
  `primer_nombre` VARCHAR(45) NOT NULL,
  `segundo_nombre` VARCHAR(45) NULL,
  `primer_apellido` VARCHAR(45) NOT NULL,
  `segundo_apellido` VARCHAR(45) NULL,
  `fk_tipo_documento` INT NOT NULL,
  `numero_documento` VARCHAR(18) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_CLIENTE_TIPO_DOCUMENTO1_idx` (`fk_tipo_documento` ASC) VISIBLE,
  CONSTRAINT `fk_CLIENTE_TIPO_DOCUMENTO1`
    FOREIGN KEY (`fk_tipo_documento`)
    REFERENCES `factory`.`TIPO_DOCUMENTO` (`id_tipo_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `factory`.`FACTURA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`FACTURA` (
  `id_factura` BIGINT NOT NULL AUTO_INCREMENT,
  `cajero` VARCHAR(100) NOT NULL,
  `caja` VARCHAR(15) NOT NULL,
  `fk_cliente` BIGINT NOT NULL,
  `cantidad` INT NOT NULL,
  `valor_total` DECIMAL NOT NULL,
  PRIMARY KEY (`id_factura`),
  UNIQUE INDEX `caja_UNIQUE` (`caja` ASC) VISIBLE,
  INDEX `fk_FACTURA_CLIENTE1_idx` (`fk_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURA_CLIENTE1`
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `factory`.`CLIENTE` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `factory`.`FACTURA_PRODUCTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`FACTURA_PRODUCTO` (
  `id_factura` BIGINT NOT NULL,
  `id_producto` BIGINT NOT NULL,
  PRIMARY KEY (`id_factura`, `id_producto`),
  INDEX `fk_FACTURA_has_PRODUCTO_PRODUCTO1_idx` (`id_producto` ASC) VISIBLE,
  INDEX `fk_FACTURA_has_PRODUCTO_FACTURA1_idx` (`id_factura` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURA_has_PRODUCTO_FACTURA1`
    FOREIGN KEY (`id_factura`)
    REFERENCES `factory`.`FACTURA` (`id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_has_PRODUCTO_PRODUCTO1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `factory`.`PRODUCTO` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `factory`.`ESTADO`
-- -----------------------------------------------------
START TRANSACTION;
USE `factory`;
INSERT INTO `factory`.`ESTADO` (`id_estado`, `descripcion`) VALUES (1, 'AGOTADO');
INSERT INTO `factory`.`ESTADO` (`id_estado`, `descripcion`) VALUES (2, 'EXISTENCIAS');

COMMIT;


-- -----------------------------------------------------
-- Data for table `factory`.`TIPO_DOCUMENTO`
-- -----------------------------------------------------
START TRANSACTION;
USE `factory`;
INSERT INTO `factory`.`TIPO_DOCUMENTO` (`id_tipo_documento`, `descripcion`) VALUES (1, 'CC');
INSERT INTO `factory`.`TIPO_DOCUMENTO` (`id_tipo_documento`, `descripcion`) VALUES (2, 'TI');
INSERT INTO `factory`.`TIPO_DOCUMENTO` (`id_tipo_documento`, `descripcion`) VALUES (3, 'CE');
INSERT INTO `factory`.`TIPO_DOCUMENTO` (`id_tipo_documento`, `descripcion`) VALUES (4, 'PASAPORTE');
INSERT INTO `factory`.`TIPO_DOCUMENTO` (`id_tipo_documento`, `descripcion`) VALUES (5, 'NIT');

COMMIT;

