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
		super();
		this.setcustId(custId);
		this.setitemId(itemId);
		this.setItemQuantity(itemQuantity);
	}
	
	public Orders(Long orderId, Long custId, Long itemId, float itemQuantity) {
		super();
		this.setorderId(orderId);
		this.setcustId(custId);
		this.setitemId(itemId);
		this.setItemQuantity(itemQuantity);
	}
		
		public Orders(Long orderId, Long custId, Long itemId, String firstName, String lastName, String itemName, float itemPrice ,float itemQuantity) {
			super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + Float.floatToIntBits(itemPrice);
		result = prime * result + Float.floatToIntBits(itemQuantity);
		result = prime * result + Float.floatToIntBits(orderCost);
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Float.floatToIntBits(itemPrice) != Float.floatToIntBits(other.itemPrice))
			return false;
		if (Float.floatToIntBits(itemQuantity) != Float.floatToIntBits(other.itemQuantity))
			return false;
		if (Float.floatToIntBits(orderCost) != Float.floatToIntBits(other.orderCost))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}
