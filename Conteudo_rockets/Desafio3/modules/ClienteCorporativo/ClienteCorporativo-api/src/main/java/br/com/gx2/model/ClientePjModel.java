/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ClientePj service. Represents a row in the &quot;Ccorp_ClientePj&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>br.com.gx2.model.impl.ClientePjModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>br.com.gx2.model.impl.ClientePjImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientePj
 * @generated
 */
@ProviderType
public interface ClientePjModel extends BaseModel<ClientePj> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cliente pj model instance should use the {@link ClientePj} interface instead.
	 */

	/**
	 * Returns the primary key of this cliente pj.
	 *
	 * @return the primary key of this cliente pj
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cliente pj.
	 *
	 * @param primaryKey the primary key of this cliente pj
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this cliente pj.
	 *
	 * @return the uuid of this cliente pj
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this cliente pj.
	 *
	 * @param uuid the uuid of this cliente pj
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the cliente pj ID of this cliente pj.
	 *
	 * @return the cliente pj ID of this cliente pj
	 */
	public long getClientePJId();

	/**
	 * Sets the cliente pj ID of this cliente pj.
	 *
	 * @param clientePJId the cliente pj ID of this cliente pj
	 */
	public void setClientePJId(long clientePJId);

	/**
	 * Returns the razao social of this cliente pj.
	 *
	 * @return the razao social of this cliente pj
	 */
	@AutoEscape
	public String getRazaoSocial();

	/**
	 * Sets the razao social of this cliente pj.
	 *
	 * @param razaoSocial the razao social of this cliente pj
	 */
	public void setRazaoSocial(String razaoSocial);

	/**
	 * Returns the cnpj of this cliente pj.
	 *
	 * @return the cnpj of this cliente pj
	 */
	@AutoEscape
	public String getCnpj();

	/**
	 * Sets the cnpj of this cliente pj.
	 *
	 * @param cnpj the cnpj of this cliente pj
	 */
	public void setCnpj(String cnpj);

	@Override
	public ClientePj cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}