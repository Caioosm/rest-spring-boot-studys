CREATE TABLE `person` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(50) NOT NULL,
    `last_name` varchar(50) NOT NULL,
    `birth_day` datetime(6) DEFAULT NULL,
    `gender` varchar(6) NOT NULL,
    `address` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
);