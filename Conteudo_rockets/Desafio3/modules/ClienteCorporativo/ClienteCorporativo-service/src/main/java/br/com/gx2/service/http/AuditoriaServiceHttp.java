/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.http;

import br.com.gx2.service.AuditoriaServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>AuditoriaServiceUtil</code> service
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
public class AuditoriaServiceHttp {

	public static br.com.gx2.model.Auditoria addAuditoria(
			HttpPrincipal httpPrincipal, br.com.gx2.model.Auditoria auditoria,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AuditoriaServiceUtil.class, "addAuditoria",
				_addAuditoriaParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, auditoria, serviceContext);

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

			return (br.com.gx2.model.Auditoria)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static br.com.gx2.model.Auditoria deleteAuditoria(
			HttpPrincipal httpPrincipal, long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AuditoriaServiceUtil.class, "deleteAuditoria",
				_deleteAuditoriaParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, auditoriaId);

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

			return (br.com.gx2.model.Auditoria)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<br.com.gx2.model.Auditoria> getAuditorias(
		HttpPrincipal httpPrincipal, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				AuditoriaServiceUtil.class, "getAuditorias",
				_getAuditoriasParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<br.com.gx2.model.Auditoria>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long countAuditorias(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				AuditoriaServiceUtil.class, "countAuditorias",
				_countAuditoriasParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static br.com.gx2.model.Auditoria getAuditoriaById(
			HttpPrincipal httpPrincipal, long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AuditoriaServiceUtil.class, "getAuditoriaById",
				_getAuditoriaByIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, auditoriaId);

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

			return (br.com.gx2.model.Auditoria)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AuditoriaServiceHttp.class);

	private static final Class<?>[] _addAuditoriaParameterTypes0 = new Class[] {
		br.com.gx2.model.Auditoria.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteAuditoriaParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getAuditoriasParameterTypes2 =
		new Class[] {int.class, int.class};
	private static final Class<?>[] _countAuditoriasParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _getAuditoriaByIdParameterTypes4 =
		new Class[] {long.class};

}