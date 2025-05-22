DROP DATABASE IF EXISTS `AM_JDBC_2025_05`;
CREATE DATABASE `AM_JDBC_2025_05`;
USE `AM_JDBC_2025_05`;

CREATE TABLE `article`(
    `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `regDate` DATETIME NOT NULL,
    `updateDate` DATETIME NOT NULL,
    `memberId` INT NOT NULL,
    `title` CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);

INSERT INTO `article`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `memberId` = 1,
    `title` = '제목1',
    `body` = '내용1';


INSERT INTO `article`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `memberId` = 2,
    `title` = '제목2',
    `body` = '내용2';

CREATE TABLE `member`(
    `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `regDate` DATETIME NOT NULL,
    `updateDate` DATETIME NOT NULL,
    `loginId` CHAR(30) NOT NULL,
    `loginPw` CHAR(100) NOT NULL,
    `name` CHAR(100) NOT NULL
);

INSERT INTO `member`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `loginId` = 'test1',
    `loginPw` = 'test1',
    `name` = '홍길동';

INSERT INTO `member`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `loginId` = 'test2',
    `loginPw` = 'test2',
    `name` = '김철수';

INSERT INTO `member`
SET `regDate` = NOW(),
    `updateDate` = NOW(),
    `loginId` = 'test3',
    `loginPw` = 'test3',
    `name` = '임꺽정';
#2배수로 글 늘리기
#INSERT INTO `article` (regDate, updateDate, title, `body`)
#SELECT NOW(), NOW(), CONCAT('title', SUBSTR(UUID(), 1, 8)),  CONCAT('body', SUBSTR(UUID(), 1, 8))
#FROM `article`;
# 게시글 테스트 데이터 대량 생성
INSERT INTO `article`
SET `regDate` = NOW(),
	`updateDate` = NOW(),
	`memberId` = FLOOR(RAND() * 3)+1,
	`title` = CONCAT('제목', SUBSTR(RAND() * 1000 FROM 1 FOR 2)),
	`body` = CONCAT('내용', SUBSTR(RAND() * 1000 FROM 1 FOR 2));

#검색기능 (제목2가 포함된 글들 1번부터 시작해서 10개 출력)
SELECT a.*, m.id, m.name
FROM `article` a
INNER JOIN `member` m
ON a.memberId = m.id
WHERE a.title LIKE CONCAT('%','제목2','%')
ORDER BY a.`id` DESC
LIMIT 1, 10;


SELECT * FROM `article`;
SELECT * FROM `member`;