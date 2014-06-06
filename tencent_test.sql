-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.49-1ubuntu8.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema tencent_test
--

CREATE DATABASE IF NOT EXISTS tencent_test;
USE tencent_test;

--
-- Definition of table `tencent_test`.`activity`
--

DROP TABLE IF EXISTS `tencent_test`.`activity`;
CREATE TABLE  `tencent_test`.`activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `id_creator` int(11) NOT NULL,
  `location` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `state` int(11) NOT NULL,
  `scope` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `activity_fk_creator` (`id_creator`),
  CONSTRAINT `activity_fk_creator` FOREIGN KEY (`id_creator`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`activity`
--

/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
LOCK TABLES `activity` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`activity_resource`
--

DROP TABLE IF EXISTS `tencent_test`.`activity_resource`;
CREATE TABLE  `tencent_test`.`activity_resource` (
  `id_resource` int(11) NOT NULL,
  `id_activity` int(11) NOT NULL,
  PRIMARY KEY (`id_resource`,`id_activity`),
  KEY `ar_fk_activity` (`id_activity`),
  CONSTRAINT `ar_fk_activity` FOREIGN KEY (`id_activity`) REFERENCES `activity` (`id`),
  CONSTRAINT `ar_fk_resource` FOREIGN KEY (`id_resource`) REFERENCES `resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`activity_resource`
--

/*!40000 ALTER TABLE `activity_resource` DISABLE KEYS */;
LOCK TABLES `activity_resource` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `activity_resource` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`blog`
--

DROP TABLE IF EXISTS `tencent_test`.`blog`;
CREATE TABLE  `tencent_test`.`blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `count` int(11) NOT NULL,
  `id_author` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blog_fk_author` (`id_author`),
  CONSTRAINT `blog_fk_author` FOREIGN KEY (`id_author`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`blog`
--

/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
LOCK TABLES `blog` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`contactus`
--

DROP TABLE IF EXISTS `tencent_test`.`contactus`;
CREATE TABLE  `tencent_test`.`contactus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) NOT NULL DEFAULT '匿名',
  `content` varchar(300) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`contactus`
--

/*!40000 ALTER TABLE `contactus` DISABLE KEYS */;
LOCK TABLES `contactus` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `contactus` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`message`
--

DROP TABLE IF EXISTS `tencent_test`.`message`;
CREATE TABLE  `tencent_test`.`message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_sender` int(11) NOT NULL,
  `topic` varchar(60) NOT NULL,
  `content` text NOT NULL,
  `outdate` tinyint(1) NOT NULL,
  `type` int(11) NOT NULL,
  `send_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `message_fk_sender` (`id_sender`),
  CONSTRAINT `message_fk_sender` FOREIGN KEY (`id_sender`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`message`
--

/*!40000 ALTER TABLE `message` DISABLE KEYS */;
LOCK TABLES `message` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`message_team`
--

DROP TABLE IF EXISTS `tencent_test`.`message_team`;
CREATE TABLE  `tencent_test`.`message_team` (
  `id_message` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  PRIMARY KEY (`id_message`,`id_team`),
  KEY `mt_fk_team` (`id_team`),
  CONSTRAINT `mt_fk_message` FOREIGN KEY (`id_message`) REFERENCES `message` (`id`),
  CONSTRAINT `mt_fk_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`message_team`
--

/*!40000 ALTER TABLE `message_team` DISABLE KEYS */;
LOCK TABLES `message_team` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `message_team` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`message_user`
--

DROP TABLE IF EXISTS `tencent_test`.`message_user`;
CREATE TABLE  `tencent_test`.`message_user` (
  `id_message` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_message`,`id_user`),
  KEY `mt_fk_user` (`id_user`),
  CONSTRAINT `mt_fk_message0		` FOREIGN KEY (`id_message`) REFERENCES `message` (`id`),
  CONSTRAINT `mt_fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`message_user`
--

/*!40000 ALTER TABLE `message_user` DISABLE KEYS */;
LOCK TABLES `message_user` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `message_user` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`project`
--

DROP TABLE IF EXISTS `tencent_test`.`project`;
CREATE TABLE  `tencent_test`.`project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `id_charger` int(11) NOT NULL,
  `type` int(2) NOT NULL,
  `defficulty` int(3) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `description` text NOT NULL,
  `state` int(11) NOT NULL,
  `image` varchar(30),
  `id_consignor` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_fk_charger` (`id_charger`),
  KEY `project_fk_consignor` (`id_consignor`),
  KEY `project_fk_team` (`id_team`),
  CONSTRAINT `project_fk_charger` FOREIGN KEY (`id_charger`) REFERENCES `user` (`id`),
  CONSTRAINT `project_fk_consignor` FOREIGN KEY (`id_consignor`) REFERENCES `user` (`id`),
  CONSTRAINT `project_fk_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
LOCK TABLES `project` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`project_resource`
--

DROP TABLE IF EXISTS `tencent_test`.`project_resource`;
CREATE TABLE  `tencent_test`.`project_resource` (
  `id_resource` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  PRIMARY KEY (`id_resource`,`id_project`),
  KEY `pr_fk_project` (`id_project`),
  CONSTRAINT `pr_fk_project` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`),
  CONSTRAINT `pr_fk_team` FOREIGN KEY (`id_resource`) REFERENCES `resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`project_resource`
--

/*!40000 ALTER TABLE `project_resource` DISABLE KEYS */;
LOCK TABLES `project_resource` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `project_resource` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`resource`
--

DROP TABLE IF EXISTS `tencent_test`.`resource`;
CREATE TABLE  `tencent_test`.`resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `type` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `input` int(11) NOT NULL DEFAULT '0',
  `output` int(11) NOT NULL DEFAULT '0',
  `cause` varchar(300) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`resource`
--

/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
LOCK TABLES `resource` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`task`
--

DROP TABLE IF EXISTS `tencent_test`.`task`;
CREATE TABLE  `tencent_test`.`task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_builder` int(11) NOT NULL,
  `content` text NOT NULL,
  `type` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `task_fk_builder` (`id_builder`),
  CONSTRAINT `task_fk_builder` FOREIGN KEY (`id_builder`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`task`
--

/*!40000 ALTER TABLE `task` DISABLE KEYS */;
LOCK TABLES `task` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`task_team`
--

DROP TABLE IF EXISTS `tencent_test`.`task_team`;
CREATE TABLE  `tencent_test`.`task_team` (
  `id_team` int(11) NOT NULL,
  `id_task` int(11) NOT NULL,
  PRIMARY KEY (`id_team`,`id_task`),
  KEY `tt_fk_task` (`id_task`),
  CONSTRAINT `tt_fk_task` FOREIGN KEY (`id_task`) REFERENCES `task` (`id`),
  CONSTRAINT `tt_fk_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`task_team`
--

/*!40000 ALTER TABLE `task_team` DISABLE KEYS */;
LOCK TABLES `task_team` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `task_team` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`team`
--

DROP TABLE IF EXISTS `tencent_test`.`team`;
CREATE TABLE  `tencent_test`.`team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `kind` int(2) NOT NULL,
  `summary` varchar(400) DEFAULT NULL,
  `id_master` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `logo` varchar(150) DEFAULT NULL,
  `score` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `team_pk_master` (`id_master`),
  CONSTRAINT `team_pk_master` FOREIGN KEY (`id_master`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`team`
--

/*!40000 ALTER TABLE `team` DISABLE KEYS */;
LOCK TABLES `team` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`team_activity`
--

DROP TABLE IF EXISTS `tencent_test`.`team_activity`;
CREATE TABLE  `tencent_test`.`team_activity` (
  `id_team` int(11) NOT NULL,
  `id_activity` int(11) NOT NULL,
  PRIMARY KEY (`id_team`,`id_activity`),
  KEY `ta_fk_activity` (`id_activity`),
  CONSTRAINT `ta_fk_activity` FOREIGN KEY (`id_activity`) REFERENCES `activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ta_fk_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`team_activity`
--

/*!40000 ALTER TABLE `team_activity` DISABLE KEYS */;
LOCK TABLES `team_activity` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `team_activity` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`team_user`
--

DROP TABLE IF EXISTS `tencent_test`.`team_user`;
CREATE TABLE  `tencent_test`.`team_user` (
  `id_team` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_team`),
  KEY `tu_fk_team` (`id_team`),
  CONSTRAINT `tu_fk_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`),
  CONSTRAINT `tu_fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`team_user`
--

/*!40000 ALTER TABLE `team_user` DISABLE KEYS */;
LOCK TABLES `team_user` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `team_user` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`user`
--

DROP TABLE IF EXISTS `tencent_test`.`user`;
CREATE TABLE  `tencent_test`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `truename` varchar(40) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(60) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `sex` char(1),
  `birthday` timestamp DEFAULT '0000-00-00 00:00:00', 
  `studentID` varchar(20),
  `major` varchar(30),
  `grade` varchar(10),
  `score` int(11) NOT NULL DEFAULT 0,
  `skill` varchar(20),
  `hobby` varchar(20),
  `level` int(11),
  `photo` varchar(150) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `reg_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `authority` int(3) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `tencent_test`.`user_resource`
--

DROP TABLE IF EXISTS `tencent_test`.`user_resource`;
CREATE TABLE  `tencent_test`.`user_resource` (
  `id_user` int(11) NOT NULL,
  `id_resource` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_resource`),
  KEY `ur_fk_resource` (`id_resource`),
  CONSTRAINT `ur_fk_resource` FOREIGN KEY (`id_resource`) REFERENCES `resource` (`id`),
  CONSTRAINT `ur_fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tencent_test`.`user_resource`
--

/*!40000 ALTER TABLE `user_resource` DISABLE KEYS */;
LOCK TABLES `user_resource` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `user_resource` ENABLE KEYS */;

DROP TABLE IF EXISTS `tencent_test`.`club`;
CREATE TABLE `tencent_test`.`club` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`clubname` varchar(20) NOT NULL,
	`logo` varchar(20) NOT NULL,
	`slogan` varchar(50) NOT NULL,
	`summary` varchar(300) NOT NULL,
	`create_date` timestamp DEFAULT CURRENT_TIMESTAMP,
	`history` varchar(300) NOT NULL,
	`id_master` int(11) NOT NULL,
	PRIMARY KEY(`id`),
	KEY `club_pk_master` (`id_master`),
  	CONSTRAINT `club_pk_master` FOREIGN KEY (`id_master`) REFERENCES `user` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
