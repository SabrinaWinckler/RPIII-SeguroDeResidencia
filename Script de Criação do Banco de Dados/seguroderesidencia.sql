-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Maio-2018 às 00:53
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `analisesolicitacao` (
  `idCorretor` int(11) NOT NULL,
  `idSolicitacao` int(11) NOT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `apolice`
--

CREATE TABLE `apolice` (
  `idApolice` int(11) NOT NULL,
  `bandeiraCartao` char(10) DEFAULT NULL,
  `numeroApolice` float DEFAULT NULL,
  `premioApolice` decimal(45,0) DEFAULT NULL,
  `dataContratacaoApolice` datetime DEFAULT NULL,
  `cartaoCreditoPgto` bigint(45) DEFAULT NULL,
  `vencimentoCartao` datetime DEFAULT NULL,
  `codSegurancaCartao` decimal(10,0) DEFAULT NULL,
  `nomeNoCartao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `apoliceparcela`
--

CREATE TABLE `apoliceparcela` (
  `idApolice` int(11) DEFAULT NULL,
  `idParcela` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliasinistro`
--

CREATE TABLE `avaliasinistro` (
  `idSinistro` int(11) DEFAULT NULL,
  `dataAvalicao` date DEFAULT NULL,
  `observacaoSinistro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `corretor`
--

CREATE TABLE `corretor` (
  `ativoCorretor` varchar(10) DEFAULT NULL,
  `dataContratacao` datetime DEFAULT NULL,
  `idPessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemservico`
--

CREATE TABLE `itemservico` (
  `descricaoRecusa` varchar(145) DEFAULT NULL,
  `descricaoAtendimento` varchar(145) DEFAULT NULL,
  `dataAtendimento` datetime DEFAULT NULL,
  `atendidaSolicitacao` varchar(10) DEFAULT NULL,
  `aceitaSolicitacao` varchar(10) DEFAULT NULL,
  `descricaoSolicitacao` varchar(145) DEFAULT NULL,
  `dataSolicitacao` datetime DEFAULT NULL,
  `idItemServiço` int(11) NOT NULL,
  `idServico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcelaapolice`
--

CREATE TABLE `parcelaapolice` (
  `valorParcela` decimal(45,0) DEFAULT NULL,
  `idParcela` int(11) NOT NULL,
  `dataPagntParcela` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatasinistro`
--

CREATE TABLE `relatasinistro` (
  `idSinistro` int(11) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `residencia`
--

CREATE TABLE `residencia` (
  `idResidencia` int(11) NOT NULL,
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
  `numeroAndares` decimal(45,0) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `residencia`
--

INSERT INTO `residencia` (`idResidencia`, `ufResidencia`, `cidade`, `bairro`, `descricaoResidencia`, `cepResidencia`, `enderecoResidencia`, `areaTotal`, `areaConstruida`, `anoConstrucao`, `estruturaAmeacada`, `localizacaoPerigosa`, `terrenoPerigoso`, `quantidadeComodos`, `quantidadeBanheiros`, `quantidadeGaragens`, `numeroAndares`) VALUES
(1, 'rs', NULL, NULL, 'kaoihagybajk', '457841', 'huih', '60.0', '56.0', 2000, 4, 6, 6, '5', 2, '1', '1'),
(2, 'RS', NULL, NULL, 'njcknkjbdkds', '565656', 'jikhiii', '56.0', '56.0', 2000, 4, 6, 3, '5', 4, '4', '1'),
(3, 'ti', NULL, NULL, 'gcgfccghj', '44684', 'hho', '56.0', '45.0', 2000, 5, 5, 5, '5', 4, '5', '4'),
(4, 'rs', NULL, NULL, 'nklbvctiv', '4564564', 'vjhvjh', '89.0', '89.0', 2000, 5, 7, 5, '4', 4, '4', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servico`
--

CREATE TABLE `servico` (
  `descricaoServico` varchar(145) DEFAULT NULL,
  `idServico` int(11) NOT NULL,
  `quantidadeServico` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sinistro`
--

CREATE TABLE `sinistro` (
  `parecerAvaliador` varchar(145) DEFAULT NULL,
  `dataSinistro` datetime DEFAULT NULL,
  `descricaoSinistro` varchar(145) DEFAULT NULL,
  `autorizadoSinistro` varchar(10) DEFAULT NULL,
  `valorSinistro` decimal(45,0) DEFAULT NULL,
  `idSinistro` int(11) NOT NULL,
  `idTipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitacaocandidato`
--

CREATE TABLE `solicitacaocandidato` (
  `idSolicitacao` int(11) NOT NULL,
  `dataSolicitacao` datetime DEFAULT NULL,
  `dataVisitaResidenciia` datetime DEFAULT NULL,
  `valorSolicitacao` float DEFAULT NULL,
  `aprovada` varchar(10) DEFAULT NULL,
  `motivoReprovacao` varchar(150) DEFAULT NULL,
  `idResidencia` int(11) NOT NULL,
  `idPessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tiposinistro`
--

CREATE TABLE `tiposinistro` (
  `descricaoTipoSinistro` varchar(45) DEFAULT NULL,
  `idTipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `analisesolicitacao`
--
ALTER TABLE `analisesolicitacao`
  ADD UNIQUE KEY `idSolicitacao_UNIQUE` (`idSolicitacao`),
  ADD UNIQUE KEY `idCorretor_UNIQUE` (`idCorretor`);

--
-- Indexes for table `apolice`
--
ALTER TABLE `apolice`
  ADD PRIMARY KEY (`idApolice`),
  ADD UNIQUE KEY `idApolice_UNIQUE` (`idApolice`);

--
-- Indexes for table `apoliceparcela`
--
ALTER TABLE `apoliceparcela`
  ADD KEY `fk_parecla_idx` (`idParcela`),
  ADD KEY `fk_apolice_idx` (`idApolice`);

--
-- Indexes for table `avaliasinistro`
--
ALTER TABLE `avaliasinistro`
  ADD KEY `fk_avaliacaoSinistro` (`idSinistro`);

--
-- Indexes for table `corretor`
--
ALTER TABLE `corretor`
  ADD KEY `fk_corretorPessoa_idx` (`idPessoa`);

--
-- Indexes for table `itemservico`
--
ALTER TABLE `itemservico`
  ADD PRIMARY KEY (`idItemServiço`),
  ADD UNIQUE KEY `idItemServiço_UNIQUE` (`idItemServiço`);

--
-- Indexes for table `parcelaapolice`
--
ALTER TABLE `parcelaapolice`
  ADD PRIMARY KEY (`idParcela`),
  ADD UNIQUE KEY `idParcela_UNIQUE` (`idParcela`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idpessoa`);

--
-- Indexes for table `relatasinistro`
--
ALTER TABLE `relatasinistro`
  ADD KEY `idSinistro` (`idSinistro`);

--
-- Indexes for table `residencia`
--
ALTER TABLE `residencia`
  ADD PRIMARY KEY (`idResidencia`),
  ADD UNIQUE KEY `idResidencia_UNIQUE` (`idResidencia`);

--
-- Indexes for table `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`idServico`),
  ADD UNIQUE KEY `idServico_UNIQUE` (`idServico`);

--
-- Indexes for table `sinistro`
--
ALTER TABLE `sinistro`
  ADD PRIMARY KEY (`idSinistro`),
  ADD UNIQUE KEY `idSinistro_UNIQUE` (`idSinistro`),
  ADD KEY `fk_tipoSinistro` (`idTipo`);

--
-- Indexes for table `solicitacaocandidato`
--
ALTER TABLE `solicitacaocandidato`
  ADD PRIMARY KEY (`idSolicitacao`),
  ADD KEY `fk_solicitacaoResidencia` (`idResidencia`),
  ADD KEY `fk_solicitacaoPessoa_idx` (`idPessoa`);

--
-- Indexes for table `tiposinistro`
--
ALTER TABLE `tiposinistro`
  ADD PRIMARY KEY (`idTipo`),
  ADD UNIQUE KEY `idTipo_UNIQUE` (`idTipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apolice`
--
ALTER TABLE `apolice`
  MODIFY `idApolice` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `itemservico`
--
ALTER TABLE `itemservico`
  MODIFY `idItemServiço` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `parcelaapolice`
--
ALTER TABLE `parcelaapolice`
  MODIFY `idParcela` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `residencia`
--
ALTER TABLE `residencia`
  MODIFY `idResidencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `servico`
--
ALTER TABLE `servico`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sinistro`
--
ALTER TABLE `sinistro`
  MODIFY `idSinistro` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `solicitacaocandidato`
--
ALTER TABLE `solicitacaocandidato`
  MODIFY `idSolicitacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tiposinistro`
--
ALTER TABLE `tiposinistro`
  MODIFY `idTipo` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `apoliceparcela`
--
ALTER TABLE `apoliceparcela`
  ADD CONSTRAINT `fk_apolice` FOREIGN KEY (`idApolice`) REFERENCES `apolice` (`idApolice`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_parecla` FOREIGN KEY (`idParcela`) REFERENCES `parcelaapolice` (`idParcela`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `avaliasinistro`
--
ALTER TABLE `avaliasinistro`
  ADD CONSTRAINT `fk_avaliacaoSinistro` FOREIGN KEY (`idSinistro`) REFERENCES `sinistro` (`idSinistro`) ON DELETE CASCADE ON UPDATE CASCADE;

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
-- Limitadores para a tabela `sinistro`
--
ALTER TABLE `sinistro`
  ADD CONSTRAINT `fk_tipoSinistro` FOREIGN KEY (`idTipo`) REFERENCES `tiposinistro` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `solicitacaocandidato`
--
ALTER TABLE `solicitacaocandidato`
  ADD CONSTRAINT `fk_solicitacaoPessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_solicitacaoResidencia` FOREIGN KEY (`idResidencia`) REFERENCES `residencia` (`idResidencia`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
