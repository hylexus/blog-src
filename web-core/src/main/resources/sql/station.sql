CREATE DATABASE IF NOT EXISTS common
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;
# http://blog.csdn.net/a364572/article/details/50483568
CREATE TABLE station
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(20) NULL,
  lng  DOUBLE      NULL
  COMMENT '经度',
  lat  DOUBLE      NULL
  COMMENT '维度'
);

