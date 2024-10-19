/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Ccorp_SolicitacaoServico&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServico
 * @generated
 */
public class SolicitacaoServicoTable
	extends BaseTable<SolicitacaoServicoTable> {

	public static final SolicitacaoServicoTable INSTANCE =
		new SolicitacaoServicoTable();

	public final Column<SolicitacaoServicoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SolicitacaoServicoTable, Long> solicitacaoId =
		createColumn(
			"solicitacaoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SolicitacaoServicoTable, String> codigoUnimed =
		createColumn(
			"codigoUnimed", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SolicitacaoServicoTable, String> descricao =
		createColumn(
			"descricao", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SolicitacaoServicoTable, Date> dataSolicitacao =
		createColumn(
			"dataSolicitacao", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<SolicitacaoServicoTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SolicitacaoServicoTable, Integer> prioridade =
		createColumn(
			"prioridade", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SolicitacaoServicoTable, Long> clientePJId =
		createColumn(
			"clientePJId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SolicitacaoServicoTable() {
		super("Ccorp_SolicitacaoServico", SolicitacaoServicoTable::new);
	}

}