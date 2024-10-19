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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import javax.ws.rs.core.Response;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for ClientePj. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ClientePjService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.gx2.service.impl.ClientePjServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the cliente pj remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ClientePjServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adiciona um novo cliente PJ.
	 *
	 * @param razaoSocial Razão social do cliente.
	 * @param cnpj CNPJ do cliente.
	 * @param serviceContext Contexto do serviço.
	 * @return Response contendo os dados do cliente criado.
	 */
	public Response addClientePj(
		String razaoSocial, String cnpj, ServiceContext serviceContext);

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser removido.
	 * @return Response contendo os dados do cliente deletado.
	 */
	public Response deleteClientePjById(long clientePJId);

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Response contendo a lista de todos os clientes.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Response getAllClientes();

	/**
	 * Busca um cliente PJ pelo seu CNPJ.
	 *
	 * @param cnpj CNPJ do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Response getClientePjByCnpj(String cnpj);

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Response getClientePjById(long clientePJId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId ID do cliente a ser atualizado.
	 * @param razaoSocial Nova razão social do cliente.
	 * @param cnpj Novo CNPJ do cliente.
	 * @return Response contendo os dados do cliente atualizado.
	 */
	public Response updateClientePj(
		long clientePJId, String razaoSocial, String cnpj);

}