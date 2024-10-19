/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model.impl;

import br.com.gx2.model.Auditoria;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Auditoria in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditoriaCacheModel
	implements CacheModel<Auditoria>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuditoriaCacheModel)) {
			return false;
		}

		AuditoriaCacheModel auditoriaCacheModel = (AuditoriaCacheModel)object;

		if (auditoriaId == auditoriaCacheModel.auditoriaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditoriaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", auditoriaId=");
		sb.append(auditoriaId);
		sb.append(", dataAcao=");
		sb.append(dataAcao);
		sb.append(", usuario=");
		sb.append(usuario);
		sb.append(", acao=");
		sb.append(acao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Auditoria toEntityModel() {
		AuditoriaImpl auditoriaImpl = new AuditoriaImpl();

		if (uuid == null) {
			auditoriaImpl.setUuid("");
		}
		else {
			auditoriaImpl.setUuid(uuid);
		}

		auditoriaImpl.setAuditoriaId(auditoriaId);

		if (dataAcao == Long.MIN_VALUE) {
			auditoriaImpl.setDataAcao(null);
		}
		else {
			auditoriaImpl.setDataAcao(new Date(dataAcao));
		}

		if (usuario == null) {
			auditoriaImpl.setUsuario("");
		}
		else {
			auditoriaImpl.setUsuario(usuario);
		}

		if (acao == null) {
			auditoriaImpl.setAcao("");
		}
		else {
			auditoriaImpl.setAcao(acao);
		}

		auditoriaImpl.resetOriginalValues();

		return auditoriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		auditoriaId = objectInput.readLong();
		dataAcao = objectInput.readLong();
		usuario = objectInput.readUTF();
		acao = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(auditoriaId);
		objectOutput.writeLong(dataAcao);

		if (usuario == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usuario);
		}

		if (acao == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(acao);
		}
	}

	public String uuid;
	public long auditoriaId;
	public long dataAcao;
	public String usuario;
	public String acao;

}