/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service.persistence.test;

import br.com.gx2.exception.NoSuchClienteCorporativoException;
import br.com.gx2.model.ClienteCorporativo;
import br.com.gx2.service.ClienteCorporativoLocalServiceUtil;
import br.com.gx2.service.persistence.ClienteCorporativoPersistence;
import br.com.gx2.service.persistence.ClienteCorporativoUtil;

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
public class ClienteCorporativoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "br.com.gx2.service"));

	@Before
	public void setUp() {
		_persistence = ClienteCorporativoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ClienteCorporativo> iterator = _clienteCorporativos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClienteCorporativo clienteCorporativo = _persistence.create(pk);

		Assert.assertNotNull(clienteCorporativo);

		Assert.assertEquals(clienteCorporativo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		_persistence.remove(newClienteCorporativo);

		ClienteCorporativo existingClienteCorporativo =
			_persistence.fetchByPrimaryKey(
				newClienteCorporativo.getPrimaryKey());

		Assert.assertNull(existingClienteCorporativo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addClienteCorporativo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClienteCorporativo newClienteCorporativo = _persistence.create(pk);

		newClienteCorporativo.setUuid(RandomTestUtil.randomString());

		newClienteCorporativo.setRazaoSocial(RandomTestUtil.randomString());

		newClienteCorporativo.setCnpj(RandomTestUtil.randomString());

		_clienteCorporativos.add(_persistence.update(newClienteCorporativo));

		ClienteCorporativo existingClienteCorporativo =
			_persistence.findByPrimaryKey(
				newClienteCorporativo.getPrimaryKey());

		Assert.assertEquals(
			existingClienteCorporativo.getUuid(),
			newClienteCorporativo.getUuid());
		Assert.assertEquals(
			existingClienteCorporativo.getCiaId(),
			newClienteCorporativo.getCiaId());
		Assert.assertEquals(
			existingClienteCorporativo.getRazaoSocial(),
			newClienteCorporativo.getRazaoSocial());
		Assert.assertEquals(
			existingClienteCorporativo.getCnpj(),
			newClienteCorporativo.getCnpj());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		ClienteCorporativo existingClienteCorporativo =
			_persistence.findByPrimaryKey(
				newClienteCorporativo.getPrimaryKey());

		Assert.assertEquals(existingClienteCorporativo, newClienteCorporativo);
	}

	@Test(expected = NoSuchClienteCorporativoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ClienteCorporativo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Ccorp_ClienteCorporativo", "uuid", true, "ciaId", true,
			"razaoSocial", true, "cnpj", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		ClienteCorporativo existingClienteCorporativo =
			_persistence.fetchByPrimaryKey(
				newClienteCorporativo.getPrimaryKey());

		Assert.assertEquals(existingClienteCorporativo, newClienteCorporativo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClienteCorporativo missingClienteCorporativo =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingClienteCorporativo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ClienteCorporativo newClienteCorporativo1 = addClienteCorporativo();
		ClienteCorporativo newClienteCorporativo2 = addClienteCorporativo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClienteCorporativo1.getPrimaryKey());
		primaryKeys.add(newClienteCorporativo2.getPrimaryKey());

		Map<Serializable, ClienteCorporativo> clienteCorporativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, clienteCorporativos.size());
		Assert.assertEquals(
			newClienteCorporativo1,
			clienteCorporativos.get(newClienteCorporativo1.getPrimaryKey()));
		Assert.assertEquals(
			newClienteCorporativo2,
			clienteCorporativos.get(newClienteCorporativo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ClienteCorporativo> clienteCorporativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(clienteCorporativos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClienteCorporativo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ClienteCorporativo> clienteCorporativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, clienteCorporativos.size());
		Assert.assertEquals(
			newClienteCorporativo,
			clienteCorporativos.get(newClienteCorporativo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ClienteCorporativo> clienteCorporativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(clienteCorporativos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClienteCorporativo.getPrimaryKey());

		Map<Serializable, ClienteCorporativo> clienteCorporativos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, clienteCorporativos.size());
		Assert.assertEquals(
			newClienteCorporativo,
			clienteCorporativos.get(newClienteCorporativo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ClienteCorporativoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ClienteCorporativo>() {

				@Override
				public void performAction(
					ClienteCorporativo clienteCorporativo) {

					Assert.assertNotNull(clienteCorporativo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClienteCorporativo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ciaId", newClienteCorporativo.getCiaId()));

		List<ClienteCorporativo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ClienteCorporativo existingClienteCorporativo = result.get(0);

		Assert.assertEquals(existingClienteCorporativo, newClienteCorporativo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClienteCorporativo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ciaId", RandomTestUtil.nextLong()));

		List<ClienteCorporativo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ClienteCorporativo newClienteCorporativo = addClienteCorporativo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClienteCorporativo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ciaId"));

		Object newCiaId = newClienteCorporativo.getCiaId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ciaId", new Object[] {newCiaId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCiaId = result.get(0);

		Assert.assertEquals(existingCiaId, newCiaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ClienteCorporativo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ciaId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ciaId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ClienteCorporativo addClienteCorporativo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ClienteCorporativo clienteCorporativo = _persistence.create(pk);

		clienteCorporativo.setUuid(RandomTestUtil.randomString());

		clienteCorporativo.setRazaoSocial(RandomTestUtil.randomString());

		clienteCorporativo.setCnpj(RandomTestUtil.randomString());

		_clienteCorporativos.add(_persistence.update(clienteCorporativo));

		return clienteCorporativo;
	}

	private List<ClienteCorporativo> _clienteCorporativos =
		new ArrayList<ClienteCorporativo>();
	private ClienteCorporativoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}