/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.SolicitacaoServico;

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

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SolicitacaoServico. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SolicitacaoServicoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SolicitacaoServicoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.gx2.service.impl.SolicitacaoServicoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the solicitacao servico local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SolicitacaoServicoLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Cria uma nova solicitação de serviço.
	 *
	 * @param clientePJId O ID do cliente PJ relacionado.
	 * @param codigoUnimed O código Unimed da solicitação.
	 * @param descricao A descrição da solicitação.
	 * @param status A situação da solicitação.
	 * @param prioridade A prioridade da solicitação.
	 * @param serviceContext O contexto do serviço.
	 * @return A solicitação de serviço criada.
	 * @throws PortalException Se ocorrer um erro durante a criação.
	 */
	public SolicitacaoServico addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao, int status,
			int prioridade, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the solicitacao servico to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoServico the solicitacao servico
	 * @return the solicitacao servico that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SolicitacaoServico addSolicitacaoServico(
		SolicitacaoServico solicitacaoServico);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	@Transactional(enabled = false)
	public SolicitacaoServico createSolicitacaoServico(long solicitacaoId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the solicitacao servico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico that was removed
	 * @throws PortalException if a solicitacao servico with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SolicitacaoServico deleteSolicitacaoServico(long solicitacaoId)
		throws PortalException;

	/**
	 * Deletes the solicitacao servico from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoServico the solicitacao servico
	 * @return the solicitacao servico that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SolicitacaoServico deleteSolicitacaoServico(
		SolicitacaoServico solicitacaoServico);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
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
	public SolicitacaoServico fetchSolicitacaoServico(long solicitacaoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Lista de solicitações de serviço.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<SolicitacaoServico> getAllSolicitacoes();

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
	 * Returns the solicitacao servico with the primary key.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws PortalException if a solicitacao servico with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SolicitacaoServico getSolicitacaoServico(long solicitacaoId)
		throws PortalException;

	/**
	 * Returns a range of all the solicitacao servicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.gx2.model.impl.SolicitacaoServicoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitacao servicos
	 * @param end the upper bound of the range of solicitacao servicos (not inclusive)
	 * @return the range of solicitacao servicos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SolicitacaoServico> getSolicitacaoServicos(int start, int end);

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSolicitacaoServicosCount();

	/**
	 * Atualiza uma solicitação de serviço existente.
	 *
	 * @param solicitacaoId O ID da solicitação de serviço a ser atualizada.
	 * @param codigoUnimed O novo código Unimed da solicitação.
	 * @param descricao A nova descrição da solicitação.
	 * @param status A nova situação da solicitação.
	 * @param prioridade A nova prioridade da solicitação.
	 * @return A solicitação de serviço atualizada.
	 * @throws PortalException Se a solicitação de serviço não for encontrada.
	 */
	public SolicitacaoServico updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade)
		throws PortalException;

	/**
	 * Updates the solicitacao servico in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SolicitacaoServicoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param solicitacaoServico the solicitacao servico
	 * @return the solicitacao servico that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SolicitacaoServico updateSolicitacaoServico(
		SolicitacaoServico solicitacaoServico);

}