CREATE TABLE analiseSolicitacao (
idResidencia INTEGER,
idSolicitacao INTEGER,/*falha: chave estrangeira*//*falha: chave estrangeira*/
FOREIGN KEY(idSolicitacao) REFERENCES Solicitacao (idSolicitacao)
);

CREATE TABLE corretor (
ativoCorretor VARCHAR(10),
dataContratacao DATETIME,
idPessoa INTEGER
);

CREATE TABLE avaliaSinistro (
idSinistro INTEGER
);

CREATE TABLE parcelaApolice (
valorParcela DECIMAL(45),
idParcela INTEGER PRIMARY KEY,
dataPagntParcela DATETIME
);

CREATE TABLE apoliceParcela (
idApolice INTEGER,
idParcela INTEGER,
FOREIGN KEY(idParcela) REFERENCES parcelaApólice (idParcela)
);

CREATE TABLE Apolice (
idApolice INTEGER PRIMARY KEY,
bandeiraCartao CHAR(10),
numeroApolice NUMERIC(10),
premioApolice NUMERIC(45),
dataContratacaoApolice DATETIME,
cartaoCreditoPgto BIGINT(45),
vencimentoCartao DATETIME,
codSegurancaCartao NUMERIC(10),
nomeNoCartao VARCHAR(45)
);

CREATE TABLE NivelPericulosidade (
terrenoPerigoso VARCHAR(10),
estruturaAmeacada VARCHAR(10),
idNivelP INTEGER PRIMARY KEY,
localizaçãoPerigosa VARCHAR(10)
);

CREATE TABLE Servico (
descricaoServico VARCHAR(145),
idServico INTEGER PRIMARY KEY,
quantidadeServico NUMERIC(10)
);

CREATE TABLE itemServico (
descricaoRecusa VARCHAR(145),
descricaoAtendimento VARCHAR(145),
dataAtendimento DATETIME,
atendidaSolicitacao VARCHAR(10),
aceitaSolicitacao VARCHAR(10),
descricaoSolicitacao VARCHAR(145),
dataSolicitacao DATETIME,
idItemServiço INTEGER PRIMARY KEY,
idServico INTEGER,
FOREIGN KEY(idServico) REFERENCES Serviço (idServico)
);

CREATE TABLE RelataSinistro (
idSinistro INTEGER,
idPessoa INTEGER
);

CREATE TABLE Sinistro (
parecerAvaliador VARCHAR(145),
dataSinistro DATETIME,
descricaoSinistro VARCHAR(145),
autorizadoSinistro VARCHAR(10),
valorSinistro DECIMAL(45),
idSinistro INTEGER PRIMARY KEY,
idTipo INTEGER,
FOREIGN KEY(idTipo) REFERENCES tipoSinistro (idTipo)
);

CREATE TABLE tipoSinistro (
descricaoTipoSinistro VARCHAR(45),
idTipo INTEGER PRIMARY KEY
);

CREATE TABLE Pessoa (
Nome VARCHAR(45),
Endereco VARCHAR(45),
Telefone BIGINT(12),
Cpf VARCHAR(14),
nomeLogin VARCHAR(10),
senha VARCHAR(45),
email VARCHAR(45),
idPessoa INTEGER PRIMARY KEY
);

CREATE TABLE Candidato (
cep VARCHAR(10),
sexo VARCHAR(10),
dataNascimento DATETIME,
idPessoa INTEGER,
idLocal INTEGER,
FOREIGN KEY(idPessoa) REFERENCES Pessoa (idPessoa),
FOREIGN KEY(idLocal) REFERENCES Local (idLocal)
);

CREATE TABLE Segurado (
idPessoa INTEGER,
FOREIGN KEY(idPessoa) REFERENCES Candidato (idPessoa)
);

CREATE TABLE SeguradoApolice (
idApolice INTEGER,
idPessoa INTEGER,
FOREIGN KEY(idApolice) REFERENCES Apolice (idApolice),
FOREIGN KEY(idPessoa) REFERENCES Segurado (idPessoa)
);

CREATE TABLE SolicitaServico (
idItemServiço INTEGER,
FOREIGN KEY(idItemServiço) REFERENCES itemServiço (idItemServiço)
);

CREATE TABLE Residência (
quantidadeGaragens NUMERIC(45),
anoConstrucao DATETIME,
ufResidencia VARCHAR(2),
idResidencia INTEGER PRIMARY KEY,
quantidadeComodos NUMERIC(45),
descricaoResidencia VARCHAR(145),
areaTotal VARCHAR(45),
cepResidencia VARCHAR(10),
areaConstruida VARCHAR(45),
numeroAndares NUMERIC(45),
enderecoResidencia VARCHAR(45),
idNivelP INTEGER,
idLocal INTEGER,
FOREIGN KEY(idNivelP) REFERENCES NivelPericulosidade (idNivelP),
FOREIGN KEY(idLocal) REFERENCES Local (idLocal)
);

CREATE TABLE Bem (
valorEstimadoBem DECIMAL(45),
descricaoBem VARCHAR(145),
idBem INTEGER PRIMARY KEY
);

CREATE TABLE BemResidencia (
idResidencia INTEGER,
idBem INTEGER,
FOREIGN KEY(idResidencia) REFERENCES Residência (idResidencia),
FOREIGN KEY(idBem) REFERENCES Bem (idBem)
);

CREATE TABLE Solicitacao (
idSolicitacao INTEGER PRIMARY KEY,
dataSolicitacao DATETIME,
dataVisitaResidenciia DATETIME,
valorSolicitacao DECIMAL(10),
aprovada VARCHAR(10),
motivoReprovacao VARCHAR(150),
idResidencia INTEGER,
idPessoa INTEGER,
FOREIGN KEY(idResidencia) REFERENCES Residência (idResidencia),
FOREIGN KEY(idPessoa) REFERENCES Pessoa (idPessoa)

);

CREATE TABLE Local (
bairro VARCHAR(45),
uf VARCHAR(2),
cidade VARCHAR(45),
idLocal INTEGER PRIMARY KEY
);

ALTER TABLE Corretor ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (idPessoa);
ALTER TABLE AvaliaSinistro ADD FOREIGN KEY(idSinistro) REFERENCES Sinistro (idSinistro);
ALTER TABLE ApoliceParcela ADD FOREIGN KEY(idApolice) REFERENCES Apólice (idApolice);
ALTER TABLE RelataSinistro ADD FOREIGN KEY(idSinistro) REFERENCES Sinistro (idSinistro);
ALTER TABLE Sinistro ADD FOREIGN KEY(idTipo) REFERENCES tipoSinistro (idTipo);
ALTER TABLE Residência ADD FOREIGN KEY(idLocal) REFERENCES Local (idLocal)
