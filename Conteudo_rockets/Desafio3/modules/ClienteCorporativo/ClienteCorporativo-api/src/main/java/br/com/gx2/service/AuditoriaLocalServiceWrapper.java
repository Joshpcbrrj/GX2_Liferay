/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AuditoriaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaLocalService
 * @generated
 */
public class AuditoriaLocalServiceWrapper
	implements AuditoriaLocalService, ServiceWrapper<AuditoriaLocalService> {

	public AuditoriaLocalServiceWrapper() {
		this(null);
	}

	public AuditoriaLocalServiceWrapper(
		AuditoriaLocalService auditoriaLocalService) {

		_auditoriaLocalService = auditoriaLocalService;
	}

	/**
	 * Adds the auditoria to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditoriaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditoria the auditoria
	 * @return the auditoria that was added
	 */
	@Override
	public br.com.gx2.model.Auditoria addAuditoria(
		br.com.gx2.model.Auditoria auditoria) {

		return _auditoriaLocalService.addAuditoria(auditoria);
	}

	/**
	 * Adiciona uma nova entrada de auditoria ao banco de dados com parâmetros adicionais.
	 *
	 * @param auditoria a auditoria a ser adicionada
	 * @param serviceContext o contexto do serviço
	 * @return a auditoria adicionada
	 * @throws PortalException se ocorrer uma exceção de portal
	 */
	@Override
	public br.com.gx2.model.Auditoria addAuditoria(
			br.com.gx2.model.Auditoria auditoria,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.addAuditoria(auditoria, serviceContext);
	}

	/**
	 * Conta o número total de entradas de auditoria.
	 *
	 * @return o total de auditorias
	 */
	@Override
	public long countAuditorias() {
		return _auditoriaLocalService.countAuditorias();
	}

	/**
	 * Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	 *
	 * @param auditoriaId the primary key for the new auditoria
	 * @return the new auditoria
	 */
	@Override
	public br.com.gx2.model.Auditoria createAuditoria(long auditoriaId) {
		return _auditoriaLocalService.createAuditoria(auditoriaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the auditoria from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditoriaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditoria the auditoria
	 * @return the auditoria that was removed
	 */
	@Override
	public br.com.gx2.model.Auditoria deleteAuditoria(
		br.com.gx2.model.Auditoria auditoria) {

		return _auditoriaLocalService.deleteAuditoria(auditoria);
	}

	/**
	 * Deletes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditoriaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws PortalException if a auditoria with the primary key could not be found
	 */
	@Override
	public br.com.gx2.model.Auditoria deleteAuditoria(long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.deleteAuditoria(auditoriaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _auditoriaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _auditoriaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditoriaLocalService.dynamicQuery();
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

		return _auditoriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.AuditoriaModelImpl</code>.
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

		return _auditoriaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.AuditoriaModelImpl</code>.
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

		return _auditoriaLocalService.dynamicQuery(
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

		return _auditoriaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _auditoriaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.gx2.model.Auditoria fetchAuditoria(long auditoriaId) {
		return _auditoriaLocalService.fetchAuditoria(auditoriaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _auditoriaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the auditoria with the primary key.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria
	 * @throws PortalException if a auditoria with the primary key could not be found
	 */
	@Override
	public br.com.gx2.model.Auditoria getAuditoria(long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.getAuditoria(auditoriaId);
	}

	/**
	 * Recupera uma entrada de auditoria pelo seu ID.
	 *
	 * @param auditoriaId o ID da auditoria
	 * @return a auditoria encontrada
	 * @throws PortalException se a auditoria não for encontrada
	 */
	@Override
	public br.com.gx2.model.Auditoria getAuditoriaById(long auditoriaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.getAuditoriaById(auditoriaId);
	}

	/**
	 * Returns a range of all the auditorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @return the range of auditorias
	 */
	@Override
	public java.util.List<br.com.gx2.model.Auditoria> getAuditorias(
		int start, int end) {

		return _auditoriaLocalService.getAuditorias(start, end);
	}

	/**
	 * Returns the number of auditorias.
	 *
	 * @return the number of auditorias
	 */
	@Override
	public int getAuditoriasCount() {
		return _auditoriaLocalService.getAuditoriasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _auditoriaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditoriaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditoriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the auditoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditoriaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditoria the auditoria
	 * @return the auditoria that was updated
	 */
	@Override
	public br.com.gx2.model.Auditoria updateAuditoria(
		br.com.gx2.model.Auditoria auditoria) {

		return _auditoriaLocalService.updateAuditoria(auditoria);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _auditoriaLocalService.getBasePersistence();
	}

	@Override
	public AuditoriaLocalService getWrappedService() {
		return _auditoriaLocalService;
	}

	@Override
	public void setWrappedService(AuditoriaLocalService auditoriaLocalService) {
		_auditoriaLocalService = auditoriaLocalService;
	}

	private AuditoriaLocalService _auditoriaLocalService;

}