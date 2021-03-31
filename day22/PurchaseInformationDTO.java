package day22;

import java.io.Serializable;

public class PurchaseInformationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String invoiceNumber;
	private String itemNumber;
	private String ItemUnit;

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

	public String getItemUnit() {
		return ItemUnit;
	}

	public void setItemUnit(String itemUnit) {
		ItemUnit = itemUnit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PurchaseInformationDTO [invoiceNumber=" + invoiceNumber + ", itemNumber=" + itemNumber + ", ItemUnit="
				+ ItemUnit + "]";
	}

}
