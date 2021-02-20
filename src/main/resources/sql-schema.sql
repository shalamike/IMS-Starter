CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `Cust_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) not NULL,
    `surname` VARCHAR(40) not NULL,
    PRIMARY KEY (`Cust_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
		`Item_id` int(11) NOT NULL auto_increment,
        `item_name` varchar(40) default null,
        `item_price` float(11) default null,
        primary key (`Item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`Order_id` int(11) NOT NULL auto_increment,
    `Cust_id` int(11) not null,
    `Item_id`int(11)  not null, 
    `item_quantity` int(11) not null,
    primary key(`Order_id`),
    foreign key(`Cust_id`) references `ims`.`customers`(`Cust_id`),
    foreign key(`Item_id`) references `ims`.`items`(`Item_id`)
);

