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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,4,'0','10','教程','2015-12-13 17:38:43','2015-12-13 17:38:46'),(3,4,'0','11','新建文件夹','2015-12-15 21:06:41','2015-12-15 21:06:41'),(4,4,'0','12','新建文件夹1','2015-12-15 21:07:55','2015-12-15 21:07:55'),(6,4,'10','1010','新建文件夹','2015-12-16 20:25:11','2015-12-16 20:25:11'),(7,4,'10','1011','新建文件夹1','2015-12-16 20:41:32','2015-12-16 20:41:32'),(8,4,'1010','101010','新建文件夹','2015-12-16 20:56:02','2015-12-16 20:56:02'),(9,4,'10','1012','新建文件夹2','2015-12-16 21:14:46','2015-12-16 21:14:46'),(10,4,'1010','101011','新建文件夹1','2015-12-16 21:15:06','2015-12-16 21:15:06'),(11,4,'101011','10101110','新建文件夹','2015-12-16 21:18:28','2015-12-16 21:18:28'),(12,4,'11','1110','新建文件夹','2015-12-16 21:18:57','2015-12-16 21:18:57'),(13,4,'1110','111010','新建文件夹','2015-12-16 21:19:02','2015-12-16 21:19:02'),(14,4,'1110','111011','新建文件夹1','2015-12-16 21:19:10','2015-12-16 21:19:10');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
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
  `filesize` double DEFAULT NULL COMMENT '文件大小',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` VALUES (1,'文件1',3.2,NULL,4,'2015-12-13 17:36:57','0',0,NULL,NULL,NULL,NULL,'txt','2015-12-13 17:37:19','2015-12-13 17:37:24','img/text.png');
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_collect`
--

DROP TABLE IF EXISTS `t_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `u_id` int(11) DEFAULT NULL COMMENT '用户id',
  `f_id` int(11) DEFAULT NULL COMMENT '文件id',
  `init_date` datetime DEFAULT NULL COMMENT '记录生成时间',
  `upd_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collect`
--

LOCK TABLES `t_collect` WRITE;
/*!40000 ALTER TABLE `t_collect` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_collect` ENABLE KEYS */;
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
  `used_space` double unsigned zerofill DEFAULT '0000000000000000000000' COMMENT '已用存储空间大小',
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
INSERT INTO `user` VALUES (1,'aaa','aaa','111',NULL,NULL,NULL,NULL,NULL),(4,'15628418747',NULL,'b209b3ac4f86f6fa983701bbb553d1a2',2048,0000000000000000000000,'2015-12-11 23:17:49','2015-12-11 23:17:49','2015-12-11 23:17:49');
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

-- Dump completed on 2015-12-16 22:15:59
