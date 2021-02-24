# TABLE SCHEMA

```mysql
CREATE TABLE user_info
(    
    user_id varchar(20) PRIMARY KEY,        
    password varchar(30),
    nick_name varchar(20),
    legal_name varchar(20),
    phone_number bigint(10),
    email varchar(30),
    address varchar(100),
    service_count int(10),
    user_status int(2),
    rating decimal(24,18),    
    messenger boolean
);

+---------------+----------------+------+-----+---------+-------+
| Field         | Type           | Null | Key | Default | Extra |
+---------------+----------------+------+-----+---------+-------+
| user_id       | varchar(20)    | NO   | PRI | NULL    |       |
| password      | varchar(30)    | YES  |     | NULL    |       |
| nick_name     | varchar(20)    | YES  |     | NULL    |       |
| legal_name    | varchar(20)    | YES  |     | NULL    |       |
| phone_number  | bigint(10)     | YES  |     | NULL    |       |
| email         | varchar(30)    | YES  |     | NULL    |       |
| address       | varchar(100)   | YES  |     | NULL    |       |
| service_count | int(10)        | YES  |     | NULL    |       |
| user_status   | int(2)         | YES  |     | NULL    |       |
| rating        | decimal(24,18) | YES  |     | NULL    |       |
| messenger     | tinyint(1)     | YES  |     | NULL    |       |
+---------------+----------------+------+-----+---------+-------+

CREATE TABLE `delivery_case` (
	`id` BIGINT(12) NOT NULL AUTO_INCREMENT,
	`start` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`destination` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`start_time` TIMESTAMP NOT NULL,
	`end_tme` TIMESTAMP NOT NULL,
	`price` INT(11) NOT NULL,
	`status` INT(1) NOT NULL,
	`sender_rating` DECIMAL(24,18) NULL DEFAULT NULL,
	`messenger_rating` DECIMAL(24,18) NULL DEFAULT NULL,
	`sender_id` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`messenger_id` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `messenger_info` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`start` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`destination` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`day` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`transportation` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`min_price` INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;
```

