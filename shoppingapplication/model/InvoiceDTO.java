package shoppingapplication.model;

public class InvoiceDTO {
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
		return "InvoiceDTO [itemId=" + itemId + ", itemName=" + itemName + ", itemBrand=" + itemBrand + ", price="
				+ price + ", quantity=" + quantity + ", itemImage=" + itemImage + "]";
	}

	public InvoiceDTO(int itemId, String itemName, String itemBrand, int price, int quantity, String itemImage) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
		this.quantity = quantity;
		this.itemImage = itemImage;
	}

	public InvoiceDTO() {
		// TODO Auto-generated constructor stub
	}
}
