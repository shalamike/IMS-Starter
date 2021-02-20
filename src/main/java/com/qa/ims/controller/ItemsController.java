package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.util.Util;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;

import com.qa.ims.utils.Utils;

public class ItemsController implements  CrudController<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemsDAO itemsDao;
	private Utils utils;
	
	public ItemsController(ItemsDAO itemsDao, Utils utils) {
		super();
		this.itemsDao = itemsDao;
		this.utils = utils;
	}
	
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDao.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Items create() {

		
		LOGGER.info("Please enter item name");
		String itemName= utils.getString();
		LOGGER.info("Please enter item price");
		Float itemPrice= utils.getFloat();
		Items item = itemsDao.create(new Items(itemName, itemPrice));
		LOGGER.info("item created");
		return item;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the Item_id of the customer you would like to update");
		Long Item_id = utils.getLong();
		LOGGER.info("Please enter the Item Name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price");
		long itemPrice= utils.getLong();
		Items item = itemsDao.create(new Items(Item_id, itemName, itemPrice));
		LOGGER.info("Customer Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the Item_id of the customer you would like to delete");
		Long Item_id = utils.getLong();
		return itemsDao.delete(Item_id);
	}

}
