DROP SCHEMA IF EXISTS `hb-04-one-to-many-uni`;

CREATE SCHEMA `hb-04-one-to-many-uni`;

USE `hb-04-one-to-many-uni`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
	`id` int(11) NOT NULL auto_increment,
    `youtube_channel` varchar(128) default null,
    `hobby` varchar(45) default null,
    primary key(`id`)
)	engine=InnoDB auto_increment=1 default charset=latin1;

DROP TABLE IF EXISTS `instructor`;

create table `instructor` (
	`id` int(11) NOT NULL auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    `instructor_detail_id` int(11) default null,
    primary key (`id`),
    KEY `FK_DETAIL_idx` (`instructor_detail_id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
    REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
	`id` int(11) NOT NULL auto_increment,
    `title` varchar(45) Default null,
    `instructor_id` int(11) default null,
    primary key(`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),
    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR`
    FOREIGN KEY (`instructor_id`)
    REFERENCES `instructor` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
)engine=InnoDB auto_increment=10 default charset=latin1;

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`id` int(11) NOT NULL auto_increment,
    `comment` varchar(256) default null,
    `course_id` int(11) default null,
    primary key(`id`),
    
    KEY `FK_COURSE_idx` (`course_id`),
    CONSTRAINT `FK_COURSE`
    FOREIGN KEY (`course_id`)
    REFERENCES `course` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
)engine=InnoDB auto_increment=1 default charset=latin1;