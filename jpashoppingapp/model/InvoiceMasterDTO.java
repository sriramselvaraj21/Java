package jpashoppingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InvoiceMasterDTO {
	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String invoiceNumber;
	private String invoiceDate;
	private String custNumber;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String string) {
		this.invoiceDate = string;
	}

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", custNumber="
				+ custNumber + "]";
	}

}
