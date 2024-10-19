/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.test;

import br.com.gx2.exception.NoSuchAuditoriaException;
import br.com.gx2.model.Auditoria;
import br.com.gx2.service.AuditoriaLocalServiceUtil;
import br.com.gx2.service.persistence.AuditoriaPersistence;
import br.com.gx2.service.persistence.AuditoriaUtil;

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
public class AuditoriaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "br.com.gx2.service"));

	@Before
	public void setUp() {
		_persistence = AuditoriaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Auditoria> iterator = _auditorias.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Auditoria auditoria = _persistence.create(pk);

		Assert.assertNotNull(auditoria);

		Assert.assertEquals(auditoria.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Auditoria newAuditoria = addAuditoria();

		_persistence.remove(newAuditoria);

		Auditoria existingAuditoria = _persistence.fetchByPrimaryKey(
			newAuditoria.getPrimaryKey());

		Assert.assertNull(existingAuditoria);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAuditoria();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Auditoria newAuditoria = _persistence.create(pk);

		newAuditoria.setUuid(RandomTestUtil.randomString());

		newAuditoria.setDataAcao(RandomTestUtil.nextDate());

		newAuditoria.setUsuario(RandomTestUtil.randomString());

		newAuditoria.setAcao(RandomTestUtil.randomString());

		_auditorias.add(_persistence.update(newAuditoria));

		Auditoria existingAuditoria = _persistence.findByPrimaryKey(
			newAuditoria.getPrimaryKey());

		Assert.assertEquals(
			existingAuditoria.getUuid(), newAuditoria.getUuid());
		Assert.assertEquals(
			existingAuditoria.getAuditoriaId(), newAuditoria.getAuditoriaId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAuditoria.getDataAcao()),
			Time.getShortTimestamp(newAuditoria.getDataAcao()));
		Assert.assertEquals(
			existingAuditoria.getUsuario(), newAuditoria.getUsuario());
		Assert.assertEquals(
			existingAuditoria.getAcao(), newAuditoria.getAcao());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Auditoria newAuditoria = addAuditoria();

		Auditoria existingAuditoria = _persistence.findByPrimaryKey(
			newAuditoria.getPrimaryKey());

		Assert.assertEquals(existingAuditoria, newAuditoria);
	}

	@Test(expected = NoSuchAuditoriaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Auditoria> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Ccorp_Auditoria", "uuid", true, "auditoriaId", true, "dataAcao",
			true, "usuario", true, "acao", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Auditoria newAuditoria = addAuditoria();

		Auditoria existingAuditoria = _persistence.fetchByPrimaryKey(
			newAuditoria.getPrimaryKey());

		Assert.assertEquals(existingAuditoria, newAuditoria);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Auditoria missingAuditoria = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAuditoria);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Auditoria newAuditoria1 = addAuditoria();
		Auditoria newAuditoria2 = addAuditoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuditoria1.getPrimaryKey());
		primaryKeys.add(newAuditoria2.getPrimaryKey());

		Map<Serializable, Auditoria> auditorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, auditorias.size());
		Assert.assertEquals(
			newAuditoria1, auditorias.get(newAuditoria1.getPrimaryKey()));
		Assert.assertEquals(
			newAuditoria2, auditorias.get(newAuditoria2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Auditoria> auditorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(auditorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Auditoria newAuditoria = addAuditoria();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuditoria.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Auditoria> auditorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, auditorias.size());
		Assert.assertEquals(
			newAuditoria, auditorias.get(newAuditoria.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Auditoria> auditorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(auditorias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Auditoria newAuditoria = addAuditoria();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuditoria.getPrimaryKey());

		Map<Serializable, Auditoria> auditorias =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, auditorias.size());
		Assert.assertEquals(
			newAuditoria, auditorias.get(newAuditoria.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AuditoriaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Auditoria>() {

				@Override
				public void performAction(Auditoria auditoria) {
					Assert.assertNotNull(auditoria);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Auditoria newAuditoria = addAuditoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auditoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"auditoriaId", newAuditoria.getAuditoriaId()));

		List<Auditoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Auditoria existingAuditoria = result.get(0);

		Assert.assertEquals(existingAuditoria, newAuditoria);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auditoria.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"auditoriaId", RandomTestUtil.nextLong()));

		List<Auditoria> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Auditoria newAuditoria = addAuditoria();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auditoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("auditoriaId"));

		Object newAuditoriaId = newAuditoria.getAuditoriaId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"auditoriaId", new Object[] {newAuditoriaId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAuditoriaId = result.get(0);

		Assert.assertEquals(existingAuditoriaId, newAuditoriaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Auditoria.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("auditoriaId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"auditoriaId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Auditoria addAuditoria() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Auditoria auditoria = _persistence.create(pk);

		auditoria.setUuid(RandomTestUtil.randomString());

		auditoria.setDataAcao(RandomTestUtil.nextDate());

		auditoria.setUsuario(RandomTestUtil.randomString());

		auditoria.setAcao(RandomTestUtil.randomString());

		_auditorias.add(_persistence.update(auditoria));

		return auditoria;
	}

	private List<Auditoria> _auditorias = new ArrayList<Auditoria>();
	private AuditoriaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}