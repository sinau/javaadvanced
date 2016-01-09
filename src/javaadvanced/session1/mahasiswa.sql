CREATE DATABASE sinau;

USE sinau;

CREATE TABLE `sinau`.`mahasiswa` (
  `nim` VARCHAR(15) NOT NULL,
  `nama` VARCHAR(50) NOT NULL,
  `nohp` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`nim`));
