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

SELECT *
FROM `article`
WHERE `id`= ?;
             id

# Member command
USE `am_jdbc_2025_05`;

SHOW TABLES;
DESC `member`;

SELECT * FROM `member`;
SELECT * FROM `article`;

SELECT*#, count(*) > 0
FROM `member`
WHERE `loginId` = 'test2';



CREATE TABLE `member`(
	`id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`regDate` DATETIME NOT NULL,
	`updateDate` DATETIME NOT NULL,
	`loginId` CHAR(30) NOT NULL,
	`loginPw` CHAR(100) NOT NULL,
	`name` CHAR(100) NOT NULL
);
INSERT INTO `member`
SET	`regDate` = NOW(),
	`updateDate` =NOW(),
	`loginId` ='test1',
	`loginPw` ='test1',
	`name` ='홍길동';
INSERT INTO `member`
SET	`regDate` = NOW(),
	`updateDate` =NOW(),
	`loginId` ='test2',
	`loginPw` ='test2',
	`name` ='홍길순';

SELECT * FROM `member`;
