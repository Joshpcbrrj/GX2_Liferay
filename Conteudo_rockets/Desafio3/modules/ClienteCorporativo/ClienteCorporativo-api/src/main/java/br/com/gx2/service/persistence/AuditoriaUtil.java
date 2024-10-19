/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence;

import br.com.gx2.model.Auditoria;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the auditoria service. This utility wraps <code>br.com.gx2.service.persistence.impl.AuditoriaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaPersistence
 * @generated
 */
public class AuditoriaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Auditoria auditoria) {
		getPersistence().clearCache(auditoria);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Auditoria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Auditoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Auditoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Auditoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Auditoria> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Auditoria update(Auditoria auditoria) {
		return getPersistence().update(auditoria);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Auditoria update(
		Auditoria auditoria, ServiceContext serviceContext) {

		return getPersistence().update(auditoria, serviceContext);
	}

	/**
	 * Returns all the auditorias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditorias
	 */
	public static List<Auditoria> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the auditorias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @return the range of matching auditorias
	 */
	public static List<Auditoria> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the auditorias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditorias
	 */
	public static List<Auditoria> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Auditoria> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditorias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditorias
	 */
	public static List<Auditoria> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Auditoria> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditoria
	 * @throws NoSuchAuditoriaException if a matching auditoria could not be found
	 */
	public static Auditoria findByUuid_First(
			String uuid, OrderByComparator<Auditoria> orderByComparator)
		throws br.com.gx2.exception.NoSuchAuditoriaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditoria, or <code>null</code> if a matching auditoria could not be found
	 */
	public static Auditoria fetchByUuid_First(
		String uuid, OrderByComparator<Auditoria> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditoria
	 * @throws NoSuchAuditoriaException if a matching auditoria could not be found
	 */
	public static Auditoria findByUuid_Last(
			String uuid, OrderByComparator<Auditoria> orderByComparator)
		throws br.com.gx2.exception.NoSuchAuditoriaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditoria, or <code>null</code> if a matching auditoria could not be found
	 */
	public static Auditoria fetchByUuid_Last(
		String uuid, OrderByComparator<Auditoria> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the auditorias before and after the current auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param auditoriaId the primary key of the current auditoria
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditoria
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	public static Auditoria[] findByUuid_PrevAndNext(
			long auditoriaId, String uuid,
			OrderByComparator<Auditoria> orderByComparator)
		throws br.com.gx2.exception.NoSuchAuditoriaException {

		return getPersistence().findByUuid_PrevAndNext(
			auditoriaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the auditorias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of auditorias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditorias
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the auditoria in the entity cache if it is enabled.
	 *
	 * @param auditoria the auditoria
	 */
	public static void cacheResult(Auditoria auditoria) {
		getPersistence().cacheResult(auditoria);
	}

	/**
	 * Caches the auditorias in the entity cache if it is enabled.
	 *
	 * @param auditorias the auditorias
	 */
	public static void cacheResult(List<Auditoria> auditorias) {
		getPersistence().cacheResult(auditorias);
	}

	/**
	 * Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	 *
	 * @param auditoriaId the primary key for the new auditoria
	 * @return the new auditoria
	 */
	public static Auditoria create(long auditoriaId) {
		return getPersistence().create(auditoriaId);
	}

	/**
	 * Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	public static Auditoria remove(long auditoriaId)
		throws br.com.gx2.exception.NoSuchAuditoriaException {

		return getPersistence().remove(auditoriaId);
	}

	public static Auditoria updateImpl(Auditoria auditoria) {
		return getPersistence().updateImpl(auditoria);
	}

	/**
	 * Returns the auditoria with the primary key or throws a <code>NoSuchAuditoriaException</code> if it could not be found.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	public static Auditoria findByPrimaryKey(long auditoriaId)
		throws br.com.gx2.exception.NoSuchAuditoriaException {

		return getPersistence().findByPrimaryKey(auditoriaId);
	}

	/**
	 * Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	 */
	public static Auditoria fetchByPrimaryKey(long auditoriaId) {
		return getPersistence().fetchByPrimaryKey(auditoriaId);
	}

	/**
	 * Returns all the auditorias.
	 *
	 * @return the auditorias
	 */
	public static List<Auditoria> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the auditorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @return the range of auditorias
	 */
	public static List<Auditoria> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the auditorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditorias
	 */
	public static List<Auditoria> findAll(
		int start, int end, OrderByComparator<Auditoria> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auditorias
	 */
	public static List<Auditoria> findAll(
		int start, int end, OrderByComparator<Auditoria> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the auditorias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of auditorias.
	 *
	 * @return the number of auditorias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuditoriaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AuditoriaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AuditoriaPersistence _persistence;

}