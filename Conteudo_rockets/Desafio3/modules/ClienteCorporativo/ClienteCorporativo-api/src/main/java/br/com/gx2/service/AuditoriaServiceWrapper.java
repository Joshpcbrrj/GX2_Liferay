/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditoriaService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaService
 * @generated
 */
public class AuditoriaServiceWrapper
	implements AuditoriaService, ServiceWrapper<AuditoriaService> {

	public AuditoriaServiceWrapper() {
		this(null);
	}

	public AuditoriaServiceWrapper(AuditoriaService auditoriaService) {
		_auditoriaService = auditoriaService;
	}

	/**
	 * Adiciona uma nova entrada de auditoria ao banco de dados com parâmetros adicionais.
	 *
	 * @param auditoria a auditoria a ser adicionada
	 * @param serviceContext o contexto do serviço
	 * @return a auditoria adicionada
	 * @throws PortalException se ocorrer uma exceção de portal
	 */
	@Override
	public br.com.gx2.model.Auditoria addAuditoria(
			br.com.gx2.model.Auditoria auditoria,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaService.addAuditoria(auditoria, serviceContext);
	}

	/**
	 * Conta o número total de entradas de auditoria.
	 *
	 * @return o total de auditorias
	 */
	@Override
	public long countAuditorias() {
		return _auditoriaService.countAuditorias();
	}

	/**
	 * Deleta a entrada de auditoria com o ID fornecido.
	 *
	 * @param auditoriaId a chave primária da auditoria a ser deletada
	 * @return a auditoria deletada
	 * @throws PortalException se não for encontrada uma auditoria com a chave primária
	 */
	@Override
	public br.com.gx2.model.Auditoria deleteAuditoria(long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaService.deleteAuditoria(auditoriaId);
	}

	/**
	 * Recupera uma entrada de auditoria pelo seu ID.
	 *
	 * @param auditoriaId o ID da auditoria
	 * @return a auditoria encontrada
	 * @throws PortalException se a auditoria não for encontrada
	 */
	@Override
	public br.com.gx2.model.Auditoria getAuditoriaById(long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaService.getAuditoriaById(auditoriaId);
	}

	/**
	 * Recupera uma lista de entradas de auditoria com base em alguns critérios.
	 *
	 * @param start o limite inferior do intervalo de auditorias
	 * @param end o limite superior do intervalo de auditorias (não inclusivo)
	 * @return a lista de auditorias
	 */
	@Override
	public java.util.List<br.com.gx2.model.Auditoria> getAuditorias(
		int start, int end) {

		return _auditoriaService.getAuditorias(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditoriaService.getOSGiServiceIdentifier();
	}

	@Override
	public AuditoriaService getWrappedService() {
		return _auditoriaService;
	}

	@Override
	public void setWrappedService(AuditoriaService auditoriaService) {
		_auditoriaService = auditoriaService;
	}

	private AuditoriaService _auditoriaService;

}