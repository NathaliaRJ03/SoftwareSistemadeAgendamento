CREATE DATABASE  IF NOT EXISTS `gestao_venda1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestao_venda1`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: gestao_venda1
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bebida java','insercao no netbeans'),(2,'Bebida java000000','insercao no netbeans'),(5,'Bebida java01','insercao no netbeans'),(8,'Bebida java02','insercao no netbeans');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `pedido` varchar(100) DEFAULT NULL,
  `data_entrega` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Vinicius Esteves de Souza','11111111','Estrada joão melo 222','Cola','11/10'),(2,'Vinicius Esteves de Souza','11111111','Estrada joão melo 222','Cola','11/10'),(3,'mk','1232312321','rua da moranga','3 pasteis','03/2034'),(4,'vini','12321321','1232132','sim','asdsad'),(5,'vini','12321321','1232132','sim','asdsad'),(6,'vini','12321321','1232132','sim','asdsad'),(7,'Vinicius','213213','estrada do mendanha','coxinha','1111'),(8,'Vini','123213','rua jose','sla','11/05'),(9,'mk','123213213','sla aonde','4 pais','amanha'),(10,'natalia','10','roblox','dinossauro','56'),(11,'natalia','21998428874','bangu','10 dinossauros','1986');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `quantidade` int DEFAULT NULL,
  `categoria_id` int NOT NULL,
  `usuario_id` bigint NOT NULL,
  `data_hora_criacao` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  KEY `fk_produto_categoria` (`categoria_id`),
  KEY `fk_produto_usuario` (`usuario_id`),
  CONSTRAINT `fk_produto_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_produto_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `perfil` varchar(10) DEFAULT 'PADRAO',
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `data_hora_criacao` datetime DEFAULT CURRENT_TIMESTAMP,
  `ultimo_login` datetime DEFAULT '0001-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Vinicius Souza','NewDesign','$2a$10$Z4WzdgJISGuzB18EYwUezuyHGAJPvi8liFy9GXc9iY2TyZJ/9zbGK','PADRAO',1,'2023-10-19 16:52:04','0001-01-01 00:00:00'),(4,'mk','robson','1234','ADMIN',1,'2023-10-19 16:59:29','0001-01-01 00:00:00'),(5,'Nathy','nt','1234','ADMIN',1,'2023-10-19 17:34:14','0001-01-01 00:00:00'),(6,'frakilin','fk','1234','PADRAO',1,'2023-10-19 18:06:42','0001-01-01 00:00:00'),(7,'Leandro','Leo','$2a$10$gzJJSMAUxezzQR/V2BC1a.ueebzx.7jBZ22Cfg9SiSWb6n3Uue2Pq','PADRAO',1,'2023-10-19 19:19:39','0001-01-01 00:00:00');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_venda` decimal(10,2) NOT NULL,
  `valor_pago` decimal(10,2) NOT NULL,
  `troco` decimal(10,2) NOT NULL,
  `desconto` decimal(10,2) NOT NULL,
  `cliente_id` int DEFAULT NULL,
  `usuario_id` bigint NOT NULL,
  `data_hora_criacao` datetime DEFAULT CURRENT_TIMESTAMP,
  `ultima_actualizacao` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_venda_cliente` (`cliente_id`),
  KEY `fk_venda_usuario` (`usuario_id`),
  CONSTRAINT `fk_venda_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_venda_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda_item`
--

DROP TABLE IF EXISTS `venda_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda_item` (
  `venda_id` int NOT NULL,
  `produto_id` bigint NOT NULL,
  `quantidade` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `desconto` decimal(10,2) NOT NULL,
  KEY `fk_venda_item_venda` (`venda_id`),
  KEY `fk_venda_item_produto` (`produto_id`),
  CONSTRAINT `fk_venda_item_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `fk_venda_item_venda` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda_item`
--

LOCK TABLES `venda_item` WRITE;
/*!40000 ALTER TABLE `venda_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestao_venda1'
--

--
-- Dumping routines for database 'gestao_venda1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-31 16:32:14
