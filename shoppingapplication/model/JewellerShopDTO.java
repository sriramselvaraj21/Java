package shoppingapplication.model;

public class JewellerShopDTO {
	private int itemId;
	private String itemName;
	private String itemBrand;
	private int price;
	private int quantity;
	private String itemImage;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	@Override
	public String toString() {
		return "JewellerShopDTO [itemId=" + itemId + ", itemName=" + itemName + ", itemBrand=" + itemBrand + ", price="
				+ price + ", quantity=" + quantity + ", itemImage=" + itemImage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemBrand == null) ? 0 : itemBrand.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemImage == null) ? 0 : itemImage.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + price;
		result = prime * result + quantity;
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
		JewellerShopDTO other = (JewellerShopDTO) obj;
		if (itemBrand == null) {
			if (other.itemBrand != null)
				return false;
		} else if (!itemBrand.equals(other.itemBrand))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemImage == null) {
			if (other.itemImage != null)
				return false;
		} else if (!itemImage.equals(other.itemImage))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (price != other.price)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	public JewellerShopDTO() {
		// TODO Auto-generated constructor stub
	}

	public JewellerShopDTO(int itemId, String itemName, String itemBrand, int price, int quantity, String itemImage) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
		this.quantity = quantity;
		this.itemImage = itemImage;
	}

}
