-- MySQL dump 10.13  Distrib 5.6.23, for osx10.8 (x86_64)
--
-- Host: 172.30.10.198    Database: peru
-- ------------------------------------------------------
-- Server version	5.6.17-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `facebook_account`
--

DROP TABLE IF EXISTS `facebook_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facebook_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `facebook_id` varchar(100) NOT NULL,
  `access_token` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facebook_account`
--

LOCK TABLES `facebook_account` WRITE;
/*!40000 ALTER TABLE `facebook_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `facebook_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_daily`
--

DROP TABLE IF EXISTS `report_daily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_daily` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `date` int(10) NOT NULL,
  `facebook_id` varchar(100) NOT NULL DEFAULT '',
  `adset_id` varchar(100) NOT NULL DEFAULT '',
  `gmv` decimal(10,0) DEFAULT '0',
  `spend` decimal(10,0) DEFAULT '0',
  `budget` decimal(10,0) DEFAULT '0',
  `impressions` int(11) DEFAULT '0',
  `frequency` float DEFAULT '0',
  `reachs` int(11) DEFAULT '0',
  `clicks` int(11) DEFAULT '0',
  `purchases` int(11) DEFAULT '0',
  `cost_general` decimal(10,0) DEFAULT '0',
  `cost_purchasing` decimal(10,0) DEFAULT '0',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_daily`
--

LOCK TABLES `report_daily` WRITE;
/*!40000 ALTER TABLE `report_daily` DISABLE KEYS */;
INSERT INTO `report_daily` VALUES (1,2018020800,'10001','20001',10,10,10,10,1,1000,1000,10000,2,3,'2018-05-10 17:25:48');
/*!40000 ALTER TABLE `report_daily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_hourly`
--

DROP TABLE IF EXISTS `report_hourly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_hourly` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `date` int(10) NOT NULL,
  `facebook_id` varchar(100) NOT NULL DEFAULT '',
  `adset_id` varchar(100) NOT NULL DEFAULT '',
  `gmv` decimal(10,0) DEFAULT '0',
  `spend` decimal(10,0) DEFAULT '0',
  `budget` decimal(10,0) DEFAULT '0',
  `impressions` int(11) DEFAULT '0',
  `frequency` float DEFAULT '0',
  `reachs` int(11) DEFAULT '0',
  `clicks` int(11) DEFAULT '0',
  `purchases` int(11) DEFAULT '0',
  `cost_general` decimal(10,0) DEFAULT '0',
  `cost_purchasing` decimal(10,0) DEFAULT '0',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_hourly`
--

LOCK TABLES `report_hourly` WRITE;
/*!40000 ALTER TABLE `report_hourly` DISABLE KEYS */;
INSERT INTO `report_hourly` VALUES (1,2018050800,'10001','1',10,10,10,10000,1,1000,10000,1,1,1,'2018-05-10 17:25:06'),(2,2018050801,'10001','2',10,1,1111,1,1,1,1,1,1,1,'2018-05-10 18:14:31'),(3,2018050802,'10001','1',11,1,1,1,1,1,1,1,1,1,'2018-05-10 18:14:49');
/*!40000 ALTER TABLE `report_hourly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_authority`
--

DROP TABLE IF EXISTS `role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authority` (
  `role_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `authority_type` varchar(100) NOT NULL DEFAULT '',
  `authority_value` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_authority`
--

LOCK TABLES `role_authority` WRITE;
/*!40000 ALTER TABLE `role_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `password` char(32) NOT NULL DEFAULT '',
  `role_id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `status` enum('active','pending','deleted','blocked') NOT NULL DEFAULT 'pending',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'raymond','raymond@peru.com','e10adc3949ba59abbe56e057f20f883e',30,0,'active','2018-05-05 14:09:27');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `facebook_id` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,1,'10001');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11  2:27:42
