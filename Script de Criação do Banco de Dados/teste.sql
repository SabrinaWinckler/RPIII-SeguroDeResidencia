CREATE TABLE Apolice (
);


CREATE TABLE Bem (
);


CREATE TABLE ItemServico (
);


CREATE TABLE Local (
);


CREATE TABLE NivelPericulosidade (
);


CREATE TABLE ParcelaApolice (
);


CREATE TABLE Pessoa (
 idPessoa CHAR(10) NOT NULL,
 nome CHAR(10) NOT NULL
);

ALTER TABLE Pessoa ADD CONSTRAINT PK_Pessoa PRIMARY KEY (idPessoa);


CREATE TABLE Servico (
);


CREATE TABLE Sinistro (
);


CREATE TABLE Solicitacao (
);


CREATE TABLE TipoSinistro (
);


CREATE TABLE Candidato (
 idPessoa CHAR(10) NOT NULL
);

ALTER TABLE Candidato ADD CONSTRAINT PK_Candidato PRIMARY KEY (idPessoa);


CREATE TABLE Corretor (
 idPessoa CHAR(10) NOT NULL
);

ALTER TABLE Corretor ADD CONSTRAINT PK_Corretor PRIMARY KEY (idPessoa);


CREATE TABLE Segurado (
 idPessoa CHAR(10) NOT NULL
);

ALTER TABLE Segurado ADD CONSTRAINT PK_Segurado PRIMARY KEY (idPessoa);


ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_0 FOREIGN KEY (idPessoa) REFERENCES Pessoa (idPessoa);


ALTER TABLE Corretor ADD CONSTRAINT FK_Corretor_0 FOREIGN KEY (idPessoa) REFERENCES Pessoa (idPessoa);


ALTER TABLE Segurado ADD CONSTRAINT FK_Segurado_0 FOREIGN KEY (idPessoa) REFERENCES Candidato (idPessoa);


