create index IX_8DFD928A on Ccorp_Auditoria (uuid_[$COLUMN_LENGTH:75$]);

create index IX_98E27DC1 on Ccorp_ClientePj (cnpj[$COLUMN_LENGTH:75$]);
create index IX_472ABB4C on Ccorp_ClientePj (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2AA9630D on Ccorp_SolicitacaoServico (clientePJId);
create index IX_C3389122 on Ccorp_SolicitacaoServico (uuid_[$COLUMN_LENGTH:75$]);