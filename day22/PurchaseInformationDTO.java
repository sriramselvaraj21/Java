package day22;

import java.io.Serializable;

public class PurchaseInformationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String invoiceNumber;
	private String itemNumber;
	private int ItemUnit;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getItemUnit() {
		return ItemUnit;
	}

	public void setItemunit(int itemUnit) {
		ItemUnit = itemUnit;
	}

	@Override
	public String toString() {
		return "PurchaseInformationDTO [invoiceNumber=" + invoiceNumber + ", itemNumber=" + itemNumber
				+ ", ItemQuantity=" + ItemUnit + "]";
	}

}
