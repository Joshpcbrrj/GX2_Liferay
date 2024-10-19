/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClientePjService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjService
 * @generated
 */
public class ClientePjServiceWrapper
	implements ClientePjService, ServiceWrapper<ClientePjService> {

	public ClientePjServiceWrapper() {
		this(null);
	}

	public ClientePjServiceWrapper(ClientePjService clientePjService) {
		_clientePjService = clientePjService;
	}

	/**
	 * Adiciona um novo cliente PJ.
	 *
	 * @param razaoSocial Razão social do cliente.
	 * @param cnpj CNPJ do cliente.
	 * @param serviceContext Contexto do serviço.
	 * @return Response contendo os dados do cliente criado.
	 */
	@Override
	public javax.ws.rs.core.Response addClientePj(
		String razaoSocial, String cnpj,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _clientePjService.addClientePj(
			razaoSocial, cnpj, serviceContext);
	}

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser removido.
	 * @return Response contendo os dados do cliente deletado.
	 */
	@Override
	public javax.ws.rs.core.Response deleteClientePjById(long clientePJId) {
		return _clientePjService.deleteClientePjById(clientePJId);
	}

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Response contendo a lista de todos os clientes.
	 */
	@Override
	public javax.ws.rs.core.Response getAllClientes() {
		return _clientePjService.getAllClientes();
	}

	/**
	 * Busca um cliente PJ pelo seu CNPJ.
	 *
	 * @param cnpj CNPJ do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	@Override
	public javax.ws.rs.core.Response getClientePjByCnpj(String cnpj) {
		return _clientePjService.getClientePjByCnpj(cnpj);
	}

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	@Override
	public javax.ws.rs.core.Response getClientePjById(long clientePJId) {
		return _clientePjService.getClientePjById(clientePJId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientePjService.getOSGiServiceIdentifier();
	}

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId ID do cliente a ser atualizado.
	 * @param razaoSocial Nova razão social do cliente.
	 * @param cnpj Novo CNPJ do cliente.
	 * @return Response contendo os dados do cliente atualizado.
	 */
	@Override
	public javax.ws.rs.core.Response updateClientePj(
		long clientePJId, String razaoSocial, String cnpj) {

		return _clientePjService.updateClientePj(
			clientePJId, razaoSocial, cnpj);
	}

	@Override
	public ClientePjService getWrappedService() {
		return _clientePjService;
	}

	@Override
	public void setWrappedService(ClientePjService clientePjService) {
		_clientePjService = clientePjService;
	}

	private ClientePjService _clientePjService;

}