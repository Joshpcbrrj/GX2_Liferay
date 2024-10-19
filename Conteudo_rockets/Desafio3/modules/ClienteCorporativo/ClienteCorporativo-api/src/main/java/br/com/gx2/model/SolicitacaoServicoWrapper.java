/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SolicitacaoServico}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServico
 * @generated
 */
public class SolicitacaoServicoWrapper
	extends BaseModelWrapper<SolicitacaoServico>
	implements ModelWrapper<SolicitacaoServico>, SolicitacaoServico {

	public SolicitacaoServicoWrapper(SolicitacaoServico solicitacaoServico) {
		super(solicitacaoServico);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("solicitacaoId", getSolicitacaoId());
		attributes.put("codigoUnimed", getCodigoUnimed());
		attributes.put("descricao", getDescricao());
		attributes.put("dataSolicitacao", getDataSolicitacao());
		attributes.put("status", getStatus());
		attributes.put("prioridade", getPrioridade());
		attributes.put("clientePJId", getClientePJId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long solicitacaoId = (Long)attributes.get("solicitacaoId");

		if (solicitacaoId != null) {
			setSolicitacaoId(solicitacaoId);
		}

		String codigoUnimed = (String)attributes.get("codigoUnimed");

		if (codigoUnimed != null) {
			setCodigoUnimed(codigoUnimed);
		}

		String descricao = (String)attributes.get("descricao");

		if (descricao != null) {
			setDescricao(descricao);
		}

		Date dataSolicitacao = (Date)attributes.get("dataSolicitacao");

		if (dataSolicitacao != null) {
			setDataSolicitacao(dataSolicitacao);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer prioridade = (Integer)attributes.get("prioridade");

		if (prioridade != null) {
			setPrioridade(prioridade);
		}

		Long clientePJId = (Long)attributes.get("clientePJId");

		if (clientePJId != null) {
			setClientePJId(clientePJId);
		}
	}

	@Override
	public SolicitacaoServico cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cliente pj ID of this solicitacao servico.
	 *
	 * @return the cliente pj ID of this solicitacao servico
	 */
	@Override
	public long getClientePJId() {
		return model.getClientePJId();
	}

	/**
	 * Returns the codigo unimed of this solicitacao servico.
	 *
	 * @return the codigo unimed of this solicitacao servico
	 */
	@Override
	public String getCodigoUnimed() {
		return model.getCodigoUnimed();
	}

	/**
	 * Returns the data solicitacao of this solicitacao servico.
	 *
	 * @return the data solicitacao of this solicitacao servico
	 */
	@Override
	public Date getDataSolicitacao() {
		return model.getDataSolicitacao();
	}

	/**
	 * Returns the descricao of this solicitacao servico.
	 *
	 * @return the descricao of this solicitacao servico
	 */
	@Override
	public String getDescricao() {
		return model.getDescricao();
	}

	/**
	 * Returns the primary key of this solicitacao servico.
	 *
	 * @return the primary key of this solicitacao servico
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prioridade of this solicitacao servico.
	 *
	 * @return the prioridade of this solicitacao servico
	 */
	@Override
	public int getPrioridade() {
		return model.getPrioridade();
	}

	/**
	 * Returns the solicitacao ID of this solicitacao servico.
	 *
	 * @return the solicitacao ID of this solicitacao servico
	 */
	@Override
	public long getSolicitacaoId() {
		return model.getSolicitacaoId();
	}

	/**
	 * Returns the status of this solicitacao servico.
	 *
	 * @return the status of this solicitacao servico
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this solicitacao servico.
	 *
	 * @return the uuid of this solicitacao servico
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cliente pj ID of this solicitacao servico.
	 *
	 * @param clientePJId the cliente pj ID of this solicitacao servico
	 */
	@Override
	public void setClientePJId(long clientePJId) {
		model.setClientePJId(clientePJId);
	}

	/**
	 * Sets the codigo unimed of this solicitacao servico.
	 *
	 * @param codigoUnimed the codigo unimed of this solicitacao servico
	 */
	@Override
	public void setCodigoUnimed(String codigoUnimed) {
		model.setCodigoUnimed(codigoUnimed);
	}

	/**
	 * Sets the data solicitacao of this solicitacao servico.
	 *
	 * @param dataSolicitacao the data solicitacao of this solicitacao servico
	 */
	@Override
	public void setDataSolicitacao(Date dataSolicitacao) {
		model.setDataSolicitacao(dataSolicitacao);
	}

	/**
	 * Sets the descricao of this solicitacao servico.
	 *
	 * @param descricao the descricao of this solicitacao servico
	 */
	@Override
	public void setDescricao(String descricao) {
		model.setDescricao(descricao);
	}

	/**
	 * Sets the primary key of this solicitacao servico.
	 *
	 * @param primaryKey the primary key of this solicitacao servico
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prioridade of this solicitacao servico.
	 *
	 * @param prioridade the prioridade of this solicitacao servico
	 */
	@Override
	public void setPrioridade(int prioridade) {
		model.setPrioridade(prioridade);
	}

	/**
	 * Sets the solicitacao ID of this solicitacao servico.
	 *
	 * @param solicitacaoId the solicitacao ID of this solicitacao servico
	 */
	@Override
	public void setSolicitacaoId(long solicitacaoId) {
		model.setSolicitacaoId(solicitacaoId);
	}

	/**
	 * Sets the status of this solicitacao servico.
	 *
	 * @param status the status of this solicitacao servico
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this solicitacao servico.
	 *
	 * @param uuid the uuid of this solicitacao servico
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SolicitacaoServicoWrapper wrap(
		SolicitacaoServico solicitacaoServico) {

		return new SolicitacaoServicoWrapper(solicitacaoServico);
	}

}