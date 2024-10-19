/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.http;

import br.com.gx2.service.SolicitacaoServicoServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>SolicitacaoServicoServiceUtil</code> service
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
public class SolicitacaoServicoServiceHttp {

	public static javax.ws.rs.core.Response addSolicitacaoServico(
			HttpPrincipal httpPrincipal, long clientePJId, String codigoUnimed,
			String descricao, int status, int prioridade)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SolicitacaoServicoServiceUtil.class, "addSolicitacaoServico",
				_addSolicitacaoServicoParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clientePJId, codigoUnimed, descricao, status,
				prioridade);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

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

	public static javax.ws.rs.core.Response updateSolicitacaoServico(
			HttpPrincipal httpPrincipal, long solicitacaoId,
			String codigoUnimed, String descricao, int status, int prioridade)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SolicitacaoServicoServiceUtil.class, "updateSolicitacaoServico",
				_updateSolicitacaoServicoParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, solicitacaoId, codigoUnimed, descricao, status,
				prioridade);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

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

	public static javax.ws.rs.core.Response getSolicitacaoServico(
		HttpPrincipal httpPrincipal, long solicitacaoId) {

		try {
			MethodKey methodKey = new MethodKey(
				SolicitacaoServicoServiceUtil.class, "getSolicitacaoServico",
				_getSolicitacaoServicoParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, solicitacaoId);

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

	public static javax.ws.rs.core.Response getAllSolicitacoes(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				SolicitacaoServicoServiceUtil.class, "getAllSolicitacoes",
				_getAllSolicitacoesParameterTypes4);

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

	private static Log _log = LogFactoryUtil.getLog(
		SolicitacaoServicoServiceHttp.class);

	private static final Class<?>[] _addSolicitacaoServicoParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _updateSolicitacaoServicoParameterTypes2 =
		new Class[] {
			long.class, String.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _getSolicitacaoServicoParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getAllSolicitacoesParameterTypes4 =
		new Class[] {};

}