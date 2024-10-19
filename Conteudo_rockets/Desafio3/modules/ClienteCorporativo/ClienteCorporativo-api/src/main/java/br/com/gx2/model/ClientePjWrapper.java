/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClientePj}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientePj
 * @generated
 */
public class ClientePjWrapper
	extends BaseModelWrapper<ClientePj>
	implements ClientePj, ModelWrapper<ClientePj> {

	public ClientePjWrapper(ClientePj clientePj) {
		super(clientePj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("clientePJId", getClientePJId());
		attributes.put("razaoSocial", getRazaoSocial());
		attributes.put("cnpj", getCnpj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long clientePJId = (Long)attributes.get("clientePJId");

		if (clientePJId != null) {
			setClientePJId(clientePJId);
		}

		String razaoSocial = (String)attributes.get("razaoSocial");

		if (razaoSocial != null) {
			setRazaoSocial(razaoSocial);
		}

		String cnpj = (String)attributes.get("cnpj");

		if (cnpj != null) {
			setCnpj(cnpj);
		}
	}

	@Override
	public ClientePj cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cliente pj ID of this cliente pj.
	 *
	 * @return the cliente pj ID of this cliente pj
	 */
	@Override
	public long getClientePJId() {
		return model.getClientePJId();
	}

	/**
	 * Returns the cnpj of this cliente pj.
	 *
	 * @return the cnpj of this cliente pj
	 */
	@Override
	public String getCnpj() {
		return model.getCnpj();
	}

	/**
	 * Returns the primary key of this cliente pj.
	 *
	 * @return the primary key of this cliente pj
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the razao social of this cliente pj.
	 *
	 * @return the razao social of this cliente pj
	 */
	@Override
	public String getRazaoSocial() {
		return model.getRazaoSocial();
	}

	/**
	 * Returns the uuid of this cliente pj.
	 *
	 * @return the uuid of this cliente pj
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
	 * Sets the cliente pj ID of this cliente pj.
	 *
	 * @param clientePJId the cliente pj ID of this cliente pj
	 */
	@Override
	public void setClientePJId(long clientePJId) {
		model.setClientePJId(clientePJId);
	}

	/**
	 * Sets the cnpj of this cliente pj.
	 *
	 * @param cnpj the cnpj of this cliente pj
	 */
	@Override
	public void setCnpj(String cnpj) {
		model.setCnpj(cnpj);
	}

	/**
	 * Sets the primary key of this cliente pj.
	 *
	 * @param primaryKey the primary key of this cliente pj
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the razao social of this cliente pj.
	 *
	 * @param razaoSocial the razao social of this cliente pj
	 */
	@Override
	public void setRazaoSocial(String razaoSocial) {
		model.setRazaoSocial(razaoSocial);
	}

	/**
	 * Sets the uuid of this cliente pj.
	 *
	 * @param uuid the uuid of this cliente pj
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
	protected ClientePjWrapper wrap(ClientePj clientePj) {
		return new ClientePjWrapper(clientePj);
	}

}