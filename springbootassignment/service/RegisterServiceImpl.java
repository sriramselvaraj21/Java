package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daomodel.CustomerDetailsDao;
import com.daomodel.UsersMasterDao;
import com.formbeans.RegisterBean;
import com.model.CustomerDetailsDto;
import com.model.UsersMasterDto;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	private CustomerDetailsDao cda;
	@Autowired
	private UsersMasterDao uma;
	@Autowired
	private LoginService ls;
	
	@Override
	public String getEmail(int uid) {
		CustomerDetailsDto  user=cda.findCustomerById(uid);
		return user.getEmail();
	}
	
	@Override
	public boolean addUserAndCustomer(RegisterBean rb) {
		try {
			UsersMasterDto uobj=UsersMasterDto.getClone();
			uobj.setFlag(0);
			uobj.setAdmin(0);
			uobj.setName(rb.getUsername());
			uobj.setPwd(rb.getPassword());
			uma.insertUsersDetails(uobj);
			
			CustomerDetailsDto cobj=CustomerDetailsDto.getClone();
			cobj.setAddress(rb.getAddress());
			cobj.setEmail(rb.getEmail());
			cobj.setName(rb.getUsername());
			cobj.setPhone(rb.getPhone());
			cobj.setCustno(ls.getUserId(rb.getUsername() ,rb.getPassword()));
			
			if( cda.insertCustomerDetails(cobj)) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	 @Override
	public boolean addAdminUser(String uname, String pwd,int role) {
		try {
			UsersMasterDto user=UsersMasterDto.getClone();
			user.setName(uname);
			user.setAdmin(role);
			user.setFlag(0);
			user.setPwd(pwd);
			return uma.insertUsersDetails(user);
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
