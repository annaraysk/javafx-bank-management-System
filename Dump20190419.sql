CREATE DATABASE  IF NOT EXISTS `bank_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `bank_management`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: bank_management
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bank_branches_det`
--

DROP TABLE IF EXISTS `bank_branches_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bank_branches_det` (
  `branch_code` varchar(50) DEFAULT NULL,
  `branch_city` varchar(20) DEFAULT NULL,
  `branch_address` varchar(50) DEFAULT NULL,
  `postal_code` int(10) DEFAULT NULL,
  `manager_name` varchar(20) DEFAULT NULL,
  `branch_ph` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_branches_det`
--

LOCK TABLES `bank_branches_det` WRITE;
/*!40000 ALTER TABLE `bank_branches_det` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_branches_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_det`
--

DROP TABLE IF EXISTS `customer_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_det` (
  `account_no` varchar(30) DEFAULT NULL,
  `customer_name` varchar(20) DEFAULT NULL,
  `account_type` varchar(15) DEFAULT NULL,
  `balance` int(20) DEFAULT NULL,
  `father_name` varchar(20) DEFAULT NULL,
  `mother_name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `Ph_no` varchar(15) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `credit_card_no` varchar(30) DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `bestf` varchar(80) DEFAULT NULL,
  `pet` varchar(80) DEFAULT NULL,
  `favCol` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_det`
--

LOCK TABLES `customer_det` WRITE;
/*!40000 ALTER TABLE `customer_det` DISABLE KEYS */;
INSERT INTO `customer_det` VALUES ('123','anna kalas','DEFAULT',3123,'shivarudra','shwe','my home','780','home','456','2029-01-01','ANNA','ba39ffd902ae70d9f561b16f85b45360','khaliq','khaliq','blue'),('12','abdul khaliq','DEFAULT',17012,'aaa','bbb','home3','677','sind','34','2029-01-01','abd','42fe161a2ed226d2088f8618a8a1fdf1','anna','ami','red'),('1234','ami jack','DEFAULT',10500,'aaa','bbb','amisja	','6056','hhuh','4567','2029-01-01','ami','6c5b7de29192b42ed9cc6c7f635c92e0','khaliq','khaliq','pink'),('1212','ami2 jav','DEFAULT',500,'aaa','bbb','aslkdf','9880','bang','1231','2029-01-01','ami2','76a486d842ff5b0a95835f11ccf537c0','khal','khal','pp'),('678','ami3 lsa','DEFAULT',500,'lll','dksfj','jlsd','567','bang','777','2029-01-01','ami3','eb4fc1e62c8b9bb518370bb94b49daff','khal','khali','pi'),('12345678','Amisha A','DEFAULT',500,'Dipak Kumar','Poonam Kumari','abbbb','123456789','Patna','987654','2029-01-01','abc','e2fc714c4727ee9395f324cd2e7f331f','Annaray','snool','blue'),('23','aa aaa','DEFAULT',500,'an','aa','hfhn','75','hgf','65','2029-01-01','fgfhn','4124bc0a9335c27f086f24ba207a4912','hh','hh','hh'),('99','aa aa','DEFAULT',500,'aa','aa','jh','98','kjhkj','99','2029-01-01','h','2510c39011c5be704182423e3a695e91','hh','hh','hh'),('898','vineeth kani','DEFAULT',500,'krish','amma','7878','9090','bang','999','2029-01-01','vine@gmail.com','a77b51765620b8b0c50236e9ea8907ab','bat','bat','blue'),('9121611621','yeshwanth sai','DEFAULT',500,'venkatesh','vasundhara','rv college of engineering','9121611621','hyd','9398693056','2029-01-01','ysai0159@gmail.com','57dde4bc2030ae07724b500d6aef0a12','vishal','batman','blue'),('34567','Mahi way','DEFAULT',500,'bhaskar','geeta','lsdkjf	','987690','dsjf','398743','2029-01-01','mahi@gmail.com','99941a8015cd830b498cd9f0ddf4a500','mahi','mahi','mahi'),('732175756','shreyas nopany','DEFAULT',500,'father','mother','whqghd','863286138','jgasdkj','7637','2029-01-01','shreyas@gmail.com','08fa0a7e19b1eaaa7655d54fabf8ec61','shreyas','shreyas','shreyas'),('62347634','Utkarsh jha','DEFAULT',500,'father','mother','jhsfiuhfd','76472647624','jjhsdhf','764764','2029-01-01','utkarsh@gmail.com','6d15ce9fd7a85016907876466c36f353','utkarsh','utkarsh','utkarsh'),('137','sagu sagu','DEFAULT',500,'sagu','sagu','sagu','137','sagu','137','2029-01-01','sagu@gmail.com','b5a8449b3ba9fd1c3a4a97f93ec585a4','sagu','sagu','sagu'),('12345','YYYY YYY','DEFAULT',500,'WW','CDE','ASA','9121611621','HYD','12456','2029-01-01','YSAI018@GMAIL.COM','e53d6091993a79bce82d3987916ab059','VINEETH','SDCS','BLYWSAC');
/*!40000 ALTER TABLE `customer_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_det`
--

DROP TABLE IF EXISTS `employee_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_det` (
  `emp_id` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `Ph_no` varchar(15) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_det`
--

LOCK TABLES `employee_det` WRITE;
/*!40000 ALTER TABLE `employee_det` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_info`
--

DROP TABLE IF EXISTS `loan_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loan_info` (
  `amount` int(11) NOT NULL AUTO_INCREMENT,
  `rem_amt` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `login` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`amount`)
) ENGINE=InnoDB AUTO_INCREMENT=4001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_info`
--

LOCK TABLES `loan_info` WRITE;
/*!40000 ALTER TABLE `loan_info` DISABLE KEYS */;
INSERT INTO `loan_info` VALUES (2000,1200,'2019-03-30 08:10:17','a@gmail.com'),(3000,1200,'2019-03-30 08:09:57','abd'),(4000,1200,'2019-03-30 08:10:13','a@gmail.com');
/*!40000 ALTER TABLE `loan_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login_info` (
  `login` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `success` enum('yes','no') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_info`
--

LOCK TABLES `login_info` WRITE;
/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
INSERT INTO `login_info` VALUES ('abd','2019-03-30 07:14:04','yes'),('abd','2019-03-30 07:14:13','yes'),('abd','2019-03-30 07:14:13','yes'),('abd','2019-03-30 07:14:42','yes'),('a@gmail.com','2019-03-30 07:15:36','yes'),('a@gmail.com','2019-03-30 07:16:36','yes'),('a@gmail.com','2019-03-30 07:17:26','yes'),('a@gmail.com','2019-03-30 07:24:23','yes'),('a@gmail.com','2019-03-30 07:25:52','yes'),('a@gmail.com','2019-03-30 07:26:24','yes'),('a@gmail.com','2019-03-30 07:27:44','yes'),('a@gmail.com','2019-03-30 07:28:54','yes'),('a@gmail.com','2019-03-30 07:29:40','yes'),('a@gmail.com','2019-03-30 07:29:48','yes'),('a@gmail.com','2019-03-30 07:30:03','yes'),('a@gmail.com','2019-03-30 07:34:34','yes'),('a@gmail.com','2019-03-30 07:40:29','yes'),('a@gmail.com','2019-03-30 07:40:50','yes'),('a@gmail.com','2019-03-30 07:40:56','yes'),('a@gmail.com','2019-03-30 07:43:48','yes'),('a@gmail.com','2019-03-30 07:45:42','yes'),('abd','2019-03-30 10:18:45','yes'),('abd','2019-03-30 10:26:53','yes'),('abd','2019-03-30 15:11:24','yes'),('abd','2019-03-30 15:14:13','yes'),('abd','2019-03-30 15:16:45','yes'),('abd','2019-03-30 15:50:08','yes'),('abd','2019-03-30 15:50:11','yes'),('abd','2019-03-30 15:50:13','yes'),('abd','2019-03-30 15:50:14','yes'),('abd','2019-03-30 15:50:30','yes'),('abd','2019-03-30 15:50:53','yes'),('abd','2019-03-30 15:50:55','yes'),('abd','2019-03-30 15:52:53','yes'),('abd','2019-03-30 16:23:12','yes'),('abd','2019-03-30 16:23:14','yes'),('abd','2019-03-30 16:24:20','yes'),('a@gmail.com','2019-03-30 16:25:03','yes'),('abd','2019-03-30 17:05:29','yes'),('abd','2019-03-30 17:05:32','yes'),('abd','2019-03-30 17:06:41','yes'),('abd','2019-03-30 17:40:59','yes'),('abd','2019-03-30 17:42:34','yes'),('abd','2019-03-30 17:42:37','yes'),('abd','2019-03-30 17:49:03','yes'),('abd','2019-03-30 18:01:40','yes'),('a@gmail.com','2019-03-31 08:10:39','yes'),('a@gmail.com','2019-03-31 08:11:29','yes'),('abd','2019-03-31 08:20:26','yes'),('abd','2019-03-31 08:20:50','yes'),('abd','2019-03-31 08:22:31','yes'),('abd','2019-03-31 08:22:37','yes'),('abd','2019-03-31 08:22:45','yes'),('abd','2019-03-31 08:23:30','yes'),('a@gmail.com','2019-03-31 08:28:13','yes'),('a@gmail.com','2019-03-31 08:28:32','yes'),('a@gmail.com','2019-03-31 08:34:47','yes'),('a@gmail.com','2019-03-31 08:35:55','yes'),('a@gmail.com','2019-03-31 08:36:43','yes'),('a@gmail.com','2019-03-31 08:39:50','yes'),('a@gmail.com','2019-03-31 08:40:21','yes'),('a@gmail.com','2019-03-31 08:40:25','yes'),('anna','2019-03-31 08:40:51','yes'),('anna','2019-03-31 08:49:37','yes'),('anna','2019-03-31 08:50:51','yes'),('anna','2019-03-31 08:51:08','yes'),('anna','2019-03-31 08:51:25','yes'),('anna','2019-03-31 08:52:27','yes'),('anna','2019-03-31 08:55:34','yes'),('anna','2019-03-31 08:57:13','yes'),('anna','2019-03-31 08:57:39','yes'),('anna','2019-03-31 08:59:30','yes'),('anna','2019-03-31 09:00:05','yes'),('anna','2019-03-31 09:14:18','yes'),('anna','2019-03-31 09:14:57','yes'),('anna','2019-03-31 09:15:06','yes'),('anna','2019-03-31 09:16:04','yes'),('anna','2019-03-31 09:16:16','yes'),('anna','2019-03-31 09:17:21','yes'),('anna','2019-03-31 09:20:40','yes'),('anna','2019-03-31 09:42:48','yes'),('anna','2019-03-31 09:43:49','yes'),('anna','2019-03-31 09:45:00','yes'),('anna','2019-03-31 09:46:07','yes'),('anna','2019-03-31 09:47:39','yes'),('anna','2019-03-31 09:48:10','yes'),('anna','2019-03-31 09:49:15','yes'),('anna','2019-03-31 09:54:39','yes'),('anna','2019-03-31 10:01:30','yes'),('anna','2019-03-31 10:01:45','yes'),('anna','2019-03-31 10:02:37','yes'),('anna','2019-03-31 10:02:49','yes'),('ami3','2019-03-31 10:18:36','yes'),('anna','2019-03-31 10:20:45','yes'),('anna','2019-03-31 10:21:48','yes'),('anna','2019-03-31 10:22:21','yes'),('anna','2019-03-31 10:22:59','yes'),('anna','2019-03-31 10:23:22','yes'),('anna','2019-03-31 10:25:46','yes'),('anna','2019-03-31 10:26:51','yes'),('anna','2019-03-31 10:27:13','yes'),('anna','2019-03-31 10:27:56','yes'),('anna','2019-03-31 10:28:26','yes'),('anna','2019-03-31 10:29:20','yes'),('anna','2019-03-31 10:29:41','yes'),('anna','2019-03-31 10:30:13','yes'),('abd','2019-03-31 11:12:47','yes'),('abd','2019-03-31 11:14:04','yes'),('abd','2019-03-31 11:18:00','yes'),('abd','2019-03-31 11:21:17','yes'),('abd','2019-03-31 11:24:33','yes'),('abd','2019-03-31 11:42:52','yes'),('abd','2019-04-01 09:27:59','yes'),('ami','2019-04-01 09:31:09','yes'),('ami','2019-04-01 09:32:14','yes'),('ami','2019-04-01 09:33:56','yes'),('ami','2019-04-01 09:34:38','yes'),('abd','2019-04-01 09:36:16','yes'),('anna','2019-04-01 09:39:54','yes'),('anna','2019-04-01 09:43:00','yes'),('anna','2019-04-01 09:44:48','yes'),('anna','2019-04-01 09:46:45','yes'),('anna','2019-04-01 09:48:03','yes'),('anna','2019-04-01 09:50:54','yes'),('abd','2019-04-01 09:52:25','yes'),('ami','2019-04-01 09:53:45','yes'),('abd','2019-04-01 09:57:33','yes'),('abd','2019-04-01 09:59:19','yes'),('anna','2019-04-01 10:03:53','yes'),('abd','2019-04-01 10:15:01','yes'),('abd','2019-04-01 10:16:48','yes'),('abd','2019-04-01 10:17:05','yes'),('anna','2019-04-01 10:17:31','yes'),('abd','2019-04-05 13:54:24','yes'),('abd','2019-04-05 13:54:51','yes'),('abd','2019-04-12 05:12:50','yes'),('abd','2019-04-12 05:13:36','yes'),('abd','2019-04-12 05:14:06','yes'),('abd','2019-04-12 05:14:50','yes'),('vine@gmail.com','2019-04-12 15:53:15','yes'),('vine@gmail.com','2019-04-12 15:54:05','yes'),('vine@gmail.com','2019-04-12 15:54:35','yes'),('vine@gmail.com','2019-04-12 15:56:04','yes'),('vine@gmail.com','2019-04-12 16:18:50','yes'),('ysai0159@gmail.com','2019-04-12 16:34:30','yes'),('ysai0159@gmail.com','2019-04-12 16:35:04','yes'),('ysai0159@gmail.com','2019-04-12 16:36:40','yes'),('vine@gmail.com','2019-04-12 17:25:55','yes'),('vine@gmail.com','2019-04-12 17:35:39','yes'),('vine@gmail.com','2019-04-12 17:36:23','yes'),('vine@gmail.com','2019-04-12 17:41:30','yes'),('vine@gmail.com','2019-04-12 18:07:25','yes'),('vine@gmail.com','2019-04-12 18:08:34','yes'),('abd','2019-04-12 18:17:09','yes'),('abd','2019-04-12 18:18:00','yes'),('abd','2019-04-12 18:23:06','yes'),('mahi@gmail.com','2019-04-12 18:25:08','yes'),('vine@gmail.com','2019-04-13 03:17:29','yes'),('vine@gmail.com','2019-04-13 04:32:50','yes'),('vine@gmail.com','2019-04-13 04:33:20','yes'),('shreyas@gmail.com','2019-04-13 06:05:31','yes'),('shreyas@gmail.com','2019-04-13 06:08:24','yes'),('shreyas@gmail.com','2019-04-13 06:08:30','yes'),('utkarsh@gmail.com','2019-04-13 06:30:05','yes'),('utkarsh@gmail.com','2019-04-13 06:30:33','yes'),('utkarsh@gmail.com','2019-04-13 06:31:26','yes'),('utkarsh@gmail.com','2019-04-13 06:33:01','yes'),('sagu@gmail.com','2019-04-15 06:26:57','yes'),('sagu@gmail.com','2019-04-15 06:31:52','yes'),('abd','2019-04-15 06:39:52','yes'),('abd','2019-04-15 06:41:48','yes'),('abd','2019-04-15 06:42:13','yes'),('vine@gmail.com','2019-04-15 08:57:10','yes'),('vine@gmail.com','2019-04-15 09:52:58','yes');
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transactions` (
  `login` varchar(50) DEFAULT NULL,
  `login2` varchar(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('anna','ami2',2000,'2019-03-31 09:38:32'),('anna','abd',2000,'2019-03-31 09:38:39'),('ami','abd',2000,'2019-03-31 09:38:50'),('ami','anna',2000,'2019-03-31 09:38:56'),('abd','anna',2000,'2019-03-31 09:39:04');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-19 14:34:49
