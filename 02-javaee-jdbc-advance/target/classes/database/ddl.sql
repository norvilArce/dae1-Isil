create database if not exists demo;

use demo;

drop table if exists employees;

CREATE TABLE `employees`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `salary` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- DEFINE STORED PROCEDURES
--

DELIMITER $$
DROP PROCEDURE IF EXISTS `get_count_for_department`$$

CREATE  PROCEDURE `get_count_for_department`(IN the_department VARCHAR(64), OUT the_count INT)
BEGIN

	SELECT COUNT(*) INTO the_count FROM employees where department=the_department;

END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `get_employees_for_department`$$

CREATE  PROCEDURE `get_employees_for_department`(IN the_department VARCHAR(64))
BEGIN

	SELECT * from employees where department=the_department;

END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `greet_the_department`$$

CREATE  PROCEDURE `greet_the_department`(INOUT department VARCHAR(64))
BEGIN

	SET department = concat('Hello to the awesome ', department, ' team!');

END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `increase_salaries_for_department`$$

CREATE  PROCEDURE `increase_salaries_for_department`(IN the_department VARCHAR(64), IN increase_amount DECIMAL(10,2))
BEGIN

	UPDATE employees SET salary= salary + increase_amount where department=the_department;

END$$
DELIMITER ;