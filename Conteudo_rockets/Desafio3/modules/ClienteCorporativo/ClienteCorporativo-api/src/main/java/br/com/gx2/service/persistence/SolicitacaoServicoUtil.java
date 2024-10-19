/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence;

import br.com.gx2.model.SolicitacaoServico;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the solicitacao servico service. This utility wraps <code>br.com.gx2.service.persistence.impl.SolicitacaoServicoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoPersistence
 * @generated
 */
public class SolicitacaoServicoUtil {

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
	public static void clearCache(SolicitacaoServico solicitacaoServico) {
		getPersistence().clearCache(solicitacaoServico);
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
	public static Map<Serializable, SolicitacaoServico> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SolicitacaoServico> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SolicitacaoServico> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SolicitacaoServico> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SolicitacaoServico update(
		SolicitacaoServico solicitacaoServico) {

		return getPersistence().update(solicitacaoServico);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SolicitacaoServico update(
		SolicitacaoServico solicitacaoServico, ServiceContext serviceContext) {

		return getPersistence().update(solicitacaoServico, serviceContext);
	}

	/**
	 * Returns all the solicitacao servicos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching solicitacao servicos
	 */
	public static List<SolicitacaoServico> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico findByUuid_First(
			String uuid,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico fetchByUuid_First(
		String uuid, OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico findByUuid_Last(
			String uuid,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico fetchByUuid_Last(
		String uuid, OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static SolicitacaoServico[] findByUuid_PrevAndNext(
			long solicitacaoId, String uuid,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByUuid_PrevAndNext(
			solicitacaoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the solicitacao servicos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of solicitacao servicos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching solicitacao servicos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the solicitacao servicos where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @return the matching solicitacao servicos
	 */
	public static List<SolicitacaoServico> findByClientePJId(long clientePJId) {
		return getPersistence().findByClientePJId(clientePJId);
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
	public static List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end) {

		return getPersistence().findByClientePJId(clientePJId, start, end);
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
	public static List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().findByClientePJId(
			clientePJId, start, end, orderByComparator);
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
	public static List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByClientePJId(
			clientePJId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico findByClientePJId_First(
			long clientePJId,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByClientePJId_First(
			clientePJId, orderByComparator);
	}

	/**
	 * Returns the first solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico fetchByClientePJId_First(
		long clientePJId,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().fetchByClientePJId_First(
			clientePJId, orderByComparator);
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico findByClientePJId_Last(
			long clientePJId,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByClientePJId_Last(
			clientePJId, orderByComparator);
	}

	/**
	 * Returns the last solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public static SolicitacaoServico fetchByClientePJId_Last(
		long clientePJId,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().fetchByClientePJId_Last(
			clientePJId, orderByComparator);
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
	public static SolicitacaoServico[] findByClientePJId_PrevAndNext(
			long solicitacaoId, long clientePJId,
			OrderByComparator<SolicitacaoServico> orderByComparator)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByClientePJId_PrevAndNext(
			solicitacaoId, clientePJId, orderByComparator);
	}

	/**
	 * Removes all the solicitacao servicos where clientePJId = &#63; from the database.
	 *
	 * @param clientePJId the cliente pj ID
	 */
	public static void removeByClientePJId(long clientePJId) {
		getPersistence().removeByClientePJId(clientePJId);
	}

	/**
	 * Returns the number of solicitacao servicos where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @return the number of matching solicitacao servicos
	 */
	public static int countByClientePJId(long clientePJId) {
		return getPersistence().countByClientePJId(clientePJId);
	}

	/**
	 * Caches the solicitacao servico in the entity cache if it is enabled.
	 *
	 * @param solicitacaoServico the solicitacao servico
	 */
	public static void cacheResult(SolicitacaoServico solicitacaoServico) {
		getPersistence().cacheResult(solicitacaoServico);
	}

	/**
	 * Caches the solicitacao servicos in the entity cache if it is enabled.
	 *
	 * @param solicitacaoServicos the solicitacao servicos
	 */
	public static void cacheResult(
		List<SolicitacaoServico> solicitacaoServicos) {

		getPersistence().cacheResult(solicitacaoServicos);
	}

	/**
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	public static SolicitacaoServico create(long solicitacaoId) {
		return getPersistence().create(solicitacaoId);
	}

	/**
	 * Removes the solicitacao servico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico that was removed
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	public static SolicitacaoServico remove(long solicitacaoId)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().remove(solicitacaoId);
	}

	public static SolicitacaoServico updateImpl(
		SolicitacaoServico solicitacaoServico) {

		return getPersistence().updateImpl(solicitacaoServico);
	}

	/**
	 * Returns the solicitacao servico with the primary key or throws a <code>NoSuchSolicitacaoServicoException</code> if it could not be found.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	public static SolicitacaoServico findByPrimaryKey(long solicitacaoId)
		throws br.com.gx2.exception.NoSuchSolicitacaoServicoException {

		return getPersistence().findByPrimaryKey(solicitacaoId);
	}

	/**
	 * Returns the solicitacao servico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico, or <code>null</code> if a solicitacao servico with the primary key could not be found
	 */
	public static SolicitacaoServico fetchByPrimaryKey(long solicitacaoId) {
		return getPersistence().fetchByPrimaryKey(solicitacaoId);
	}

	/**
	 * Returns all the solicitacao servicos.
	 *
	 * @return the solicitacao servicos
	 */
	public static List<SolicitacaoServico> findAll() {
		return getPersistence().findAll();
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
	public static List<SolicitacaoServico> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<SolicitacaoServico> findAll(
		int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<SolicitacaoServico> findAll(
		int start, int end,
		OrderByComparator<SolicitacaoServico> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the solicitacao servicos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SolicitacaoServicoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		SolicitacaoServicoPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile SolicitacaoServicoPersistence _persistence;

}