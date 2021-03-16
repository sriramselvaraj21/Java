package day22;

import java.io.Serializable;

public class CustomerInformationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerNumber;
	private String CustomerAddress;
	private String CustomerEmail;
	private String CustomerContact;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	@Override
	public String toString() {
		return "CustomerInformationDTO [customerNumber=" + customerNumber + ", CustomerAddress=" + CustomerAddress
				+ ", CustomerEmail=" + CustomerEmail + ", CustomerContact=" + CustomerContact + "]";
	}

}