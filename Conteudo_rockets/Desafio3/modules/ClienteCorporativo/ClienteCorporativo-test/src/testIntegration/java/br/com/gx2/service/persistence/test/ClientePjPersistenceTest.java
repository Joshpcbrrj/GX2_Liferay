/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.test;

import br.com.gx2.exception.NoSuchClientePjException;
import br.com.gx2.model.ClientePj;
import br.com.gx2.service.ClientePjLocalServiceUtil;
import br.com.gx2.service.persistence.ClientePjPersistence;
import br.com.gx2.service.persistence.ClientePjUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
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
public class ClientePjPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "br.com.gx2.service"));

	@Before
	public void setUp() {
		_persistence = ClientePjUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ClientePj> iterator = _clientePjs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClientePj clientePj = _persistence.create(pk);

		Assert.assertNotNull(clientePj);

		Assert.assertEquals(clientePj.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ClientePj newClientePj = addClientePj();

		_persistence.remove(newClientePj);

		ClientePj existingClientePj = _persistence.fetchByPrimaryKey(
			newClientePj.getPrimaryKey());

		Assert.assertNull(existingClientePj);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addClientePj();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClientePj newClientePj = _persistence.create(pk);

		newClientePj.setUuid(RandomTestUtil.randomString());

		newClientePj.setRazaoSocial(RandomTestUtil.randomString());

		newClientePj.setCnpj(RandomTestUtil.randomString());

		_clientePjs.add(_persistence.update(newClientePj));

		ClientePj existingClientePj = _persistence.findByPrimaryKey(
			newClientePj.getPrimaryKey());

		Assert.assertEquals(
			existingClientePj.getUuid(), newClientePj.getUuid());
		Assert.assertEquals(
			existingClientePj.getClientePJId(), newClientePj.getClientePJId());
		Assert.assertEquals(
			existingClientePj.getRazaoSocial(), newClientePj.getRazaoSocial());
		Assert.assertEquals(
			existingClientePj.getCnpj(), newClientePj.getCnpj());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByCnpj() throws Exception {
		_persistence.countByCnpj("");

		_persistence.countByCnpj("null");

		_persistence.countByCnpj((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ClientePj newClientePj = addClientePj();

		ClientePj existingClientePj = _persistence.findByPrimaryKey(
			newClientePj.getPrimaryKey());

		Assert.assertEquals(existingClientePj, newClientePj);
	}

	@Test(expected = NoSuchClientePjException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ClientePj> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Ccorp_ClientePj", "uuid", true, "clientePJId", true, "razaoSocial",
			true, "cnpj", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ClientePj newClientePj = addClientePj();

		ClientePj existingClientePj = _persistence.fetchByPrimaryKey(
			newClientePj.getPrimaryKey());

		Assert.assertEquals(existingClientePj, newClientePj);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClientePj missingClientePj = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingClientePj);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ClientePj newClientePj1 = addClientePj();
		ClientePj newClientePj2 = addClientePj();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClientePj1.getPrimaryKey());
		primaryKeys.add(newClientePj2.getPrimaryKey());

		Map<Serializable, ClientePj> clientePjs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, clientePjs.size());
		Assert.assertEquals(
			newClientePj1, clientePjs.get(newClientePj1.getPrimaryKey()));
		Assert.assertEquals(
			newClientePj2, clientePjs.get(newClientePj2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ClientePj> clientePjs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(clientePjs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ClientePj newClientePj = addClientePj();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClientePj.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ClientePj> clientePjs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, clientePjs.size());
		Assert.assertEquals(
			newClientePj, clientePjs.get(newClientePj.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ClientePj> clientePjs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(clientePjs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ClientePj newClientePj = addClientePj();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClientePj.getPrimaryKey());

		Map<Serializable, ClientePj> clientePjs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, clientePjs.size());
		Assert.assertEquals(
			newClientePj, clientePjs.get(newClientePj.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ClientePjLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ClientePj>() {

				@Override
				public void performAction(ClientePj clientePj) {
					Assert.assertNotNull(clientePj);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ClientePj newClientePj = addClientePj();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClientePj.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"clientePJId", newClientePj.getClientePJId()));

		List<ClientePj> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ClientePj existingClientePj = result.get(0);

		Assert.assertEquals(existingClientePj, newClientePj);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClientePj.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"clientePJId", RandomTestUtil.nextLong()));

		List<ClientePj> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ClientePj newClientePj = addClientePj();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClientePj.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("clientePJId"));

		Object newClientePJId = newClientePj.getClientePJId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"clientePJId", new Object[] {newClientePJId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingClientePJId = result.get(0);

		Assert.assertEquals(existingClientePJId, newClientePJId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClientePj.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("clientePJId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"clientePJId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ClientePj newClientePj = addClientePj();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newClientePj.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		ClientePj newClientePj = addClientePj();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClientePj.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"clientePJId", newClientePj.getClientePJId()));

		List<ClientePj> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(ClientePj clientePj) {
		Assert.assertEquals(
			clientePj.getCnpj(),
			ReflectionTestUtil.invoke(
				clientePj, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "cnpj"));
	}

	protected ClientePj addClientePj() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClientePj clientePj = _persistence.create(pk);

		clientePj.setUuid(RandomTestUtil.randomString());

		clientePj.setRazaoSocial(RandomTestUtil.randomString());

		clientePj.setCnpj(RandomTestUtil.randomString());

		_clientePjs.add(_persistence.update(clientePj));

		return clientePj;
	}

	private List<ClientePj> _clientePjs = new ArrayList<ClientePj>();
	private ClientePjPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}