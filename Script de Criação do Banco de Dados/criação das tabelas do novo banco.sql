CREATE TABLE apolice (
  idApolice int(11) NOT NULL AUTO_INCREMENT,
  idSolicitacao int,
  bandeiraCartao varchar(10) DEFAULT NULL,
  numeroApolice float DEFAULT NULL,
  premioApolice decimal(45,0) DEFAULT NULL,
  dataContratacaoApolice varchar(11) DEFAULT NULL,
  cartaoCreditoPgto bigint(45) DEFAULT NULL,
  vencimentoCartao varchar(10) DEFAULT NULL,
  codSegurancaCartao decimal DEFAULT NULL,
  nomeNoCartao varchar(45) DEFAULT NULL,
  quantidadeParcelas int,
  valorParcela float,
  PRIMARY KEY (idApolice),
  foreign key (idSolicitacao) references solitacaoseguro(idSolicitacao)
);

CREATE TABLE bem (
  idBem int NOT NULL AUTO_INCREMENT,
  descricaoBem varchar(60) DEFAULT NULL,
  valorBem float DEFAULT NULL,
  idResidenciaPertencente int(11) DEFAULT NULL,
  PRIMARY KEY (idBem),
  foreign key(idResidenciaPertencente) references residencia(idResidencia)
);

CREATE TABLE candidato (
  Nome varchar(45) DEFAULT NULL,
  Endereco varchar(45) DEFAULT NULL,
  Telefone varchar(15) DEFAULT NULL,
  Cpf varchar(14) DEFAULT NULL unique key,
  nomeLogin varchar(10) DEFAULT NULL unique key,
  senha varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL unique key,
  cep varchar(10) DEFAULT NULL,
  sexo varchar(10) DEFAULT NULL,
  idCandidato int not null auto_increment,
  ufCandidato varchar(2) DEFAULT NULL,
  cidadeCandidato varchar(30) DEFAULT NULL,
  bairroCandidato varchar(30) DEFAULT NULL,
  dataNascimento varchar(10) DEFAULT NULL,
  primary key(idCandidato)
);

CREATE TABLE corretor (
  Nome varchar(45) DEFAULT NULL,
  Endereco varchar(45) DEFAULT NULL,
  Telefone bigint(12) DEFAULT NULL,
  Cpf varchar(14) DEFAULT NULL unique key,
  nomeLogin varchar(10) DEFAULT NULL unique key,
  senha varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL unique key,
  ativoCorretor varchar(10) DEFAULT NULL,
  dataContratacao datetime DEFAULT NULL,
  idPessoa int(11) NOT NULL,
  primary key(idPessoa)
);

CREATE TABLE segurado(
 idSegurado int not null,
 foreign key(idSegurado) references candidato(idCandidato)
);

CREATE TABLE itemservico (
  descricaoRecusa varchar(145) DEFAULT NULL,
  descricaoAtendimento varchar(145) DEFAULT NULL,
  atendidaSolicitacao varchar(10) DEFAULT NULL,
  aceitaSolicitacao varchar(10) DEFAULT NULL,
  descricaoSolicitacao varchar(145) DEFAULT NULL,
  idItemServico int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (idItemServico)
);

CREATE TABLE solicitacaoServico(
idSolicitacaoServico int not null auto_increment,
idServico int not null,
idItemServico int not null,
primary key(idSolicitacaoServico),
foreign key(idServico) references servico(idServico),
foreign key(idItemServico) references itemservico(idItemServico)
);

CREATE TABLE residencia (
  idResidencia int(11) NOT NULL AUTO_INCREMENT,
  idProprietario int(11) NOT NULL,
  ufResidencia varchar(2) DEFAULT NULL,
  cidade varchar(45) DEFAULT NULL,
  bairro varchar(45) DEFAULT NULL,
  descricaoResidencia varchar(145) DEFAULT NULL,
  cepResidencia varchar(10) DEFAULT NULL,
  enderecoResidencia varchar(45) DEFAULT NULL,
  areaTotal varchar(45) DEFAULT NULL,
  areaConstruida varchar(45) DEFAULT NULL,
  anoConstrucao int(11) DEFAULT NULL,
  estruturaAmeacada int(11) DEFAULT NULL,
  localizacaoPerigosa int(11) DEFAULT NULL,
  terrenoPerigoso int(11) DEFAULT NULL,
  quantidadeComodos decimal(45,0) DEFAULT NULL,
  quantidadeBanheiros int(11) DEFAULT NULL,
  quantidadeGaragens decimal(45,0) DEFAULT NULL,
  numeroAndares decimal(45,0) DEFAULT NULL,
  PRIMARY KEY (idResidencia),
  foreign key(idProprietario) references candidato(idPessoa)
);

CREATE TABLE servico (
  descricaoServico varchar(145) DEFAULT NULL,
  idServico int(11) NOT NULL AUTO_INCREMENT,
  quantidadeServico decimal(10,0) DEFAULT NULL,
  dataDeSolicitacao date DEFAULT NULL,
  dataVisita date DEFAULT NULL,
  PRIMARY KEY (idServico)
);

CREATE TABLE sinistro (
  parecerAvaliador varchar(145) DEFAULT NULL,
  dataSinistro date DEFAULT NULL,
  descricaoSinistro varchar(145) DEFAULT NULL,
  autorizadoSinistro varchar(10) DEFAULT NULL,
  valorSinistro decimal(45,0) DEFAULT NULL,
  idSinistro int(11) NOT NULL AUTO_INCREMENT,
  idTipo int(11) DEFAULT NULL,
  idCorretor int not null,
  PRIMARY KEY (idSinistro),
  foreign key(idTipo) references tiposinistro(idTipo),
  foreign key(idCorretor) references corretor(idCorretor)
);

CREATE TABLE solicitacaoseguro (
  idSolicitacao int(11) NOT NULL AUTO_INCREMENT,
  dataSolicitacao date DEFAULT NULL,
  dataVisitaResidenciia varchar(10) DEFAULT NULL,
  valorSolicitacao float DEFAULT NULL,
  aprovada varchar(10) DEFAULT NULL,
  motivoReprovacao varchar(150) DEFAULT NULL,
  motivoAlterecao varchar(150) DEFAULT NULL,
  idResidencia int(11) DEFAULT NULL,
  idCandidato int(11) DEFAULT NULL,
  idCorretor int not null,
  PRIMARY KEY (idSolicitacao),
  foreign key (idResidencia) references residencia(idResidencia),
  foreign key(idCandidato) references candidato(idCandidato),
  foreign key(idCorretor) references corretor(idCorretor)
);

CREATE TABLE tiposinistro (
  descricaoTipoSinistro varchar(45) DEFAULT NULL,
  idTipo int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (idTipo)
);
  idcontatoUsuario INT NOT NULL,
  email VARCHAR(45) NULL,
  mensagem VARCHAR(45) NULL,
  idCandidato INT NULL,
  idCorretor INT NULL
);
  