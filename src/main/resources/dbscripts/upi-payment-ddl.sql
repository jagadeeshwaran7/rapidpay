CREATE TABLE `upi-payment`.`account`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`account_number` INTEGER NOT NULL,
	`account_holder_name` VARCHAR(200) NOT NULL,
	`mobile_number` INTEGER
);
CREATE TABLE `upi-payment`.`upi`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`upi_id` INTEGER NOT NULL,
	`account_number` VARCHAR(200) NOT NULL,
	`upi_secret` INTEGER,
	`upi_status` VARCHAR(20) NOT NULL,
	CONSTRAINT FK_id FOREIGN KEY(id)
        REFERENCES account(id)
);
