package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long Item_id = resultSet.getLong("Item_id");
		Long Cust_id = resultSet.getLong("Cust_id");
		Long Order_id = resultSet.getLong("Order_id");
		float item_quantity = resultSet.getFloat("item_quantity");
		float item_price = resultSet.getFloat("item_price");
		String first_name = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		String item_Name = resultSet.getString("item_name");
		return new Orders(Order_id, Cust_id, Item_id, first_name, surname, item_Name, item_price, item_quantity);
	}
	
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select  `orders`.`order_id`, `orders`.`Cust_id`, `orders`.`Item_id` , `customers`.`first_name`,`customers`.`surname`, `items`.`item_name`, \r\n"
						+ "`items`.`item_price`, `orders`.`item_quantity`, (`items`.`item_price` * `orders`.`item_quantity`)'\r\n"
						+ "from `orders`, `items`, `customers`\r\n"
						+ "where `orders`.`Item_id` = `items`.`Item_id`\r\n"
						+ "and `orders`.`Cust_id` = `customers`.`Cust_id`");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Orders read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("Select  `orders`.`order_id`, `orders`.`Cust_id`, `orders`.`Item_id` , `customers`.`first_name`,`customers`.`surname`, `items`.`item_name`, \r\n"
						+ "`items`.`item_price`, `orders`.`item_quantity`, (`items`.`item_price` * `orders`.`item_quantity`)\r\n"
						+ "from `orders`, `items`, `customers`\r\n"
						+ "where `orders`.`Item_id` = `items`.`Item_id`\r\n"
						+ "and `orders`.`Cust_id` = `customers`.`Cust_id`");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(Cust_id, Item_id, item_quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, order.getcustId());
			statement.setLong(2, order.getitemId());
			statement.setFloat(3, order.getItemQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders set Cust_id = ?, Item_id = ?, item_quantity = ? WHERE Order_id = ?");) {
			statement.setLong(1, order.getcustId());
			statement.setLong(2, order.getitemId());
			statement.setFloat(3, order.getItemQuantity());
			statement.setFloat(4, order.getorderId());
			statement.executeUpdate();
			return read(order.getorderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select  `orders`.`order_id`, `orders`.`Cust_id`, `orders`.`Item_id` , `customers`.`first_name`,`customers`.`surname`, `items`.`item_name`, \r\n"
						+ "`items`.`item_price`, `orders`.`item_quantity`, (`items`.`item_price` * `orders`.`item_quantity`)\r\n"
						+ "from `orders`, `items`, `customers`\r\n"
						+ "where `orders`.`Item_id` = `items`.`Item_id`\r\n"
						+ "and `orders`.`Cust_id` = `customers`.`Cust_id` ORDER BY Order_id");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE Order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
