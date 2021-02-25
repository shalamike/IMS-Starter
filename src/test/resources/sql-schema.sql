  
 
drop schema `ims`;
create schema if not exists `ims`;


use `ims`;


drop table if exists `customers` ;
CREATE TABLE IF NOT EXISTS `customers` (
    `Cust_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) not NULL,
    `surname` VARCHAR(40) not NULL,
    PRIMARY KEY (`Cust_id`)
);



drop table if exists `items`  ;
CREATE TABLE IF NOT EXISTS `items`(
        `Item_id` int(11) NOT NULL auto_increment,
        `item_name` varchar(40) default null,
        `item_price` float(11) default null,
        primary key (`Item_id`)
);


drop table if exists `orders` CASCADE;
CREATE TABLE IF NOT EXISTS `orders` (
    `Order_id` int(11) NOT NULL auto_increment,
    `Cust_id` int(11) not null,
    `Item_id`int(11)  not null, 
    `item_quantity` int(11) not null,
    primary key(`Order_id`),
    foreign key(`Cust_id`) references `ims`.`customers`(`Cust_id`)  ON DELETE CASCADE,
    foreign key(`Item_id`) references `ims`.`items`(`Item_id`)  ON DELETE CASCADE
);






