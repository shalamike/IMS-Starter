package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long Cust_id;
	private Long Item_id;
	private Long Order_id;
	private float itemQuantity;
	
	public Orders(long Cust_id, Long Item_id, float itemQuantity) {
		this.setCust_id(getCust_id());
		this.setItem_id(Item_id);
		this.setItemQuantity(itemQuantity);
	}
	
	public Orders(long Order_id, long Cust_id, Long Item_id, float itemQuantity) {
		this.setOrder_id(Order_id);
		this.setCust_id(getCust_id());
		this.setItem_id(Item_id);
		this.setItemQuantity(itemQuantity);
	}
	
	public Long getCust_id() {
		return Cust_id;
	}
	public void setCust_id(Long cust_id) {
		Cust_id = cust_id;
	}
	public Long getItem_id() {
		return Item_id;
	}
	public void setItem_id(Long item_id) {
		Item_id = item_id;
	}
	public Long getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(Long order_id) {
		Order_id = order_id;
	}
	public float getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(float itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	
	


}
