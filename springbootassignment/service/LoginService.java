package com.service;

public interface LoginService {
	public boolean checkUser(String uname,String upass);
	public boolean updateFlag(String uname,String upass,int flag);
	public int checkFlag(String uname,String upass);
	public int getUserId(String uname,String upass);
	public boolean checkAdmin(String uname,String upass);
	public boolean checkManager(String uname,String upass);
}
