package day22;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int invoiceNumber;
	private Date invoiceDate;
	private int customerNumber;

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", customerNumber="
				+ customerNumber + "]";
	}

}