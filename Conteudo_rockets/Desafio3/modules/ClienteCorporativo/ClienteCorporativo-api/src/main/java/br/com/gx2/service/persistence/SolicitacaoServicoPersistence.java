/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence;

import br.com.gx2.exception.NoSuchSolicitacaoServicoException;
import br.com.gx2.model.SolicitacaoServico;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the solicitacao servico service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoUtil
 * @generated
 */
@ProviderType
public interface SolicitacaoServicoPersistence
	extends BasePersistence<SolicitacaoServico> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SolicitacaoServicoUtil} to access the solicitacao servico persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the solicitacao servicos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching solicitacao servicos
	 */
	public java.util.List<SolicitacaoServico> findByUuid(String uuid);

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
	public java.util.List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

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
	public java.util.List<SolicitacaoServico> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
				orderByComparator)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Returns the first solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

	/**
	 * Returns the last solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
				orderByComparator)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Returns the last solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

	/**
	 * Returns the solicitacao servicos before and after the current solicitacao servico in the ordered set where uuid = &#63;.
	 *
	 * @param solicitacaoId the primary key of the current solicitacao servico
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	public SolicitacaoServico[] findByUuid_PrevAndNext(
			long solicitacaoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
				orderByComparator)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Removes all the solicitacao servicos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of solicitacao servicos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching solicitacao servicos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the solicitacao servicos where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @return the matching solicitacao servicos
	 */
	public java.util.List<SolicitacaoServico> findByClientePJId(
		long clientePJId);

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
	public java.util.List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end);

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
	public java.util.List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

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
	public java.util.List<SolicitacaoServico> findByClientePJId(
		long clientePJId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico findByClientePJId_First(
			long clientePJId,
			com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
				orderByComparator)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Returns the first solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico fetchByClientePJId_First(
		long clientePJId,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

	/**
	 * Returns the last solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico findByClientePJId_Last(
			long clientePJId,
			com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
				orderByComparator)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Returns the last solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching solicitacao servico, or <code>null</code> if a matching solicitacao servico could not be found
	 */
	public SolicitacaoServico fetchByClientePJId_Last(
		long clientePJId,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

	/**
	 * Returns the solicitacao servicos before and after the current solicitacao servico in the ordered set where clientePJId = &#63;.
	 *
	 * @param solicitacaoId the primary key of the current solicitacao servico
	 * @param clientePJId the cliente pj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	public SolicitacaoServico[] findByClientePJId_PrevAndNext(
			long solicitacaoId, long clientePJId,
			com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
				orderByComparator)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Removes all the solicitacao servicos where clientePJId = &#63; from the database.
	 *
	 * @param clientePJId the cliente pj ID
	 */
	public void removeByClientePJId(long clientePJId);

	/**
	 * Returns the number of solicitacao servicos where clientePJId = &#63;.
	 *
	 * @param clientePJId the cliente pj ID
	 * @return the number of matching solicitacao servicos
	 */
	public int countByClientePJId(long clientePJId);

	/**
	 * Caches the solicitacao servico in the entity cache if it is enabled.
	 *
	 * @param solicitacaoServico the solicitacao servico
	 */
	public void cacheResult(SolicitacaoServico solicitacaoServico);

	/**
	 * Caches the solicitacao servicos in the entity cache if it is enabled.
	 *
	 * @param solicitacaoServicos the solicitacao servicos
	 */
	public void cacheResult(
		java.util.List<SolicitacaoServico> solicitacaoServicos);

	/**
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	public SolicitacaoServico create(long solicitacaoId);

	/**
	 * Removes the solicitacao servico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico that was removed
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	public SolicitacaoServico remove(long solicitacaoId)
		throws NoSuchSolicitacaoServicoException;

	public SolicitacaoServico updateImpl(SolicitacaoServico solicitacaoServico);

	/**
	 * Returns the solicitacao servico with the primary key or throws a <code>NoSuchSolicitacaoServicoException</code> if it could not be found.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws NoSuchSolicitacaoServicoException if a solicitacao servico with the primary key could not be found
	 */
	public SolicitacaoServico findByPrimaryKey(long solicitacaoId)
		throws NoSuchSolicitacaoServicoException;

	/**
	 * Returns the solicitacao servico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico, or <code>null</code> if a solicitacao servico with the primary key could not be found
	 */
	public SolicitacaoServico fetchByPrimaryKey(long solicitacaoId);

	/**
	 * Returns all the solicitacao servicos.
	 *
	 * @return the solicitacao servicos
	 */
	public java.util.List<SolicitacaoServico> findAll();

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
	public java.util.List<SolicitacaoServico> findAll(int start, int end);

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
	public java.util.List<SolicitacaoServico> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator);

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
	public java.util.List<SolicitacaoServico> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SolicitacaoServico>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the solicitacao servicos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	public int countAll();

}