package com.qa.ims.persistence.domain;

public class Items {
	
	private Long Iid;
	private float itemPrice;
	private String itemName;

	public Items(String itemName, float itemPrice) {
		this.setItemName(itemName);
		this.setitemPrice(itemPrice);
	}
	public Items(long Iid, String itemName, float itemPrice) {
		this.setItemName(itemName);
		this.setIid(Iid);
		this.setitemPrice(itemPrice);
	}
	

	public Long getIid() {
		return Iid;
	}

	public void setIid(Long iid) {
		Iid = iid;
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
		return " Iid " + this.Iid + " Item Name " + this.itemName + " item price " + this.itemPrice;
	}
}
