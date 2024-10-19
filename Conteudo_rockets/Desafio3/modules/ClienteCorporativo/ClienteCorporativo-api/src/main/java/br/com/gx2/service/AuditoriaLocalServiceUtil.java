/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.Auditoria;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Auditoria. This utility wraps
 * <code>br.com.gx2.service.impl.AuditoriaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaLocalService
 * @generated
 */
public class AuditoriaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.gx2.service.impl.AuditoriaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Auditoria addAuditoria(Auditoria auditoria) {
		return getService().addAuditoria(auditoria);
	}

	/**
	 * Adiciona uma nova entrada de auditoria ao banco de dados com parâmetros adicionais.
	 *
	 * @param auditoria a auditoria a ser adicionada
	 * @param serviceContext o contexto do serviço
	 * @return a auditoria adicionada
	 * @throws PortalException se ocorrer uma exceção de portal
	 */
	public static Auditoria addAuditoria(
			Auditoria auditoria,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAuditoria(auditoria, serviceContext);
	}

	/**
	 * Conta o número total de entradas de auditoria.
	 *
	 * @return o total de auditorias
	 */
	public static long countAuditorias() {
		return getService().countAuditorias();
	}

	/**
	 * Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	 *
	 * @param auditoriaId the primary key for the new auditoria
	 * @return the new auditoria
	 */
	public static Auditoria createAuditoria(long auditoriaId) {
		return getService().createAuditoria(auditoriaId);
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
	 * Deletes the auditoria from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditoriaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditoria the auditoria
	 * @return the auditoria that was removed
	 */
	public static Auditoria deleteAuditoria(Auditoria auditoria) {
		return getService().deleteAuditoria(auditoria);
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
	public static Auditoria deleteAuditoria(long auditoriaId)
		throws PortalException {

		return getService().deleteAuditoria(auditoriaId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.AuditoriaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.AuditoriaModelImpl</code>.
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

	public static Auditoria fetchAuditoria(long auditoriaId) {
		return getService().fetchAuditoria(auditoriaId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the auditoria with the primary key.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria
	 * @throws PortalException if a auditoria with the primary key could not be found
	 */
	public static Auditoria getAuditoria(long auditoriaId)
		throws PortalException {

		return getService().getAuditoria(auditoriaId);
	}

	/**
	 * Recupera uma entrada de auditoria pelo seu ID.
	 *
	 * @param auditoriaId o ID da auditoria
	 * @return a auditoria encontrada
	 * @throws PortalException se a auditoria não for encontrada
	 */
	public static Auditoria getAuditoriaById(long auditoriaId)
		throws PortalException {

		return getService().getAuditoriaById(auditoriaId);
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
	public static List<Auditoria> getAuditorias(int start, int end) {
		return getService().getAuditorias(start, end);
	}

	/**
	 * Returns the number of auditorias.
	 *
	 * @return the number of auditorias
	 */
	public static int getAuditoriasCount() {
		return getService().getAuditoriasCount();
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
	 * Updates the auditoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditoriaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditoria the auditoria
	 * @return the auditoria that was updated
	 */
	public static Auditoria updateAuditoria(Auditoria auditoria) {
		return getService().updateAuditoria(auditoria);
	}

	public static AuditoriaLocalService getService() {
		return _service;
	}

	public static void setService(AuditoriaLocalService service) {
		_service = service;
	}

	private static volatile AuditoriaLocalService _service;

}