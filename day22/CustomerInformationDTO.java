package day22;

import java.io.Serializable;

public class CustomerInformationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerNumber;
	private String customerName;
	private String CustomerAddress;
	private String CustomerEmail;
	private String CustomerContact;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getCustomerContact() {
		return CustomerContact;
	}

	public void setCustomerContact(String customerContact) {
		CustomerContact = customerContact;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerInformationDTO [customerNumber=" + customerNumber + ", customerName=" + customerName
				+ ", CustomerAddress=" + CustomerAddress + ", CustomerEmail=" + CustomerEmail + ", CustomerContact="
				+ CustomerContact + "]";
	}

}