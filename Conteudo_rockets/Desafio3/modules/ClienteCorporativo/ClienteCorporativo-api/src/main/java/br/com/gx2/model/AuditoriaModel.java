/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Auditoria service. Represents a row in the &quot;Ccorp_Auditoria&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>br.com.gx2.model.impl.AuditoriaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>br.com.gx2.model.impl.AuditoriaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Auditoria
 * @generated
 */
@ProviderType
public interface AuditoriaModel extends BaseModel<Auditoria> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a auditoria model instance should use the {@link Auditoria} interface instead.
	 */

	/**
	 * Returns the primary key of this auditoria.
	 *
	 * @return the primary key of this auditoria
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this auditoria.
	 *
	 * @param primaryKey the primary key of this auditoria
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this auditoria.
	 *
	 * @return the uuid of this auditoria
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this auditoria.
	 *
	 * @param uuid the uuid of this auditoria
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the auditoria ID of this auditoria.
	 *
	 * @return the auditoria ID of this auditoria
	 */
	public long getAuditoriaId();

	/**
	 * Sets the auditoria ID of this auditoria.
	 *
	 * @param auditoriaId the auditoria ID of this auditoria
	 */
	public void setAuditoriaId(long auditoriaId);

	/**
	 * Returns the data acao of this auditoria.
	 *
	 * @return the data acao of this auditoria
	 */
	public Date getDataAcao();

	/**
	 * Sets the data acao of this auditoria.
	 *
	 * @param dataAcao the data acao of this auditoria
	 */
	public void setDataAcao(Date dataAcao);

	/**
	 * Returns the usuario of this auditoria.
	 *
	 * @return the usuario of this auditoria
	 */
	@AutoEscape
	public String getUsuario();

	/**
	 * Sets the usuario of this auditoria.
	 *
	 * @param usuario the usuario of this auditoria
	 */
	public void setUsuario(String usuario);

	/**
	 * Returns the acao of this auditoria.
	 *
	 * @return the acao of this auditoria
	 */
	@AutoEscape
	public String getAcao();

	/**
	 * Sets the acao of this auditoria.
	 *
	 * @param acao the acao of this auditoria
	 */
	public void setAcao(String acao);

	@Override
	public Auditoria cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}