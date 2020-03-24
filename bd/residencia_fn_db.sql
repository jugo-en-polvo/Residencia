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
  `rut_usuario` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint NOT NULL,
  `observaciones` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
INSERT INTO `apoderado` VALUES ('19.176.758-6','Pabla Vergara','950718288','Los Guindos 667','Esteban.lagos.lobos@gmail.com');
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
  `rut_residente` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `rut_usuario` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `presion_arterial` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `pulso` varchar(5) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `saturacion` varchar(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `hgt` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `cambio_posicion` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `solucion_parenteral` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `suero` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `observaciones` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
/*!40000 ALTER TABLE `control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controles_medicos`
--

DROP TABLE IF EXISTS `controles_medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `controles_medicos` (
  `rut_residente` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha_hora_control` datetime NOT NULL,
  `id_lugar` int unsigned NOT NULL,
  `estado_control` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL DEFAULT 'N',
  `observaciones` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
INSERT INTO `controles_medicos` VALUES ('19.014.691-k','2020-03-24 10:00:00',4,'N','1');
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
  `rut_residente` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `enfermedad` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(150) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_diagnostico`),
  KEY `rut_residente` (`rut_residente`),
  CONSTRAINT `diagnostico_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
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
  `rut_residente` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `desayuno` tinyint DEFAULT NULL,
  `colacion_1` tinyint DEFAULT NULL,
  `almuerzo` tinyint DEFAULT NULL,
  `colacion_2` tinyint DEFAULT NULL,
  `once` tinyint DEFAULT NULL,
  `cena` tinyint DEFAULT NULL,
  `observaciones` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergencia`
--

DROP TABLE IF EXISTS `emergencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emergencia` (
  `rut_residente` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha_emergencia` datetime NOT NULL,
  `id_lugar` int unsigned NOT NULL,
  `observaciones` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
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
  `nombre_lugar` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fono_lugar` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion_lugar` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint NOT NULL,
  PRIMARY KEY (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Hospital Naval','123456789','Avenida Freire',1),(2,'Hospital VanAlgo','123456789','Avenida CasaMucho 213',0),(3,'Residencia','2003000400','5 Norte, 5 Poniente',1),(4,'Hospital Van Buren','1234','1234',1);
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
  `nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `concentracion` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `presentacion` varchar(5) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `detalle` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `stock` int NOT NULL,
  `stock_critico` int NOT NULL,
  PRIMARY KEY (`id_medicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES (7,'Paracetamol','600mg','20','Comprimidos','El de siempre. Muy Bueno.',20,10),(8,'Ibuprofeno','600mg','30','Píldoras','Para el dolor.',20,5),(9,'Tapsin Noche','5gr','1','Sobre','Tapsin noche para noche',20,5);
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prevision`
--

DROP TABLE IF EXISTS `prevision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prevision` (
  `id_prevision` int unsigned NOT NULL AUTO_INCREMENT,
  `tipo_prevision` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(310) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_prevision`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prevision`
--

LOCK TABLES `prevision` WRITE;
/*!40000 ALTER TABLE `prevision` DISABLE KEYS */;
INSERT INTO `prevision` VALUES (1,'FONASA','El Fondo Nacional de Salud (Fonasa) es el organismo público que administra los fondos estatales destinados a salud en Chile, para dar cobertura a sus beneficiarios y beneficiarias. Fonasa es la alternativa pública al sistema privado de salud, representado por las Instituciones de Salud Previsional (ISAPRES).'),(2,'ISAPRE','Las Instituciones de Salud Previsional (Isapres) son entidades privadas que funcionan en base a un esquema de seguros, las cuales están facultados para administrar la cotización obligatoria de salud de los personas que libre e individualmente optaron por ellas en lugar del sistema de salud estatal (FONASA).'),(3,'Fuerzas Armandas','Previsión dada las fuerzas de orden público.'),(4,'Mauricio','dsa');
/*!40000 ALTER TABLE `prevision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `previsionnombretipo`
--

DROP TABLE IF EXISTS `previsionnombretipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `previsionnombretipo` (
  `id_prevision_nombre_tipo` int unsigned NOT NULL AUTO_INCREMENT,
  `id_prevision` int unsigned NOT NULL,
  `nombre_prevision` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(300) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_prevision_nombre_tipo`),
  KEY `id_prevision` (`id_prevision`),
  CONSTRAINT `previsionnombretipo_ibfk_1` FOREIGN KEY (`id_prevision`) REFERENCES `prevision` (`id_prevision`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `previsionnombretipo`
--

LOCK TABLES `previsionnombretipo` WRITE;
/*!40000 ALTER TABLE `previsionnombretipo` DISABLE KEYS */;
INSERT INTO `previsionnombretipo` VALUES (6,1,'A','Son consideradas en este grupo las personas carentes de recursos y los causantes de subsidio único familiar, por lo que se atienden de manera gratuita en Hospitales y Consultorios públicos.'),(7,1,'B','Son consideradas en este grupo las personas cuyo Ingreso Imponible Mensual sea menor o igual a $276.000 y las personas beneficiarias de Pensiones Básicas Solidarias, por lo que se atienden de manera gratuita en Hospitales y Consultorios públicos.'),(8,1,'C',''),(9,1,'D',''),(10,2,'Chuqicamata Ltda.',''),(11,2,'Consalud S.A',''),(12,2,'Colmena Golden Cross S.A',''),(13,1,'-No Sabe-',NULL),(14,2,'-No Sabe-',NULL),(15,2,'Banmédica S.A','');
/*!40000 ALTER TABLE `previsionnombretipo` ENABLE KEYS */;
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
  `id_prevision` int unsigned NOT NULL,
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
  CONSTRAINT `residente_ibfk_2` FOREIGN KEY (`id_prevision`) REFERENCES `previsionnombretipo` (`id_prevision_nombre_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residente`
--

LOCK TABLES `residente` WRITE;
/*!40000 ALTER TABLE `residente` DISABLE KEYS */;
INSERT INTO `residente` VALUES ('19.014.691-k','19.176.758-6',11,'Andreas Demian Manríquez Ramírez','1996-01-01 00:00:00','2020-03-16 00:00:00',NULL,'M','Polvo.','Normal','Esta obeso.'),('20.780.507-6','19.176.758-6',11,'Salyan Elizabeth Manríquez Ramírez','2001-05-21 00:00:00','2020-03-16 00:00:00',NULL,'F','Perros.','Normal','Le gustan los gatos.');
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
  `rut_usuario` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `periodo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tratamiento`),
  KEY `rut_residente` (`rut_residente`),
  KEY `id_medicamento` (`id_medicamento`),
  KEY `rut_usuario` (`rut_usuario`),
  CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`rut_residente`) REFERENCES `residente` (`rut_residente`),
  CONSTRAINT `tratamientos_ibfk_2` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`),
  CONSTRAINT `tratamientos_ibfk_3` FOREIGN KEY (`rut_usuario`) REFERENCES `usuarios` (`rut_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamientos`
--

LOCK TABLES `tratamientos` WRITE;
/*!40000 ALTER TABLE `tratamientos` DISABLE KEYS */;
INSERT INTO `tratamientos` VALUES (27,'19.014.691-k',9,1,'22:00','19.014.691-k','Todos los días.'),(28,'19.014.691-k',9,1,'22:00','19.014.691-k','Todos los días.');
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
INSERT INTO `usuarios` VALUES ('19.014.691-k','Andreas Manríquez','n95vB6n2qOiMmbWg1GreiwrIZKT+XKQ2oc07+7DAPF0=',1,0),('21.116.123-k','Esteban Lagos','n95vB6n2qOiMmbWg1GreiwrIZKT+XKQ2oc07+7DAPF0=',1,0);
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

-- Dump completed on 2020-03-24  8:35:42
