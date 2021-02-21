package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrdersDAO ordersDao;
	private Utils utils;
	
	public OrdersController(OrdersDAO ordersDao, Utils utils) {
		super();
		this.ordersDao = ordersDao;
		this.utils = utils;
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDao.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter a valid Cust_is");
		Long custId= utils.getLong();
		LOGGER.info("Please enter a valid item_id");
		Long itemId= utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		Orders order= ordersDao.create(new Orders(custId, itemId, quantity));
		LOGGER.info("item created");
		return order;
	}

	@Override
	public Orders update() {
		LOGGER.info("please enter the OrderId of the order you wish to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the new CustID");
		Long CustId = utils.getLong();
		LOGGER.info("please enter the new itemId");
		Long itemId = utils.getLong();
		LOGGER.info("please enter the new quantity");
		float quantity = utils.getFloat();
		return ordersDao.create(new Orders(orderId, CustId, itemId, quantity));
		
		
	}

	@Override
	public int delete() {
		LOGGER.info("please enter the Order_id you wish to delete");
		Long orderId = utils.getLong();
		return ordersDao.delete(orderId);
	}

}
