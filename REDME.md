CREATE TABLE `customer` (
  `CUST_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NOT NULL,
  `AGE` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`CUST_ID`)
);



DROP PROCEDURE IF EXISTS `spring-jdbc`.`get_customer`;
DELIMITER $$

CREATE   PROCEDURE `spring-jdbc`.`get_customer`(IN varCustomerId INT, OUT varName VARCHAR(100), OUT varAge INT)
    BEGIN
	SELECT * FROM customer WHERE cust_Id =varCustomerId;
    END$$

DELIMITER ;