package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	private final OrdersDAO DaoOrders = new OrdersDAO();
	private final ItemsDAO DaoItems = new ItemsDAO();
	private final CustomerDAO DaoCust = new CustomerDAO();
	
	Customer createdCustomer = new Customer(1l, "leroy", "jenkins");
	Items item = new Items(1l, "crisps", 0.5);
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		Customer createdCustomer = new Customer(1l, "leroy", "jenkins");
		Items createdItem = new Items(1l, "crisps", 0.5);
		DaoItems.create(createdItem);
		DaoCust.create(createdCustomer);
		Orders createdOrder = new Orders(1l, 1l, 1l,"leroy","jenkins","crisps",0.5f, 10f);
		assertEquals(createdOrder, DaoOrders.create(createdOrder));
		Orders createdOrder2 = new Orders(1l, 1l, 10);
		assertEquals(createdOrder2,DaoOrders.create(createdOrder2));
	}
	
	@Test
	public void TestRead() {
		assertEquals(new Orders(1l, 1l, 1l, 10f), DaoOrders.read(1l));
	}
	
	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1L, 2l, 1l, "leroy", "Jenkins", "crisps", 10, 10f));
		expected.add(new Orders(2L, 1l, 2l, "aj", "mitchel", "drink", 10, 10f));
		expected.add(new Orders(3L, 3l, 1l, "mike", "larry", "crisps", 10, 10f));
		assertEquals(expected, DaoOrders.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Orders(1L, 2l, 1l, "leroy", "Jenkins", "crisps", 20, 10f), DaoOrders.readLatest());
	}
	

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Orders(1L, 2l, 1l, "leroy", "Jenkins", "crisps", 20, 10f), DaoOrders.read(ID));
	}

	@Test
	public void testUpdate() {
		final Orders updated = new Orders(1L, 2l, 1l, "leroy", "Jenkins", "crisps", 20, 10f);
		assertEquals(updated,DaoOrders.update(updated));
		
	}


	@Test
	public void testDelete() {
		assertEquals(1, DaoOrders.delete(1));
	}
	
	@Test
	public void TestSqlException() {
		DBUtils.connect("dbsldfnsdf");
		DaoOrders.create(new Orders(1l,1l,10));
		assertEquals(0, DaoOrders.delete(1));
	}
	
	@Test
	public void TestSqlException2() {
		DBUtils.connect("dbsldfnsdf");
		final Orders updated = new Orders(1L, 2l, 1l, "leroy", "Jenkins", "crisps", 20, 10f);
		assertNull(DaoOrders.update(updated));
	}
	
	@Test
	public void TestSqlException3() {
		DBUtils.connect("dbsldfnsdf");
		assertNull( DaoOrders.read(1l));
	}


}
