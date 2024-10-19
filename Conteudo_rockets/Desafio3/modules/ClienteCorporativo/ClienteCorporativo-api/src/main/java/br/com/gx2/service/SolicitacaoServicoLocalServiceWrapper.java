/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SolicitacaoServicoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoLocalService
 * @generated
 */
public class SolicitacaoServicoLocalServiceWrapper
	implements ServiceWrapper<SolicitacaoServicoLocalService>,
			   SolicitacaoServicoLocalService {

	public SolicitacaoServicoLocalServiceWrapper() {
		this(null);
	}

	public SolicitacaoServicoLocalServiceWrapper(
		SolicitacaoServicoLocalService solicitacaoServicoLocalService) {

		_solicitacaoServicoLocalService = solicitacaoServicoLocalService;
	}

	/**
	 * Cria uma nova solicitação de serviço.
	 *
	 * @param clientePJId O ID do cliente PJ relacionado.
	 * @param codigoUnimed O código Unimed da solicitação.
	 * @param descricao A descrição da solicitação.
	 * @param status A situação da solicitação.
	 * @param prioridade A prioridade da solicitação.
	 * @param serviceContext O contexto do serviço.
	 * @return A solicitação de serviço criada.
	 * @throws PortalException Se ocorrer um erro durante a criação.
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao, int status,
			int prioridade,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.addSolicitacaoServico(
			clientePJId, codigoUnimed, descricao, status, prioridade,
			serviceContext);
	}

	/**
	 * Adds the solicitacao servico to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoServico the solicitacao servico
	 * @return the solicitacao servico that was added
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico addSolicitacaoServico(
		br.com.gx2.model.SolicitacaoServico solicitacaoServico) {

		return _solicitacaoServicoLocalService.addSolicitacaoServico(
			solicitacaoServico);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico createSolicitacaoServico(
		long solicitacaoId) {

		return _solicitacaoServicoLocalService.createSolicitacaoServico(
			solicitacaoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the solicitacao servico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico that was removed
	 * @throws PortalException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico deleteSolicitacaoServico(
			long solicitacaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.deleteSolicitacaoServico(
			solicitacaoId);
	}

	/**
	 * Deletes the solicitacao servico from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoServico the solicitacao servico
	 * @return the solicitacao servico that was removed
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico deleteSolicitacaoServico(
		br.com.gx2.model.SolicitacaoServico solicitacaoServico) {

		return _solicitacaoServicoLocalService.deleteSolicitacaoServico(
			solicitacaoServico);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _solicitacaoServicoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _solicitacaoServicoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _solicitacaoServicoLocalService.dynamicQuery();
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

		return _solicitacaoServicoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
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

		return _solicitacaoServicoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
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

		return _solicitacaoServicoLocalService.dynamicQuery(
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

		return _solicitacaoServicoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _solicitacaoServicoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.gx2.model.SolicitacaoServico fetchSolicitacaoServico(
		long solicitacaoId) {

		return _solicitacaoServicoLocalService.fetchSolicitacaoServico(
			solicitacaoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _solicitacaoServicoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Lista de solicitações de serviço.
	 */
	@Override
	public java.util.ArrayList<br.com.gx2.model.SolicitacaoServico>
		getAllSolicitacoes() {

		return _solicitacaoServicoLocalService.getAllSolicitacoes();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _solicitacaoServicoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _solicitacaoServicoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the solicitacao servico with the primary key.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws PortalException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico getSolicitacaoServico(
			long solicitacaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.getSolicitacaoServico(
			solicitacaoId);
	}

	/**
	 * Returns a range of all the solicitacao servicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @return the range of solicitacao servicos
	 */
	@Override
	public java.util.List<br.com.gx2.model.SolicitacaoServico>
		getSolicitacaoServicos(int start, int end) {

		return _solicitacaoServicoLocalService.getSolicitacaoServicos(
			start, end);
	}

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	@Override
	public int getSolicitacaoServicosCount() {
		return _solicitacaoServicoLocalService.getSolicitacaoServicosCount();
	}

	/**
	 * Atualiza uma solicitação de serviço existente.
	 *
	 * @param solicitacaoId O ID da solicitação de serviço a ser atualizada.
	 * @param codigoUnimed O novo código Unimed da solicitação.
	 * @param descricao A nova descrição da solicitação.
	 * @param status A nova situação da solicitação.
	 * @param prioridade A nova prioridade da solicitação.
	 * @return A solicitação de serviço atualizada.
	 * @throws PortalException Se a solicitação de serviço não for encontrada.
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _solicitacaoServicoLocalService.updateSolicitacaoServico(
			solicitacaoId, codigoUnimed, descricao, status, prioridade);
	}

	/**
	 * Updates the solicitacao servico in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoServico the solicitacao servico
	 * @return the solicitacao servico that was updated
	 */
	@Override
	public br.com.gx2.model.SolicitacaoServico updateSolicitacaoServico(
		br.com.gx2.model.SolicitacaoServico solicitacaoServico) {

		return _solicitacaoServicoLocalService.updateSolicitacaoServico(
			solicitacaoServico);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _solicitacaoServicoLocalService.getBasePersistence();
	}

	@Override
	public SolicitacaoServicoLocalService getWrappedService() {
		return _solicitacaoServicoLocalService;
	}

	@Override
	public void setWrappedService(
		SolicitacaoServicoLocalService solicitacaoServicoLocalService) {

		_solicitacaoServicoLocalService = solicitacaoServicoLocalService;
	}

	private SolicitacaoServicoLocalService _solicitacaoServicoLocalService;

}