/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package br.com.gx2.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchClientePjException extends NoSuchModelException {

	public NoSuchClientePjException() {
	}

	public NoSuchClientePjException(String msg) {
		super(msg);
	}

	public NoSuchClientePjException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchClientePjException(Throwable throwable) {
		super(throwable);
	}

}