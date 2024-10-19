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
 * This class is a wrapper for {@link Auditoria}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Auditoria
 * @generated
 */
public class AuditoriaWrapper
	extends BaseModelWrapper<Auditoria>
	implements Auditoria, ModelWrapper<Auditoria> {

	public AuditoriaWrapper(Auditoria auditoria) {
		super(auditoria);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("auditoriaId", getAuditoriaId());
		attributes.put("dataAcao", getDataAcao());
		attributes.put("usuario", getUsuario());
		attributes.put("acao", getAcao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long auditoriaId = (Long)attributes.get("auditoriaId");

		if (auditoriaId != null) {
			setAuditoriaId(auditoriaId);
		}

		Date dataAcao = (Date)attributes.get("dataAcao");

		if (dataAcao != null) {
			setDataAcao(dataAcao);
		}

		String usuario = (String)attributes.get("usuario");

		if (usuario != null) {
			setUsuario(usuario);
		}

		String acao = (String)attributes.get("acao");

		if (acao != null) {
			setAcao(acao);
		}
	}

	@Override
	public Auditoria cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the acao of this auditoria.
	 *
	 * @return the acao of this auditoria
	 */
	@Override
	public String getAcao() {
		return model.getAcao();
	}

	/**
	 * Returns the auditoria ID of this auditoria.
	 *
	 * @return the auditoria ID of this auditoria
	 */
	@Override
	public long getAuditoriaId() {
		return model.getAuditoriaId();
	}

	/**
	 * Returns the data acao of this auditoria.
	 *
	 * @return the data acao of this auditoria
	 */
	@Override
	public Date getDataAcao() {
		return model.getDataAcao();
	}

	/**
	 * Returns the primary key of this auditoria.
	 *
	 * @return the primary key of this auditoria
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the usuario of this auditoria.
	 *
	 * @return the usuario of this auditoria
	 */
	@Override
	public String getUsuario() {
		return model.getUsuario();
	}

	/**
	 * Returns the uuid of this auditoria.
	 *
	 * @return the uuid of this auditoria
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
	 * Sets the acao of this auditoria.
	 *
	 * @param acao the acao of this auditoria
	 */
	@Override
	public void setAcao(String acao) {
		model.setAcao(acao);
	}

	/**
	 * Sets the auditoria ID of this auditoria.
	 *
	 * @param auditoriaId the auditoria ID of this auditoria
	 */
	@Override
	public void setAuditoriaId(long auditoriaId) {
		model.setAuditoriaId(auditoriaId);
	}

	/**
	 * Sets the data acao of this auditoria.
	 *
	 * @param dataAcao the data acao of this auditoria
	 */
	@Override
	public void setDataAcao(Date dataAcao) {
		model.setDataAcao(dataAcao);
	}

	/**
	 * Sets the primary key of this auditoria.
	 *
	 * @param primaryKey the primary key of this auditoria
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the usuario of this auditoria.
	 *
	 * @param usuario the usuario of this auditoria
	 */
	@Override
	public void setUsuario(String usuario) {
		model.setUsuario(usuario);
	}

	/**
	 * Sets the uuid of this auditoria.
	 *
	 * @param uuid the uuid of this auditoria
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
	protected AuditoriaWrapper wrap(Auditoria auditoria) {
		return new AuditoriaWrapper(auditoria);
	}

}