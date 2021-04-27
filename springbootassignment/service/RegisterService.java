package com.service;

import com.formbeans.RegisterBean;

public interface RegisterService {
	public boolean addUserAndCustomer(RegisterBean rb);
	public String getEmail(int uid);
	public boolean addAdminUser(String uname,String pwd,int role);
}
