package com.qa.ims.persistence.domain;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemsTest { 
	Items coke = new Items("coke", 1.5f);
	Items hat= new Items(1l, "hat", 5f);
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Items.class).verify();
	}
	
	
	@Test
	public void testConstructor(){
		assertTrue(coke instanceof Items);
		assertTrue(hat instanceof Items);
	}
	
	@Test 
	public void testGetItemsId(){
		assertSame(1l, hat.getItem_id());
	}
	
	@Test
	public void testSetItemsId() {
		coke.setItem_id(2l);
		assertSame(2l, coke.getItem_id());
	}
	
	@Test
	public void testgetItemsName() {
		assertSame("coke", coke.getItemName());
		assertSame("hat", hat.getItemName());
	}
	
	@Test
	public void testsetItemsName() {
		hat.setItemName("fedora");
		coke.setItemName("diet");
		assertSame("fedora", hat.getItemName());
		assertSame("diet", coke.getItemName());
	}
	
	@Test
	public void testGetItemPrice() {
		Items cd = new Items(3l, "cd", 1.5f);
		assertEquals(1.5f, cd.getitemPrice(), 1.5f);
	}
	
	@Test
	public void testToStringTest() {
		Items tv = new Items(4l, "tv", 100f);
		assertEquals("Item_id: 4, Item Name: tv, item price: 100.0", tv.toString());
	}
	
	
}
