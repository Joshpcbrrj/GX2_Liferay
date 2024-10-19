/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.impl;

import br.com.gx2.exception.NoSuchAuditoriaException;
import br.com.gx2.model.Auditoria;
import br.com.gx2.model.AuditoriaTable;
import br.com.gx2.model.impl.AuditoriaImpl;
import br.com.gx2.model.impl.AuditoriaModelImpl;
import br.com.gx2.service.persistence.AuditoriaPersistence;
import br.com.gx2.service.persistence.AuditoriaUtil;
import br.com.gx2.service.persistence.impl.constants.CcorpPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the auditoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuditoriaPersistence.class)
public class AuditoriaPersistenceImpl
	extends BasePersistenceImpl<Auditoria> implements AuditoriaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuditoriaUtil</code> to access the auditoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuditoriaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the auditorias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditorias
	 */
	@Override
	public List<Auditoria> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Auditoria> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Auditoria> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Auditoria> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Auditoria> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Auditoria> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Auditoria> list = null;

		if (useFinderCache) {
			list = (List<Auditoria>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Auditoria auditoria : list) {
					if (!uuid.equals(auditoria.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUDITORIA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditoriaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Auditoria>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditoria
	 * @throws NoSuchAuditoriaException if a matching auditoria could not be found
	 */
	@Override
	public Auditoria findByUuid_First(
			String uuid, OrderByComparator<Auditoria> orderByComparator)
		throws NoSuchAuditoriaException {

		Auditoria auditoria = fetchByUuid_First(uuid, orderByComparator);

		if (auditoria != null) {
			return auditoria;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuditoriaException(sb.toString());
	}

	/**
	 * Returns the first auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditoria, or <code>null</code> if a matching auditoria could not be found
	 */
	@Override
	public Auditoria fetchByUuid_First(
		String uuid, OrderByComparator<Auditoria> orderByComparator) {

		List<Auditoria> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditoria
	 * @throws NoSuchAuditoriaException if a matching auditoria could not be found
	 */
	@Override
	public Auditoria findByUuid_Last(
			String uuid, OrderByComparator<Auditoria> orderByComparator)
		throws NoSuchAuditoriaException {

		Auditoria auditoria = fetchByUuid_Last(uuid, orderByComparator);

		if (auditoria != null) {
			return auditoria;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuditoriaException(sb.toString());
	}

	/**
	 * Returns the last auditoria in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditoria, or <code>null</code> if a matching auditoria could not be found
	 */
	@Override
	public Auditoria fetchByUuid_Last(
		String uuid, OrderByComparator<Auditoria> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Auditoria> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Auditoria[] findByUuid_PrevAndNext(
			long auditoriaId, String uuid,
			OrderByComparator<Auditoria> orderByComparator)
		throws NoSuchAuditoriaException {

		uuid = Objects.toString(uuid, "");

		Auditoria auditoria = findByPrimaryKey(auditoriaId);

		Session session = null;

		try {
			session = openSession();

			Auditoria[] array = new AuditoriaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, auditoria, uuid, orderByComparator, true);

			array[1] = auditoria;

			array[2] = getByUuid_PrevAndNext(
				session, auditoria, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Auditoria getByUuid_PrevAndNext(
		Session session, Auditoria auditoria, String uuid,
		OrderByComparator<Auditoria> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUDITORIA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuditoriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditoria)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Auditoria> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the auditorias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Auditoria auditoria :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditoria);
		}
	}

	/**
	 * Returns the number of auditorias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditorias
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITORIA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"auditoria.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(auditoria.uuid IS NULL OR auditoria.uuid = '')";

	public AuditoriaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Auditoria.class);

		setModelImplClass(AuditoriaImpl.class);
		setModelPKClass(long.class);

		setTable(AuditoriaTable.INSTANCE);
	}

	/**
	 * Caches the auditoria in the entity cache if it is enabled.
	 *
	 * @param auditoria the auditoria
	 */
	@Override
	public void cacheResult(Auditoria auditoria) {
		entityCache.putResult(
			AuditoriaImpl.class, auditoria.getPrimaryKey(), auditoria);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the auditorias in the entity cache if it is enabled.
	 *
	 * @param auditorias the auditorias
	 */
	@Override
	public void cacheResult(List<Auditoria> auditorias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (auditorias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Auditoria auditoria : auditorias) {
			if (entityCache.getResult(
					AuditoriaImpl.class, auditoria.getPrimaryKey()) == null) {

				cacheResult(auditoria);
			}
		}
	}

	/**
	 * Clears the cache for all auditorias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuditoriaImpl.class);

		finderCache.clearCache(AuditoriaImpl.class);
	}

	/**
	 * Clears the cache for the auditoria.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Auditoria auditoria) {
		entityCache.removeResult(AuditoriaImpl.class, auditoria);
	}

	@Override
	public void clearCache(List<Auditoria> auditorias) {
		for (Auditoria auditoria : auditorias) {
			entityCache.removeResult(AuditoriaImpl.class, auditoria);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AuditoriaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuditoriaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	 *
	 * @param auditoriaId the primary key for the new auditoria
	 * @return the new auditoria
	 */
	@Override
	public Auditoria create(long auditoriaId) {
		Auditoria auditoria = new AuditoriaImpl();

		auditoria.setNew(true);
		auditoria.setPrimaryKey(auditoriaId);

		String uuid = PortalUUIDUtil.generate();

		auditoria.setUuid(uuid);

		return auditoria;
	}

	/**
	 * Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	@Override
	public Auditoria remove(long auditoriaId) throws NoSuchAuditoriaException {
		return remove((Serializable)auditoriaId);
	}

	/**
	 * Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	@Override
	public Auditoria remove(Serializable primaryKey)
		throws NoSuchAuditoriaException {

		Session session = null;

		try {
			session = openSession();

			Auditoria auditoria = (Auditoria)session.get(
				AuditoriaImpl.class, primaryKey);

			if (auditoria == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditoriaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auditoria);
		}
		catch (NoSuchAuditoriaException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Auditoria removeImpl(Auditoria auditoria) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auditoria)) {
				auditoria = (Auditoria)session.get(
					AuditoriaImpl.class, auditoria.getPrimaryKeyObj());
			}

			if (auditoria != null) {
				session.delete(auditoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (auditoria != null) {
			clearCache(auditoria);
		}

		return auditoria;
	}

	@Override
	public Auditoria updateImpl(Auditoria auditoria) {
		boolean isNew = auditoria.isNew();

		if (!(auditoria instanceof AuditoriaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(auditoria.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(auditoria);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in auditoria proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Auditoria implementation " +
					auditoria.getClass());
		}

		AuditoriaModelImpl auditoriaModelImpl = (AuditoriaModelImpl)auditoria;

		if (Validator.isNull(auditoria.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			auditoria.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(auditoria);
			}
			else {
				auditoria = (Auditoria)session.merge(auditoria);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AuditoriaImpl.class, auditoriaModelImpl, false, true);

		if (isNew) {
			auditoria.setNew(false);
		}

		auditoria.resetOriginalValues();

		return auditoria;
	}

	/**
	 * Returns the auditoria with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria
	 * @return the auditoria
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	@Override
	public Auditoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditoriaException {

		Auditoria auditoria = fetchByPrimaryKey(primaryKey);

		if (auditoria == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditoriaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auditoria;
	}

	/**
	 * Returns the auditoria with the primary key or throws a <code>NoSuchAuditoriaException</code> if it could not be found.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria
	 * @throws NoSuchAuditoriaException if a auditoria with the primary key could not be found
	 */
	@Override
	public Auditoria findByPrimaryKey(long auditoriaId)
		throws NoSuchAuditoriaException {

		return findByPrimaryKey((Serializable)auditoriaId);
	}

	/**
	 * Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditoriaId the primary key of the auditoria
	 * @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	 */
	@Override
	public Auditoria fetchByPrimaryKey(long auditoriaId) {
		return fetchByPrimaryKey((Serializable)auditoriaId);
	}

	/**
	 * Returns all the auditorias.
	 *
	 * @return the auditorias
	 */
	@Override
	public List<Auditoria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Auditoria> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Auditoria> findAll(
		int start, int end, OrderByComparator<Auditoria> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Auditoria> findAll(
		int start, int end, OrderByComparator<Auditoria> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Auditoria> list = null;

		if (useFinderCache) {
			list = (List<Auditoria>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUDITORIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITORIA;

				sql = sql.concat(AuditoriaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Auditoria>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the auditorias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Auditoria auditoria : findAll()) {
			remove(auditoria);
		}
	}

	/**
	 * Returns the number of auditorias.
	 *
	 * @return the number of auditorias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUDITORIA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "auditoriaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUDITORIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuditoriaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the auditoria persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		AuditoriaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AuditoriaUtil.setPersistence(null);

		entityCache.removeCache(AuditoriaImpl.class.getName());
	}

	@Override
	@Reference(
		target = CcorpPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CcorpPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CcorpPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AUDITORIA =
		"SELECT auditoria FROM Auditoria auditoria";

	private static final String _SQL_SELECT_AUDITORIA_WHERE =
		"SELECT auditoria FROM Auditoria auditoria WHERE ";

	private static final String _SQL_COUNT_AUDITORIA =
		"SELECT COUNT(auditoria) FROM Auditoria auditoria";

	private static final String _SQL_COUNT_AUDITORIA_WHERE =
		"SELECT COUNT(auditoria) FROM Auditoria auditoria WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auditoria.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Auditoria exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Auditoria exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuditoriaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}