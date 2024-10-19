/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.impl;

import br.com.gx2.exception.NoSuchClientePjException;
import br.com.gx2.model.ClientePj;
import br.com.gx2.model.ClientePjTable;
import br.com.gx2.model.impl.ClientePjImpl;
import br.com.gx2.model.impl.ClientePjModelImpl;
import br.com.gx2.service.persistence.ClientePjPersistence;
import br.com.gx2.service.persistence.ClientePjUtil;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the cliente pj service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClientePjPersistence.class)
public class ClientePjPersistenceImpl
	extends BasePersistenceImpl<ClientePj> implements ClientePjPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClientePjUtil</code> to access the cliente pj persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClientePjImpl.class.getName();

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
	 * Returns all the cliente pjs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cliente pjs
	 */
	@Override
	public List<ClientePj> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientePj> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ClientePj> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientePj> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ClientePj> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ClientePj> orderByComparator,
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

		List<ClientePj> list = null;

		if (useFinderCache) {
			list = (List<ClientePj>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClientePj clientePj : list) {
					if (!uuid.equals(clientePj.getUuid())) {
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

			sb.append(_SQL_SELECT_CLIENTEPJ_WHERE);

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
				sb.append(ClientePjModelImpl.ORDER_BY_JPQL);
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

				list = (List<ClientePj>)QueryUtil.list(
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
	 * Returns the first cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj findByUuid_First(
			String uuid, OrderByComparator<ClientePj> orderByComparator)
		throws NoSuchClientePjException {

		ClientePj clientePj = fetchByUuid_First(uuid, orderByComparator);

		if (clientePj != null) {
			return clientePj;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClientePjException(sb.toString());
	}

	/**
	 * Returns the first cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj fetchByUuid_First(
		String uuid, OrderByComparator<ClientePj> orderByComparator) {

		List<ClientePj> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj findByUuid_Last(
			String uuid, OrderByComparator<ClientePj> orderByComparator)
		throws NoSuchClientePjException {

		ClientePj clientePj = fetchByUuid_Last(uuid, orderByComparator);

		if (clientePj != null) {
			return clientePj;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClientePjException(sb.toString());
	}

	/**
	 * Returns the last cliente pj in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj fetchByUuid_Last(
		String uuid, OrderByComparator<ClientePj> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ClientePj> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ClientePj[] findByUuid_PrevAndNext(
			long clientePJId, String uuid,
			OrderByComparator<ClientePj> orderByComparator)
		throws NoSuchClientePjException {

		uuid = Objects.toString(uuid, "");

		ClientePj clientePj = findByPrimaryKey(clientePJId);

		Session session = null;

		try {
			session = openSession();

			ClientePj[] array = new ClientePjImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, clientePj, uuid, orderByComparator, true);

			array[1] = clientePj;

			array[2] = getByUuid_PrevAndNext(
				session, clientePj, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClientePj getByUuid_PrevAndNext(
		Session session, ClientePj clientePj, String uuid,
		OrderByComparator<ClientePj> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLIENTEPJ_WHERE);

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
			sb.append(ClientePjModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(clientePj)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClientePj> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cliente pjs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ClientePj clientePj :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clientePj);
		}
	}

	/**
	 * Returns the number of cliente pjs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cliente pjs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTEPJ_WHERE);

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
		"clientePj.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(clientePj.uuid IS NULL OR clientePj.uuid = '')";

	private FinderPath _finderPathFetchByCnpj;
	private FinderPath _finderPathCountByCnpj;

	/**
	 * Returns the cliente pj where cnpj = &#63; or throws a <code>NoSuchClientePjException</code> if it could not be found.
	 *
	 * @param cnpj the cnpj
	 * @return the matching cliente pj
	 * @throws NoSuchClientePjException if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj findByCnpj(String cnpj) throws NoSuchClientePjException {
		ClientePj clientePj = fetchByCnpj(cnpj);

		if (clientePj == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("cnpj=");
			sb.append(cnpj);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchClientePjException(sb.toString());
		}

		return clientePj;
	}

	/**
	 * Returns the cliente pj where cnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @return the matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj fetchByCnpj(String cnpj) {
		return fetchByCnpj(cnpj, true);
	}

	/**
	 * Returns the cliente pj where cnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cnpj the cnpj
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cliente pj, or <code>null</code> if a matching cliente pj could not be found
	 */
	@Override
	public ClientePj fetchByCnpj(String cnpj, boolean useFinderCache) {
		cnpj = Objects.toString(cnpj, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {cnpj};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCnpj, finderArgs, this);
		}

		if (result instanceof ClientePj) {
			ClientePj clientePj = (ClientePj)result;

			if (!Objects.equals(cnpj, clientePj.getCnpj())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLIENTEPJ_WHERE);

			boolean bindCnpj = false;

			if (cnpj.isEmpty()) {
				sb.append(_FINDER_COLUMN_CNPJ_CNPJ_3);
			}
			else {
				bindCnpj = true;

				sb.append(_FINDER_COLUMN_CNPJ_CNPJ_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCnpj) {
					queryPos.add(cnpj);
				}

				List<ClientePj> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCnpj, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {cnpj};
							}

							_log.warn(
								"ClientePjPersistenceImpl.fetchByCnpj(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ClientePj clientePj = list.get(0);

					result = clientePj;

					cacheResult(clientePj);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ClientePj)result;
		}
	}

	/**
	 * Removes the cliente pj where cnpj = &#63; from the database.
	 *
	 * @param cnpj the cnpj
	 * @return the cliente pj that was removed
	 */
	@Override
	public ClientePj removeByCnpj(String cnpj) throws NoSuchClientePjException {
		ClientePj clientePj = findByCnpj(cnpj);

		return remove(clientePj);
	}

	/**
	 * Returns the number of cliente pjs where cnpj = &#63;.
	 *
	 * @param cnpj the cnpj
	 * @return the number of matching cliente pjs
	 */
	@Override
	public int countByCnpj(String cnpj) {
		cnpj = Objects.toString(cnpj, "");

		FinderPath finderPath = _finderPathCountByCnpj;

		Object[] finderArgs = new Object[] {cnpj};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLIENTEPJ_WHERE);

			boolean bindCnpj = false;

			if (cnpj.isEmpty()) {
				sb.append(_FINDER_COLUMN_CNPJ_CNPJ_3);
			}
			else {
				bindCnpj = true;

				sb.append(_FINDER_COLUMN_CNPJ_CNPJ_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCnpj) {
					queryPos.add(cnpj);
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

	private static final String _FINDER_COLUMN_CNPJ_CNPJ_2 =
		"clientePj.cnpj = ?";

	private static final String _FINDER_COLUMN_CNPJ_CNPJ_3 =
		"(clientePj.cnpj IS NULL OR clientePj.cnpj = '')";

	public ClientePjPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClientePj.class);

		setModelImplClass(ClientePjImpl.class);
		setModelPKClass(long.class);

		setTable(ClientePjTable.INSTANCE);
	}

	/**
	 * Caches the cliente pj in the entity cache if it is enabled.
	 *
	 * @param clientePj the cliente pj
	 */
	@Override
	public void cacheResult(ClientePj clientePj) {
		entityCache.putResult(
			ClientePjImpl.class, clientePj.getPrimaryKey(), clientePj);

		finderCache.putResult(
			_finderPathFetchByCnpj, new Object[] {clientePj.getCnpj()},
			clientePj);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cliente pjs in the entity cache if it is enabled.
	 *
	 * @param clientePjs the cliente pjs
	 */
	@Override
	public void cacheResult(List<ClientePj> clientePjs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (clientePjs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ClientePj clientePj : clientePjs) {
			if (entityCache.getResult(
					ClientePjImpl.class, clientePj.getPrimaryKey()) == null) {

				cacheResult(clientePj);
			}
		}
	}

	/**
	 * Clears the cache for all cliente pjs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClientePjImpl.class);

		finderCache.clearCache(ClientePjImpl.class);
	}

	/**
	 * Clears the cache for the cliente pj.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClientePj clientePj) {
		entityCache.removeResult(ClientePjImpl.class, clientePj);
	}

	@Override
	public void clearCache(List<ClientePj> clientePjs) {
		for (ClientePj clientePj : clientePjs) {
			entityCache.removeResult(ClientePjImpl.class, clientePj);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ClientePjImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ClientePjImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ClientePjModelImpl clientePjModelImpl) {

		Object[] args = new Object[] {clientePjModelImpl.getCnpj()};

		finderCache.putResult(_finderPathCountByCnpj, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByCnpj, args, clientePjModelImpl);
	}

	/**
	 * Creates a new cliente pj with the primary key. Does not add the cliente pj to the database.
	 *
	 * @param clientePJId the primary key for the new cliente pj
	 * @return the new cliente pj
	 */
	@Override
	public ClientePj create(long clientePJId) {
		ClientePj clientePj = new ClientePjImpl();

		clientePj.setNew(true);
		clientePj.setPrimaryKey(clientePJId);

		String uuid = PortalUUIDUtil.generate();

		clientePj.setUuid(uuid);

		return clientePj;
	}

	/**
	 * Removes the cliente pj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj that was removed
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	@Override
	public ClientePj remove(long clientePJId) throws NoSuchClientePjException {
		return remove((Serializable)clientePJId);
	}

	/**
	 * Removes the cliente pj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cliente pj
	 * @return the cliente pj that was removed
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	@Override
	public ClientePj remove(Serializable primaryKey)
		throws NoSuchClientePjException {

		Session session = null;

		try {
			session = openSession();

			ClientePj clientePj = (ClientePj)session.get(
				ClientePjImpl.class, primaryKey);

			if (clientePj == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientePjException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clientePj);
		}
		catch (NoSuchClientePjException noSuchEntityException) {
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
	protected ClientePj removeImpl(ClientePj clientePj) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clientePj)) {
				clientePj = (ClientePj)session.get(
					ClientePjImpl.class, clientePj.getPrimaryKeyObj());
			}

			if (clientePj != null) {
				session.delete(clientePj);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clientePj != null) {
			clearCache(clientePj);
		}

		return clientePj;
	}

	@Override
	public ClientePj updateImpl(ClientePj clientePj) {
		boolean isNew = clientePj.isNew();

		if (!(clientePj instanceof ClientePjModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clientePj.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(clientePj);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clientePj proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClientePj implementation " +
					clientePj.getClass());
		}

		ClientePjModelImpl clientePjModelImpl = (ClientePjModelImpl)clientePj;

		if (Validator.isNull(clientePj.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			clientePj.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clientePj);
			}
			else {
				clientePj = (ClientePj)session.merge(clientePj);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ClientePjImpl.class, clientePjModelImpl, false, true);

		cacheUniqueFindersCache(clientePjModelImpl);

		if (isNew) {
			clientePj.setNew(false);
		}

		clientePj.resetOriginalValues();

		return clientePj;
	}

	/**
	 * Returns the cliente pj with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	@Override
	public ClientePj findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientePjException {

		ClientePj clientePj = fetchByPrimaryKey(primaryKey);

		if (clientePj == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientePjException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clientePj;
	}

	/**
	 * Returns the cliente pj with the primary key or throws a <code>NoSuchClientePjException</code> if it could not be found.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws NoSuchClientePjException if a cliente pj with the primary key could not be found
	 */
	@Override
	public ClientePj findByPrimaryKey(long clientePJId)
		throws NoSuchClientePjException {

		return findByPrimaryKey((Serializable)clientePJId);
	}

	/**
	 * Returns the cliente pj with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj, or <code>null</code> if a cliente pj with the primary key could not be found
	 */
	@Override
	public ClientePj fetchByPrimaryKey(long clientePJId) {
		return fetchByPrimaryKey((Serializable)clientePJId);
	}

	/**
	 * Returns all the cliente pjs.
	 *
	 * @return the cliente pjs
	 */
	@Override
	public List<ClientePj> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ClientePj> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ClientePj> findAll(
		int start, int end, OrderByComparator<ClientePj> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ClientePj> findAll(
		int start, int end, OrderByComparator<ClientePj> orderByComparator,
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

		List<ClientePj> list = null;

		if (useFinderCache) {
			list = (List<ClientePj>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLIENTEPJ);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTEPJ;

				sql = sql.concat(ClientePjModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClientePj>)QueryUtil.list(
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
	 * Removes all the cliente pjs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClientePj clientePj : findAll()) {
			remove(clientePj);
		}
	}

	/**
	 * Returns the number of cliente pjs.
	 *
	 * @return the number of cliente pjs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLIENTEPJ);

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
		return "clientePJId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLIENTEPJ;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClientePjModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cliente pj persistence.
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

		_finderPathFetchByCnpj = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCnpj",
			new String[] {String.class.getName()}, new String[] {"cnpj"}, true);

		_finderPathCountByCnpj = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCnpj",
			new String[] {String.class.getName()}, new String[] {"cnpj"},
			false);

		ClientePjUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ClientePjUtil.setPersistence(null);

		entityCache.removeCache(ClientePjImpl.class.getName());
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

	private static final String _SQL_SELECT_CLIENTEPJ =
		"SELECT clientePj FROM ClientePj clientePj";

	private static final String _SQL_SELECT_CLIENTEPJ_WHERE =
		"SELECT clientePj FROM ClientePj clientePj WHERE ";

	private static final String _SQL_COUNT_CLIENTEPJ =
		"SELECT COUNT(clientePj) FROM ClientePj clientePj";

	private static final String _SQL_COUNT_CLIENTEPJ_WHERE =
		"SELECT COUNT(clientePj) FROM ClientePj clientePj WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clientePj.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClientePj exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClientePj exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClientePjPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}