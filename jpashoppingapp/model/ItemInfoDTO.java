package jpashoppingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemInfoDTO {
	public ItemInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String itemId;
	private String itemName;
	private String price;
	private String quantity;
	private String brand;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ItemInfoDTO [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", quantity="
				+ quantity + ", brand=" + brand + "]";
	}

}
