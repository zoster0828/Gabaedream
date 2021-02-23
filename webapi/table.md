# TABLE SCHEMA

```mysql
CREATE TABLE user_info
(
    server_id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,    
    user_id varchar(20) UNIQUE,        
    password varchar(30),
    nick_name varchar(20),
    legal_name varchar(20),
    phoneNumber int(10),
    email varchar(30),
    address varchar(100),
    service_count int(10),
    user_status int(2),
    rating decimal(24,18),    
    messenger boolean
);

+---------------+----------------+------+-----+---------+----------------+
| Field         | Type           | Null | Key | Default | Extra          |
+---------------+----------------+------+-----+---------+----------------+
| server_id     | int(10)        | NO   | PRI | NULL    | auto_increment |
| user_id       | varchar(20)    | YES  | UNI | NULL    |                |
| password      | varchar(30)    | YES  |     | NULL    |                |
| nick_name     | varchar(20)    | YES  |     | NULL    |                |
| legal_name    | varchar(20)    | YES  |     | NULL    |                |
| phoneNumber   | int(10)        | YES  |     | NULL    |                |
| email         | varchar(30)    | YES  |     | NULL    |                |
| address       | varchar(100)   | YES  |     | NULL    |                |
| service_count | int(10)        | YES  |     | NULL    |                |
| user_status   | int(2)         | YES  |     | NULL    |                |
| rating        | decimal(24,18) | YES  |     | NULL    |                |
| messenger     | tinyint(1)     | YES  |     | NULL    |                |
+---------------+----------------+------+-----+---------+----------------+
```
