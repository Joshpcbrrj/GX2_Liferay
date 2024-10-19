/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.ClientePj;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ClientePj. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClientePjLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ClientePjLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.gx2.service.impl.ClientePjLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the cliente pj local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ClientePjLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the cliente pj to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePj the cliente pj
	 * @return the cliente pj that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ClientePj addClientePj(ClientePj clientePj);

	/**
	 * Adiciona um novo cliente PJ ao banco de dados.
	 *
	 * @param razaoSocial A razão social do cliente.
	 * @param cnpj O CNPJ do cliente.
	 * @param serviceContext O contexto do serviço, utilizado para informações adicionais.
	 * @return O objeto ClientePj criado.
	 * @throws PortalException Se ocorrer um erro durante o processo de criação.
	 */
	public ClientePj addClientePj(
			String razaoSocial, String cnpj, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new cliente pj with the primary key. Does not add the cliente pj to the database.
	 *
	 * @param clientePJId the primary key for the new cliente pj
	 * @return the new cliente pj
	 */
	@Transactional(enabled = false)
	public ClientePj createClientePj(long clientePJId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the cliente pj from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePj the cliente pj
	 * @return the cliente pj that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ClientePj deleteClientePj(ClientePj clientePj);

	/**
	 * Deletes the cliente pj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj that was removed
	 * @throws PortalException if a cliente pj with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ClientePj deleteClientePj(long clientePJId) throws PortalException;

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser deletado.
	 * @return O objeto ClientePj deletado.
	 * @throws PortalException Se ocorrer um erro durante a deleção ou se o cliente não for encontrado.
	 */
	public ClientePj deleteClientePjById(long clientePjId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClientePj fetchClientePj(long clientePJId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Lista de todos os clientes PJ.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClientePj> getAllClientes();

	/**
	 * Returns the cliente pj with the primary key.
	 *
	 * @param clientePJId the primary key of the cliente pj
	 * @return the cliente pj
	 * @throws PortalException if a cliente pj with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClientePj getClientePj(long clientePJId) throws PortalException;

	/**
	 * Busca um cliente PJ pelo CNPJ.
	 * Utiliza paginação para garantir que apenas 1 resultado seja retornado.
	 *
	 * @param cnpj O CNPJ do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClientePj getClientePjByCnpj(String cnpj);

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClientePj getClientePjById(long clientePjId);

	/**
	 * Returns a range of all the cliente pjs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.ClientePjModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente pjs
	 * @param end the upper bound of the range of cliente pjs (not inclusive)
	 * @return the range of cliente pjs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClientePj> getClientePjs(int start, int end);

	/**
	 * Returns the number of cliente pjs.
	 *
	 * @return the number of cliente pjs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getClientePjsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the cliente pj in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClientePjLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clientePj the cliente pj
	 * @return the cliente pj that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ClientePj updateClientePj(ClientePj clientePj);

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId O ID do cliente PJ a ser atualizado.
	 * @param razaoSocial A nova razão social do cliente.
	 * @param cnpj O novo CNPJ do cliente.
	 * @return O objeto ClientePj atualizado.
	 * @throws PortalException Se ocorrer um erro durante a atualização ou se o cliente não for encontrado.
	 */
	public ClientePj updateClientePj(
			long clientePJId, String razaoSocial, String cnpj)
		throws PortalException;

}