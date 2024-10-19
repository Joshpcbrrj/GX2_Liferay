/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.test;

import br.com.gx2.exception.NoSuchSolicitacaoServicoException;
import br.com.gx2.model.SolicitacaoServico;
import br.com.gx2.service.SolicitacaoServicoLocalServiceUtil;
import br.com.gx2.service.persistence.SolicitacaoServicoPersistence;
import br.com.gx2.service.persistence.SolicitacaoServicoUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SolicitacaoServicoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "br.com.gx2.service"));

	@Before
	public void setUp() {
		_persistence = SolicitacaoServicoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SolicitacaoServico> iterator = _solicitacaoServicos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SolicitacaoServico solicitacaoServico = _persistence.create(pk);

		Assert.assertNotNull(solicitacaoServico);

		Assert.assertEquals(solicitacaoServico.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		_persistence.remove(newSolicitacaoServico);

		SolicitacaoServico existingSolicitacaoServico =
			_persistence.fetchByPrimaryKey(
				newSolicitacaoServico.getPrimaryKey());

		Assert.assertNull(existingSolicitacaoServico);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSolicitacaoServico();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SolicitacaoServico newSolicitacaoServico = _persistence.create(pk);

		newSolicitacaoServico.setUuid(RandomTestUtil.randomString());

		newSolicitacaoServico.setCodigoUnimed(RandomTestUtil.randomString());

		newSolicitacaoServico.setDescricao(RandomTestUtil.randomString());

		newSolicitacaoServico.setDataSolicitacao(RandomTestUtil.nextDate());

		newSolicitacaoServico.setStatus(RandomTestUtil.nextInt());

		newSolicitacaoServico.setPrioridade(RandomTestUtil.nextInt());

		newSolicitacaoServico.setClientePJId(RandomTestUtil.nextLong());

		_solicitacaoServicos.add(_persistence.update(newSolicitacaoServico));

		SolicitacaoServico existingSolicitacaoServico =
			_persistence.findByPrimaryKey(
				newSolicitacaoServico.getPrimaryKey());

		Assert.assertEquals(
			existingSolicitacaoServico.getUuid(),
			newSolicitacaoServico.getUuid());
		Assert.assertEquals(
			existingSolicitacaoServico.getSolicitacaoId(),
			newSolicitacaoServico.getSolicitacaoId());
		Assert.assertEquals(
			existingSolicitacaoServico.getCodigoUnimed(),
			newSolicitacaoServico.getCodigoUnimed());
		Assert.assertEquals(
			existingSolicitacaoServico.getDescricao(),
			newSolicitacaoServico.getDescricao());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingSolicitacaoServico.getDataSolicitacao()),
			Time.getShortTimestamp(newSolicitacaoServico.getDataSolicitacao()));
		Assert.assertEquals(
			existingSolicitacaoServico.getStatus(),
			newSolicitacaoServico.getStatus());
		Assert.assertEquals(
			existingSolicitacaoServico.getPrioridade(),
			newSolicitacaoServico.getPrioridade());
		Assert.assertEquals(
			existingSolicitacaoServico.getClientePJId(),
			newSolicitacaoServico.getClientePJId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByClientePJId() throws Exception {
		_persistence.countByClientePJId(RandomTestUtil.nextLong());

		_persistence.countByClientePJId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		SolicitacaoServico existingSolicitacaoServico =
			_persistence.findByPrimaryKey(
				newSolicitacaoServico.getPrimaryKey());

		Assert.assertEquals(existingSolicitacaoServico, newSolicitacaoServico);
	}

	@Test(expected = NoSuchSolicitacaoServicoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SolicitacaoServico> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Ccorp_SolicitacaoServico", "uuid", true, "solicitacaoId", true,
			"codigoUnimed", true, "descricao", true, "dataSolicitacao", true,
			"status", true, "prioridade", true, "clientePJId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		SolicitacaoServico existingSolicitacaoServico =
			_persistence.fetchByPrimaryKey(
				newSolicitacaoServico.getPrimaryKey());

		Assert.assertEquals(existingSolicitacaoServico, newSolicitacaoServico);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SolicitacaoServico missingSolicitacaoServico =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSolicitacaoServico);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SolicitacaoServico newSolicitacaoServico1 = addSolicitacaoServico();
		SolicitacaoServico newSolicitacaoServico2 = addSolicitacaoServico();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSolicitacaoServico1.getPrimaryKey());
		primaryKeys.add(newSolicitacaoServico2.getPrimaryKey());

		Map<Serializable, SolicitacaoServico> solicitacaoServicos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, solicitacaoServicos.size());
		Assert.assertEquals(
			newSolicitacaoServico1,
			solicitacaoServicos.get(newSolicitacaoServico1.getPrimaryKey()));
		Assert.assertEquals(
			newSolicitacaoServico2,
			solicitacaoServicos.get(newSolicitacaoServico2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SolicitacaoServico> solicitacaoServicos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(solicitacaoServicos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSolicitacaoServico.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SolicitacaoServico> solicitacaoServicos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, solicitacaoServicos.size());
		Assert.assertEquals(
			newSolicitacaoServico,
			solicitacaoServicos.get(newSolicitacaoServico.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SolicitacaoServico> solicitacaoServicos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(solicitacaoServicos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSolicitacaoServico.getPrimaryKey());

		Map<Serializable, SolicitacaoServico> solicitacaoServicos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, solicitacaoServicos.size());
		Assert.assertEquals(
			newSolicitacaoServico,
			solicitacaoServicos.get(newSolicitacaoServico.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SolicitacaoServicoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<SolicitacaoServico>() {

				@Override
				public void performAction(
					SolicitacaoServico solicitacaoServico) {

					Assert.assertNotNull(solicitacaoServico);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SolicitacaoServico.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"solicitacaoId", newSolicitacaoServico.getSolicitacaoId()));

		List<SolicitacaoServico> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SolicitacaoServico existingSolicitacaoServico = result.get(0);

		Assert.assertEquals(existingSolicitacaoServico, newSolicitacaoServico);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SolicitacaoServico.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"solicitacaoId", RandomTestUtil.nextLong()));

		List<SolicitacaoServico> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SolicitacaoServico newSolicitacaoServico = addSolicitacaoServico();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SolicitacaoServico.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("solicitacaoId"));

		Object newSolicitacaoId = newSolicitacaoServico.getSolicitacaoId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"solicitacaoId", new Object[] {newSolicitacaoId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSolicitacaoId = result.get(0);

		Assert.assertEquals(existingSolicitacaoId, newSolicitacaoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SolicitacaoServico.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("solicitacaoId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"solicitacaoId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SolicitacaoServico addSolicitacaoServico() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SolicitacaoServico solicitacaoServico = _persistence.create(pk);

		solicitacaoServico.setUuid(RandomTestUtil.randomString());

		solicitacaoServico.setCodigoUnimed(RandomTestUtil.randomString());

		solicitacaoServico.setDescricao(RandomTestUtil.randomString());

		solicitacaoServico.setDataSolicitacao(RandomTestUtil.nextDate());

		solicitacaoServico.setStatus(RandomTestUtil.nextInt());

		solicitacaoServico.setPrioridade(RandomTestUtil.nextInt());

		solicitacaoServico.setClientePJId(RandomTestUtil.nextLong());

		_solicitacaoServicos.add(_persistence.update(solicitacaoServico));

		return solicitacaoServico;
	}

	private List<SolicitacaoServico> _solicitacaoServicos =
		new ArrayList<SolicitacaoServico>();
	private SolicitacaoServicoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}