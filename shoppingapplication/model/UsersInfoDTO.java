package shoppingapplication.model;

import java.io.Serializable;

public class UsersInfoDTO implements Serializable {

	public UsersInfoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UsersInfoDTO(int customerNumber, String customerUsername, String customerPassword, int customerFlag) {
		this.customerNumber = customerNumber;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.customerFlag = customerFlag;

	}

	private static final long serialVersionUID = 1L;
	private int customerNumber;
	private String customerUsername;
	private String customerPassword;
	private int customerFlag;

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getCustomerFlag() {
		return customerFlag;
	}

	public void setCustomerFlag(int customerFlag) {
		this.customerFlag = customerFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UsersInfoDTO [customerNumber=" + customerNumber + ", customerUsername=" + customerUsername
				+ ", customerPassword=" + customerPassword + ", customerFlag=" + customerFlag + "]";
	}
}
