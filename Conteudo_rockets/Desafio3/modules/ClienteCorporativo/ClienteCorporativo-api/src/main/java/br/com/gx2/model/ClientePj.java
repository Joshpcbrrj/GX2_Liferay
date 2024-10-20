/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ClientePj service. Represents a row in the &quot;Ccorp_ClientePj&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjModel
 * @generated
 */
@ImplementationClassName("br.com.gx2.model.impl.ClientePjImpl")
@ProviderType
public interface ClientePj extends ClientePjModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>br.com.gx2.model.impl.ClientePjImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ClientePj, Long> CLIENTE_PJ_ID_ACCESSOR =
		new Accessor<ClientePj, Long>() {

			@Override
			public Long get(ClientePj clientePj) {
				return clientePj.getClientePJId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ClientePj> getTypeClass() {
				return ClientePj.class;
			}

		};

}