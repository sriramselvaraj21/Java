package day22;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String invoiceNumber;
	private Date invoiceDate;
	private String customerNumber;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", customerNumber="
				+ customerNumber + "]";
	}

}