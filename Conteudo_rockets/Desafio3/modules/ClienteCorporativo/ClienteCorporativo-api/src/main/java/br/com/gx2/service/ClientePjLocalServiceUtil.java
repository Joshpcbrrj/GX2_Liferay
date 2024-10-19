/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.ClientePj;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ClientePj. This utility wraps
 * <code>br.com.gx2.service.impl.ClientePjLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjLocalService
 * @generated
 */
public class ClientePjLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.gx2.service.impl.ClientePjLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ClientePj addClientePj(ClientePj clientePj) {
		return getService().addClientePj(clientePj);
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
	public static ClientePj addClientePj(
			String razaoSocial, String cnpj,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addClientePj(razaoSocial, cnpj, serviceContext);
	}

	/**
	 * Creates a new cliente pj with the primary key. Does not add the cliente pj to the database.
	 *
	 * @param clientePJId the primary key for the new cliente pj
	 * @return the new cliente pj
	 */
	public static ClientePj createClientePj(long clientePJId) {
		return getService().createClientePj(clientePJId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ClientePj deleteClientePj(ClientePj clientePj) {
		return getService().deleteClientePj(clientePj);
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
	public static ClientePj deleteClientePj(long clientePJId)
		throws PortalException {

		return getService().deleteClientePj(clientePJId);
	}

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser deletado.
	 * @return O objeto ClientePj deletado.
	 * @throws PortalException Se ocorrer um erro durante a deleção ou se o cliente não for encontrado.
	 */
	public static ClientePj deleteClientePjById(long clientePjId)
		throws PortalException {

		return getService().deleteClientePjById(clientePjId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ClientePj fetchClientePj(long clientePJId) {
		return getService().fetchClientePj(clientePJId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Lista de todos os clientes PJ.
	 */
	public static List<ClientePj> getAllClientes() {
		return getService().getAllClientes();
	}

	/**
	 * Returns the cliente pj with the primary key.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws PortalException if a cliente pj with the primary key could not be found
	 */
	public static ClientePj getClientePj(long clientePJId)
		throws PortalException {

		return getService().getClientePj(clientePJId);
	}

	/**
	 * Busca um cliente PJ pelo CNPJ.
	 * Utiliza paginação para garantir que apenas 1 resultado seja retornado.
	 *
	 * @param cnpj O CNPJ do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	public static ClientePj getClientePjByCnpj(String cnpj) {
		return getService().getClientePjByCnpj(cnpj);
	}

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	public static ClientePj getClientePjById(long clientePjId) {
		return getService().getClientePjById(clientePjId);
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
	public static List<ClientePj> getClientePjs(int start, int end) {
		return getService().getClientePjs(start, end);
	}

	/**
	 * Returns the number of cliente pjs.
	 *
	 * @return the number of cliente pjs
	 */
	public static int getClientePjsCount() {
		return getService().getClientePjsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static ClientePj updateClientePj(ClientePj clientePj) {
		return getService().updateClientePj(clientePj);
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
	public static ClientePj updateClientePj(
			long clientePJId, String razaoSocial, String cnpj)
		throws PortalException {

		return getService().updateClientePj(clientePJId, razaoSocial, cnpj);
	}

	public static ClientePjLocalService getService() {
		return _service;
	}

	public static void setService(ClientePjLocalService service) {
		_service = service;
	}

	private static volatile ClientePjLocalService _service;

}