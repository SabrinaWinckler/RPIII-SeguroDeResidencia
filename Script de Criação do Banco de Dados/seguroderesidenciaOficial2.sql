-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Jul-2018 às 20:37
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
-- Estrutura da tabela `alteracaosolicitacaoseguro`
--

CREATE TABLE `alteracaosolicitacaoseguro` (
  `idRegistroAlteracao` int(11) NOT NULL,
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
  `dataAlteracao` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
  `idSegurado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `apolice`
--

INSERT INTO `apolice` (`idApolice`, `idSolicitacao`, `bandeiraCartao`, `numeroApolice`, `premioApolice`, `dataContratacaoApolice`, `cartaoCreditoPgto`, `vencimentoCartao`, `codSegurancaCartao`, `nomeNoCartao`, `quantidadeParcelas`, `valorParcela`, `idSegurado`) VALUES
(8, 1, NULL, '2536', 200, '2018/07/15', '4545', 'Jan/2018', 140, 'Matheus', 4, 50, 1);

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
  `observacaoSinistro` varchar(45) DEFAULT NULL,
  `idCorretor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `bem`
--

CREATE TABLE `bem` (
  `idBem` int(11) NOT NULL,
  `descricaoBem` varchar(60) DEFAULT NULL,
  `valorBem` float DEFAULT NULL,
  `idResidenciaPertencente` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

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
  `idCandidato` int(11) NOT NULL,
  `ufCandidato` varchar(2) DEFAULT NULL,
  `cidadeCandidato` varchar(30) DEFAULT NULL,
  `bairroCandidato` varchar(30) DEFAULT NULL,
  `dataNascimento` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `candidato`
--

INSERT INTO `candidato` (`Nome`, `Endereco`, `Telefone`, `Cpf`, `nomeLogin`, `senha`, `email`, `cep`, `sexo`, `idCandidato`, `ufCandidato`, `cidadeCandidato`, `bairroCandidato`, `dataNascimento`) VALUES
('Paulo da Silva', 'Joao Aurelio, 55', '55996856425', '123456789-12', 'paulo', '0352635', 'paulosilva@gmail.com', '97547580', 'Masculino', 1, 'RS', 'Alegrete', 'Centro', '1970-02-10');

-- --------------------------------------------------------

--
-- Estrutura da tabela `corretor`
--

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
  `idCorretor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `corretor`
--

INSERT INTO `corretor` (`Nome`, `Endereco`, `Telefone`, `Cpf`, `nomeLogin`, `senha`, `email`, `ativoCorretor`, `dataContratacao`, `idCorretor`) VALUES
('Matheus Montanha Paulon', 'Joaquim Rodrigues Paim, 410', '55984564630', '123456789-12', 'math', '742617', 'matheusmontanhakk@gmail.com', 'offline', '2018-07-14', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemservico`
--

CREATE TABLE `itemservico` (
  `descricaoRecusa` varchar(145) DEFAULT NULL,
  `descricaoAtendimento` varchar(145) DEFAULT NULL,
  `atendidaSolicitacao` varchar(10) DEFAULT NULL,
  `aceitaSolicitacao` varchar(10) DEFAULT NULL,
  `descricaoSolicitacao` varchar(145) DEFAULT NULL,
  `idItemServico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcelaapolice`
--

CREATE TABLE `parcelaapolice` (
  `valorParcela` decimal(45,0) DEFAULT NULL,
  `idParcela` int(11) NOT NULL,
  `dataPagntParcela` datetime DEFAULT NULL,
  `idApolice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `Nome` varchar(45) DEFAULT NULL,
  `Endereco` varchar(45) DEFAULT NULL,
  `Telefone` bigint(12) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `nomeLogin` varchar(10) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`Nome`, `Endereco`, `Telefone`, `Cpf`, `nomeLogin`, `senha`, `email`, `idPessoa`) VALUES
('Matheus Montanha', 'Joaquim Rodrigues Paim, 410', 34565236, '229', 'jojoPaulin', '0352635', 'estranho@gmail.com', 40),
('Matheus Montanha Paulon', 'Joaquim Rodrigues Paim, 410', 984564630, '03457088064', 'mathmont', '742617', 'matheusmontanha@gmail.com', 41),
('Joao Paulo Silva', 'Joaquim Rodrigues Paim, 410', 55984564630, '03457088063', 'joaoPaulo', '1234', 'JoaoSilva@hotmail.com', 42),
('Hanna Rebeca Ismail', 'Rua Inácio Lecuana 388', 11944442010, '42459085800', 'hanna', '944442010', 'hanna.rebeka64@gmail.com', 43);

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatasinistro`
--

CREATE TABLE `relatasinistro` (
  `idSinistro` int(11) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `relatasinistro`
--

INSERT INTO `relatasinistro` (`idSinistro`, `idPessoa`) VALUES
(4, 41);

-- --------------------------------------------------------

--
-- Estrutura da tabela `residencia`
--

CREATE TABLE `residencia` (
  `idResidencia` int(11) NOT NULL,
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
  `numeroAndares` decimal(45,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `residencia`
--

INSERT INTO `residencia` (`idResidencia`, `idProprietario`, `ufResidencia`, `cidade`, `bairro`, `descricaoResidencia`, `cepResidencia`, `enderecoResidencia`, `areaTotal`, `areaConstruida`, `anoConstrucao`, `estruturaAmeacada`, `localizacaoPerigosa`, `terrenoPerigoso`, `quantidadeComodos`, `quantidadeBanheiros`, `quantidadeGaragens`, `numeroAndares`) VALUES
(1, 1, 'RS', 'Alegrete', 'Centro', 'Casa Verde', '97547580', 'Joao Aurelio, 55', '200', '75', 2010, 4, 2, 4, '4', 1, '1', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `segurado`
--

CREATE TABLE `segurado` (
  `idSegurado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `segurado`
--

INSERT INTO `segurado` (`idSegurado`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `seguradosolicitaservico`
--

CREATE TABLE `seguradosolicitaservico` (
  `idSegurado` int(11) DEFAULT NULL,
  `idServico` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servico`
--

CREATE TABLE `servico` (
  `descricaoServico` varchar(145) DEFAULT NULL,
  `idServico` int(11) NOT NULL,
  `quantidadeServico` decimal(10,0) DEFAULT NULL,
  `dataDeSolicitacao` date DEFAULT NULL,
  `dataVisita` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sinistro`
--

CREATE TABLE `sinistro` (
  `parecerAvaliador` varchar(145) DEFAULT NULL,
  `dataSinistro` date DEFAULT NULL,
  `descricaoSinistro` varchar(145) DEFAULT NULL,
  `autorizadoSinistro` varchar(10) DEFAULT NULL,
  `valorSinistro` decimal(45,0) DEFAULT NULL,
  `idSinistro` int(11) NOT NULL,
  `idTipo` int(11) DEFAULT NULL,
  `idCorretor` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `sinistro`
--

INSERT INTO `sinistro` (`parecerAvaliador`, `dataSinistro`, `descricaoSinistro`, `autorizadoSinistro`, `valorSinistro`, `idSinistro`, `idTipo`, `idCorretor`) VALUES
(NULL, '2018-07-15', 'AAAAAAH', NULL, '0', 1, 4, NULL),
(NULL, '2018-07-15', 'Blablablabla', NULL, '0', 2, 4, NULL);

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
-- Estrutura da tabela `solicitacaoseguro`
--

CREATE TABLE `solicitacaoseguro` (
  `idSolicitacao` int(11) NOT NULL,
  `dataSolicitacao` date DEFAULT NULL,
  `dataVisitaResidenciia` varchar(10) DEFAULT NULL,
  `valorSolicitacao` float DEFAULT NULL,
  `aprovada` varchar(10) DEFAULT NULL,
  `motivoReprovacao` varchar(150) DEFAULT NULL,
  `motivoAlterecao` varchar(150) DEFAULT NULL,
  `idResidencia` int(11) DEFAULT NULL,
  `idCandidato` int(11) DEFAULT NULL,
  `idCorretor` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `solicitacaoseguro`
--

INSERT INTO `solicitacaoseguro` (`idSolicitacao`, `dataSolicitacao`, `dataVisitaResidenciia`, `valorSolicitacao`, `aprovada`, `motivoReprovacao`, `motivoAlterecao`, `idResidencia`, `idCandidato`, `idCorretor`) VALUES
(1, '2018-07-14', '2018-07-15', 500, 'aprovada', NULL, NULL, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitacaoservico`
--

CREATE TABLE `solicitacaoservico` (
  `idSolicitacaoServico` int(11) NOT NULL,
  `idServico` int(11) NOT NULL,
  `idItemServico` int(11) NOT NULL,
  `idApolice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitacaosinistro`
--

CREATE TABLE `solicitacaosinistro` (
  `idSolicitacaoSinistro` int(11) NOT NULL,
  `idSegurado` int(11) DEFAULT NULL,
  `idSinistro` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tiposinistro`
--

CREATE TABLE `tiposinistro` (
  `descricaoTipoSinistro` varchar(45) DEFAULT NULL,
  `idTipo` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tiposinistro`
--

INSERT INTO `tiposinistro` (`descricaoTipoSinistro`, `idTipo`) VALUES
('Incêndio', 1),
('Roubo', 2),
('Explosão', 3),
('Outro', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alteracaosolicitacaoseguro`
--
ALTER TABLE `alteracaosolicitacaoseguro`
  ADD PRIMARY KEY (`idRegistroAlteracao`),
  ADD KEY `idSolicitacao` (`idSolicitacao`),
  ADD KEY `idCandidato` (`idCandidato`),
  ADD KEY `idCorretor` (`idCorretor`);

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
  ADD KEY `idSolicitacao` (`idSolicitacao`),
  ADD KEY `idSegurado` (`idSegurado`);

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
  ADD KEY `fk_avaliacaoSinistro` (`idSinistro`),
  ADD KEY `fk_corretot_idx` (`idCorretor`);

--
-- Indexes for table `bem`
--
ALTER TABLE `bem`
  ADD PRIMARY KEY (`idBem`),
  ADD KEY `idResidenciaPertencente` (`idResidenciaPertencente`);

--
-- Indexes for table `candidato`
--
ALTER TABLE `candidato`
  ADD PRIMARY KEY (`idCandidato`),
  ADD UNIQUE KEY `Cpf` (`Cpf`),
  ADD UNIQUE KEY `nomeLogin` (`nomeLogin`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `corretor`
--
ALTER TABLE `corretor`
  ADD PRIMARY KEY (`idCorretor`),
  ADD UNIQUE KEY `Cpf` (`Cpf`),
  ADD UNIQUE KEY `nomeLogin` (`nomeLogin`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `itemservico`
--
ALTER TABLE `itemservico`
  ADD PRIMARY KEY (`idItemServico`);

--
-- Indexes for table `parcelaapolice`
--
ALTER TABLE `parcelaapolice`
  ADD PRIMARY KEY (`idParcela`),
  ADD UNIQUE KEY `idParcela_UNIQUE` (`idParcela`),
  ADD KEY `apolice_idx` (`idApolice`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idPessoa`),
  ADD UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`),
  ADD UNIQUE KEY `cpf_pk` (`Cpf`),
  ADD UNIQUE KEY `email_unique` (`email`),
  ADD UNIQUE KEY `nomeLogin_unique` (`nomeLogin`);

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
  ADD KEY `idProprietario` (`idProprietario`);

--
-- Indexes for table `segurado`
--
ALTER TABLE `segurado`
  ADD KEY `idSegurado` (`idSegurado`);

--
-- Indexes for table `seguradosolicitaservico`
--
ALTER TABLE `seguradosolicitaservico`
  ADD KEY `idSegurado` (`idSegurado`),
  ADD KEY `idServico` (`idServico`);

--
-- Indexes for table `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`idServico`);

--
-- Indexes for table `sinistro`
--
ALTER TABLE `sinistro`
  ADD PRIMARY KEY (`idSinistro`),
  ADD KEY `idTipo` (`idTipo`),
  ADD KEY `idCorretor` (`idCorretor`);

--
-- Indexes for table `solicitacaocandidato`
--
ALTER TABLE `solicitacaocandidato`
  ADD PRIMARY KEY (`idSolicitacao`),
  ADD KEY `fk_solicitacaoResidencia` (`idResidencia`),
  ADD KEY `fk_solicitacaoPessoa_idx` (`idPessoa`);

--
-- Indexes for table `solicitacaoseguro`
--
ALTER TABLE `solicitacaoseguro`
  ADD PRIMARY KEY (`idSolicitacao`),
  ADD KEY `idResidencia` (`idResidencia`),
  ADD KEY `idCandidato` (`idCandidato`),
  ADD KEY `idCorretor` (`idCorretor`);

--
-- Indexes for table `solicitacaoservico`
--
ALTER TABLE `solicitacaoservico`
  ADD PRIMARY KEY (`idSolicitacaoServico`),
  ADD KEY `idServico` (`idServico`),
  ADD KEY `idItemServico` (`idItemServico`),
  ADD KEY `idApolice` (`idApolice`);

--
-- Indexes for table `solicitacaosinistro`
--
ALTER TABLE `solicitacaosinistro`
  ADD PRIMARY KEY (`idSolicitacaoSinistro`),
  ADD KEY `idSegurado` (`idSegurado`),
  ADD KEY `idSinistro` (`idSinistro`);

--
-- Indexes for table `tiposinistro`
--
ALTER TABLE `tiposinistro`
  ADD PRIMARY KEY (`idTipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alteracaosolicitacaoseguro`
--
ALTER TABLE `alteracaosolicitacaoseguro`
  MODIFY `idRegistroAlteracao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `apolice`
--
ALTER TABLE `apolice`
  MODIFY `idApolice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `bem`
--
ALTER TABLE `bem`
  MODIFY `idBem` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `candidato`
--
ALTER TABLE `candidato`
  MODIFY `idCandidato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `corretor`
--
ALTER TABLE `corretor`
  MODIFY `idCorretor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `itemservico`
--
ALTER TABLE `itemservico`
  MODIFY `idItemServico` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `parcelaapolice`
--
ALTER TABLE `parcelaapolice`
  MODIFY `idParcela` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idPessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `residencia`
--
ALTER TABLE `residencia`
  MODIFY `idResidencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `servico`
--
ALTER TABLE `servico`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sinistro`
--
ALTER TABLE `sinistro`
  MODIFY `idSinistro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `solicitacaocandidato`
--
ALTER TABLE `solicitacaocandidato`
  MODIFY `idSolicitacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `solicitacaoseguro`
--
ALTER TABLE `solicitacaoseguro`
  MODIFY `idSolicitacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `solicitacaoservico`
--
ALTER TABLE `solicitacaoservico`
  MODIFY `idSolicitacaoServico` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `solicitacaosinistro`
--
ALTER TABLE `solicitacaosinistro`
  MODIFY `idSolicitacaoSinistro` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tiposinistro`
--
ALTER TABLE `tiposinistro`
  MODIFY `idTipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `apolice`
--
ALTER TABLE `apolice`
  ADD CONSTRAINT `apolice_ibfk_1` FOREIGN KEY (`idSegurado`) REFERENCES `segurado` (`idSegurado`);

--
-- Limitadores para a tabela `avaliasinistro`
--
ALTER TABLE `avaliasinistro`
  ADD CONSTRAINT `fk_avaliacaoSinistro` FOREIGN KEY (`idSinistro`) REFERENCES `sinistro` (`idSinistro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `solicitacaocandidato`
--
ALTER TABLE `solicitacaocandidato`
  ADD CONSTRAINT `fk_solicitacaoResidencia` FOREIGN KEY (`idResidencia`) REFERENCES `residencia` (`idResidencia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `solicitacaoservico`
--
ALTER TABLE `solicitacaoservico`
  ADD CONSTRAINT `solicitacaoservico_ibfk_1` FOREIGN KEY (`idApolice`) REFERENCES `apolice` (`idApolice`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
