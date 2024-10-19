/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ClientePjLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjLocalService
 * @generated
 */
public class ClientePjLocalServiceWrapper
	implements ClientePjLocalService, ServiceWrapper<ClientePjLocalService> {

	public ClientePjLocalServiceWrapper() {
		this(null);
	}

	public ClientePjLocalServiceWrapper(
		ClientePjLocalService clientePjLocalService) {

		_clientePjLocalService = clientePjLocalService;
	}

	/**
	 * Adds the cliente pj to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePj the cliente pj
	 * @return the cliente pj that was added
	 */
	@Override
	public br.com.gx2.model.ClientePj addClientePj(
		br.com.gx2.model.ClientePj clientePj) {

		return _clientePjLocalService.addClientePj(clientePj);
	}

	/**
	 * Adiciona um novo cliente PJ ao banco de dados.
	 *
	 * @param razaoSocial A razão social do cliente.
	 * @param cnpj O CNPJ do cliente.
	 * @param serviceContext O contexto do serviço, utilizado para informações adicionais.
	 * @return O objeto ClientePj criado.
	 * @throws PortalException Se ocorrer um erro durante o processo de criação.
	 */
	@Override
	public br.com.gx2.model.ClientePj addClientePj(
			String razaoSocial, String cnpj,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.addClientePj(
			razaoSocial, cnpj, serviceContext);
	}

	/**
	 * Creates a new cliente pj with the primary key. Does not add the cliente pj to the database.
	 *
	 * @param clientePJId the primary key for the new cliente pj
	 * @return the new cliente pj
	 */
	@Override
	public br.com.gx2.model.ClientePj createClientePj(long clientePJId) {
		return _clientePjLocalService.createClientePj(clientePJId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cliente pj from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePj the cliente pj
	 * @return the cliente pj that was removed
	 */
	@Override
	public br.com.gx2.model.ClientePj deleteClientePj(
		br.com.gx2.model.ClientePj clientePj) {

		return _clientePjLocalService.deleteClientePj(clientePj);
	}

	/**
	 * Deletes the cliente pj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj that was removed
	 * @throws PortalException if a cliente pj with the primary key could not be found
	 */
	@Override
	public br.com.gx2.model.ClientePj deleteClientePj(long clientePJId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.deleteClientePj(clientePJId);
	}

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser deletado.
	 * @return O objeto ClientePj deletado.
	 * @throws PortalException Se ocorrer um erro durante a deleção ou se o cliente não for encontrado.
	 */
	@Override
	public br.com.gx2.model.ClientePj deleteClientePjById(long clientePjId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.deleteClientePjById(clientePjId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _clientePjLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _clientePjLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clientePjLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _clientePjLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _clientePjLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _clientePjLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _clientePjLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _clientePjLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.gx2.model.ClientePj fetchClientePj(long clientePJId) {
		return _clientePjLocalService.fetchClientePj(clientePJId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clientePjLocalService.getActionableDynamicQuery();
	}

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Lista de todos os clientes PJ.
	 */
	@Override
	public java.util.List<br.com.gx2.model.ClientePj> getAllClientes() {
		return _clientePjLocalService.getAllClientes();
	}

	/**
	 * Returns the cliente pj with the primary key.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws PortalException if a cliente pj with the primary key could not be found
	 */
	@Override
	public br.com.gx2.model.ClientePj getClientePj(long clientePJId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.getClientePj(clientePJId);
	}

	/**
	 * Busca um cliente PJ pelo CNPJ.
	 * Utiliza paginação para garantir que apenas 1 resultado seja retornado.
	 *
	 * @param cnpj O CNPJ do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	@Override
	public br.com.gx2.model.ClientePj getClientePjByCnpj(String cnpj) {
		return _clientePjLocalService.getClientePjByCnpj(cnpj);
	}

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	@Override
	public br.com.gx2.model.ClientePj getClientePjById(long clientePjId) {
		return _clientePjLocalService.getClientePjById(clientePjId);
	}

	/**
	 * Returns a range of all the cliente pjs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @return the range of cliente pjs
	 */
	@Override
	public java.util.List<br.com.gx2.model.ClientePj> getClientePjs(
		int start, int end) {

		return _clientePjLocalService.getClientePjs(start, end);
	}

	/**
	 * Returns the number of cliente pjs.
	 *
	 * @return the number of cliente pjs
	 */
	@Override
	public int getClientePjsCount() {
		return _clientePjLocalService.getClientePjsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clientePjLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clientePjLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cliente pj in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePj the cliente pj
	 * @return the cliente pj that was updated
	 */
	@Override
	public br.com.gx2.model.ClientePj updateClientePj(
		br.com.gx2.model.ClientePj clientePj) {

		return _clientePjLocalService.updateClientePj(clientePj);
	}

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId O ID do cliente PJ a ser atualizado.
	 * @param razaoSocial A nova razão social do cliente.
	 * @param cnpj O novo CNPJ do cliente.
	 * @return O objeto ClientePj atualizado.
	 * @throws PortalException Se ocorrer um erro durante a atualização ou se o cliente não for encontrado.
	 */
	@Override
	public br.com.gx2.model.ClientePj updateClientePj(
			long clientePJId, String razaoSocial, String cnpj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clientePjLocalService.updateClientePj(
			clientePJId, razaoSocial, cnpj);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _clientePjLocalService.getBasePersistence();
	}

	@Override
	public ClientePjLocalService getWrappedService() {
		return _clientePjLocalService;
	}

	@Override
	public void setWrappedService(ClientePjLocalService clientePjLocalService) {
		_clientePjLocalService = clientePjLocalService;
	}

	private ClientePjLocalService _clientePjLocalService;

}