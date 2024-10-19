/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SolicitacaoServicoService}.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoService
 * @generated
 */
public class SolicitacaoServicoServiceWrapper
	implements ServiceWrapper<SolicitacaoServicoService>,
			   SolicitacaoServicoService {

	public SolicitacaoServicoServiceWrapper() {
		this(null);
	}

	public SolicitacaoServicoServiceWrapper(
		SolicitacaoServicoService solicitacaoServicoService) {

		_solicitacaoServicoService = solicitacaoServicoService;
	}

	/**
	 * Adiciona uma nova solicitação de serviço.
	 *
	 * @param clientePJId ID do cliente PJ.
	 * @param codigoUnimed Código Unimed da solicitação.
	 * @param descricao Descrição da solicitação.
	 * @param status Status da solicitação.
	 * @param prioridade Prioridade da solicitação.
	 * @return Resposta com o status da criação.
	 * @throws PortalException Se ocorrer um erro ao validar ou criar a solicitação.
	 */
	@Override
	public javax.ws.rs.core.Response addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao, int status,
			int prioridade)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoService.addSolicitacaoServico(
			clientePJId, codigoUnimed, descricao, status, prioridade);
	}

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Resposta com a lista de solicitações.
	 */
	@Override
	public javax.ws.rs.core.Response getAllSolicitacoes() {
		return _solicitacaoServicoService.getAllSolicitacoes();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _solicitacaoServicoService.getOSGiServiceIdentifier();
	}

	/**
	 * Obtém uma solicitação de serviço pelo ID.
	 *
	 * @param solicitacaoId ID da solicitação a ser buscada.
	 * @return Resposta com a solicitação encontrada.
	 */
	@Override
	public javax.ws.rs.core.Response getSolicitacaoServico(long solicitacaoId) {
		return _solicitacaoServicoService.getSolicitacaoServico(solicitacaoId);
	}

	/**
	 * Atualiza uma solicitação de serviço existente.
	 *
	 * @param solicitacaoId ID da solicitação a ser atualizada.
	 * @param codigoUnimed Código Unimed da solicitação.
	 * @param descricao Nova descrição da solicitação.
	 * @param status Novo status da solicitação.
	 * @param prioridade Nova prioridade da solicitação.
	 * @return Resposta com o status da atualização.
	 * @throws PortalException Se ocorrer um erro ao validar ou atualizar a solicitação.
	 */
	@Override
	public javax.ws.rs.core.Response updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoService.updateSolicitacaoServico(
			solicitacaoId, codigoUnimed, descricao, status, prioridade);
	}

	@Override
	public SolicitacaoServicoService getWrappedService() {
		return _solicitacaoServicoService;
	}

	@Override
	public void setWrappedService(
		SolicitacaoServicoService solicitacaoServicoService) {

		_solicitacaoServicoService = solicitacaoServicoService;
	}

	private SolicitacaoServicoService _solicitacaoServicoService;

}