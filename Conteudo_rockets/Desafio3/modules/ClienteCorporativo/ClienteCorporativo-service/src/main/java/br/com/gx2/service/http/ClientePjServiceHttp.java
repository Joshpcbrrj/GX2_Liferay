/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.http;

import br.com.gx2.service.ClientePjServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>ClientePjServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClientePjServiceHttp {

	public static javax.ws.rs.core.Response addClientePj(
		HttpPrincipal httpPrincipal, String razaoSocial, String cnpj,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				ClientePjServiceUtil.class, "addClientePj",
				_addClientePjParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, razaoSocial, cnpj, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static javax.ws.rs.core.Response deleteClientePjById(
		HttpPrincipal httpPrincipal, long clientePJId) {

		try {
			MethodKey methodKey = new MethodKey(
				ClientePjServiceUtil.class, "deleteClientePjById",
				_deleteClientePjByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clientePJId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static javax.ws.rs.core.Response getClientePjById(
		HttpPrincipal httpPrincipal, long clientePJId) {

		try {
			MethodKey methodKey = new MethodKey(
				ClientePjServiceUtil.class, "getClientePjById",
				_getClientePjByIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clientePJId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static javax.ws.rs.core.Response getClientePjByCnpj(
		HttpPrincipal httpPrincipal, String cnpj) {

		try {
			MethodKey methodKey = new MethodKey(
				ClientePjServiceUtil.class, "getClientePjByCnpj",
				_getClientePjByCnpjParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, cnpj);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static javax.ws.rs.core.Response getAllClientes(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				ClientePjServiceUtil.class, "getAllClientes",
				_getAllClientesParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static javax.ws.rs.core.Response updateClientePj(
		HttpPrincipal httpPrincipal, long clientePJId, String razaoSocial,
		String cnpj) {

		try {
			MethodKey methodKey = new MethodKey(
				ClientePjServiceUtil.class, "updateClientePj",
				_updateClientePjParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clientePJId, razaoSocial, cnpj);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (javax.ws.rs.core.Response)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClientePjServiceHttp.class);

	private static final Class<?>[] _addClientePjParameterTypes0 = new Class[] {
		String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteClientePjByIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getClientePjByIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getClientePjByCnpjParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _getAllClientesParameterTypes4 =
		new Class[] {};
	private static final Class<?>[] _updateClientePjParameterTypes5 =
		new Class[] {long.class, String.class, String.class};

}