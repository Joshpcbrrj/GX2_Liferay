/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.SolicitacaoServico;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SolicitacaoServico. This utility wraps
 * <code>br.com.gx2.service.impl.SolicitacaoServicoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoLocalService
 * @generated
 */
public class SolicitacaoServicoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.gx2.service.impl.SolicitacaoServicoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static SolicitacaoServico addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao, int status,
			int prioridade,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSolicitacaoServico(
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
	public static SolicitacaoServico addSolicitacaoServico(
		SolicitacaoServico solicitacaoServico) {

		return getService().addSolicitacaoServico(solicitacaoServico);
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
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	public static SolicitacaoServico createSolicitacaoServico(
		long solicitacaoId) {

		return getService().createSolicitacaoServico(solicitacaoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static SolicitacaoServico deleteSolicitacaoServico(
			long solicitacaoId)
		throws PortalException {

		return getService().deleteSolicitacaoServico(solicitacaoId);
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
	public static SolicitacaoServico deleteSolicitacaoServico(
		SolicitacaoServico solicitacaoServico) {

		return getService().deleteSolicitacaoServico(solicitacaoServico);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
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

	public static SolicitacaoServico fetchSolicitacaoServico(
		long solicitacaoId) {

		return getService().fetchSolicitacaoServico(solicitacaoId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Lista de solicitações de serviço.
	 */
	public static java.util.ArrayList<SolicitacaoServico> getAllSolicitacoes() {
		return getService().getAllSolicitacoes();
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
	 * Returns the solicitacao servico with the primary key.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws PortalException if a solicitacao servico with the primary key could not be found
	 */
	public static SolicitacaoServico getSolicitacaoServico(long solicitacaoId)
		throws PortalException {

		return getService().getSolicitacaoServico(solicitacaoId);
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
	public static List<SolicitacaoServico> getSolicitacaoServicos(
		int start, int end) {

		return getService().getSolicitacaoServicos(start, end);
	}

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	public static int getSolicitacaoServicosCount() {
		return getService().getSolicitacaoServicosCount();
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
	public static SolicitacaoServico updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade)
		throws PortalException {

		return getService().updateSolicitacaoServico(
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
	public static SolicitacaoServico updateSolicitacaoServico(
		SolicitacaoServico solicitacaoServico) {

		return getService().updateSolicitacaoServico(solicitacaoServico);
	}

	public static SolicitacaoServicoLocalService getService() {
		return _service;
	}

	public static void setService(SolicitacaoServicoLocalService service) {
		_service = service;
	}

	private static volatile SolicitacaoServicoLocalService _service;

}