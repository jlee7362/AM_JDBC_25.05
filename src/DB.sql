DROP DATABASE IF EXISTS `AM_JDBC_2025_05`;
CREATE DATABASE `AM_JDBC_2025_05`;
USE `AM_JDBC_2025_05`;


CREATE TABLE `article`(
	`id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`regDate` DATETIME NOT NULL,
	`updateDate` DATETIME NOT NULL,
	`title` CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

INSERT INTO `article`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`title` = '제목1',
	`body` = '내용1';

	SELECT * FROM `article`;
ORDER BY `id` DESC;

UPDATE `article`
SET `updateDate` = NOW(),
	`title` = '제목1',
	`body` = '내용1'
	WHERE `id` = 1;