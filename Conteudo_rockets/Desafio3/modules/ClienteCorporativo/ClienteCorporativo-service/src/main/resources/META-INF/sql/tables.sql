create table Ccorp_Auditoria (
	uuid_ VARCHAR(75) null,
	auditoriaId LONG not null primary key,
	dataAcao DATE null,
	usuario VARCHAR(75) null,
	acao VARCHAR(75) null
);

create table Ccorp_ClientePj (
	uuid_ VARCHAR(75) null,
	clientePJId LONG not null primary key,
	razaoSocial VARCHAR(75) null,
	cnpj VARCHAR(75) null
);

create table Ccorp_SolicitacaoServico (
	uuid_ VARCHAR(75) null,
	solicitacaoId LONG not null primary key,
	codigoUnimed VARCHAR(75) null,
	descricao VARCHAR(75) null,
	dataSolicitacao DATE null,
	status INTEGER,
	prioridade INTEGER,
	clientePJId LONG
);