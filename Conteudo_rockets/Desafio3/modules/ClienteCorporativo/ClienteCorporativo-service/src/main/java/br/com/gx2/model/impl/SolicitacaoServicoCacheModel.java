/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model.impl;

import br.com.gx2.model.SolicitacaoServico;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SolicitacaoServico in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SolicitacaoServicoCacheModel
	implements CacheModel<SolicitacaoServico>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SolicitacaoServicoCacheModel)) {
			return false;
		}

		SolicitacaoServicoCacheModel solicitacaoServicoCacheModel =
			(SolicitacaoServicoCacheModel)object;

		if (solicitacaoId == solicitacaoServicoCacheModel.solicitacaoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, solicitacaoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", solicitacaoId=");
		sb.append(solicitacaoId);
		sb.append(", codigoUnimed=");
		sb.append(codigoUnimed);
		sb.append(", descricao=");
		sb.append(descricao);
		sb.append(", dataSolicitacao=");
		sb.append(dataSolicitacao);
		sb.append(", status=");
		sb.append(status);
		sb.append(", prioridade=");
		sb.append(prioridade);
		sb.append(", clientePJId=");
		sb.append(clientePJId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SolicitacaoServico toEntityModel() {
		SolicitacaoServicoImpl solicitacaoServicoImpl =
			new SolicitacaoServicoImpl();

		if (uuid == null) {
			solicitacaoServicoImpl.setUuid("");
		}
		else {
			solicitacaoServicoImpl.setUuid(uuid);
		}

		solicitacaoServicoImpl.setSolicitacaoId(solicitacaoId);

		if (codigoUnimed == null) {
			solicitacaoServicoImpl.setCodigoUnimed("");
		}
		else {
			solicitacaoServicoImpl.setCodigoUnimed(codigoUnimed);
		}

		if (descricao == null) {
			solicitacaoServicoImpl.setDescricao("");
		}
		else {
			solicitacaoServicoImpl.setDescricao(descricao);
		}

		if (dataSolicitacao == Long.MIN_VALUE) {
			solicitacaoServicoImpl.setDataSolicitacao(null);
		}
		else {
			solicitacaoServicoImpl.setDataSolicitacao(
				new Date(dataSolicitacao));
		}

		solicitacaoServicoImpl.setStatus(status);
		solicitacaoServicoImpl.setPrioridade(prioridade);
		solicitacaoServicoImpl.setClientePJId(clientePJId);

		solicitacaoServicoImpl.resetOriginalValues();

		return solicitacaoServicoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		solicitacaoId = objectInput.readLong();
		codigoUnimed = objectInput.readUTF();
		descricao = objectInput.readUTF();
		dataSolicitacao = objectInput.readLong();

		status = objectInput.readInt();

		prioridade = objectInput.readInt();

		clientePJId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(solicitacaoId);

		if (codigoUnimed == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codigoUnimed);
		}

		if (descricao == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descricao);
		}

		objectOutput.writeLong(dataSolicitacao);

		objectOutput.writeInt(status);

		objectOutput.writeInt(prioridade);

		objectOutput.writeLong(clientePJId);
	}

	public String uuid;
	public long solicitacaoId;
	public String codigoUnimed;
	public String descricao;
	public long dataSolicitacao;
	public int status;
	public int prioridade;
	public long clientePJId;

}