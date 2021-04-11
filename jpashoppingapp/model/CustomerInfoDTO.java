package jpashoppingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerInfoDTO {
	public CustomerInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String custNumber;
	private String custName;
	private String custAddress;
	private String custContact;
	private String custEmail;

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "CustomerInfoDTO [custNumber=" + custNumber + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custContact=" + custContact + ", custEmail=" + custEmail + "]";
	}

}
