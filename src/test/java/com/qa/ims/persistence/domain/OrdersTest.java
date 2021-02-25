package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersTest {
	
	Orders o1 = new Orders(1l, 1l, 4f);
	Orders o2 = new Orders(1l, 2l, 1l, 4f);
	Orders o3 = new Orders(2l,1l, 2l, "mike", "larry", "coke", 0.5f, 10f);
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Orders.class).verify();
	}
	@Test 
	public void testConstructor() {
		assertTrue(o1 instanceof Orders);
		assertTrue(o2 instanceof Orders);
		assertTrue(o3 instanceof Orders);
	}
	
	@Test 
	public void testConstructorCreatesFullName() {
		assertEquals("mike larry",o3.getCustomerName());
		Orders o = new Orders(2l,1l, 2l, "leroy", "leroymy", "coke", 0.5f, 10f);
		assertEquals("leroy leroymy", o.getCustomerName());
	}
	
	@Test
	public void ConstructorGetsFullPriceTest() {
		assertEquals(5f, o3.getItemPrice(), 5f);
		Orders o = new Orders(2l,1l, 2l, "dee", "jay", "coke", 3f, 1000f);
		assertEquals(3000f, o.getItemPrice(),3000f);
	}
	
	@Test
	public void testGetCustId() {
		assertSame(1l, o1.getcustId());
		assertSame(2l, o2.getcustId());
		assertSame(1l, o3.getcustId());
	}
	
	@Test
	public void testSetCustID() {
		Orders o = new Orders(2l,1l, 2l, "dee", "jay", "coke", 3f, 1000f);
		o.setcustId(4l);
		assertSame(4l, o.getcustId());
	}
	
	@Test
	public void testgetOrderId() {
		assertSame(1l, o2.getorderId());
		assertSame(2l, o3.getorderId());
	}
	
	@Test
	public void testSetOrderId() {
		Orders o = new Orders(2l,1l, 2l, "dee", "jay", "coke", 3f, 1000f);
		o.setorderId(1l);
		assertSame(1l, o.getorderId());
	}
	
	@Test
	public void testGetCustomerId() {
		assertSame(1l, o1.getcustId());
	}
	@Test
	public void testSetCustomerId() {}
	
}
