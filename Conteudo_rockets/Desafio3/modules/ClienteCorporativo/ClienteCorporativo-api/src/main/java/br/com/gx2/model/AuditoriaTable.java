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
 * The table class for the &quot;Ccorp_Auditoria&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Auditoria
 * @generated
 */
public class AuditoriaTable extends BaseTable<AuditoriaTable> {

	public static final AuditoriaTable INSTANCE = new AuditoriaTable();

	public final Column<AuditoriaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditoriaTable, Long> auditoriaId = createColumn(
		"auditoriaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AuditoriaTable, Date> dataAcao = createColumn(
		"dataAcao", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuditoriaTable, String> usuario = createColumn(
		"usuario", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditoriaTable, String> acao = createColumn(
		"acao", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AuditoriaTable() {
		super("Ccorp_Auditoria", AuditoriaTable::new);
	}

}