-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: seguroderesidencia
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `analisesolicitacao`
--

DROP TABLE IF EXISTS `analisesolicitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `analisesolicitacao` (
  `idCorretor` int(11) NOT NULL,
  `idSolicitacao` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  UNIQUE KEY `idSolicitacao_UNIQUE` (`idSolicitacao`),
  UNIQUE KEY `idCorretor_UNIQUE` (`idCorretor`),
  KEY `fk_solicitacao` (`idSolicitacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisesolicitacao`
--

LOCK TABLES `analisesolicitacao` WRITE;
/*!40000 ALTER TABLE `analisesolicitacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `analisesolicitacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apolice`
--

DROP TABLE IF EXISTS `apolice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apolice` (
  `idApolice` int(11) NOT NULL AUTO_INCREMENT,
  `bandeiraCartao` char(10) DEFAULT NULL,
  `numeroApolice` float DEFAULT NULL,
  `premioApolice` decimal(45,0) DEFAULT NULL,
  `dataContratacaoApolice` varchar(11) DEFAULT NULL,
  `cartaoCreditoPgto` bigint(45) DEFAULT NULL,
  `vencimentoCartao` varchar(10) DEFAULT NULL,
  `codSegurancaCartao` decimal(10,0) DEFAULT NULL,
  `nomeNoCartao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idApolice`),
  UNIQUE KEY `idApolice_UNIQUE` (`idApolice`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apolice`
--

LOCK TABLES `apolice` WRITE;
/*!40000 ALTER TABLE `apolice` DISABLE KEYS */;
INSERT INTO `apolice` VALUES (1,NULL,2536,250,'08/06/2018',NULL,'2142',215,'2142');
/*!40000 ALTER TABLE `apolice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoliceparcela`
--

DROP TABLE IF EXISTS `apoliceparcela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apoliceparcela` (
  `idApolice` int(11) DEFAULT NULL,
  `idParcela` int(11) DEFAULT NULL,
  KEY `fk_parecla_idx` (`idParcela`),
  KEY `fk_apolice_idx` (`idApolice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoliceparcela`
--

LOCK TABLES `apoliceparcela` WRITE;
/*!40000 ALTER TABLE `apoliceparcela` DISABLE KEYS */;
/*!40000 ALTER TABLE `apoliceparcela` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bem`
--

DROP TABLE IF EXISTS `bem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bem` (
  `idBem` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoBem` varchar(60) DEFAULT NULL,
  `valorBem` float DEFAULT NULL,
  `idResidenciaPertencente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBem`),
  KEY `idResidenciaPertencente` (`idResidenciaPertencente`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bem`
--

LOCK TABLES `bem` WRITE;
/*!40000 ALTER TABLE `bem` DISABLE KEYS */;
INSERT INTO `bem` VALUES (41,'Sofa',540,24),(42,'Sofa',520,24),(43,'Sofa',520,24),(44,'Sofa',520,24),(45,'Sofa',520,24),(46,'Sofa',520,24);
/*!40000 ALTER TABLE `bem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato` (
  `cep` varchar(10) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `idPessoa` int(11) NOT NULL,
  `ufCandidato` varchar(2) DEFAULT NULL,
  `cidadeCandidato` varchar(30) DEFAULT NULL,
  `bairroCandidato` varchar(30) DEFAULT NULL,
  `dataNascimento` varchar(10) DEFAULT NULL,
  UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato`
--

LOCK TABLES `candidato` WRITE;
/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
INSERT INTO `candidato` VALUES ('97547590','Masculino',40,'RS','Alegrete','Centro','06/09/1998'),('97547590',NULL,41,'RS','Alegrete','NS conceição aparecida','06Jul1997'),('97547590',NULL,42,'RS','Alegrete','NS da conceicao aparecida','02Mar1984'),('97546280',NULL,43,'RS','Alegrete','Ibirapuitã','08Mar1999');
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corretor`
--

DROP TABLE IF EXISTS `corretor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corretor` (
  `ativoCorretor` varchar(10) DEFAULT NULL,
  `dataContratacao` datetime DEFAULT NULL,
  `idPessoa` int(11) NOT NULL,
  KEY `fk_corretorPessoa_idx` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corretor`
--

LOCK TABLES `corretor` WRITE;
/*!40000 ALTER TABLE `corretor` DISABLE KEYS */;
/*!40000 ALTER TABLE `corretor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemservico`
--

DROP TABLE IF EXISTS `itemservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemservico` (
  `descricaoRecusa` varchar(145) DEFAULT NULL,
  `descricaoAtendimento` varchar(145) DEFAULT NULL,
  `atendidaSolicitacao` varchar(10) DEFAULT NULL,
  `aceitaSolicitacao` varchar(10) DEFAULT NULL,
  `descricaoSolicitacao` varchar(145) DEFAULT NULL,
  `idItemServiço` int(11) NOT NULL AUTO_INCREMENT,
  `idServico` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItemServiço`),
  UNIQUE KEY `idItemServiço_UNIQUE` (`idItemServiço`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemservico`
--

LOCK TABLES `itemservico` WRITE;
/*!40000 ALTER TABLE `itemservico` DISABLE KEYS */;
INSERT INTO `itemservico` VALUES ('',NULL,NULL,NULL,NULL,1,1);
/*!40000 ALTER TABLE `itemservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcelaapolice`
--

DROP TABLE IF EXISTS `parcelaapolice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcelaapolice` (
  `valorParcela` decimal(45,0) DEFAULT NULL,
  `idParcela` int(11) NOT NULL AUTO_INCREMENT,
  `dataPagntParcela` datetime DEFAULT NULL,
  PRIMARY KEY (`idParcela`),
  UNIQUE KEY `idParcela_UNIQUE` (`idParcela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcelaapolice`
--

LOCK TABLES `parcelaapolice` WRITE;
/*!40000 ALTER TABLE `parcelaapolice` DISABLE KEYS */;
/*!40000 ALTER TABLE `parcelaapolice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `Nome` varchar(45) DEFAULT NULL,
  `Endereco` varchar(45) DEFAULT NULL,
  `Telefone` bigint(12) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `nomeLogin` varchar(10) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPessoa`),
  UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`),
  UNIQUE KEY `cpf_pk` (`Cpf`),
  UNIQUE KEY `email_unique` (`email`),
  UNIQUE KEY `nomeLogin_unique` (`nomeLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('Matheus Montanha','Joaquim Rodrigues Paim, 410',34565236,'229','jojoPaulin','0352635','estranho@gmail.com',40),('Matheus Montanha Paulon','Joaquim Rodrigues Paim, 410',984564630,'03457088064','mathmont','742617','matheusmontanha@gmail.com',41),('Joao Paulo Silva','Joaquim Rodrigues Paim, 410',55984564630,'03457088063','joaoPaulo','1234','JoaoSilva@hotmail.com',42),('Hanna Rebeca Ismail','Rua Inácio Lecuana 388',11944442010,'42459085800','hanna','944442010','hanna.rebeka64@gmail.com',43);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relatasinistro`
--

DROP TABLE IF EXISTS `relatasinistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relatasinistro` (
  `idSinistro` int(11) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  KEY `idSinistro` (`idSinistro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relatasinistro`
--

LOCK TABLES `relatasinistro` WRITE;
/*!40000 ALTER TABLE `relatasinistro` DISABLE KEYS */;
INSERT INTO `relatasinistro` VALUES (4,41);
/*!40000 ALTER TABLE `relatasinistro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residencia`
--

DROP TABLE IF EXISTS `residencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residencia` (
  `idResidencia` int(11) NOT NULL AUTO_INCREMENT,
  `idProprietario` int(11) NOT NULL,
  `ufResidencia` varchar(2) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `descricaoResidencia` varchar(145) DEFAULT NULL,
  `cepResidencia` varchar(10) DEFAULT NULL,
  `enderecoResidencia` varchar(45) DEFAULT NULL,
  `areaTotal` varchar(45) DEFAULT NULL,
  `areaConstruida` varchar(45) DEFAULT NULL,
  `anoConstrucao` int(11) DEFAULT NULL,
  `estruturaAmeacada` int(11) DEFAULT NULL,
  `localizacaoPerigosa` int(11) DEFAULT NULL,
  `terrenoPerigoso` int(11) DEFAULT NULL,
  `quantidadeComodos` decimal(45,0) DEFAULT NULL,
  `quantidadeBanheiros` int(11) DEFAULT NULL,
  `quantidadeGaragens` decimal(45,0) DEFAULT NULL,
  `numeroAndares` decimal(45,0) DEFAULT NULL,
  PRIMARY KEY (`idResidencia`),
  KEY `idProprietario` (`idProprietario`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residencia`
--

LOCK TABLES `residencia` WRITE;
/*!40000 ALTER TABLE `residencia` DISABLE KEYS */;
INSERT INTO `residencia` VALUES (24,40,'RS','Alegrete','Centro','Casa verde','97547590','Joaquim Rodrigues Paim, 410','5285.0','510.0',2011,5,4,5,7,1,1,3);
/*!40000 ALTER TABLE `residencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segurado`
--

DROP TABLE IF EXISTS `segurado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segurado` (
  `idPessoa` int(11) DEFAULT NULL,
  KEY `idPessoa` (`idPessoa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segurado`
--

LOCK TABLES `segurado` WRITE;
/*!40000 ALTER TABLE `segurado` DISABLE KEYS */;
INSERT INTO `segurado` VALUES (40);
/*!40000 ALTER TABLE `segurado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguradosolicitaservico`
--

DROP TABLE IF EXISTS `seguradosolicitaservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguradosolicitaservico` (
  `idSegurado` int(11) DEFAULT NULL,
  `idServico` int(11) DEFAULT NULL,
  KEY `idSegurado` (`idSegurado`),
  KEY `idServico` (`idServico`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguradosolicitaservico`
--

LOCK TABLES `seguradosolicitaservico` WRITE;
/*!40000 ALTER TABLE `seguradosolicitaservico` DISABLE KEYS */;
INSERT INTO `seguradosolicitaservico` VALUES (40,1);
/*!40000 ALTER TABLE `seguradosolicitaservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `descricaoServico` varchar(145) DEFAULT NULL,
  `idServico` int(11) NOT NULL AUTO_INCREMENT,
  `quantidadeServico` decimal(10,0) DEFAULT NULL,
  `dataDeSolicitacao` date DEFAULT NULL,
  `dataVisita` date DEFAULT NULL,
  PRIMARY KEY (`idServico`),
  UNIQUE KEY `idServico_UNIQUE` (`idServico`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES ('Encanador,',1,1,'2018-06-22','2018-06-23'),('Encanador,',2,1,'2018-06-23','2018-06-24');
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinistro`
--

DROP TABLE IF EXISTS `sinistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sinistro` (
  `parecerAvaliador` varchar(145) DEFAULT NULL,
  `dataSinistro` date DEFAULT NULL,
  `descricaoSinistro` varchar(145) DEFAULT NULL,
  `autorizadoSinistro` varchar(10) DEFAULT NULL,
  `valorSinistro` decimal(45,0) DEFAULT NULL,
  `idSinistro` int(11) NOT NULL AUTO_INCREMENT,
  `idTipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSinistro`),
  UNIQUE KEY `idSinistro_UNIQUE` (`idSinistro`),
  KEY `fk_tipoSinistro` (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinistro`
--

LOCK TABLES `sinistro` WRITE;
/*!40000 ALTER TABLE `sinistro` DISABLE KEYS */;
INSERT INTO `sinistro` VALUES ('Sinistro muito louco','2018-05-23','Dois homens com mascara.',NULL,250,4,4);
/*!40000 ALTER TABLE `sinistro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitacaoseguro`
--

DROP TABLE IF EXISTS `solicitacaoseguro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacaoseguro` (
  `idSolicitacao` int(11) NOT NULL AUTO_INCREMENT,
  `dataSolicitacao` date DEFAULT NULL,
  `dataVisitaResidenciia` varchar(10) DEFAULT NULL,
  `valorSolicitacao` float DEFAULT NULL,
  `aprovada` varchar(10) DEFAULT NULL,
  `motivoReprovacao` varchar(150) DEFAULT NULL,
  `motivoAlterecao` varchar(150) DEFAULT NULL,
  `idResidencia` int(11) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitacao`),
  KEY `idResidencia` (`idResidencia`),
  KEY `idPessoa` (`idPessoa`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacaoseguro`
--

LOCK TABLES `solicitacaoseguro` WRITE;
/*!40000 ALTER TABLE `solicitacaoseguro` DISABLE KEYS */;
INSERT INTO `solicitacaoseguro` VALUES (4,'2018-06-20',NULL,250,'aprovada','','',24,40);
/*!40000 ALTER TABLE `solicitacaoseguro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposinistro`
--

DROP TABLE IF EXISTS `tiposinistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposinistro` (
  `descricaoTipoSinistro` varchar(45) DEFAULT NULL,
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idTipo`),
  UNIQUE KEY `idTipo_UNIQUE` (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposinistro`
--

LOCK TABLES `tiposinistro` WRITE;
/*!40000 ALTER TABLE `tiposinistro` DISABLE KEYS */;
INSERT INTO `tiposinistro` VALUES ('Roubo',4);
/*!40000 ALTER TABLE `tiposinistro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-29 17:52:18
