-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fighterdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fighterdb` ;

-- -----------------------------------------------------
-- Schema fighterdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fighterdb` DEFAULT CHARACTER SET utf8 ;
USE `fighterdb` ;

-- -----------------------------------------------------
-- Table `universe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `universe` ;

CREATE TABLE IF NOT EXISTS `universe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `image_url` VARCHAR(3000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `power_bracket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `power_bracket` ;

CREATE TABLE IF NOT EXISTS `power_bracket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `image_url` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fighter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fighter` ;

CREATE TABLE IF NOT EXISTS `fighter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(3000) NULL,
  `universe_id` INT NOT NULL,
  `power_bracket_id` INT NOT NULL,
  `image_url` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fighter_universe_idx` (`universe_id` ASC),
  INDEX `fk_fighter_power_bracket1_idx` (`power_bracket_id` ASC),
  CONSTRAINT `fk_fighter_universe`
    FOREIGN KEY (`universe_id`)
    REFERENCES `universe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fighter_power_bracket1`
    FOREIGN KEY (`power_bracket_id`)
    REFERENCES `power_bracket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fight`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fight` ;

CREATE TABLE IF NOT EXISTS `fight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fighter_one_id` INT NOT NULL,
  `fighter_two_id` INT NOT NULL,
  `who_won_id` INT NOT NULL,
  `fight_date` DATETIME NULL,
  `image_url_one` VARCHAR(3000) NULL,
  `image_url_two` VARCHAR(3000) NULL,
  `who_vs_who` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fight_fighter1_idx` (`fighter_one_id` ASC),
  INDEX `fk_fight_fighter2_idx` (`fighter_two_id` ASC),
  INDEX `fk_fight_fighter3_idx` (`who_won_id` ASC),
  CONSTRAINT `fk_fight_fighter1`
    FOREIGN KEY (`fighter_one_id`)
    REFERENCES `fighter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fight_fighter2`
    FOREIGN KEY (`fighter_two_id`)
    REFERENCES `fighter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fight_fighter3`
    FOREIGN KEY (`who_won_id`)
    REFERENCES `fighter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS root@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'root'@'localhost';
SET SQL_MODE = '';
DROP USER IF EXISTS fighthost@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'fighthost'@'localhost' IDENTIFIED BY 'fighthost';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'fighthost'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `universe`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `universe` (`id`, `name`, `image_url`) VALUES (1, 'Marvel', NULL);
INSERT INTO `universe` (`id`, `name`, `image_url`) VALUES (2, 'DC', NULL);
INSERT INTO `universe` (`id`, `name`, `image_url`) VALUES (3, 'Anime', NULL);
INSERT INTO `universe` (`id`, `name`, `image_url`) VALUES (4, 'VideoGames', NULL);
INSERT INTO `universe` (`id`, `name`, `image_url`) VALUES (5, 'Toon', NULL);
INSERT INTO `universe` (`id`, `name`, `image_url`) VALUES (6, 'Other', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `power_bracket`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `power_bracket` (`id`, `name`, `image_url`, `description`) VALUES (1, 'ultra human', NULL, NULL);
INSERT INTO `power_bracket` (`id`, `name`, `image_url`, `description`) VALUES (2, 'super', NULL, NULL);
INSERT INTO `power_bracket` (`id`, `name`, `image_url`, `description`) VALUES (3, 'super duper', NULL, NULL);
INSERT INTO `power_bracket` (`id`, `name`, `image_url`, `description`) VALUES (4, 'planet destroyer', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `fighter`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (1, 'Goku', NULL, 3, 4, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (2, 'Silver Surfer', NULL, 1, 4, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (3, 'Batman', NULL, 2, 1, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (4, 'Superman', NULL, 2, 3, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (5, 'Vampire Hunter D', NULL, 3, 2, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (6, 'Geralt of Rivia', NULL, 4, 1, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (7, 'Wolverine', NULL, 1, 2, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (8, 'Deadpool', NULL, 1, 2, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (9, 'Rengoku the Flame Hashira', NULL, 3, 1, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (10, 'Velociraptor', NULL, 6, 1, NULL);
INSERT INTO `fighter` (`id`, `name`, `description`, `universe_id`, `power_bracket_id`, `image_url`) VALUES (11, 'Bugs Bunny', NULL, 5, 3, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `fight`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `fight` (`id`, `fighter_one_id`, `fighter_two_id`, `who_won_id`, `fight_date`, `image_url_one`, `image_url_two`, `who_vs_who`) VALUES (1, 1, 2, 1, NULL, NULL, NULL, 'Goku vs Silver Surfer');

COMMIT;

