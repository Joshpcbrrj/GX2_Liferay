/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model.impl;

import br.com.gx2.model.Auditoria;
import br.com.gx2.service.AuditoriaLocalServiceUtil;

/**
 * The extended model base implementation for the Auditoria service. Represents a row in the &quot;Ccorp_Auditoria&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditoriaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaImpl
 * @see Auditoria
 * @generated
 */
public abstract class AuditoriaBaseImpl
	extends AuditoriaModelImpl implements Auditoria {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a auditoria model instance should use the <code>Auditoria</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AuditoriaLocalServiceUtil.addAuditoria(this);
		}
		else {
			AuditoriaLocalServiceUtil.updateAuditoria(this);
		}
	}

}