-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 24-Maio-2018 às 18:34
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seguroderesidencia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `analisesolicitacao`
--

DROP TABLE IF EXISTS `analisesolicitacao`;
CREATE TABLE IF NOT EXISTS `analisesolicitacao` (
  `idCorretor` int(11) NOT NULL,
  `idSolicitacao` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  UNIQUE KEY `idSolicitacao_UNIQUE` (`idSolicitacao`),
  UNIQUE KEY `idCorretor_UNIQUE` (`idCorretor`),
  KEY `fk_solicitacao` (`idSolicitacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `apolice`
--

DROP TABLE IF EXISTS `apolice`;
CREATE TABLE IF NOT EXISTS `apolice` (
  `idApolice` int(11) NOT NULL AUTO_INCREMENT,
  `bandeiraCartao` char(10) DEFAULT NULL,
  `numeroApolice` float DEFAULT NULL,
  `premioApolice` decimal(45,0) DEFAULT NULL,
  `dataContratacaoApolice` datetime DEFAULT NULL,
  `cartaoCreditoPgto` bigint(45) DEFAULT NULL,
  `vencimentoCartao` datetime DEFAULT NULL,
  `codSegurancaCartao` decimal(10,0) DEFAULT NULL,
  `nomeNoCartao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idApolice`),
  UNIQUE KEY `idApolice_UNIQUE` (`idApolice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `apoliceparcela`
--

DROP TABLE IF EXISTS `apoliceparcela`;
CREATE TABLE IF NOT EXISTS `apoliceparcela` (
  `idApolice` int(11) DEFAULT NULL,
  `idParcela` int(11) DEFAULT NULL,
  KEY `fk_parecla_idx` (`idParcela`),
  KEY `fk_apolice_idx` (`idApolice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `bem`
--

DROP TABLE IF EXISTS `bem`;
CREATE TABLE IF NOT EXISTS `bem` (
  `idBem` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoBem` varchar(60) DEFAULT NULL,
  `valorBem` float DEFAULT NULL,
  `idResidenciaPertencente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBem`),
  KEY `idResidenciaPertencente` (`idResidenciaPertencente`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `bem`
--

INSERT INTO `bem` (`idBem`, `descricaoBem`, `valorBem`, `idResidenciaPertencente`) VALUES
(41, 'Sofa', 540, 24);

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

DROP TABLE IF EXISTS `candidato`;
CREATE TABLE IF NOT EXISTS `candidato` (
  `cep` varchar(10) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `idPessoa` int(11) NOT NULL,
  `ufCandidato` varchar(2) DEFAULT NULL,
  `cidadeCandidato` varchar(30) DEFAULT NULL,
  `bairroCandidato` varchar(30) DEFAULT NULL,
  `dataNascimento` varchar(10) DEFAULT NULL,
  UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `candidato`
--

INSERT INTO `candidato` (`cep`, `sexo`, `idPessoa`, `ufCandidato`, `cidadeCandidato`, `bairroCandidato`, `dataNascimento`) VALUES
('97547590', 'Masculino', 40, 'RS', 'Alegrete', 'Centro', '06/09/1998'),
('97547590', NULL, 41, 'RS', 'Alegrete', 'NS conceição aparecida', '06Jul1997');

-- --------------------------------------------------------

--
-- Estrutura da tabela `corretor`
--

DROP TABLE IF EXISTS `corretor`;
CREATE TABLE IF NOT EXISTS `corretor` (
  `ativoCorretor` varchar(10) DEFAULT NULL,
  `dataContratacao` datetime DEFAULT NULL,
  `idPessoa` int(11) NOT NULL,
  KEY `fk_corretorPessoa_idx` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemservico`
--

DROP TABLE IF EXISTS `itemservico`;
CREATE TABLE IF NOT EXISTS `itemservico` (
  `descricaoRecusa` varchar(145) DEFAULT NULL,
  `descricaoAtendimento` varchar(145) DEFAULT NULL,
  `dataAtendimento` datetime DEFAULT NULL,
  `atendidaSolicitacao` varchar(10) DEFAULT NULL,
  `aceitaSolicitacao` varchar(10) DEFAULT NULL,
  `descricaoSolicitacao` varchar(145) DEFAULT NULL,
  `dataSolicitacao` datetime DEFAULT NULL,
  `idItemServiço` int(11) NOT NULL AUTO_INCREMENT,
  `idServico` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItemServiço`),
  UNIQUE KEY `idItemServiço_UNIQUE` (`idItemServiço`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcelaapolice`
--

DROP TABLE IF EXISTS `parcelaapolice`;
CREATE TABLE IF NOT EXISTS `parcelaapolice` (
  `valorParcela` decimal(45,0) DEFAULT NULL,
  `idParcela` int(11) NOT NULL AUTO_INCREMENT,
  `dataPagntParcela` datetime DEFAULT NULL,
  PRIMARY KEY (`idParcela`),
  UNIQUE KEY `idParcela_UNIQUE` (`idParcela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `Nome` varchar(45) DEFAULT NULL,
  `Endereco` varchar(45) DEFAULT NULL,
  `Telefone` bigint(12) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `nomeLogin` varchar(10) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPessoa`),
  UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`Nome`, `Endereco`, `Telefone`, `Cpf`, `nomeLogin`, `senha`, `email`, `idPessoa`) VALUES
('Matheus Montanha', 'Joaquim Rodrigues Paim, 410', 34565236, '229', 'jojoPaulin', '0352635', 'estranho@gmail.com', 40),
('Matheus Montanha Paulon', 'Joaquim Rodrigues Paim, 410', 984564630, '3457088063', 'mathmont', '742617', 'matheusmontanha@gmail.com', 41);

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatasinistro`
--

DROP TABLE IF EXISTS `relatasinistro`;
CREATE TABLE IF NOT EXISTS `relatasinistro` (
  `idSinistro` int(11) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  KEY `idSinistro` (`idSinistro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `residencia`
--

DROP TABLE IF EXISTS `residencia`;
CREATE TABLE IF NOT EXISTS `residencia` (
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

--
-- Extraindo dados da tabela `residencia`
--

INSERT INTO `residencia` (`idResidencia`, `idProprietario`, `ufResidencia`, `cidade`, `bairro`, `descricaoResidencia`, `cepResidencia`, `enderecoResidencia`, `areaTotal`, `areaConstruida`, `anoConstrucao`, `estruturaAmeacada`, `localizacaoPerigosa`, `terrenoPerigoso`, `quantidadeComodos`, `quantidadeBanheiros`, `quantidadeGaragens`, `numeroAndares`) VALUES
(24, 40, 'RS', 'Alegrete', 'Centro', 'Casa verde', '97547590', 'Joaquim Rodrigues Paim, 410', '5285.0', '510.0', 2011, 5, 4, 5, '7', 1, '1', '3');

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurado`
--

DROP TABLE IF EXISTS `segurado`;
CREATE TABLE IF NOT EXISTS `segurado` (
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  KEY `idPessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servico`
--

DROP TABLE IF EXISTS `servico`;
CREATE TABLE IF NOT EXISTS `servico` (
  `descricaoServico` varchar(145) DEFAULT NULL,
  `idServico` int(11) NOT NULL AUTO_INCREMENT,
  `quantidadeServico` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idServico`),
  UNIQUE KEY `idServico_UNIQUE` (`idServico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sinistro`
--

DROP TABLE IF EXISTS `sinistro`;
CREATE TABLE IF NOT EXISTS `sinistro` (
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

--
-- Extraindo dados da tabela `sinistro`
--

INSERT INTO `sinistro` (`parecerAvaliador`, `dataSinistro`, `descricaoSinistro`, `autorizadoSinistro`, `valorSinistro`, `idSinistro`, `idTipo`) VALUES
('Sinistro muito louco', '2018-05-23', 'Dois homens com mascara.', 'Autorizado', '250', 4, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitacaoseguro`
--

DROP TABLE IF EXISTS `solicitacaoseguro`;
CREATE TABLE IF NOT EXISTS `solicitacaoseguro` (
  `idSolicitacao` int(11) NOT NULL AUTO_INCREMENT,
  `dataSolicitacao` date DEFAULT NULL,
  `dataVisitaResidenciia` date DEFAULT NULL,
  `valorSolicitacao` float DEFAULT NULL,
  `aprovada` varchar(10) DEFAULT NULL,
  `motivoReprovacao` varchar(150) DEFAULT NULL,
  `motivoAlterecao` varchar(150) DEFAULT NULL,
  `idResidencia` int(11) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitacao`),
  KEY `idResidencia` (`idResidencia`),
  KEY `idPessoa` (`idPessoa`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `solicitacaoseguro`
--

INSERT INTO `solicitacaoseguro` (`idSolicitacao`, `dataSolicitacao`, `dataVisitaResidenciia`, `valorSolicitacao`, `aprovada`, `motivoReprovacao`, `motivoAlterecao`, `idResidencia`, `idPessoa`) VALUES
(4, '2018-06-20', '2018-06-20', 250, 'aprovada', '', 'Sem alterações', 24, 40);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tiposinistro`
--

DROP TABLE IF EXISTS `tiposinistro`;
CREATE TABLE IF NOT EXISTS `tiposinistro` (
  `descricaoTipoSinistro` varchar(45) DEFAULT NULL,
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idTipo`),
  UNIQUE KEY `idTipo_UNIQUE` (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tiposinistro`
--

INSERT INTO `tiposinistro` (`descricaoTipoSinistro`, `idTipo`) VALUES
('Roubo', 4);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `analisesolicitacao`
--
ALTER TABLE `analisesolicitacao`
  ADD CONSTRAINT `fk_corretor` FOREIGN KEY (`idCorretor`) REFERENCES `corretor` (`idPessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_solicitacao` FOREIGN KEY (`idSolicitacao`) REFERENCES `solicitacao` (`idSolicitacao`);

--
-- Limitadores para a tabela `apoliceparcela`
--
ALTER TABLE `apoliceparcela`
  ADD CONSTRAINT `fk_apolice` FOREIGN KEY (`idApolice`) REFERENCES `apolice` (`idApolice`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_parecla` FOREIGN KEY (`idParcela`) REFERENCES `parcelaapolice` (`idParcela`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `corretor`
--
ALTER TABLE `corretor`
  ADD CONSTRAINT `fk_corretorPessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `relatasinistro`
--
ALTER TABLE `relatasinistro`
  ADD CONSTRAINT FOREIGN KEY (`idSinistro`) REFERENCES `sinistro` (`idSinistro`);

--
-- Limitadores para a tabela `segurado`
--
ALTER TABLE `segurado`
  ADD CONSTRAINT `fk_candidato` FOREIGN KEY (`idPessoa`) REFERENCES `candidato` (`idPessoa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `sinistro`
--
ALTER TABLE `sinistro`
  ADD CONSTRAINT `fk_tipoSinistro` FOREIGN KEY (`idTipo`) REFERENCES `tiposinistro` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
