/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.impl;

import br.com.gx2.exception.NoSuchSolicitacaoServicoException;
import br.com.gx2.model.SolicitacaoServico;
import br.com.gx2.model.SolicitacaoServicoTable;
import br.com.gx2.model.impl.SolicitacaoServicoImpl;
import br.com.gx2.model.impl.SolicitacaoServicoModelImpl;
import br.com.gx2.service.persistence.SolicitacaoServicoPersistence;
import br.com.gx2.service.persistence.SolicitacaoServicoUtil;
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
 * The persistence implementation for the solicitacao servico service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SolicitacaoServicoPersistence.class)
public class SolicitacaoServicoPersistenceImpl
	extends BasePersistenceImpl<SolicitacaoServico>
	implements SolicitacaoServicoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SolicitacaoServicoUtil</code> to access the solicitacao servico persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SolicitacaoServicoImpl.class.getName();

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
	 * Returns all the solicitacao servicos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the solicitacao servicos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @return the range of matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the solicitacao servicos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the solicitacao servicos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator,
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

		List<SolicitacaoServico> list = null;

		if (useFinderCache) {
			list = (List<SolicitacaoServico>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SolicitacaoServico solicitacaoServico : list) {
					if (!uuid.equals(solicitacaoServico.getUuid())) {
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

			sb.append(_SQL_SELECT_SOLICITACAOSERVICO_WHERE);

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
				sb.append(SolicitacaoServicoModelImpl.ORDER_BY_JPQL);
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

				list = (List<SolicitacaoServico>)QueryUtil.list(
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
	 * Returns the first solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico findByUuid_First(
			String uuid,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws NoSuchSolicitacaoServicoException {

		SolicitacaoServico solicitacaoServico = fetchByUuid_First(
			uuid, orderByComparator);

		if (solicitacaoServico != null) {
			return solicitacaoServico;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSolicitacaoServicoException(sb.toString());
	}

	/**
	 * Returns the first solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico fetchByUuid_First(
		String uuid, OrderByComparator<SolicitacaoServico> orderByComparator) {

		List<SolicitacaoServico> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico findByUuid_Last(
			String uuid,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws NoSuchSolicitacaoServicoException {

		SolicitacaoServico solicitacaoServico = fetchByUuid_Last(
			uuid, orderByComparator);

		if (solicitacaoServico != null) {
			return solicitacaoServico;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSolicitacaoServicoException(sb.toString());
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico fetchByUuid_Last(
		String uuid, OrderByComparator<SolicitacaoServico> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SolicitacaoServico> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the solicitacao servicos before and after the current solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param solicitacaoId the primary key of the current solicitacao servico
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico[] findByUuid_PrevAndNext(
			long solicitacaoId, String uuid,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws NoSuchSolicitacaoServicoException {

		uuid = Objects.toString(uuid, "");

		SolicitacaoServico solicitacaoServico = findByPrimaryKey(solicitacaoId);

		Session session = null;

		try {
			session = openSession();

			SolicitacaoServico[] array = new SolicitacaoServicoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, solicitacaoServico, uuid, orderByComparator, true);

			array[1] = solicitacaoServico;

			array[2] = getByUuid_PrevAndNext(
				session, solicitacaoServico, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SolicitacaoServico getByUuid_PrevAndNext(
		Session session, SolicitacaoServico solicitacaoServico, String uuid,
		OrderByComparator<SolicitacaoServico> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SOLICITACAOSERVICO_WHERE);

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
			sb.append(SolicitacaoServicoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						solicitacaoServico)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SolicitacaoServico> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the solicitacao servicos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SolicitacaoServico solicitacaoServico :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(solicitacaoServico);
		}
	}

	/**
	 * Returns the number of solicitacao servicos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching solicitacao servicos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SOLICITACAOSERVICO_WHERE);

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
		"solicitacaoServico.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(solicitacaoServico.uuid IS NULL OR solicitacaoServico.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByClientePJId;
	private FinderPath _finderPathWithoutPaginationFindByClientePJId;
	private FinderPath _finderPathCountByClientePJId;

	/**
	 * Returns all the solicitacao servicos where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @return the matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByClientePJId(long clientePJId) {
		return findByClientePJId(
			clientePJId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the solicitacao servicos where clientePJId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param clientePJId the cliente pj ID
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @return the range of matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end) {

		return findByClientePJId(clientePJId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the solicitacao servicos where clientePJId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param clientePJId the cliente pj ID
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return findByClientePJId(
			clientePJId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the solicitacao servicos where clientePJId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param clientePJId the cliente pj ID
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByClientePJId;
				finderArgs = new Object[] {clientePJId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByClientePJId;
			finderArgs = new Object[] {
				clientePJId, start, end, orderByComparator
			};
		}

		List<SolicitacaoServico> list = null;

		if (useFinderCache) {
			list = (List<SolicitacaoServico>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SolicitacaoServico solicitacaoServico : list) {
					if (clientePJId != solicitacaoServico.getClientePJId()) {
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

			sb.append(_SQL_SELECT_SOLICITACAOSERVICO_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTEPJID_CLIENTEPJID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SolicitacaoServicoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientePJId);

				list = (List<SolicitacaoServico>)QueryUtil.list(
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
	 * Returns the first solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico findByClientePJId_First(
			long clientePJId,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws NoSuchSolicitacaoServicoException {

		SolicitacaoServico solicitacaoServico = fetchByClientePJId_First(
			clientePJId, orderByComparator);

		if (solicitacaoServico != null) {
			return solicitacaoServico;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("clientePJId=");
		sb.append(clientePJId);

		sb.append("}");

		throw new NoSuchSolicitacaoServicoException(sb.toString());
	}

	/**
	 * Returns the first solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico fetchByClientePJId_First(
		long clientePJId,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		List<SolicitacaoServico> list = findByClientePJId(
			clientePJId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico findByClientePJId_Last(
			long clientePJId,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws NoSuchSolicitacaoServicoException {

		SolicitacaoServico solicitacaoServico = fetchByClientePJId_Last(
			clientePJId, orderByComparator);

		if (solicitacaoServico != null) {
			return solicitacaoServico;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("clientePJId=");
		sb.append(clientePJId);

		sb.append("}");

		throw new NoSuchSolicitacaoServicoException(sb.toString());
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	@Override
	public SolicitacaoServico fetchByClientePJId_Last(
		long clientePJId,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		int count = countByClientePJId(clientePJId);

		if (count == 0) {
			return null;
		}

		List<SolicitacaoServico> list = findByClientePJId(
			clientePJId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the solicitacao servicos before and after the current solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param solicitacaoId the primary key of the current solicitacao servico
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico[] findByClientePJId_PrevAndNext(
			long solicitacaoId, long clientePJId,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws NoSuchSolicitacaoServicoException {

		SolicitacaoServico solicitacaoServico = findByPrimaryKey(solicitacaoId);

		Session session = null;

		try {
			session = openSession();

			SolicitacaoServico[] array = new SolicitacaoServicoImpl[3];

			array[0] = getByClientePJId_PrevAndNext(
				session, solicitacaoServico, clientePJId, orderByComparator,
				true);

			array[1] = solicitacaoServico;

			array[2] = getByClientePJId_PrevAndNext(
				session, solicitacaoServico, clientePJId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SolicitacaoServico getByClientePJId_PrevAndNext(
		Session session, SolicitacaoServico solicitacaoServico,
		long clientePJId,
		OrderByComparator<SolicitacaoServico> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SOLICITACAOSERVICO_WHERE);

		sb.append(_FINDER_COLUMN_CLIENTEPJID_CLIENTEPJID_2);

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
			sb.append(SolicitacaoServicoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(clientePJId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						solicitacaoServico)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SolicitacaoServico> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the solicitacao servicos where clientePJId = &#63; from the database.
	 *
	 * @param clientePJId the cliente pj ID
	 */
	@Override
	public void removeByClientePJId(long clientePJId) {
		for (SolicitacaoServico solicitacaoServico :
				findByClientePJId(
					clientePJId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(solicitacaoServico);
		}
	}

	/**
	 * Returns the number of solicitacao servicos where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @return the number of matching solicitacao servicos
	 */
	@Override
	public int countByClientePJId(long clientePJId) {
		FinderPath finderPath = _finderPathCountByClientePJId;

		Object[] finderArgs = new Object[] {clientePJId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SOLICITACAOSERVICO_WHERE);

			sb.append(_FINDER_COLUMN_CLIENTEPJID_CLIENTEPJID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(clientePJId);

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

	private static final String _FINDER_COLUMN_CLIENTEPJID_CLIENTEPJID_2 =
		"solicitacaoServico.clientePJId = ?";

	public SolicitacaoServicoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SolicitacaoServico.class);

		setModelImplClass(SolicitacaoServicoImpl.class);
		setModelPKClass(long.class);

		setTable(SolicitacaoServicoTable.INSTANCE);
	}

	/**
	 * Caches the solicitacao servico in the entity cache if it is enabled.
	 *
	 * @param solicitacaoServico the solicitacao servico
	 */
	@Override
	public void cacheResult(SolicitacaoServico solicitacaoServico) {
		entityCache.putResult(
			SolicitacaoServicoImpl.class, solicitacaoServico.getPrimaryKey(),
			solicitacaoServico);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the solicitacao servicos in the entity cache if it is enabled.
	 *
	 * @param solicitacaoServicos the solicitacao servicos
	 */
	@Override
	public void cacheResult(List<SolicitacaoServico> solicitacaoServicos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (solicitacaoServicos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SolicitacaoServico solicitacaoServico : solicitacaoServicos) {
			if (entityCache.getResult(
					SolicitacaoServicoImpl.class,
					solicitacaoServico.getPrimaryKey()) == null) {

				cacheResult(solicitacaoServico);
			}
		}
	}

	/**
	 * Clears the cache for all solicitacao servicos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SolicitacaoServicoImpl.class);

		finderCache.clearCache(SolicitacaoServicoImpl.class);
	}

	/**
	 * Clears the cache for the solicitacao servico.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SolicitacaoServico solicitacaoServico) {
		entityCache.removeResult(
			SolicitacaoServicoImpl.class, solicitacaoServico);
	}

	@Override
	public void clearCache(List<SolicitacaoServico> solicitacaoServicos) {
		for (SolicitacaoServico solicitacaoServico : solicitacaoServicos) {
			entityCache.removeResult(
				SolicitacaoServicoImpl.class, solicitacaoServico);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SolicitacaoServicoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SolicitacaoServicoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	@Override
	public SolicitacaoServico create(long solicitacaoId) {
		SolicitacaoServico solicitacaoServico = new SolicitacaoServicoImpl();

		solicitacaoServico.setNew(true);
		solicitacaoServico.setPrimaryKey(solicitacaoId);

		String uuid = PortalUUIDUtil.generate();

		solicitacaoServico.setUuid(uuid);

		return solicitacaoServico;
	}

	/**
	 * Removes the solicitacao servico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico that was removed
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico remove(long solicitacaoId)
		throws NoSuchSolicitacaoServicoException {

		return remove((Serializable)solicitacaoId);
	}

	/**
	 * Removes the solicitacao servico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the solicitacao servico
	 * @return the solicitacao servico that was removed
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico remove(Serializable primaryKey)
		throws NoSuchSolicitacaoServicoException {

		Session session = null;

		try {
			session = openSession();

			SolicitacaoServico solicitacaoServico =
				(SolicitacaoServico)session.get(
					SolicitacaoServicoImpl.class, primaryKey);

			if (solicitacaoServico == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSolicitacaoServicoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(solicitacaoServico);
		}
		catch (NoSuchSolicitacaoServicoException noSuchEntityException) {
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
	protected SolicitacaoServico removeImpl(
		SolicitacaoServico solicitacaoServico) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(solicitacaoServico)) {
				solicitacaoServico = (SolicitacaoServico)session.get(
					SolicitacaoServicoImpl.class,
					solicitacaoServico.getPrimaryKeyObj());
			}

			if (solicitacaoServico != null) {
				session.delete(solicitacaoServico);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (solicitacaoServico != null) {
			clearCache(solicitacaoServico);
		}

		return solicitacaoServico;
	}

	@Override
	public SolicitacaoServico updateImpl(
		SolicitacaoServico solicitacaoServico) {

		boolean isNew = solicitacaoServico.isNew();

		if (!(solicitacaoServico instanceof SolicitacaoServicoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(solicitacaoServico.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					solicitacaoServico);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in solicitacaoServico proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SolicitacaoServico implementation " +
					solicitacaoServico.getClass());
		}

		SolicitacaoServicoModelImpl solicitacaoServicoModelImpl =
			(SolicitacaoServicoModelImpl)solicitacaoServico;

		if (Validator.isNull(solicitacaoServico.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			solicitacaoServico.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(solicitacaoServico);
			}
			else {
				solicitacaoServico = (SolicitacaoServico)session.merge(
					solicitacaoServico);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SolicitacaoServicoImpl.class, solicitacaoServicoModelImpl, false,
			true);

		if (isNew) {
			solicitacaoServico.setNew(false);
		}

		solicitacaoServico.resetOriginalValues();

		return solicitacaoServico;
	}

	/**
	 * Returns the solicitacao servico with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSolicitacaoServicoException {

		SolicitacaoServico solicitacaoServico = fetchByPrimaryKey(primaryKey);

		if (solicitacaoServico == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSolicitacaoServicoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return solicitacaoServico;
	}

	/**
	 * Returns the solicitacao servico with the primary key or throws a <code>NoSuchSolicitacaoServicoException</code> if it could not be found.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico findByPrimaryKey(long solicitacaoId)
		throws NoSuchSolicitacaoServicoException {

		return findByPrimaryKey((Serializable)solicitacaoId);
	}

	/**
	 * Returns the solicitacao servico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico, or <code>null</code> if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico fetchByPrimaryKey(long solicitacaoId) {
		return fetchByPrimaryKey((Serializable)solicitacaoId);
	}

	/**
	 * Returns all the solicitacao servicos.
	 *
	 * @return the solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the solicitacao servicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @return the range of solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the solicitacao servicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findAll(
		int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the solicitacao servicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of solicitacao servicos
	 */
	@Override
	public List<SolicitacaoServico> findAll(
		int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator,
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

		List<SolicitacaoServico> list = null;

		if (useFinderCache) {
			list = (List<SolicitacaoServico>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SOLICITACAOSERVICO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SOLICITACAOSERVICO;

				sql = sql.concat(SolicitacaoServicoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SolicitacaoServico>)QueryUtil.list(
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
	 * Removes all the solicitacao servicos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SolicitacaoServico solicitacaoServico : findAll()) {
			remove(solicitacaoServico);
		}
	}

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_SOLICITACAOSERVICO);

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
		return "solicitacaoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SOLICITACAOSERVICO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SolicitacaoServicoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the solicitacao servico persistence.
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

		_finderPathWithPaginationFindByClientePJId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClientePJId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"clientePJId"}, true);

		_finderPathWithoutPaginationFindByClientePJId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClientePJId",
			new String[] {Long.class.getName()}, new String[] {"clientePJId"},
			true);

		_finderPathCountByClientePJId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientePJId",
			new String[] {Long.class.getName()}, new String[] {"clientePJId"},
			false);

		SolicitacaoServicoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SolicitacaoServicoUtil.setPersistence(null);

		entityCache.removeCache(SolicitacaoServicoImpl.class.getName());
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

	private static final String _SQL_SELECT_SOLICITACAOSERVICO =
		"SELECT solicitacaoServico FROM SolicitacaoServico solicitacaoServico";

	private static final String _SQL_SELECT_SOLICITACAOSERVICO_WHERE =
		"SELECT solicitacaoServico FROM SolicitacaoServico solicitacaoServico WHERE ";

	private static final String _SQL_COUNT_SOLICITACAOSERVICO =
		"SELECT COUNT(solicitacaoServico) FROM SolicitacaoServico solicitacaoServico";

	private static final String _SQL_COUNT_SOLICITACAOSERVICO_WHERE =
		"SELECT COUNT(solicitacaoServico) FROM SolicitacaoServico solicitacaoServico WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "solicitacaoServico.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SolicitacaoServico exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SolicitacaoServico exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SolicitacaoServicoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}