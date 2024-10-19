/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence;

import br.com.gx2.exception.NoSuchAuditoriaException;
import br.com.gx2.model.Auditoria;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the auditoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaUtil
 * @generated
 */
@ProviderType
public interface AuditoriaPersistence extends BasePersistence<Auditoria> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditoriaUtil} to access the auditoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the auditorias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditorias
	 */
	public java.util.List<Auditoria> findByUuid(String uuid);

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
	public java.util.List<Auditoria> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Auditoria> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
			orderByComparator);

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
	public java.util.List<Auditoria> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditoria
	 * @throws NoSuchAuditoriaException if a matching auditoria could not be found
	 */
	public Auditoria findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
				orderByComparator)
		throws NoSuchAuditoriaException;

	/**
	 * Returns the first auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditoria, or <code>null</code> if a matching auditoria could not be found
	 */
	public Auditoria fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
			orderByComparator);

	/**
	 * Returns the last auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditoria
	 * @throws NoSuchAuditoriaException if a matching auditoria could not be found
	 */
	public Auditoria findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
				orderByComparator)
		throws NoSuchAuditoriaException;

	/**
	 * Returns the last auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditoria, or <code>null</code> if a matching auditoria could not be found
	 */
	public Auditoria fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
			orderByComparator);

	/**
	 * Returns the auditorias before and after the current auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param auditoriaId the primary key of the current auditoria
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditoria
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	public Auditoria[] findByUuid_PrevAndNext(
			long auditoriaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
				orderByComparator)
		throws NoSuchAuditoriaException;

	/**
	 * Removes all the auditorias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of auditorias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditorias
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the auditoria in the entity cache if it is enabled.
	 *
	 * @param auditoria the auditoria
	 */
	public void cacheResult(Auditoria auditoria);

	/**
	 * Caches the auditorias in the entity cache if it is enabled.
	 *
	 * @param auditorias the auditorias
	 */
	public void cacheResult(java.util.List<Auditoria> auditorias);

	/**
	 * Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	 *
	 * @param auditoriaId the primary key for the new auditoria
	 * @return the new auditoria
	 */
	public Auditoria create(long auditoriaId);

	/**
	 * Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	public Auditoria remove(long auditoriaId) throws NoSuchAuditoriaException;

	public Auditoria updateImpl(Auditoria auditoria);

	/**
	 * Returns the auditoria with the primary key or throws a <code>NoSuchAuditoriaException</code> if it could not be found.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	public Auditoria findByPrimaryKey(long auditoriaId)
		throws NoSuchAuditoriaException;

	/**
	 * Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	 */
	public Auditoria fetchByPrimaryKey(long auditoriaId);

	/**
	 * Returns all the auditorias.
	 *
	 * @return the auditorias
	 */
	public java.util.List<Auditoria> findAll();

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
	public java.util.List<Auditoria> findAll(int start, int end);

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
	public java.util.List<Auditoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
			orderByComparator);

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
	public java.util.List<Auditoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditoria>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the auditorias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of auditorias.
	 *
	 * @return the number of auditorias
	 */
	public int countAll();

}