package com.formbeans;

public class RegisterBean {
	private String username;
	private String password;
	private String address;
	private String email;
	private String phone;
	public synchronized final String getUsername() {
		return username;
	}
	public synchronized final void setUsername(String username) {
		this.username = username;
	}
	public synchronized final String getPassword() {
		return password;
	}
	public synchronized final void setPassword(String password) {
		this.password = password;
	}
	public synchronized final String getAddress() {
		return address;
	}
	public synchronized final void setAddress(String address) {
		this.address = address;
	}
	public synchronized final String getEmail() {
		return email;
	}
	public synchronized final void setEmail(String email) {
		this.email = email;
	}
	public synchronized final String getPhone() {
		return phone;
	}
	public synchronized final void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "RegisterBean [username=" + username + ", password=" + password + ", address=" + address + ", email="
				+ email + ", phone=" + phone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterBean other = (RegisterBean) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
