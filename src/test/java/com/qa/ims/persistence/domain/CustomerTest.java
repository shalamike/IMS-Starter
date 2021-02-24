package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	
	Customer c = new Customer(1l, "john", "doe");

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	@Test
	public void testConstructor() {
		Customer c1 = new Customer("michael,", "jenkins");
		Customer c2 = new Customer (2l, "leroy", "jeknins");
		assertTrue(c1 instanceof Customer); 
		assertTrue(c2 instanceof Customer);
	}
	
	@Test
	public void testGetId() {
		Customer al = new Customer("jamie", "oliver");
		assertSame(1l, c.getId());
		assertNull(al.getId());
	}
	
	@Test
	public void testSetID() {
		Customer al = new Customer("alex", "jones");
		al.setId(5l);
		assertSame(5l, al.getId());
	}
	
	@Test
	public void testgetFirstName() {
		assertSame("john", c.getFirstName());
	}
	
	@Test
	public void testGetSurname() {
		assertSame("doe", c.getSurname());
	}
	
	@Test
	public void testToString() {
		assertEquals("Cust_id:1 first name:john surname:doe", c.toString());
	}
}
