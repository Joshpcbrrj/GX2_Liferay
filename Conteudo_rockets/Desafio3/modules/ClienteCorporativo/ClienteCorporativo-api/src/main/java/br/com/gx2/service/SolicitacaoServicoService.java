/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import javax.ws.rs.core.Response;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for SolicitacaoServico. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SolicitacaoServicoService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.gx2.service.impl.SolicitacaoServicoServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the solicitacao servico remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SolicitacaoServicoServiceUtil} if injection and service tracking are not available.
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
	public Response addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao, int status,
			int prioridade)
		throws PortalException;

	/**
	 * Remove uma solicitação de serviço existente pelo ID.
	 *
	 * @param solicitacaoId o ID da solicitação de serviço a ser removida
	 * @return a resposta HTTP com o DTO da solicitação de serviço removida, ou erro caso não seja encontrada
	 */
	public Response deleteSolicitacaoServico(long solicitacaoId);

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Resposta com a lista de solicitações.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Response getAllSolicitacoes();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Obtém uma solicitação de serviço pelo ID.
	 *
	 * @param solicitacaoId ID da solicitação a ser buscada.
	 * @return Resposta com a solicitação encontrada.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Response getSolicitacaoServico(long solicitacaoId);

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
	public Response updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade)
		throws PortalException;

}