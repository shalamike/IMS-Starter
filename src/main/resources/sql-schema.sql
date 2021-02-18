CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `Cid` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`Cid`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
		`Iid` int(11) NOT NULL auto_increment,
        `item_name` varchar(40) default null,
        `item_price` int(11) default null,
        primary key (`Iid`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`Oid` int(11) NOT NULL auto_increment,
    `Cid` int(11) not null,
    `Iid`int(11)  not null, 
    `item_quantity` int(11) default null,
    `order_cost` int(11) default null,
    primary key(Oid),
    foreign key(`Cid`) references `ims`.`customers`(`Cid`),
    foreign key(`Iid`) references `ims`.`items`(`Iid`)
);

