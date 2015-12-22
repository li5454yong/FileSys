-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: filesys
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `u_id` int(11) DEFAULT NULL COMMENT '用户id',
  `p_id` varchar(50) DEFAULT NULL COMMENT '上级分类id',
  `self_id` varchar(50) DEFAULT NULL COMMENT '分类自身id',
  `title` varchar(50) DEFAULT NULL COMMENT '分类标题',
  `init_date` datetime DEFAULT NULL COMMENT '记录生成时间',
  `upd_date` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,4,'0','10','教程','2015-12-13 17:38:43','2015-12-13 17:38:46'),(3,4,'0','11','新建文件夹','2015-12-15 21:06:41','2015-12-15 21:06:41'),(4,4,'0','12','新建文件夹1','2015-12-15 21:07:55','2015-12-15 21:07:55'),(6,4,'10','1010','新建文件夹','2015-12-16 20:25:11','2015-12-16 20:25:11'),(7,4,'10','1011','新建文件夹1','2015-12-16 20:41:32','2015-12-16 20:41:32'),(8,4,'1010','101010','新建文件夹','2015-12-16 20:56:02','2015-12-16 20:56:02'),(9,4,'10','1012','新建文件夹2','2015-12-16 21:14:46','2015-12-16 21:14:46'),(10,4,'1010','101011','新建文件夹1','2015-12-16 21:15:06','2015-12-16 21:15:06'),(11,4,'101011','10101110','新建文件夹','2015-12-16 21:18:28','2015-12-16 21:18:28'),(12,4,'11','1110','新建文件夹','2015-12-16 21:18:57','2015-12-16 21:18:57'),(13,4,'1110','111010','新建文件夹','2015-12-16 21:19:02','2015-12-16 21:19:02'),(14,4,'1110','111011','新建文件夹1','2015-12-16 21:19:10','2015-12-16 21:19:10'),(15,4,'101010','10101010','新建文件夹','2015-12-21 17:17:13','2015-12-21 17:17:13'),(16,4,'1011','101110','java教程','2015-12-22 20:47:26','2015-12-22 20:47:26'),(17,4,'10101010','1010101010','新建文件夹','2015-12-22 21:58:42','2015-12-22 21:58:42');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_id` int(11) NOT NULL,
  `init_date` datetime DEFAULT NULL,
  `u_id` int(11) NOT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `filename` varchar(100) DEFAULT NULL COMMENT '文件名',
  `filesize` varchar(20) DEFAULT NULL COMMENT '文件大小',
  `filepath` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `uploaddate` datetime DEFAULT NULL COMMENT '上传时间',
  `category_id` varchar(50) DEFAULT NULL COMMENT '所属分类id',
  `downloadnum` int(11) DEFAULT NULL COMMENT '下载量',
  `filedesc` varchar(300) DEFAULT NULL COMMENT '文件描述',
  `public_share_path` varchar(50) DEFAULT NULL COMMENT '公开分享路径',
  `private_share_path` varchar(50) DEFAULT NULL COMMENT '私密分享路径',
  `distill_pwd` varchar(50) DEFAULT NULL COMMENT '文件提取码（文件为公开分享时为null)',
  `filetype` varchar(20) DEFAULT NULL COMMENT '文件类型',
  `init_date` datetime DEFAULT NULL COMMENT '记录生成时间',
  `upd_date` datetime DEFAULT NULL COMMENT '记录生成时间',
  `icon_path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` VALUES (36,'oracle新建表空间、用户、用户授权.txt','.54 Kb','D:/FileSys/upload/15628418747/教程/oracle新建表空间、用户、用户授权.txt',4,'2015-12-22 21:57:06','10',0,NULL,NULL,NULL,NULL,'txt','2015-12-22 21:57:06','2015-12-22 21:57:06','img/text.png'),(37,'JAVA_Demo.rar','6.37 M','D:/FileSys/upload/15628418747/教程/新建文件夹/新建文件夹/JAVA_Demo.rar',4,'2015-12-22 21:57:30','101010',0,NULL,NULL,NULL,NULL,'rar','2015-12-22 21:57:30','2015-12-22 21:57:30','img/rar.png'),(38,'JAVA_Demo.rar','6.37 M','D:/FileSys/upload/15628418747/教程/新建文件夹/新建文件夹/新建文件夹/新建文件夹/JAVA_Demo.rar',4,'2015-12-22 21:58:56','1010101010',0,NULL,NULL,NULL,NULL,'rar','2015-12-22 21:58:56','2015-12-22 21:58:56','img/rar.png'),(39,'JAVA_Demo.rar','6.37 M','D:/FileSys/upload/15628418747/教程/新建文件夹/新建文件夹/新建文件夹/JAVA_Demo.rar',4,'2015-12-22 21:59:26','10101010',0,NULL,NULL,NULL,NULL,'rar','2015-12-22 21:59:26','2015-12-22 21:59:26','img/rar.png'),(40,'上海融义投资咨询有限公司-接口文档.rar','3.78 M','D:/FileSys/upload/15628418747/教程/新建文件夹/新建文件夹/新建文件夹/新建文件夹/上海融义投资咨询有限公司-接口文档.rar',4,'2015-12-22 22:01:43','1010101010',0,NULL,NULL,NULL,NULL,'rar','2015-12-22 22:01:43','2015-12-22 22:01:43','img/rar.png');
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `memory_space` double DEFAULT NULL COMMENT '用户存储空间大小',
  `used_space` float unsigned zerofill DEFAULT '000000000000' COMMENT '已用存储空间大小',
  `reg_date` datetime DEFAULT NULL COMMENT '注册时间',
  `init_date` datetime DEFAULT NULL COMMENT '记录生成时间',
  `upd_date` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'aaa','aaa','111',NULL,NULL,NULL,NULL,NULL),(4,'15628418747',NULL,'b209b3ac4f86f6fa983701bbb553d1a2',2048,0000022.9436,'2015-12-11 23:17:49','2015-12-11 23:17:49','2015-12-11 23:17:49');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-22 22:02:16
