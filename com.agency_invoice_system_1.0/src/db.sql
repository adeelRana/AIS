/*
SQLyog Ultimate v8.61 
MySQL - 5.6.17 : Database - ar_ais
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ar_ais` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ar_ais`;

/*Table structure for table `app_user` */

DROP TABLE IF EXISTS `app_user`;

CREATE TABLE `app_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL,
  `USER_PASS` varchar(50) NOT NULL,
  `USER_ROLE` varchar(6) NOT NULL DEFAULT 'user',
  `LAST_LOGIN_TIME` bigint(20) NOT NULL,
  `CREATED_BY` double NOT NULL,
  `EDITED_BY` bigint(20) DEFAULT '0',
  `STATUS` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `app_user` */

insert  into `app_user`(`USER_ID`,`USER_NAME`,`USER_PASS`,`USER_ROLE`,`LAST_LOGIN_TIME`,`CREATED_BY`,`EDITED_BY`,`STATUS`) values (1,'Adeel Rana','asd','super',0,1,1,1);

/*Table structure for table `booker` */

DROP TABLE IF EXISTS `booker`;

CREATE TABLE `booker` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `OPENING_DATE` bigint(20) NOT NULL,
  `OPENING_CR` decimal(10,2) NOT NULL,
  `CURRENT_CR` decimal(12,2) NOT NULL,
  `STATUS` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `booker` */

insert  into `booker`(`ID`,`NAME`,`OPENING_DATE`,`OPENING_CR`,`CURRENT_CR`,`STATUS`) values (3,'Malik',1526626800971,'0.00','0.00',1),(4,'Yameen',1526626800450,'0.00','0.00',1),(5,'Kai',1527145200336,'0.00','0.00',1);

/*Table structure for table `booker_cr` */

DROP TABLE IF EXISTS `booker_cr`;

CREATE TABLE `booker_cr` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CR_DATE` bigint(20) NOT NULL,
  `CR_TYPE` tinyint(4) NOT NULL,
  `CR_BOOKER` bigint(20) NOT NULL,
  `CR_INVOICE` bigint(20) NOT NULL DEFAULT '0',
  `CR_AMOUNT` decimal(10,2) NOT NULL,
  `CR_PIAD` decimal(10,2) NOT NULL,
  `CR_STATUS` tinyint(4) NOT NULL,
  `CR_REMARKS` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_booker_cr` (`CR_BOOKER`),
  CONSTRAINT `FK_booker_cr` FOREIGN KEY (`CR_BOOKER`) REFERENCES `booker` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `booker_cr` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `OPENING_DATE` bigint(20) NOT NULL,
  `OPENING_CR` decimal(10,2) NOT NULL,
  `CURRENT_CR` decimal(10,2) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `company` */

insert  into `company`(`ID`,`NAME`,`OPENING_DATE`,`OPENING_CR`,`CURRENT_CR`,`STATUS`) values (1,'Pepsico',1526281200226,'0.00','0.00',1);

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INVOICE_SUMMARY` bigint(20) NOT NULL,
  `INVOICE_SHOP` bigint(11) NOT NULL,
  `INVOICE_NO` varchar(50) NOT NULL,
  `TOTAL_QTY` decimal(10,2) NOT NULL,
  `RTN_QTY` decimal(10,2) NOT NULL DEFAULT '0.00',
  `TOTAL_AMOUNT` decimal(10,2) NOT NULL,
  `COLLECTION` decimal(10,2) NOT NULL,
  `CREDIT` decimal(10,2) NOT NULL,
  `INV_DISCOUNT` double NOT NULL,
  `INV_DISCOUNT_TYPE` varchar(10) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `RTN` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_invoice_summary` (`INVOICE_SUMMARY`),
  KEY `FK_invoice_shop` (`INVOICE_SHOP`),
  CONSTRAINT `FK_invoice_shop` FOREIGN KEY (`INVOICE_SHOP`) REFERENCES `shop` (`ID`),
  CONSTRAINT `FK_invoice_summary` FOREIGN KEY (`INVOICE_SUMMARY`) REFERENCES `summary` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

/*Data for the table `invoice` */

insert  into `invoice`(`ID`,`INVOICE_SUMMARY`,`INVOICE_SHOP`,`INVOICE_NO`,`TOTAL_QTY`,`RTN_QTY`,`TOTAL_AMOUNT`,`COLLECTION`,`CREDIT`,`INV_DISCOUNT`,`INV_DISCOUNT_TYPE`,`STATUS`,`RTN`) values (16,3,22,'1527274800000-0','7.00','0.00','3610.00','0.00','0.00',0,'AG_PER',1,0),(17,3,23,'1527274800000-1','6.00','0.00','3280.00','0.00','0.00',0,'AG_PER',1,0),(18,3,6,'1527274800000-2','3.00','0.00','1640.00','0.00','0.00',0,'AG_PER',1,0),(19,3,24,'1527274800000-3','2.00','0.00','1190.00','0.00','0.00',0,'AG_PER',1,0),(20,3,12,'1527274800000-4','3.00','0.00','1520.00','0.00','0.00',2,'AG_PER',1,0),(21,3,13,'1527274800000-5','4.00','0.00','2115.00','0.00','0.00',0,'AG_PER',1,0),(22,3,17,'1527274800000-6','13.00','0.00','8380.00','0.00','0.00',0,'AG_PER',1,0),(23,3,11,'1527274800000-7','4.00','0.00','2235.00','0.00','0.00',0,'AG_PER',1,0),(24,3,7,'1527274800000-8','3.00','0.00','1785.00','0.00','0.00',0,'AG_PER',1,0),(25,3,14,'1527274800000-9','5.00','0.00','1650.00','0.00','0.00',3,'AG_PER',1,0),(26,4,3,'1527404400000-0','5.00','0.00','2370.25','0.00','0.00',2,'JOIN_PER',1,0),(27,4,26,'1527404400000-1','3.00','0.00','1520.00','0.00','0.00',0,'AG_PER',1,0),(28,4,27,'1527404400000-2','3.00','0.00','1375.00','0.00','0.00',0,'AG_PER',1,0),(29,4,29,'1527404400000-3','2.00','0.00','1190.00','0.00','0.00',0,'AG_PER',1,0),(30,4,31,'1527404400000-4','3.00','0.00','1785.00','0.00','0.00',0,'AG_PER',1,0),(31,4,34,'1527404400000-5','3.00','0.00','1640.00','0.00','0.00',0,'AG_PER',1,0),(32,4,35,'1527404400000-6','5.00','0.00','2830.00','0.00','0.00',0,'AG_PER',1,0),(33,4,36,'1527404400000-7','3.00','0.00','1520.00','0.00','0.00',0,'AG_PER',1,0),(34,4,38,'1527404400000-8','1.00','0.00','595.00','0.00','0.00',0,'AG_PER',1,0),(35,4,37,'1527404400000-9','3.00','0.00','1945.00','0.00','0.00',0,'AG_PER',1,0),(36,4,39,'1527404400000-10','4.00','0.00','2244.20','0.00','0.00',2,'AG_PER',1,0),(37,4,121,'1527404400000-11','5.00','0.00','3135.00','0.00','0.00',0,'AG_PER',1,0),(38,5,51,'1527447600000-0','3.00','0.00','1785.00','0.00','0.00',0,'AG_PER',1,0),(39,5,53,'1527447600000-1','5.00','0.00','2685.00','0.00','0.00',0,'AG_PER',1,0),(40,5,46,'1527447600000-2','6.00','0.00','3028.20','0.00','0.00',2,'AG_PER',1,0),(41,5,55,'1527447600000-3','4.00','0.00','2380.00','0.00','0.00',0,'AG_PER',1,0),(42,5,43,'1527447600000-4','3.00','0.00','1520.00','0.00','0.00',0,'AG_PER',1,0),(43,5,54,'1527447600000-5','8.00','0.00','5235.00','0.00','0.00',0,'AG_PER',1,0),(44,5,56,'1527447600000-6','3.00','0.00','1640.00','0.00','0.00',0,'AG_PER',1,0),(45,5,1,'1527447600000-7','8.00','0.00','4280.00','0.00','0.00',0,'AG_PER',1,0),(46,5,4,'1527447600000-8','9.00','0.00','4840.00','0.00','0.00',0,'AG_PER',1,0),(47,5,2,'1527447600000-9','2.00','0.00','1190.00','0.00','0.00',0,'AG_PER',1,0),(48,6,92,'1527447600000-0','10.00','0.00','6660.00','0.00','0.00',0,'AG_PER',1,0);

/*Table structure for table `invoice_detail` */

DROP TABLE IF EXISTS `invoice_detail`;

CREATE TABLE `invoice_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DAY_ID` bigint(20) NOT NULL,
  `DETAIL_INVOICE` bigint(20) NOT NULL,
  `DETAIL_PRODUCT` bigint(20) NOT NULL,
  `QTY` decimal(10,2) NOT NULL,
  `RETURN_QTY` decimal(10,2) NOT NULL,
  `PRICE` decimal(10,2) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_invoice_detail_inv` (`DETAIL_INVOICE`),
  KEY `FK_invoice_detail_pro` (`DETAIL_PRODUCT`),
  CONSTRAINT `FK_invoice_detail` FOREIGN KEY (`DETAIL_INVOICE`) REFERENCES `invoice` (`ID`),
  CONSTRAINT `FK_invoice_detail_pro` FOREIGN KEY (`DETAIL_PRODUCT`) REFERENCES `products` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=latin1;

/*Data for the table `invoice_detail` */

insert  into `invoice_detail`(`ID`,`DAY_ID`,`DETAIL_INVOICE`,`DETAIL_PRODUCT`,`QTY`,`RETURN_QTY`,`PRICE`,`STATUS`) values (34,5,16,41,'48.00','0.00','450.00',1),(35,5,16,38,'72.00','0.00','330.00',1),(36,5,16,1,'64.00','0.00','595.00',1),(37,5,16,3,'64.00','0.00','595.00',1),(38,5,16,4,'128.00','0.00','595.00',1),(39,5,16,43,'48.00','0.00','450.00',1),(40,5,17,4,'64.00','0.00','595.00',1),(41,5,17,1,'64.00','0.00','595.00',1),(42,5,17,41,'48.00','0.00','450.00',1),(43,5,17,3,'64.00','0.00','595.00',1),(44,5,17,42,'48.00','0.00','450.00',1),(45,5,17,2,'64.00','0.00','595.00',1),(46,5,18,4,'64.00','0.00','595.00',1),(47,5,18,40,'48.00','0.00','450.00',1),(48,5,18,2,'64.00','0.00','595.00',1),(49,5,19,1,'64.00','0.00','595.00',1),(50,5,19,4,'64.00','0.00','595.00',1),(51,5,20,39,'72.00','0.00','330.00',1),(52,5,20,1,'128.00','0.00','595.00',1),(53,5,21,38,'72.00','0.00','330.00',1),(54,5,21,3,'64.00','0.00','595.00',1),(55,5,21,1,'64.00','0.00','595.00',1),(56,5,21,4,'64.00','0.00','595.00',1),(57,5,22,22,'24.00','0.00','650.00',1),(58,5,22,56,'24.00','0.00','450.00',1),(59,5,22,21,'24.00','0.00','650.00',1),(60,5,22,3,'64.00','0.00','595.00',1),(61,5,22,1,'128.00','0.00','595.00',1),(62,5,22,3,'64.00','0.00','595.00',1),(63,5,22,12,'48.00','0.00','900.00',1),(64,5,22,42,'48.00','0.00','450.00',1),(65,5,22,11,'48.00','0.00','900.00',1),(66,5,22,13,'48.00','0.00','900.00',1),(67,5,22,30,'24.00','0.00','550.00',1),(68,5,23,4,'64.00','0.00','595.00',1),(69,5,23,3,'64.00','0.00','595.00',1),(70,5,23,1,'64.00','0.00','595.00',1),(71,5,23,41,'48.00','0.00','450.00',1),(72,5,24,1,'64.00','0.00','595.00',1),(73,5,24,3,'64.00','0.00','595.00',1),(74,5,24,4,'64.00','0.00','595.00',1),(75,5,25,38,'144.00','0.00','330.00',1),(76,5,25,39,'216.00','0.00','330.00',1),(77,6,26,30,'12.00','0.00','550.00',1),(78,6,26,1,'64.00','0.00','595.00',1),(79,6,26,40,'48.00','0.00','450.00',1),(80,6,26,41,'48.00','0.00','450.00',1),(81,6,26,56,'24.00','0.00','450.00',1),(82,6,27,3,'64.00','0.00','595.00',1),(83,6,27,38,'72.00','0.00','330.00',1),(84,6,27,4,'64.00','0.00','595.00',1),(85,6,28,39,'72.00','0.00','330.00',1),(86,6,28,41,'48.00','0.00','450.00',1),(87,6,28,4,'64.00','0.00','595.00',1),(88,6,29,4,'64.00','0.00','595.00',1),(89,6,29,3,'64.00','0.00','595.00',1),(90,6,30,4,'64.00','0.00','595.00',1),(91,6,30,1,'64.00','0.00','595.00',1),(92,6,30,3,'64.00','0.00','595.00',1),(93,6,31,41,'48.00','0.00','450.00',1),(94,6,31,4,'64.00','0.00','595.00',1),(95,6,31,1,'64.00','0.00','595.00',1),(96,6,32,2,'64.00','0.00','595.00',1),(97,6,32,43,'48.00','0.00','450.00',1),(98,6,32,3,'64.00','0.00','595.00',1),(99,6,32,4,'128.00','0.00','595.00',1),(100,6,33,4,'64.00','0.00','595.00',1),(101,6,33,39,'72.00','0.00','330.00',1),(102,6,33,3,'64.00','0.00','595.00',1),(103,6,34,4,'64.00','0.00','595.00',1),(104,6,35,13,'48.00','0.00','900.00',1),(105,6,35,3,'64.00','0.00','595.00',1),(106,6,35,42,'48.00','0.00','450.00',1),(107,6,36,4,'64.00','0.00','595.00',1),(108,6,36,43,'48.00','0.00','450.00',1),(109,6,36,1,'64.00','0.00','595.00',1),(110,6,36,21,'24.00','0.00','650.00',1),(111,6,37,70,'48.00','0.00','900.00',1),(112,6,37,3,'64.00','0.00','595.00',1),(113,6,37,2,'64.00','0.00','595.00',1),(114,6,37,42,'48.00','0.00','450.00',1),(115,6,37,4,'64.00','0.00','595.00',1),(116,7,38,3,'64.00','0.00','595.00',1),(117,7,38,4,'64.00','0.00','595.00',1),(118,7,38,1,'64.00','0.00','595.00',1),(119,7,39,3,'64.00','0.00','595.00',1),(120,7,39,40,'48.00','0.00','450.00',1),(121,7,39,1,'64.00','0.00','595.00',1),(122,7,39,41,'48.00','0.00','450.00',1),(123,7,39,4,'64.00','0.00','595.00',1),(124,7,40,4,'128.00','0.00','595.00',1),(125,7,40,29,'12.00','0.00','550.00',1),(126,7,40,41,'48.00','0.00','450.00',1),(127,7,40,43,'96.00','0.00','450.00',1),(128,7,41,1,'128.00','0.00','595.00',1),(129,7,41,4,'128.00','0.00','595.00',1),(130,7,42,4,'64.00','0.00','595.00',1),(131,7,42,39,'72.00','0.00','330.00',1),(132,7,42,1,'64.00','0.00','595.00',1),(133,7,43,29,'12.00','0.00','550.00',1),(134,7,43,4,'64.00','0.00','595.00',1),(135,7,43,13,'48.00','0.00','900.00',1),(136,7,43,3,'64.00','0.00','595.00',1),(137,7,43,10,'48.00','0.00','900.00',1),(138,7,43,1,'64.00','0.00','595.00',1),(139,7,43,22,'24.00','0.00','650.00',1),(140,7,43,56,'24.00','0.00','450.00',1),(141,7,44,3,'64.00','0.00','595.00',1),(142,7,44,43,'48.00','0.00','450.00',1),(143,7,44,1,'64.00','0.00','595.00',1),(144,7,45,43,'48.00','0.00','450.00',1),(145,7,45,4,'64.00','0.00','595.00',1),(146,7,45,30,'12.00','0.00','550.00',1),(147,7,45,2,'64.00','0.00','595.00',1),(148,7,45,41,'48.00','0.00','450.00',1),(149,7,45,3,'64.00','0.00','595.00',1),(150,7,45,1,'64.00','0.00','595.00',1),(151,7,45,40,'48.00','0.00','450.00',1),(152,7,46,2,'64.00','0.00','595.00',1),(153,7,46,38,'72.00','0.00','330.00',1),(154,7,46,41,'48.00','0.00','450.00',1),(155,7,46,1,'64.00','0.00','595.00',1),(156,7,46,43,'48.00','0.00','450.00',1),(157,7,46,3,'64.00','0.00','595.00',1),(158,7,46,4,'64.00','0.00','595.00',1),(159,7,46,13,'48.00','0.00','900.00',1),(160,7,46,38,'72.00','0.00','330.00',1),(161,7,47,2,'64.00','0.00','595.00',1),(162,7,47,1,'64.00','0.00','595.00',1),(163,7,48,10,'48.00','0.00','900.00',1),(164,7,48,2,'64.00','0.00','595.00',1),(165,7,48,55,'10.00','0.00','930.00',1),(166,7,48,19,'24.00','0.00','650.00',1),(167,7,48,62,'24.00','0.00','450.00',1),(168,7,48,31,'12.00','0.00','550.00',1),(169,7,48,35,'12.00','0.00','880.00',1),(170,7,48,42,'48.00','0.00','450.00',1),(171,7,48,63,'24.00','0.00','675.00',1),(172,7,48,27,'16.00','0.00','580.00',1);

/*Table structure for table `license` */

DROP TABLE IF EXISTS `license`;

CREATE TABLE `license` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `KEY` text,
  `MAC_ADDRESS` text,
  `INSTALLATION_DATE` bigint(20) DEFAULT NULL,
  `UPDATE_DATE` bigint(20) DEFAULT NULL,
  `DAYS_ALLOW` int(11) DEFAULT NULL,
  `DAYS_RUN` int(11) DEFAULT NULL,
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PASS` varchar(50) NOT NULL DEFAULT 'inventry123',
  `DB_VERSION` varchar(20) NOT NULL DEFAULT '0.0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `license` */

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRODUCT_COMPANY` bigint(20) NOT NULL,
  `CODE` varchar(15) DEFAULT NULL,
  `NAME` varchar(30) NOT NULL,
  `FLAVOUR` varchar(30) NOT NULL,
  `WEIGHT` double NOT NULL,
  `WEIGHT_UNIT` varchar(10) NOT NULL DEFAULT 'gm',
  `PIECE_PRICE` double DEFAULT '0',
  `PIECES_PER_CTN` double NOT NULL,
  `SALE_PRICE` double NOT NULL,
  `PURCHASE_PRICE` double NOT NULL,
  `OPENING_QTY` double NOT NULL,
  `CURRENT_QTY` double NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK_products_comp` (`PRODUCT_COMPANY`),
  CONSTRAINT `FK_products_comp` FOREIGN KEY (`PRODUCT_COMPANY`) REFERENCES `company` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

/*Data for the table `products` */

insert  into `products`(`ID`,`PRODUCT_COMPANY`,`CODE`,`NAME`,`FLAVOUR`,`WEIGHT`,`WEIGHT_UNIT`,`PIECE_PRICE`,`PIECES_PER_CTN`,`SALE_PRICE`,`PURCHASE_PRICE`,`OPENING_QTY`,`CURRENT_QTY`,`STATUS`) values (1,1,'1-1-3','Lays','Masala',13,'gm',10,64,595,590,6400,4864,1),(2,1,'1-1-4','Lays','Salted',13,'gm',10,64,595,590,6400,5888,1),(3,1,'1-1-1','Lays','French Cheese',13,'gm',10,64,595,590,6400,5184,1),(4,1,'1-1-5','Lays','Yogurt & Herb',13,'gm',10,64,595,590,6400,4544,1),(5,1,'1-1-2','Lays','Ketchup',13,'gm',10,64,595,590,6400,6400,1),(10,1,'1-2-4','Lays','Salted',27,'gm',20,48,900,890,4800,4704,1),(11,1,'1-2-1','Lays','French Cheese',27,'gm',20,48,900,890,4800,4752,1),(12,1,'1-2-3','Lays','Masala',27,'gm',20,48,900,890,4800,4752,1),(13,1,'1-2-5','Lays','Yogurt & Herb',27,'gm',20,48,900,890,4800,4608,1),(19,1,'1-3-4','Lays','Salted',40,'gm',30,24,655,640,2400,2376,1),(20,1,'1-3-1','Lays','French Cheese',40,'gm',30,24,655,640,2400,2400,1),(21,1,'1-3-3','Lays','Masala',40,'gm',30,24,655,640,2400,2352,1),(22,1,'1-3-5','Lays','Yogurt & Herb',40,'gm',30,24,655,640,2400,2352,1),(23,1,'1-3-2','Lays','Ketchup',40,'gm',30,24,655,640,2400,2400,1),(25,1,'1-4-1','Lays','French Cheese',53,'gm',40,16,580,570,1600,1600,1),(26,1,'1-4-3','Lays','Masala',53,'gm',40,16,580,570,1600,1600,1),(27,1,'1-4-4','Lays','Salted',53,'gm',40,16,580,570,1600,1584,1),(28,1,'1-4-5','Lays','Yogurt & Herb',53,'gm',40,16,580,570,1600,1600,1),(29,1,'1-5-1','Lays','French Cheese',70,'gm',50,12,550,540,1200,1176,1),(30,1,'1-5-3','Lays','Masala',70,'gm',50,12,550,540,1200,1152,1),(31,1,'1-5-4','Lays','Salted',70,'gm',50,12,550,540,1200,1188,1),(32,1,'1-5-5','Lays','Yogurt & Herb',70,'gm',50,12,550,540,1200,1200,1),(33,1,'1-8-1','Lays','French Cheese',112,'gm',80,12,880,870,1200,1200,1),(34,1,'1-8-3','Lays','Masala',112,'gm',80,12,880,870,1200,1200,1),(35,1,'1-8-4','Lays','Salted',112,'gm',80,12,880,870,1200,1188,1),(36,1,'1-8-5','Lays','Yogurt & Herb',112,'gm',80,12,880,870,1200,1200,1),(37,1,'1-10-1','Lays','French Cheese',155,'gm',100,10,930,920,1000,1000,1),(38,1,'2-1-2','Kurkuray','Red Chilli',11,'gm',5,72,335,320,7200,6768,1),(39,1,'2-1-1','Kurkuray','Chatni Chaske',11,'gm',5,72,335,320,7200,6696,1),(40,1,'2-2-2','Kurkuray','Red Chilli',22,'gm',10,48,455,440,4800,4608,1),(41,1,'2-2-1','Kurkuray','Chatni Chaska',22,'gm',10,48,455,440,4800,4320,1),(42,1,'2-6-3','Kurkuray','Salt & pepper',19,'gm',10,48,455,440,4800,4560,1),(43,1,'4-2-1','Cheetos','Bites',17,'gm',10,48,450,440,4800,4416,1),(44,1,'6-2-1','Nuts','Masala',27,'gm',20,48,900,890,4800,4800,1),(45,1,'4-1-1','Cheetos','Bites',7,'gm',5,48,220,210,4800,4800,1),(46,1,'4-1-4','Cheetos','Ketchup',7,'gm',5,48,220,210,4800,4800,1),(47,1,'4-1-5','Cheetos','Osean Safari',7,'gm',5,48,220,210,4800,4800,1),(48,1,'4-2-2','Cheetos','Cheese',17,'gm',10,48,450,440,4800,4800,1),(49,1,'4-2-3','Cheetos','Chicken & Vegg:',17,'gm',10,48,450,440,4800,4800,1),(50,1,'4-2-4','Cheetos','Ketchup',17,'gm',10,48,450,440,4800,4800,1),(51,1,'4-2-7','Cheetos','Star',17,'gm',10,48,450,440,4800,4800,1),(52,1,'4-3-4','Cheetos','Ketchup ',28,'gm',20,36,675,665,3600,3600,1),(53,1,'4-3-6','Cheetos','Red Flaming Hot',32,'gm',20,36,675,665,3600,3600,1),(54,1,'1-10-3','Lays','masala',155,'gm',100,10,930,920,1000,1000,1),(55,1,'1-10-4','Lays','Salte',155,'gm',100,10,930,920,1000,990,1),(56,1,'2-3-1','Kurkuray','Chatni Chaska',42,'gm',20,24,455,440,2400,2328,1),(57,1,'2-3-2','Kurkuray','Red Chilli',42,'gm',20,24,455,440,2400,2400,1),(58,1,'2-4-1','Kurkuray','Chatni Chaska',65,'gm',30,24,675,665,2400,2400,1),(59,1,'2-4-2','Kurkuray','Red Chilli',65,'gm',30,24,675,665,2400,2400,1),(60,1,'2-5-1','Kurkuray','Chatni Chaska',112,'gm',50,12,555,540,1200,1200,1),(61,1,'2-5-2','Kurkuray','Red Chilli',112,'gm',50,12,555,540,1200,1200,1),(62,1,'2-7-3','Kurkuray','Salt & Pepper',38,'gm',20,24,455,440,4800,4776,1),(63,1,'2-8-3','Kurkuray','Salt & Pepper',58,'gm',30,24,675,665,2400,2376,1),(64,1,'5-1-1','Nimco','Mix',14,'gm',10,100,930,920,10000,10000,1),(65,1,'5-2-1','Nimco','Mix',33,'gm',20,48,900,890,4800,4800,1),(66,1,'5-3-1','Nimco','Mix',85,'gm',50,20,930,920,2000,2000,1),(67,1,'6-1-2','Nuts','Salt',12,'gm',10,100,930,920,10000,10000,1),(68,1,'6-1-1','Nuts','Masala',12,'gm',10,100,930,920,10000,10000,1),(69,1,'6-2-2','Nuts','Salt',27,'gm',20,48,900,890,4800,4800,1),(70,1,'3-1-1','Wawey','B.B.Q',23,'gm',20,48,900,890,4800,4752,1),(71,1,'3-1-2','Wawey','Onion',23,'gm',20,48,900,890,4800,4800,1),(72,1,'3-1-3','Wawey','Swiss-Cheese',23,'gm',20,48,900,890,4800,4800,1),(73,1,'3-2-1','Wawey','B.B.Q',35,'gm',30,24,675,665,2400,2400,1),(74,1,'3-2-2','Wawey','Onion',35,'gm',30,24,675,665,2400,2400,1),(75,1,'3-2-3','Wawey','Swiss-Cheese',35,'gm',30,24,675,665,2400,2400,1),(76,1,'3-3-1','Wawey','B.B.Q',68,'gm',50,12,550,540,1200,1200,1),(77,1,'3-3-2','Wawey','Onion',68,'gm',50,12,550,540,1200,1200,1);

/*Table structure for table `route` */

DROP TABLE IF EXISTS `route`;

CREATE TABLE `route` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `ROUTE_BOOKER` bigint(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `WEEK_DAY` varchar(15) NOT NULL DEFAULT 'NOT SPECIFIED',
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_route_booker` (`ROUTE_BOOKER`),
  CONSTRAINT `FK_route_booker` FOREIGN KEY (`ROUTE_BOOKER`) REFERENCES `booker` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `route` */

insert  into `route`(`ID`,`ROUTE_BOOKER`,`NAME`,`WEEK_DAY`,`STATUS`) values (3,3,'S.U.Colony & Mehran Society','Monday',1),(4,3,'Brohi Mohalla','Tuesday',1),(5,3,'Sandoz Road','Wednesday',1),(6,3,'Bazar & Phatak','Thursday',1),(7,3,'Society Phase-III','Saturday',1),(8,3,'R.B.B Colony','Sunday',1),(10,5,'Sehwan Road','Wednesday',1),(11,5,'Sindh University Colony','Thursday',1),(12,5,'Saeedabad','Saturday',1),(13,5,'R.B.B colony','Sunday',1),(14,5,'Phatak','Monday',1),(15,5,'LUMHS','Tuesday',1);

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `SHOP_ROUTE` bigint(20) NOT NULL,
  `SHOP_BOOKER` bigint(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `TYPE` varchar(10) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `OPENING_CR` decimal(10,2) NOT NULL,
  `OPENING_DATE` bigint(20) NOT NULL,
  `CURRENT_CR` decimal(10,2) NOT NULL,
  `SCHEME` double DEFAULT NULL,
  `DISCOUNT_DISTRIBUTOR` double NOT NULL,
  `DISCOUNT_AGENCY` double NOT NULL,
  `DISCOUNT_TYPE` enum('AG_RS','AG_PER','DBT_PER','DBT_RS','JOIN_RS','JOIN_PER') DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_shop_booker` (`SHOP_BOOKER`),
  KEY `FK_shop_route` (`SHOP_ROUTE`),
  CONSTRAINT `FK_shop_booker` FOREIGN KEY (`SHOP_BOOKER`) REFERENCES `booker` (`ID`),
  CONSTRAINT `FK_shop_route` FOREIGN KEY (`SHOP_ROUTE`) REFERENCES `route` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;

/*Data for the table `shop` */

insert  into `shop`(`ID`,`SHOP_ROUTE`,`SHOP_BOOKER`,`NAME`,`TYPE`,`ADDRESS`,`OPENING_CR`,`OPENING_DATE`,`CURRENT_CR`,`SCHEME`,`DISCOUNT_DISTRIBUTOR`,`DISCOUNT_AGENCY`,`DISCOUNT_TYPE`,`STATUS`) values (1,7,3,'Ashok Kumar','','-','0.00',1526626800905,'0.00',NULL,0,0,'AG_PER',1),(2,7,3,'Imtiaz','','-','0.00',1526626800905,'0.00',NULL,0,0,'AG_PER',1),(3,7,3,'Sajid Akram','','-','0.00',1526626800219,'0.00',NULL,3,0,'JOIN_PER',1),(4,7,3,'Rashid 1','','-','0.00',1526626800254,'0.00',NULL,0,0,'AG_PER',1),(5,5,3,'Burfat','','-','0.00',1526756400002,'0.00',NULL,0,0,'AG_PER',1),(6,5,3,'Majid','G/S','-','0.00',1526756400440,'0.00',NULL,0,0,'AG_PER',1),(7,6,3,'Sooraj','G/S','-','0.00',1526756400537,'0.00',NULL,0,0,'AG_PER',1),(8,6,3,'Majid Qureshi','','-','0.00',1526756400211,'0.00',NULL,0,2,'AG_PER',1),(9,6,3,'Nadeem Laghari','','-','0.00',1526756400891,'0.00',NULL,0,0,'AG_PER',1),(10,6,3,'Munawar Bhutto','','-','0.00',1526756400530,'0.00',NULL,0,0,'AG_PER',1),(11,6,3,'AL-Murtaza','','-','0.00',1526756400986,'0.00',NULL,0,0,'AG_PER',1),(12,6,3,'Al-Atif','','-','0.00',1526756400995,'0.00',NULL,0,2,'AG_PER',1),(13,6,3,'Dilbar Chandio','','-','0.00',1526756400866,'0.00',NULL,0,0,'AG_PER',1),(14,6,3,'Rind','W/S','-','0.00',1536756400866,'0.00',NULL,0,3,'AG_PER',1),(15,6,3,'Shahnawaz','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(16,6,3,'Aijaz','','- ','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(17,6,3,'Aziz Khan','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(18,5,3,'Amjad Pahi','W/S','-','0.00',1536756400866,'0.00',NULL,0,3,'AG_PER',1),(19,5,3,'Baba Qureshi','W/S','-','0.00',1536756400866,'0.00',NULL,0,3,'AG_PER',1),(20,5,3,'Ali Sher Chandio','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(21,5,3,'Ayoob Chandio','','-','0.00',1536756400866,'0.00',NULL,0,3,'AG_PER',1),(22,5,3,'Ismail Chandio','','- ','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(23,5,3,'Pahi','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(24,5,3,'Sajjad','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(25,5,3,'Sahah Nawaz Petaro','','-','0.00',1536756400866,'0.00',NULL,3,2,'JOIN_PER',1),(26,7,3,'Naveed Lashari','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(27,7,3,'Ishaque','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(28,7,3,'Ab.Ghafoor','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(29,7,3,'Iqbal Shoro','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(30,7,3,'Duaa Meraj','W/S','-','0.00',1536756400866,'0.00',NULL,0,3,'AG_PER',1),(31,7,3,'Sadiq','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(32,7,3,'Kashif','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(33,7,3,'Mir Abbasi','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(34,7,3,'Ali Akbar','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(35,7,3,'Rashid-2','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(36,7,3,'Al-Madina','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(37,7,3,'Khalid','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(38,7,3,'B.S','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(39,7,3,'Soomra','G/S','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(40,7,3,'Rajper','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(41,8,3,'Pyaro','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(42,8,3,'Hasnain','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(43,8,3,'Aamir','','- ','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(44,8,3,'Hamid','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(45,8,3,'Sajid Shoro','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(46,8,3,'Haresh Kumar','','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(47,8,3,'Manzoor Ali','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(48,8,3,'Farhan','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(49,8,3,'Ahsan','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(50,8,3,'Shah','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(51,8,3,'Nisar Baig','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(52,8,3,'Shaikh Bakery','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(53,8,3,'Ayaan Bakery','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(54,8,3,'Khizra Bakery ','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(55,8,3,'Jameel','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(56,8,3,'M.Ali','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(57,8,3,'Salman','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(58,8,3,'New Shop','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(59,8,3,'Khanzeb','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(60,8,3,'Shaikh ','M/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(61,3,3,'Wassy','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(62,3,3,'Sindh','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(63,3,3,'Shaikh','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(64,3,3,'Zardar Khan','','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(65,3,3,'Hanan','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(66,3,3,'Khan Laiq','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(67,3,3,'City Book Store','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(68,3,3,'Saeed','G/S','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(69,3,3,'Ab.Qadir','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(70,3,3,'Javed','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(71,3,3,'Jhatial ','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(72,3,3,'Aqib','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(73,3,3,'Lashari','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(74,3,3,'Mazhar','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(75,3,3,'Friends','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(76,4,3,'Farhan Rind','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(77,4,3,'Rooman','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(78,4,3,'Al-Mansoor','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(79,4,3,'Nawaz','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(80,4,3,'Kamran','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(81,4,3,'Fazal Khan','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(82,4,3,'Rida Hostel','','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(83,4,3,'Bahadur','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(84,4,3,'Saleem','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(85,4,3,'Sajjad Ali','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(86,4,3,'Ibrahim','M/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(87,4,3,'Suhag','G/S','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(88,4,3,'Mazhar Cabin','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(89,4,3,'Jamali','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(90,4,3,'Panhwar','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(91,4,3,'Jillani','D/R','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(92,15,5,'Hussain','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(93,15,5,'Mukhtiyar','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(94,15,5,'Khoso','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(95,10,5,'Aman','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(96,10,5,'Imtiyaz','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(97,10,5,'Irfan','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(98,10,5,'Ameer Ali ','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(99,10,5,'Cabin','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(100,10,5,'Al Rehman','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(101,11,5,'Masroor','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(102,11,5,'Abbas soomro','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(103,11,5,'Sahito','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(104,12,5,'Lakyari','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(105,12,5,'Safdar','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(106,12,5,'Jholay Lal','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(107,13,5,'Bilawal','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(108,13,5,'Taslemm','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(109,13,5,'Raheel','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(110,13,5,'Ramzan','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(111,13,5,'Ibn-e-qasim','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(112,14,5,'Ibrahim','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(113,14,5,'Nayaz','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(114,14,5,'Fida','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(115,14,5,'Al Madina','W/S','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(116,14,5,'Rind','W/S','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(117,14,5,'Asghar Narejo','W/S','-','0.00',1536756400866,'0.00',NULL,0,2,'AG_PER',1),(118,14,5,'Mallah','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(119,14,5,'Raheem','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(120,14,5,'Cabin-2','','-','0.00',1536756400866,'0.00',NULL,0,0,'AG_PER',1),(121,7,3,'Sadam','','-','0.00',1527361200611,'0.00',NULL,0,0,'AG_PER',1);

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STOCK_COMPANY` bigint(11) NOT NULL,
  `INVOICE_NO` bigint(20) NOT NULL,
  `DATE` bigint(20) NOT NULL,
  `TOTAL_QTY` double NOT NULL,
  `TOTAL_AMOUNT` double NOT NULL,
  `PAID` double NOT NULL,
  `PAYABLE` double NOT NULL,
  `STOCK_TYPE` enum('OPENING','CASH_PURCHASE','CR_PURCHASE','PARTIAL') NOT NULL,
  `TIME_IN` varchar(8) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_stock_com` (`STOCK_COMPANY`),
  CONSTRAINT `FK_stock_com` FOREIGN KEY (`STOCK_COMPANY`) REFERENCES `company` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `stock` */

insert  into `stock`(`ID`,`STOCK_COMPANY`,`INVOICE_NO`,`DATE`,`TOTAL_QTY`,`TOTAL_AMOUNT`,`PAID`,`PAYABLE`,`STOCK_TYPE`,`TIME_IN`,`STATUS`) values (4,1,1122,1526540400000,0,0,0,0,'CR_PURCHASE','01:37',3),(5,1,1125,1526540400000,3,2070,0,2070,'CR_PURCHASE','01:43',3),(8,1,11285232,1526626800000,50,28500,0,28500,'CR_PURCHASE','09:59',3),(9,1,1123562,1526626800000,1,920,0,920,'CR_PURCHASE','02:03',3),(10,1,1165232,1526713200000,40,21600,0,21600,'CR_PURCHASE','07:58',3),(11,1,12354321321,1526713200000,100,89000,0,89000,'CR_PURCHASE','08:20',3),(12,1,1235432,1527145200000,10,3200,0,3200,'CR_PURCHASE','01:05',3);

/*Table structure for table `stock_detail` */

DROP TABLE IF EXISTS `stock_detail`;

CREATE TABLE `stock_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STOCK_PRODUCT` bigint(20) NOT NULL,
  `STOCK` bigint(20) NOT NULL,
  `QTY` double NOT NULL,
  `PURCHASE_PRICE` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_stock_detail` (`STOCK_PRODUCT`),
  KEY `FK_stock_detail_pro` (`STOCK`),
  CONSTRAINT `FK_purchase_detail_parent` FOREIGN KEY (`STOCK`) REFERENCES `stock` (`ID`),
  CONSTRAINT `FK_purchase_detail_prod` FOREIGN KEY (`STOCK_PRODUCT`) REFERENCES `products` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `stock_detail` */

insert  into `stock_detail`(`ID`,`STOCK_PRODUCT`,`STOCK`,`QTY`,`PURCHASE_PRICE`) values (5,3,4,2,'590.00'),(6,11,4,1,'890.00'),(7,3,5,128,'590.00'),(8,11,5,48,'890.00'),(11,25,8,800,'570.00'),(12,37,9,10,'920.00'),(13,31,10,120,'540.00'),(14,29,10,120,'540.00'),(15,30,10,120,'540.00'),(16,32,10,120,'540.00'),(17,44,11,4800,'890.00'),(18,38,12,720,'320.00');

/*Table structure for table `summary` */

DROP TABLE IF EXISTS `summary`;

CREATE TABLE `summary` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `W_SCHEDULE` bigint(20) NOT NULL,
  `SUMMARY_ROUTE` bigint(11) NOT NULL,
  `SUMMARY_BOOKER` bigint(20) NOT NULL,
  `QTY` decimal(10,2) NOT NULL,
  `RTN` decimal(10,2) NOT NULL,
  `AMOUNT` decimal(10,2) NOT NULL,
  `CASH` decimal(10,2) NOT NULL,
  `CREDIT` decimal(10,2) NOT NULL,
  `BALANCE` decimal(10,2) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_summary` (`W_SCHEDULE`),
  KEY `FK_summary_route` (`SUMMARY_ROUTE`),
  KEY `FK_summary_BOOKER` (`SUMMARY_BOOKER`),
  CONSTRAINT `FK_summary` FOREIGN KEY (`W_SCHEDULE`) REFERENCES `working_schedule` (`ID`),
  CONSTRAINT `FK_summary_BOOKER` FOREIGN KEY (`SUMMARY_BOOKER`) REFERENCES `booker` (`ID`),
  CONSTRAINT `FK_summary_route` FOREIGN KEY (`SUMMARY_ROUTE`) REFERENCES `route` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `summary` */

insert  into `summary`(`ID`,`W_SCHEDULE`,`SUMMARY_ROUTE`,`SUMMARY_BOOKER`,`QTY`,`RTN`,`AMOUNT`,`CASH`,`CREDIT`,`BALANCE`,`STATUS`) values (3,5,7,3,'50.00','0.00','27405.00','0.00','0.00','27405.00',1),(4,6,8,3,'40.00','0.00','22149.45','0.00','0.00','22149.45',1),(5,7,3,3,'51.00','0.00','28583.00','0.00','0.00','28583.00',7),(6,7,15,5,'10.00','0.00','6660.00','0.00','0.00','6660.00',1);

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BOOKER_ID` bigint(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `STATUS` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `supplier` */

/*Table structure for table `transactions` */

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TRAN_PARTY_ID` bigint(20) NOT NULL,
  `TRAN_ACCOUNT` bigint(20) DEFAULT '0',
  `TRAN_TYPE` int(11) NOT NULL,
  `TRAN_AMOUNT` decimal(10,2) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `REMARKS` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transactions` */

/*Table structure for table `working_schedule` */

DROP TABLE IF EXISTS `working_schedule`;

CREATE TABLE `working_schedule` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE` bigint(20) NOT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `working_schedule` */

insert  into `working_schedule`(`ID`,`DATE`,`STATUS`) values (5,1527274800000,1),(6,1527404400000,1),(7,1527447600000,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
