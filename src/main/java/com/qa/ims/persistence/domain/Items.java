package com.qa.ims.persistence.domain;

public class Items {
	
	private Long Item_id;
	private float itemPrice;
	private String itemName;

	public Items(String itemName, float itemPrice) {
		this.setItemName(itemName);
		this.setitemPrice(itemPrice);
	}
	public Items(long Item_id, String itemName, float itemPrice) {
		this.setItemName(itemName);
		this.setItem_id(Item_id);
		this.setitemPrice(itemPrice);
	}
	

	public Long getItem_id() {
		return Item_id;
	}

	public void setItem_id(Long Item_id) {
		this.Item_id = Item_id;
	}

	public float getitemPrice() {
		return itemPrice;
	}

	public void setitemPrice(float itemPrice2) {
		this.itemPrice = itemPrice2;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public String toString() {
		return "Item_id: " + this.Item_id + ", Item Name: " + this.itemName + ", item price: " + this.itemPrice;
	}
}
