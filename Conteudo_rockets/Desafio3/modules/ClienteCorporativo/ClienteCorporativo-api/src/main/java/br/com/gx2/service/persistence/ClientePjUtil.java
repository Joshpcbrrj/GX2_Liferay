/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence;

import br.com.gx2.model.ClientePj;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cliente pj service. This utility wraps <code>br.com.gx2.service.persistence.impl.ClientePjPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjPersistence
 * @generated
 */
public class ClientePjUtil {

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
	public static void clearCache(ClientePj clientePj) {
		getPersistence().clearCache(clientePj);
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
	public static Map<Serializable, ClientePj> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClientePj> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClientePj> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClientePj> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClientePj> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClientePj update(ClientePj clientePj) {
		return getPersistence().update(clientePj);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClientePj update(
		ClientePj clientePj, ServiceContext serviceContext) {

		return getPersistence().update(clientePj, serviceContext);
	}

	/**
	 * Returns all the cliente pjs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cliente pjs
	 */
	public static List<ClientePj> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cliente pjs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @return the range of matching cliente pjs
	 */
	public static List<ClientePj> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cliente pjs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cliente pjs
	 */
	public static List<ClientePj> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientePj> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cliente pjs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cliente pjs
	 */
	public static List<ClientePj> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientePj> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	public static ClientePj findByUuid_First(
			String uuid, OrderByComparator<ClientePj> orderByComparator)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public static ClientePj fetchByUuid_First(
		String uuid, OrderByComparator<ClientePj> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	public static ClientePj findByUuid_Last(
			String uuid, OrderByComparator<ClientePj> orderByComparator)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public static ClientePj fetchByUuid_Last(
		String uuid, OrderByComparator<ClientePj> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cliente pjs before and after the current cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param clientePJId the primary key of the current cliente pj
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente pj
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	public static ClientePj[] findByUuid_PrevAndNext(
			long clientePJId, String uuid,
			OrderByComparator<ClientePj> orderByComparator)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().findByUuid_PrevAndNext(
			clientePJId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cliente pjs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cliente pjs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cliente pjs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cliente pj where cnpj = &#63; or throws a <code>NoSuchClientePjException</code> if it could not be found.
	 *
	 * @param cnpj the cnpj
	 * @return the matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	public static ClientePj findByCnpj(String cnpj)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().findByCnpj(cnpj);
	}

	/**
	 * Returns the cliente pj where cnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @return the matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public static ClientePj fetchByCnpj(String cnpj) {
		return getPersistence().fetchByCnpj(cnpj);
	}

	/**
	 * Returns the cliente pj where cnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public static ClientePj fetchByCnpj(String cnpj, boolean useFinderCache) {
		return getPersistence().fetchByCnpj(cnpj, useFinderCache);
	}

	/**
	 * Removes the cliente pj where cnpj = &#63; from the database.
	 *
	 * @param cnpj the cnpj
	 * @return the cliente pj that was removed
	 */
	public static ClientePj removeByCnpj(String cnpj)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().removeByCnpj(cnpj);
	}

	/**
	 * Returns the number of cliente pjs where cnpj = &#63;.
	 *
	 * @param cnpj the cnpj
	 * @return the number of matching cliente pjs
	 */
	public static int countByCnpj(String cnpj) {
		return getPersistence().countByCnpj(cnpj);
	}

	/**
	 * Caches the cliente pj in the entity cache if it is enabled.
	 *
	 * @param clientePj the cliente pj
	 */
	public static void cacheResult(ClientePj clientePj) {
		getPersistence().cacheResult(clientePj);
	}

	/**
	 * Caches the cliente pjs in the entity cache if it is enabled.
	 *
	 * @param clientePjs the cliente pjs
	 */
	public static void cacheResult(List<ClientePj> clientePjs) {
		getPersistence().cacheResult(clientePjs);
	}

	/**
	 * Creates a new cliente pj with the primary key. Does not add the cliente pj to the database.
	 *
	 * @param clientePJId the primary key for the new cliente pj
	 * @return the new cliente pj
	 */
	public static ClientePj create(long clientePJId) {
		return getPersistence().create(clientePJId);
	}

	/**
	 * Removes the cliente pj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj that was removed
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	public static ClientePj remove(long clientePJId)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().remove(clientePJId);
	}

	public static ClientePj updateImpl(ClientePj clientePj) {
		return getPersistence().updateImpl(clientePj);
	}

	/**
	 * Returns the cliente pj with the primary key or throws a <code>NoSuchClientePjException</code> if it could not be found.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	public static ClientePj findByPrimaryKey(long clientePJId)
		throws br.com.gx2.exception.NoSuchClientePjException {

		return getPersistence().findByPrimaryKey(clientePJId);
	}

	/**
	 * Returns the cliente pj with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj, or <code>null</code> if a cliente pj with the primary key could not be found
	 */
	public static ClientePj fetchByPrimaryKey(long clientePJId) {
		return getPersistence().fetchByPrimaryKey(clientePJId);
	}

	/**
	 * Returns all the cliente pjs.
	 *
	 * @return the cliente pjs
	 */
	public static List<ClientePj> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cliente pjs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @return the range of cliente pjs
	 */
	public static List<ClientePj> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cliente pjs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cliente pjs
	 */
	public static List<ClientePj> findAll(
		int start, int end, OrderByComparator<ClientePj> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cliente pjs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cliente pjs
	 */
	public static List<ClientePj> findAll(
		int start, int end, OrderByComparator<ClientePj> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cliente pjs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cliente pjs.
	 *
	 * @return the number of cliente pjs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClientePjPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ClientePjPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ClientePjPersistence _persistence;

}