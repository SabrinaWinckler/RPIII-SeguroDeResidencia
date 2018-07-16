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
-- Table structure for table `alteracaosolicitacaoseguro`
--

DROP TABLE IF EXISTS `alteracaosolicitacaoseguro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alteracaosolicitacaoseguro` (
  `idRegistroAlteracao` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitacao` int(11) NOT NULL,
  `idCandidato` int(11) DEFAULT NULL,
  `idCorretor` int(11) DEFAULT NULL,
  `quantidadeComodos` int(11) DEFAULT NULL,
  `quantidadeBanheiros` int(11) DEFAULT NULL,
  `quantidadeGaragens` int(11) DEFAULT NULL,
  `anoConstrucao` int(11) DEFAULT NULL,
  `areaConstruida` varchar(45) DEFAULT NULL,
  `areaTotal` varchar(45) DEFAULT NULL,
  `terrenoPerigoso` int(11) DEFAULT NULL,
  `estruturaAmeacada` int(11) DEFAULT NULL,
  `localizacaoPerigosa` int(11) DEFAULT NULL,
  `dataAlteracao` date DEFAULT NULL,
  PRIMARY KEY (`idRegistroAlteracao`),
  KEY `idSolicitacao` (`idSolicitacao`),
  KEY `idCandidato` (`idCandidato`),
  KEY `idCorretor` (`idCorretor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alteracaosolicitacaoseguro`
--

LOCK TABLES `alteracaosolicitacaoseguro` WRITE;
/*!40000 ALTER TABLE `alteracaosolicitacaoseguro` DISABLE KEYS */;
/*!40000 ALTER TABLE `alteracaosolicitacaoseguro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apolice`
--

DROP TABLE IF EXISTS `apolice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apolice` (
  `idApolice` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitacao` int(11) DEFAULT NULL,
  `bandeiraCartao` varchar(10) DEFAULT NULL,
  `numeroApolice` varchar(10) DEFAULT NULL,
  `premioApolice` float DEFAULT NULL,
  `dataContratacaoApolice` varchar(11) DEFAULT NULL,
  `cartaoCreditoPgto` varchar(19) DEFAULT NULL,
  `vencimentoCartao` varchar(10) DEFAULT NULL,
  `codSegurancaCartao` int(11) DEFAULT NULL,
  `nomeNoCartao` varchar(45) DEFAULT NULL,
  `quantidadeParcelas` int(11) DEFAULT NULL,
  `valorParcela` float DEFAULT NULL,
  `idSegurado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idApolice`),
  KEY `idSolicitacao` (`idSolicitacao`),
  KEY `idSegurado` (`idSegurado`),
  CONSTRAINT `apolice_ibfk_1` FOREIGN KEY (`idSegurado`) REFERENCES `segurado` (`idSegurado`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apolice`
--

LOCK TABLES `apolice` WRITE;
/*!40000 ALTER TABLE `apolice` DISABLE KEYS */;
INSERT INTO `apolice` VALUES (8,1,NULL,'2536',200,'2018/07/15','4545','Jan/2018',140,'Matheus',4,50,1);
/*!40000 ALTER TABLE `apolice` ENABLE KEYS */;
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
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bem`
--

LOCK TABLES `bem` WRITE;
/*!40000 ALTER TABLE `bem` DISABLE KEYS */;
INSERT INTO `bem` VALUES (1,'Sofa',450,1),(11,'Sofa',300,5),(10,'Sofa ',500,4);
/*!40000 ALTER TABLE `bem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidato` (
  `Nome` varchar(45) DEFAULT NULL,
  `Endereco` varchar(45) DEFAULT NULL,
  `Telefone` varchar(15) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `nomeLogin` varchar(10) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `idCandidato` int(11) NOT NULL AUTO_INCREMENT,
  `ufCandidato` varchar(2) DEFAULT NULL,
  `cidadeCandidato` varchar(30) DEFAULT NULL,
  `bairroCandidato` varchar(30) DEFAULT NULL,
  `dataNascimento` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idCandidato`),
  UNIQUE KEY `Cpf` (`Cpf`),
  UNIQUE KEY `nomeLogin` (`nomeLogin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidato`
--

LOCK TABLES `candidato` WRITE;
/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
INSERT INTO `candidato` VALUES ('Paulo da Silva','Joao Aurelio, 55','55996856425','123456789-12','paulo','0352635','paulosilva@gmail.com','97547580','Masculino',1,'RS','Alegrete','Centro','1970-02-10');
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corretor`
--

DROP TABLE IF EXISTS `corretor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corretor` (
  `Nome` varchar(45) DEFAULT NULL,
  `Endereco` varchar(45) DEFAULT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `nomeLogin` varchar(10) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ativoCorretor` varchar(10) DEFAULT NULL,
  `dataContratacao` date DEFAULT NULL,
  `idCorretor` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCorretor`),
  UNIQUE KEY `Cpf` (`Cpf`),
  UNIQUE KEY `nomeLogin` (`nomeLogin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corretor`
--

LOCK TABLES `corretor` WRITE;
/*!40000 ALTER TABLE `corretor` DISABLE KEYS */;
INSERT INTO `corretor` VALUES ('Matheus Montanha Paulon','Joaquim Rodrigues Paim, 410','55984564630','123456789-12','math','742617','matheusmontanhakk@gmail.com','offline','2018-07-14',1);
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
  `idItemServico` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idItemServico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemservico`
--

LOCK TABLES `itemservico` WRITE;
/*!40000 ALTER TABLE `itemservico` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemservico` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residencia`
--

LOCK TABLES `residencia` WRITE;
/*!40000 ALTER TABLE `residencia` DISABLE KEYS */;
INSERT INTO `residencia` VALUES (1,1,'RS','Alegrete','Centro','Casa Verde','97547580','Joao Aurelio, 55','200','75',2010,4,2,4,4,1,1,1),(4,1,'RS','Alegrete','Santos Dumont','Casa verde','97547380','Sergipe','100.0','75.0',2010,5,5,5,4,1,1,1),(5,1,'RS','Alegrete','Nossa Senhora da Conceição Aparecida','Casa vermelha','97547590','Joaquim Rodrigues Paim','100.0','75.0',2010,5,5,5,4,1,1,1);
/*!40000 ALTER TABLE `residencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segurado`
--

DROP TABLE IF EXISTS `segurado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segurado` (
  `idSegurado` int(11) NOT NULL,
  KEY `idSegurado` (`idSegurado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segurado`
--

LOCK TABLES `segurado` WRITE;
/*!40000 ALTER TABLE `segurado` DISABLE KEYS */;
INSERT INTO `segurado` VALUES (1);
/*!40000 ALTER TABLE `segurado` ENABLE KEYS */;
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
  PRIMARY KEY (`idServico`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
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
  `idCorretor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSinistro`),
  KEY `idTipo` (`idTipo`),
  KEY `idCorretor` (`idCorretor`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinistro`
--

LOCK TABLES `sinistro` WRITE;
/*!40000 ALTER TABLE `sinistro` DISABLE KEYS */;
INSERT INTO `sinistro` VALUES (NULL,'2018-07-16','Ventos fortes e chuvas ocorrendo o destelhamento.',NULL,0,1,5,NULL);
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
  `idCandidato` int(11) DEFAULT NULL,
  `idCorretor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitacao`),
  KEY `idResidencia` (`idResidencia`),
  KEY `idCandidato` (`idCandidato`),
  KEY `idCorretor` (`idCorretor`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacaoseguro`
--

LOCK TABLES `solicitacaoseguro` WRITE;
/*!40000 ALTER TABLE `solicitacaoseguro` DISABLE KEYS */;
INSERT INTO `solicitacaoseguro` VALUES (1,'2018-07-14','2018-07-15',500,'aprovada',NULL,NULL,1,1,1),(2,'2018-07-16',NULL,1090.3,NULL,NULL,NULL,5,1,NULL);
/*!40000 ALTER TABLE `solicitacaoseguro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitacaoservico`
--

DROP TABLE IF EXISTS `solicitacaoservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacaoservico` (
  `idSolicitacaoServico` int(11) NOT NULL AUTO_INCREMENT,
  `idServico` int(11) NOT NULL,
  `idItemServico` int(11) NOT NULL,
  `idApolice` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitacaoServico`),
  KEY `idServico` (`idServico`),
  KEY `idItemServico` (`idItemServico`),
  KEY `idApolice` (`idApolice`),
  CONSTRAINT `solicitacaoservico_ibfk_1` FOREIGN KEY (`idApolice`) REFERENCES `apolice` (`idApolice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacaoservico`
--

LOCK TABLES `solicitacaoservico` WRITE;
/*!40000 ALTER TABLE `solicitacaoservico` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitacaoservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitacaosinistro`
--

DROP TABLE IF EXISTS `solicitacaosinistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacaosinistro` (
  `idSolicitacaoSinistro` int(11) NOT NULL AUTO_INCREMENT,
  `idSinistro` int(11) DEFAULT NULL,
  `idApolice` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitacaoSinistro`),
  KEY `idSinistro` (`idSinistro`),
  KEY `idApolice` (`idApolice`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacaosinistro`
--

LOCK TABLES `solicitacaosinistro` WRITE;
/*!40000 ALTER TABLE `solicitacaosinistro` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitacaosinistro` ENABLE KEYS */;
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
  PRIMARY KEY (`idTipo`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposinistro`
--

LOCK TABLES `tiposinistro` WRITE;
/*!40000 ALTER TABLE `tiposinistro` DISABLE KEYS */;
INSERT INTO `tiposinistro` VALUES ('Incendio',1),('Enchente',2),('Destelhamento',3),('Arrombamento',4),('Furto',5);
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

-- Dump completed on 2018-07-16 17:57:42
