CREATE DATABASE  IF NOT EXISTS `residencia_fn_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `residencia_fn_db`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: residencia_fn_db
-- ------------------------------------------------------
-- Server version	5.7.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apoderado`
--

DROP TABLE IF EXISTS `apoderado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apoderado` (
  `rut_apoderado` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_apoderado` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `fono_apoderado` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion_apoderado` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `email_apoderado` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`rut_apoderado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoderado`
--

LOCK TABLES `apoderado` WRITE;
/*!40000 ALTER TABLE `apoderado` DISABLE KEYS */;
INSERT INTO `apoderado` VALUES ('20.000.000-0','Mama','11111111111','Su Casa','mama@gmail.com'),('22.000.000-0','Mama Mamosa','22222222222','Su casa en su barrio',NULL);
/*!40000 ALTER TABLE `apoderado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `id_medicamento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_generico` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_fantasia` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `detalle` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `stock_critico` int(11) NOT NULL,
  PRIMARY KEY (`id_medicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES (3,'Ibuprofeno','','Pildoras','Para el dolor de cabeza',100,10),(4,'Paracetamol','','Comprimido','Para el dolor de guata',100,20),(5,'Palan','Palin','Comprimido','',100,20);
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prevision`
--

DROP TABLE IF EXISTS `prevision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prevision` (
  `id_prevision` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_prevision` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_prevision`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prevision`
--

LOCK TABLES `prevision` WRITE;
/*!40000 ALTER TABLE `prevision` DISABLE KEYS */;
INSERT INTO `prevision` VALUES (1,'FONASA'),(2,'ISAPRE'),(4,'Mauricio');
/*!40000 ALTER TABLE `prevision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residente`
--

DROP TABLE IF EXISTS `residente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residente` (
  `rut_residente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `rut_apoderado` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `id_prevision` int(11) NOT NULL,
  `nombre_residente` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `fecha_egreso` datetime DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  `alergias` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `regimen_alimentario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `observaciones` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`rut_residente`),
  KEY `rut_apoderado` (`rut_apoderado`),
  KEY `residente_ibfk_2` (`id_prevision`),
  CONSTRAINT `residente_ibfk_1` FOREIGN KEY (`rut_apoderado`) REFERENCES `apoderado` (`rut_apoderado`),
  CONSTRAINT `residente_ibfk_2` FOREIGN KEY (`id_prevision`) REFERENCES `prevision` (`id_prevision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residente`
--

LOCK TABLES `residente` WRITE;
/*!40000 ALTER TABLE `residente` DISABLE KEYS */;
INSERT INTO `residente` VALUES ('19.014.691-k','20.000.000-0',1,'Andreas Demian Manriquez Ramirez','2020-02-18 03:00:00','2020-02-24 03:00:00',NULL,'M','polvo, el mismo.','diabetica','esta medio guaton'),('21.000.000-0','22.000.000-0',2,'Salyan Demian Manriquez Ramirez','2020-02-04 03:00:00','2020-02-18 03:00:00',NULL,'F','perros, dogs.','normal','no le gustan los perros.');
/*!40000 ALTER TABLE `residente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamientos`
--

DROP TABLE IF EXISTS `tratamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tratamientos` (
  `id_tratamiento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rut_residente` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `id_medicamento` int(10) unsigned DEFAULT NULL,
  `dosis` decimal(10,0) DEFAULT NULL,
  `hora` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_tratamiento`),
  KEY `rut_residente` (`rut_residente`),
  KEY `id_medicamento` (`id_medicamento`),
  CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`),
  CONSTRAINT `tratamientos_ibfk_2` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamientos`
--

LOCK TABLES `tratamientos` WRITE;
/*!40000 ALTER TABLE `tratamientos` DISABLE KEYS */;
INSERT INTO `tratamientos` VALUES (7,'19.014.691-k',4,2,'20:00');
/*!40000 ALTER TABLE `tratamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `rut_usuario` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_usuario` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clave` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nivel_acceso` tinyint(4) DEFAULT '0',
  `estado` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`rut_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('21116123k','Estobon','Cwkulzzp9y0sqeMqw3hiu22ivv2R/ePV/rdRperWyoU=',0,0),('998887776','asd','Cwkulzzp9y0sqeMqw3hiu22ivv2R/ePV/rdRperWyoU=',1,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-02  2:37:51
