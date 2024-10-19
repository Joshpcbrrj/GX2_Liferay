/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.Auditoria;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Auditoria. This utility wraps
 * <code>br.com.gx2.service.impl.AuditoriaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaService
 * @generated
 */
public class AuditoriaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.gx2.service.impl.AuditoriaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adiciona uma nova entrada de auditoria ao banco de dados com parâmetros adicionais.
	 *
	 * @param auditoria a auditoria a ser adicionada
	 * @param serviceContext o contexto do serviço
	 * @return a auditoria adicionada
	 * @throws PortalException se ocorrer uma exceção de portal
	 */
	public static Auditoria addAuditoria(
			Auditoria auditoria,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAuditoria(auditoria, serviceContext);
	}

	/**
	 * Conta o número total de entradas de auditoria.
	 *
	 * @return o total de auditorias
	 */
	public static long countAuditorias() {
		return getService().countAuditorias();
	}

	/**
	 * Deleta a entrada de auditoria com o ID fornecido.
	 *
	 * @param auditoriaId a chave primária da auditoria a ser deletada
	 * @return a auditoria deletada
	 * @throws PortalException se não for encontrada uma auditoria com a chave primária
	 */
	public static Auditoria deleteAuditoria(long auditoriaId)
		throws PortalException {

		return getService().deleteAuditoria(auditoriaId);
	}

	/**
	 * Recupera uma entrada de auditoria pelo seu ID.
	 *
	 * @param auditoriaId o ID da auditoria
	 * @return a auditoria encontrada
	 * @throws PortalException se a auditoria não for encontrada
	 */
	public static Auditoria getAuditoriaById(long auditoriaId)
		throws PortalException {

		return getService().getAuditoriaById(auditoriaId);
	}

	/**
	 * Recupera uma lista de entradas de auditoria com base em alguns critérios.
	 *
	 * @param start o limite inferior do intervalo de auditorias
	 * @param end o limite superior do intervalo de auditorias (não inclusivo)
	 * @return a lista de auditorias
	 */
	public static List<Auditoria> getAuditorias(int start, int end) {
		return getService().getAuditorias(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AuditoriaService getService() {
		return _service;
	}

	public static void setService(AuditoriaService service) {
		_service = service;
	}

	private static volatile AuditoriaService _service;

}