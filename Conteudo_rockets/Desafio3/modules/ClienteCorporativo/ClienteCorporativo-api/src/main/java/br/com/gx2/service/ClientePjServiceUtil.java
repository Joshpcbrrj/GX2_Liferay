/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

/**
 * Provides the remote service utility for ClientePj. This utility wraps
 * <code>br.com.gx2.service.impl.ClientePjServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjService
 * @generated
 */
public class ClientePjServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.gx2.service.impl.ClientePjServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adiciona um novo cliente PJ.
	 *
	 * @param razaoSocial Razão social do cliente.
	 * @param cnpj CNPJ do cliente.
	 * @param serviceContext Contexto do serviço.
	 * @return Response contendo os dados do cliente criado.
	 */
	public static javax.ws.rs.core.Response addClientePj(
		java.lang.String razaoSocial, java.lang.String cnpj,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addClientePj(razaoSocial, cnpj, serviceContext);
	}

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser removido.
	 * @return Response contendo os dados do cliente deletado.
	 */
	public static javax.ws.rs.core.Response deleteClientePjById(
		long clientePJId) {

		return getService().deleteClientePjById(clientePJId);
	}

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Response contendo a lista de todos os clientes.
	 */
	public static javax.ws.rs.core.Response getAllClientes() {
		return getService().getAllClientes();
	}

	/**
	 * Busca um cliente PJ pelo seu CNPJ.
	 *
	 * @param cnpj CNPJ do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	public static javax.ws.rs.core.Response getClientePjByCnpj(
		java.lang.String cnpj) {

		return getService().getClientePjByCnpj(cnpj);
	}

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	public static javax.ws.rs.core.Response getClientePjById(long clientePJId) {
		return getService().getClientePjById(clientePJId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId ID do cliente a ser atualizado.
	 * @param razaoSocial Nova razão social do cliente.
	 * @param cnpj Novo CNPJ do cliente.
	 * @return Response contendo os dados do cliente atualizado.
	 */
	public static javax.ws.rs.core.Response updateClientePj(
		long clientePJId, java.lang.String razaoSocial, java.lang.String cnpj) {

		return getService().updateClientePj(clientePJId, razaoSocial, cnpj);
	}

	public static ClientePjService getService() {
		return _service;
	}

	public static void setService(ClientePjService service) {
		_service = service;
	}

	private static volatile ClientePjService _service;

}