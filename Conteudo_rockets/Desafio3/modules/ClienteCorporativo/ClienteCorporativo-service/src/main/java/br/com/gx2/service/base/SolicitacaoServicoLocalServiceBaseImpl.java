/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.base;

import br.com.gx2.model.SolicitacaoServico;
import br.com.gx2.service.SolicitacaoServicoLocalService;
import br.com.gx2.service.SolicitacaoServicoLocalServiceUtil;
import br.com.gx2.service.persistence.AuditoriaPersistence;
import br.com.gx2.service.persistence.ClientePjPersistence;
import br.com.gx2.service.persistence.SolicitacaoServicoPersistence;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the solicitacao servico local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.com.gx2.service.impl.SolicitacaoServicoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see br.com.gx2.service.impl.SolicitacaoServicoLocalServiceImpl
 * @generated
 */
public abstract class SolicitacaoServicoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   SolicitacaoServicoLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SolicitacaoServicoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>SolicitacaoServicoLocalServiceUtil</code>.
	 */

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
	@Override
	public SolicitacaoServico addSolicitacaoServico(
		SolicitacaoServico solicitacaoServico) {

		solicitacaoServico.setNew(true);

		return solicitacaoServicoPersistence.update(solicitacaoServico);
	}

	/**
	 * Creates a new solicitacao servico with the primary key. Does not add the solicitacao servico to the database.
	 *
	 * @param solicitacaoId the primary key for the new solicitacao servico
	 * @return the new solicitacao servico
	 */
	@Override
	@Transactional(enabled = false)
	public SolicitacaoServico createSolicitacaoServico(long solicitacaoId) {
		return solicitacaoServicoPersistence.create(solicitacaoId);
	}

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
	@Override
	public SolicitacaoServico deleteSolicitacaoServico(long solicitacaoId)
		throws PortalException {

		return solicitacaoServicoPersistence.remove(solicitacaoId);
	}

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
	@Override
	public SolicitacaoServico deleteSolicitacaoServico(
		SolicitacaoServico solicitacaoServico) {

		return solicitacaoServicoPersistence.remove(solicitacaoServico);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return solicitacaoServicoPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			SolicitacaoServico.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return solicitacaoServicoPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return solicitacaoServicoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return solicitacaoServicoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return solicitacaoServicoPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return solicitacaoServicoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public SolicitacaoServico fetchSolicitacaoServico(long solicitacaoId) {
		return solicitacaoServicoPersistence.fetchByPrimaryKey(solicitacaoId);
	}

	/**
	 * Returns the solicitacao servico with the primary key.
	 *
	 * @param solicitacaoId the primary key of the solicitacao servico
	 * @return the solicitacao servico
	 * @throws PortalException if a solicitacao servico with the primary key could not be found
	 */
	@Override
	public SolicitacaoServico getSolicitacaoServico(long solicitacaoId)
		throws PortalException {

		return solicitacaoServicoPersistence.findByPrimaryKey(solicitacaoId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			solicitacaoServicoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SolicitacaoServico.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("solicitacaoId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			solicitacaoServicoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(SolicitacaoServico.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"solicitacaoId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			solicitacaoServicoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SolicitacaoServico.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("solicitacaoId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return solicitacaoServicoPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement SolicitacaoServicoLocalServiceImpl#deleteSolicitacaoServico(SolicitacaoServico) to avoid orphaned data");
		}

		return solicitacaoServicoLocalService.deleteSolicitacaoServico(
			(SolicitacaoServico)persistedModel);
	}

	@Override
	public BasePersistence<SolicitacaoServico> getBasePersistence() {
		return solicitacaoServicoPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return solicitacaoServicoPersistence.findByPrimaryKey(primaryKeyObj);
	}

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
	@Override
	public List<SolicitacaoServico> getSolicitacaoServicos(int start, int end) {
		return solicitacaoServicoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of solicitacao servicos.
	 *
	 * @return the number of solicitacao servicos
	 */
	@Override
	public int getSolicitacaoServicosCount() {
		return solicitacaoServicoPersistence.countAll();
	}

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
	@Override
	public SolicitacaoServico updateSolicitacaoServico(
		SolicitacaoServico solicitacaoServico) {

		return solicitacaoServicoPersistence.update(solicitacaoServico);
	}

	@Deactivate
	protected void deactivate() {
		SolicitacaoServicoLocalServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			SolicitacaoServicoLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		solicitacaoServicoLocalService =
			(SolicitacaoServicoLocalService)aopProxy;

		SolicitacaoServicoLocalServiceUtil.setService(
			solicitacaoServicoLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SolicitacaoServicoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SolicitacaoServico.class;
	}

	protected String getModelClassName() {
		return SolicitacaoServico.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				solicitacaoServicoPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected AuditoriaPersistence auditoriaPersistence;

	@Reference
	protected ClientePjPersistence clientePjPersistence;

	protected SolicitacaoServicoLocalService solicitacaoServicoLocalService;

	@Reference
	protected SolicitacaoServicoPersistence solicitacaoServicoPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		SolicitacaoServicoLocalServiceBaseImpl.class);

}