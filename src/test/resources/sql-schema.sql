drop table if exists `orders` cascade;
drop table if exists `items`  cascade;
drop table if exists `customers` cascade;


CREATE TABLE IF NOT EXISTS `customers` (
    `Cust_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) not NULL,
    `surname` VARCHAR(40) not NULL,
    PRIMARY KEY (`Cust_id`)
);

CREATE TABLE IF NOT EXISTS `items`(
        `Item_id` int(11) NOT NULL auto_increment,
        `item_name` varchar(40) default null,
        `item_price` float(11) default null,
        primary key (`Item_id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `Order_id` int(11) NOT NULL auto_increment,
    `Cust_id` int(11) not null,
    `Item_id`int(11)  not null, 
    `item_quantity` int(11) not null,
    primary key(`Order_id`),
    foreign key(`Cust_id`) references `customers`(`Cust_id`)  ON DELETE CASCADE,
    foreign key(`Item_id`) references `items`(`Item_id`)  ON DELETE CASCADE
);






