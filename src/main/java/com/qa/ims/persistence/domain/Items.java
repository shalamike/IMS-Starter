package com.qa.ims.persistence.domain;

public class Items {
		
	private Long Item_id;
	private double itemPrice;
	private String itemName;
	
	public Items(String itemName, double itemPrice) {
		super();
		this.setItemName(itemName);
		this.setitemPrice(itemPrice);
	}
	public Items(long Item_id, String itemName, double itemPrice) {
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

	public double getitemPrice() {
		return itemPrice;
	}

	public void setitemPrice(double itemPrice2) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Item_id == null) ? 0 : Item_id.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Items other = (Items) obj;
		if (Item_id == null) {
			if (other.Item_id != null)
				return false;
		} else if (!Item_id.equals(other.Item_id))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		return true;
	}
	
	
}
