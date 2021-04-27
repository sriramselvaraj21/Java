package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@SuppressWarnings("serial")
@Entity
@Table(name="CustomerDetails")
public class CustomerDetailsDto implements Serializable,Cloneable{

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custno;
	private String email;
	private String name;
	private String phone;
	private String address;
	
	@Transient
	private static CustomerDetailsDto custdobj;
	private CustomerDetailsDto() {
		
	}
	
	public synchronized CustomerDetailsDto getCloneObj() throws Exception{
		return (CustomerDetailsDto)super.clone();
	}
	
	public static synchronized CustomerDetailsDto getClone() throws Exception{
		if(custdobj==null) {
			custdobj=new CustomerDetailsDto();
			return custdobj;
		}
		return custdobj;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static CustomerDetailsDto getCustdobj() {
		return custdobj;
	}

	public static void setCustdobj(CustomerDetailsDto custdobj) {
		CustomerDetailsDto.custdobj = custdobj;
	}

	@Override
	public String toString() {
		return "CustomerDetialsDto [custno=" + custno + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + "]";
	}

}
