CREATE DATABASE  IF NOT EXISTS `residencia_fn_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `residencia_fn_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: residencia_fn_db
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `administrar_medicamento`
--

DROP TABLE IF EXISTS `administrar_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrar_medicamento` (
  `id_tratamiento` int unsigned NOT NULL,
  `fecha_administracion` datetime NOT NULL,
  `rut_usuario` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint NOT NULL,
  `observaciones` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_tratamiento`,`fecha_administracion`),
  KEY `administrar_medicamento_ibfk_2` (`rut_usuario`),
  CONSTRAINT `administrar_medicamento_ibfk_1` FOREIGN KEY (`id_tratamiento`) REFERENCES `tratamientos` (`id_tratamiento`),
  CONSTRAINT `administrar_medicamento_ibfk_2` FOREIGN KEY (`rut_usuario`) REFERENCES `usuarios` (`rut_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrar_medicamento`
--

LOCK TABLES `administrar_medicamento` WRITE;
/*!40000 ALTER TABLE `administrar_medicamento` DISABLE KEYS */;
INSERT INTO `administrar_medicamento` VALUES (7,'2020-03-04 00:00:00',NULL,0,''),(8,'2020-03-04 00:00:00',NULL,0,''),(9,'2020-03-04 00:00:00',NULL,0,''),(10,'2020-03-04 00:00:00','20.000.000-0',1,'Todo Conforme'),(11,'2020-03-04 00:00:00',NULL,0,''),(12,'2020-03-04 00:00:00',NULL,0,''),(13,'2020-03-04 00:00:00',NULL,0,''),(14,'2020-03-04 00:00:00',NULL,0,''),(15,'2020-03-04 00:00:00',NULL,0,''),(16,'2020-03-04 00:00:00',NULL,0,'');
/*!40000 ALTER TABLE `administrar_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoderado`
--

DROP TABLE IF EXISTS `apoderado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apoderado` (
  `rut_apoderado` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre_apoderado` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fono_apoderado` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion_apoderado` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `email_apoderado` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
-- Table structure for table `control`
--

DROP TABLE IF EXISTS `control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control` (
  `fecha_hora_control` datetime NOT NULL,
  `rut_residente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `rut_usuario` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `presion_arterial` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pulso` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `saturacion` varchar(4) COLLATE utf8_spanish_ci DEFAULT NULL,
  `hgt` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cambio_posicion` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `solucion_parenteral` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `suero` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `observaciones` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`fecha_hora_control`,`rut_residente`),
  KEY `rut_residente` (`rut_residente`),
  KEY `rut_usuario` (`rut_usuario`),
  CONSTRAINT `control_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`),
  CONSTRAINT `control_ibfk_2` FOREIGN KEY (`rut_usuario`) REFERENCES `usuarios` (`rut_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control`
--

LOCK TABLES `control` WRITE;
/*!40000 ALTER TABLE `control` DISABLE KEYS */;
INSERT INTO `control` VALUES ('2020-03-04 06:44:08','21.000.000-0','20.000.000-0','1','1','1','1','1','1','1',NULL);
/*!40000 ALTER TABLE `control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controles_medicos`
--

DROP TABLE IF EXISTS `controles_medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `controles_medicos` (
  `rut_residente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_hora_control` datetime NOT NULL,
  `id_lugar` int unsigned NOT NULL,
  `estado_control` varchar(1) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `observaciones` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`rut_residente`,`fecha_hora_control`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `controles_medicos_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`),
  CONSTRAINT `controles_medicos_ibfk_2` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id_lugar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controles_medicos`
--

LOCK TABLES `controles_medicos` WRITE;
/*!40000 ALTER TABLE `controles_medicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `controles_medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostico` (
  `id_diagnostico` int unsigned NOT NULL AUTO_INCREMENT,
  `rut_residente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `enfermedad` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_diagnostico`),
  KEY `rut_residente` (`rut_residente`),
  CONSTRAINT `diagnostico_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
INSERT INTO `diagnostico` VALUES (1,'19.014.691-k','Cancer','Un Cancer po'),(2,'19.014.691-k','Diabetes','Por comer mucha azucar');
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieta` (
  `fecha_dieta` datetime NOT NULL,
  `rut_residente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `desayuno` tinyint DEFAULT NULL,
  `colacion_1` tinyint DEFAULT NULL,
  `almuerzo` tinyint DEFAULT NULL,
  `colacion_2` tinyint DEFAULT NULL,
  `once` tinyint DEFAULT NULL,
  `cena` tinyint DEFAULT NULL,
  `observaciones` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`fecha_dieta`,`rut_residente`),
  KEY `rut_residente` (`rut_residente`),
  CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES ('2020-03-04 00:00:00','19.014.691-k',0,0,0,0,0,0,NULL),('2020-03-04 03:00:00','19.014.691-k',0,1,1,0,0,0,NULL),('2020-03-04 03:00:00','21.000.000-0',0,1,0,0,0,0,NULL);
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergencia`
--

DROP TABLE IF EXISTS `emergencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emergencia` (
  `rut_residente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_emergencia` datetime NOT NULL,
  `id_lugar` int unsigned NOT NULL,
  `observaciones` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`rut_residente`,`fecha_emergencia`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `emergencia_ibfk_1` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id_lugar`),
  CONSTRAINT `emergencia_ibfk_2` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergencia`
--

LOCK TABLES `emergencia` WRITE;
/*!40000 ALTER TABLE `emergencia` DISABLE KEYS */;
INSERT INTO `emergencia` VALUES ('19.014.691-k','2020-03-03 03:00:00',1,'Le dolia la guata y vomito.'),('19.014.691-k','2020-03-03 08:00:00',1,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),('19.014.691-k','2020-03-03 14:16:00',1,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),('21.000.000-0','2020-03-04 03:00:00',1,'Probando zona horaria'),('21.000.000-0','2020-03-04 05:00:00',1,'casa'),('21.000.000-0','2020-03-09 03:00:00',1,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
/*!40000 ALTER TABLE `emergencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `id_lugar` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre_lugar` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fono_lugar` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion_lugar` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Hospital Naval','123456789','Calle Falsa 123'),(2,'Hospital VanAlgo','123456789','Avenida CasaMucho 213');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `id_medicamento` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre_generico` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre_fantasia` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `detalle` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `stock` int NOT NULL,
  `stock_critico` int NOT NULL,
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
  `id_prevision` int NOT NULL AUTO_INCREMENT,
  `nombre_prevision` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_prevision`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prevision`
--

LOCK TABLES `prevision` WRITE;
/*!40000 ALTER TABLE `prevision` DISABLE KEYS */;
INSERT INTO `prevision` VALUES (1,'FONASA'),(2,'FONASA'),(4,'Mauricio');
/*!40000 ALTER TABLE `prevision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residente`
--

DROP TABLE IF EXISTS `residente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residente` (
  `rut_residente` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `rut_apoderado` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_prevision` int NOT NULL,
  `nombre_residente` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `fecha_egreso` datetime DEFAULT NULL,
  `sexo` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `alergias` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `regimen_alimentario` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `observaciones` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
INSERT INTO `residente` VALUES ('19.014.691-k','20.000.000-0',1,'Andreas Demian Manriquez Ramirez','2020-02-18 03:00:00','2020-02-24 03:00:00',NULL,'F','polvo, el mismo, los gatos','Normal','esta medio guaton, se le esta callendo el pelo'),('21.000.000-0','22.000.000-0',2,'Salyan Demian Manriquez Ramirez','2020-02-04 03:00:00','2020-02-18 03:00:00',NULL,'F','perros, dogs.','Normal','no le gustan los perros.'),('21.212.121-2','22.000.000-0',2,'Pepe Pepe Pepe','1973-10-15 00:00:00','1910-03-03 00:00:00',NULL,'F','Polvo','Diabetica','Nada');
/*!40000 ALTER TABLE `residente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamientos`
--

DROP TABLE IF EXISTS `tratamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tratamientos` (
  `id_tratamiento` int unsigned NOT NULL AUTO_INCREMENT,
  `rut_residente` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_medicamento` int unsigned DEFAULT NULL,
  `dosis` decimal(10,0) DEFAULT NULL,
  `hora` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_tratamiento`),
  KEY `rut_residente` (`rut_residente`),
  KEY `id_medicamento` (`id_medicamento`),
  CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`),
  CONSTRAINT `tratamientos_ibfk_2` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamientos`
--

LOCK TABLES `tratamientos` WRITE;
/*!40000 ALTER TABLE `tratamientos` DISABLE KEYS */;
INSERT INTO `tratamientos` VALUES (7,'19.014.691-k',4,2,'20:00'),(8,'19.014.691-k',4,1,'24:00'),(9,'19.014.691-k',5,2,'23:40'),(10,'19.014.691-k',4,2,'10:00'),(11,'21.000.000-0',4,20,'12:00'),(12,'19.014.691-k',4,22,'22:22'),(13,'21.000.000-0',3,2,'11:11'),(14,'21.000.000-0',5,2,'12:12'),(15,'21.000.000-0',4,222,'11:11'),(16,'19.014.691-k',4,2000,'19:00');
/*!40000 ALTER TABLE `tratamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `rut_usuario` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre_usuario` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `clave` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `nivel_acceso` tinyint DEFAULT '0',
  `estado` tinyint DEFAULT '1',
  PRIMARY KEY (`rut_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('19.014.691-k','Andreas Manriquez','0iROh+5CiCSpAi1HtA1AMSBi/CNHIvgOD49IMFfUhS8=',0,0),('20.000.000-0','Andreas','n95vB6n2qOiMmbWg1GreiwrIZKT+XKQ2oc07+7DAPF0=',1,0),('21116123k','Estobon','Cwkulzzp9y0sqeMqw3hiu22ivv2R/ePV/rdRperWyoU=',0,0),('30.000.000-0','Esteban','n95vB6n2qOiMmbWg1GreiwrIZKT+XKQ2oc07+7DAPF0=',0,0),('998887776','asd','Cwkulzzp9y0sqeMqw3hiu22ivv2R/ePV/rdRperWyoU=',1,1);
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

-- Dump completed on 2020-03-04 20:53:15
