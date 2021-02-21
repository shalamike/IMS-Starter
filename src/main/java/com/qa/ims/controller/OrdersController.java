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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
