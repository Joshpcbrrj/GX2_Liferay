/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model.impl;

import br.com.gx2.model.ClientePj;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ClientePj in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClientePjCacheModel
	implements CacheModel<ClientePj>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClientePjCacheModel)) {
			return false;
		}

		ClientePjCacheModel clientePjCacheModel = (ClientePjCacheModel)object;

		if (clientePJId == clientePjCacheModel.clientePJId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientePJId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clientePJId=");
		sb.append(clientePJId);
		sb.append(", razaoSocial=");
		sb.append(razaoSocial);
		sb.append(", cnpj=");
		sb.append(cnpj);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClientePj toEntityModel() {
		ClientePjImpl clientePjImpl = new ClientePjImpl();

		if (uuid == null) {
			clientePjImpl.setUuid("");
		}
		else {
			clientePjImpl.setUuid(uuid);
		}

		clientePjImpl.setClientePJId(clientePJId);

		if (razaoSocial == null) {
			clientePjImpl.setRazaoSocial("");
		}
		else {
			clientePjImpl.setRazaoSocial(razaoSocial);
		}

		if (cnpj == null) {
			clientePjImpl.setCnpj("");
		}
		else {
			clientePjImpl.setCnpj(cnpj);
		}

		clientePjImpl.resetOriginalValues();

		return clientePjImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		clientePJId = objectInput.readLong();
		razaoSocial = objectInput.readUTF();
		cnpj = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(clientePJId);

		if (razaoSocial == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(razaoSocial);
		}

		if (cnpj == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cnpj);
		}
	}

	public String uuid;
	public long clientePJId;
	public String razaoSocial;
	public String cnpj;

}