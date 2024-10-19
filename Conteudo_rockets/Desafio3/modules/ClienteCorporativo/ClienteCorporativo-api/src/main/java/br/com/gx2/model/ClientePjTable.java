/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Ccorp_ClientePj&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePj
 * @generated
 */
public class ClientePjTable extends BaseTable<ClientePjTable> {

	public static final ClientePjTable INSTANCE = new ClientePjTable();

	public final Column<ClientePjTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ClientePjTable, Long> clientePJId = createColumn(
		"clientePJId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ClientePjTable, String> razaoSocial = createColumn(
		"razaoSocial", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ClientePjTable, String> cnpj = createColumn(
		"cnpj", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ClientePjTable() {
		super("Ccorp_ClientePj", ClientePjTable::new);
	}

}