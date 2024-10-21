/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for SolicitacaoServico. This utility wraps
 * <code>br.com.gx2.service.impl.SolicitacaoServicoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoService
 * @generated
 */
public class SolicitacaoServicoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.gx2.service.impl.SolicitacaoServicoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static javax.ws.rs.core.Response addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao, int status,
			int prioridade)
		throws PortalException {

		return getService().addSolicitacaoServico(
			clientePJId, codigoUnimed, descricao, status, prioridade);
	}

	/**
	 * Remove uma solicitação de serviço existente pelo ID.
	 *
	 * @param solicitacaoId o ID da solicitação de serviço a ser removida
	 * @return a resposta HTTP com o DTO da solicitação de serviço removida, ou erro caso não seja encontrada
	 */
	public static javax.ws.rs.core.Response deleteSolicitacaoServico(
		long solicitacaoId) {

		return getService().deleteSolicitacaoServico(solicitacaoId);
	}

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Resposta com a lista de solicitações.
	 */
	public static javax.ws.rs.core.Response getAllSolicitacoes() {
		return getService().getAllSolicitacoes();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Obtém uma solicitação de serviço pelo ID.
	 *
	 * @param solicitacaoId ID da solicitação a ser buscada.
	 * @return Resposta com a solicitação encontrada.
	 */
	public static javax.ws.rs.core.Response getSolicitacaoServico(
		long solicitacaoId) {

		return getService().getSolicitacaoServico(solicitacaoId);
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
	public static javax.ws.rs.core.Response updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade)
		throws PortalException {

		return getService().updateSolicitacaoServico(
			solicitacaoId, codigoUnimed, descricao, status, prioridade);
	}

	public static SolicitacaoServicoService getService() {
		return _service;
	}

	public static void setService(SolicitacaoServicoService service) {
		_service = service;
	}

	private static volatile SolicitacaoServicoService _service;

}