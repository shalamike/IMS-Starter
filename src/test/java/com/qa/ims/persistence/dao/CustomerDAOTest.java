package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(1L, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(1L, "jordan", "harrison"), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Customer(ID, "jordan", "harrison"), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "chris", "perrins");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void TestSqlException1() {
		DBUtils.connect("dbsldfnsdf");
		DAO.create(new Customer(1l,"John", "doe"));
		assertEquals(0, DAO.delete(1));
	}
	@Test
	public void TestSqlException2() {
		DBUtils.connect("dbsldfnsdf");
		final Customer updated = new Customer(1l,"John", "doe");
		assertNull( DAO.update(updated));
	}
	
	@Test
	public void TestSqlException3() {
		DBUtils.connect("dbsldfnsdf");
		//assertEquals(new Items(1l,"crisps", 1f), DAO.read(1l));
		assertNull(DAO.read(1l));
	}
	
	@Test
	public void TestSqlException4() {
		DBUtils.connect("dbsldfnsdf");
		ArrayList<Items> empty = new ArrayList<Items>();
		assertEquals( empty, DAO.readAll());
	}
	
	@Test
	public void TestSqlException5() {
		DBUtils.connect("dbsldfnsdf");
		 assertNull( DAO.readLatest());
	}
}
