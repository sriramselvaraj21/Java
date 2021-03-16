package day22;

import java.io.Serializable;

public class ItemInformationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemNumber;
	private String itemDescription;
	private String itemPrice;
	private String itemQuantity;

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "ItemInformationDTO [itemNumber=" + itemNumber + ", itemDescription=" + itemDescription + ", itemPrice="
				+ itemPrice + ", itemQuantity=" + itemQuantity + "]";
	}

}