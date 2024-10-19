/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence;

import br.com.gx2.exception.NoSuchClientePjException;
import br.com.gx2.model.ClientePj;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cliente pj service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjUtil
 * @generated
 */
@ProviderType
public interface ClientePjPersistence extends BasePersistence<ClientePj> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientePjUtil} to access the cliente pj persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cliente pjs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cliente pjs
	 */
	public java.util.List<ClientePj> findByUuid(String uuid);

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
	public java.util.List<ClientePj> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ClientePj> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
			orderByComparator);

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
	public java.util.List<ClientePj> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	public ClientePj findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
				orderByComparator)
		throws NoSuchClientePjException;

	/**
	 * Returns the first cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public ClientePj fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
			orderByComparator);

	/**
	 * Returns the last cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	public ClientePj findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
				orderByComparator)
		throws NoSuchClientePjException;

	/**
	 * Returns the last cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public ClientePj fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
			orderByComparator);

	/**
	 * Returns the cliente pjs before and after the current cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param clientePJId the primary key of the current cliente pj
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente pj
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	public ClientePj[] findByUuid_PrevAndNext(
			long clientePJId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
				orderByComparator)
		throws NoSuchClientePjException;

	/**
	 * Removes all the cliente pjs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cliente pjs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cliente pjs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cliente pj where cnpj = &#63; or throws a <code>NoSuchClientePjException</code> if it could not be found.
	 *
	 * @param cnpj the cnpj
	 * @return the matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	public ClientePj findByCnpj(String cnpj) throws NoSuchClientePjException;

	/**
	 * Returns the cliente pj where cnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @return the matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public ClientePj fetchByCnpj(String cnpj);

	/**
	 * Returns the cliente pj where cnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	public ClientePj fetchByCnpj(String cnpj, boolean useFinderCache);

	/**
	 * Removes the cliente pj where cnpj = &#63; from the database.
	 *
	 * @param cnpj the cnpj
	 * @return the cliente pj that was removed
	 */
	public ClientePj removeByCnpj(String cnpj) throws NoSuchClientePjException;

	/**
	 * Returns the number of cliente pjs where cnpj = &#63;.
	 *
	 * @param cnpj the cnpj
	 * @return the number of matching cliente pjs
	 */
	public int countByCnpj(String cnpj);

	/**
	 * Caches the cliente pj in the entity cache if it is enabled.
	 *
	 * @param clientePj the cliente pj
	 */
	public void cacheResult(ClientePj clientePj);

	/**
	 * Caches the cliente pjs in the entity cache if it is enabled.
	 *
	 * @param clientePjs the cliente pjs
	 */
	public void cacheResult(java.util.List<ClientePj> clientePjs);

	/**
	 * Creates a new cliente pj with the primary key. Does not add the cliente pj to the database.
	 *
	 * @param clientePJId the primary key for the new cliente pj
	 * @return the new cliente pj
	 */
	public ClientePj create(long clientePJId);

	/**
	 * Removes the cliente pj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj that was removed
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	public ClientePj remove(long clientePJId) throws NoSuchClientePjException;

	public ClientePj updateImpl(ClientePj clientePj);

	/**
	 * Returns the cliente pj with the primary key or throws a <code>NoSuchClientePjException</code> if it could not be found.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	public ClientePj findByPrimaryKey(long clientePJId)
		throws NoSuchClientePjException;

	/**
	 * Returns the cliente pj with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj, or <code>null</code> if a cliente pj with the primary key could not be found
	 */
	public ClientePj fetchByPrimaryKey(long clientePJId);

	/**
	 * Returns all the cliente pjs.
	 *
	 * @return the cliente pjs
	 */
	public java.util.List<ClientePj> findAll();

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
	public java.util.List<ClientePj> findAll(int start, int end);

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
	public java.util.List<ClientePj> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
			orderByComparator);

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
	public java.util.List<ClientePj> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClientePj>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cliente pjs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cliente pjs.
	 *
	 * @return the number of cliente pjs
	 */
	public int countAll();

}