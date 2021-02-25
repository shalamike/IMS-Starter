package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items(2L, "7up", 1d);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		//resources
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1l, "crisps", 0.5d));
		expected.add(new Items(2l, "coke", 1d));
		//actions
		DAO.create(new Items(1l, "coke", 1d));
		//assertions
		List<Items> results = DAO.readAll();
		for(int x = 0; x < results.size(); x++) {
			assertEquals(expected.get(x), results.get(x));
		}
		
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items(1L, "crisps", 0.5f), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "crisps", 0.5f), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "cheese", 2f);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	
}