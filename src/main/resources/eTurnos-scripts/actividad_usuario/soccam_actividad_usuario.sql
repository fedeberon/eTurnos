-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: soccam
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table actividad_usuario
--

DROP TABLE IF EXISTS actividad_usuario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE actividad_usuario (
  ACT_ID bigint(20) NOT NULL AUTO_INCREMENT,
  ACT_ACTIVIDAD varchar(255) DEFAULT NULL,
  ACT_MOMENTO tinyblob,
  USU_ID int(11) DEFAULT NULL,
  PRIMARY KEY (ACT_ID),
  KEY FK_gjl4qxbc1ig5rh9rkm21b4fir (USU_ID),
  CONSTRAINT FK_gjl4qxbc1ig5rh9rkm21b4fir FOREIGN KEY (USU_ID) REFERENCES users (USERS_ID)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table actividad_usuario
--

LOCK TABLES actividad_usuario WRITE;
/*!40000 ALTER TABLE actividad_usuario DISABLE KEYS */;
INSERT INTO actividad_usuario VALUES (7065,'LOGUEADO','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\ã(	)NW@x',1),(7066,'LOGUEADO','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\ã(l´@x',1),(7067,'LOGUEADO','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\ã\n5,\ÃYÀx',1),(7068,'LOGUEADO','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\ã\n!p€x',1);
/*!40000 ALTER TABLE actividad_usuario ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-30 11:01:06
