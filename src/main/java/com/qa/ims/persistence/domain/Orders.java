package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long custId;
	private Long itemId;
	private Long orderId;
	private float itemPrice;
	private float itemQuantity;
	private float orderCost;
	private String customerName;
	private String itemName;
	
	
	public Orders(Long custId, Long itemId, float itemQuantity) {
		this.setcustId(custId);
		this.setitemId(itemId);
		this.setItemQuantity(itemQuantity);
	}
	
	public Orders(Long orderId, Long custId, Long itemId, float itemQuantity) {
		this.setorderId(orderId);
		this.setcustId(custId);
		this.setitemId(itemId);
		this.setItemQuantity(itemQuantity);
	}
		
		public Orders(Long orderId, Long custId, Long itemId, String firstName, String lastName, String itemName, float itemPrice ,float itemQuantity) {
			this.setorderId(orderId);
			this.setcustId(custId);
			this.setitemId(itemId);
			this.setItemQuantity(itemQuantity);
			this.setItemPrice(itemPrice);
			this.setCustomerName(firstName + " " + lastName);
			this.setItemName(itemName);
			this.setOrderCost(this.itemPrice * this.itemQuantity);
			
	}
	public Long getcustId() {
		return custId;
	}
	public void setcustId(Long custId) {
		this.custId = custId;
	}
	public Long getitemId() {
		return itemId;
	}
	public void setitemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getorderId() {
		return orderId;
	}
	public void setorderId(Long orderId) {
		this.orderId = orderId;
	}
	public float getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(float itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public float getorderCost() {
		return orderCost;
	}

	public void setorderCost(float orderCost) {
		this.orderCost = orderCost;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	public String toString() {
		return "orderID: " + this.orderId + ", Customer Name: " + this.customerName + ", item name: " + this.itemName + ", Item Price: " + this.itemPrice + ", Item quantity: " + this.itemQuantity + ", total_cost " + this.orderCost;
		//return "orderId: " + this.orderId + ", custId: " + this.custId + ", itemId: " + this.itemId + ", item quantity: " + this.itemQuantity;
	}

}
