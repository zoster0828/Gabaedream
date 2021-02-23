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
```
