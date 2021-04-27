package com.daomodel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UsersMasterDto;

@SuppressWarnings("unchecked")
@Repository
public class UsersMasterDaoImpl implements UsersMasterDao{
	@Autowired
	public SessionFactory factory;
	@Override
	public boolean insertUsersDetails(UsersMasterDto UsersDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.save(UsersDetails);			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateUsersDetails(UsersMasterDto UsersDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.update(UsersDetails);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUsersDetails(int userId) {
		try {
			UsersMasterDto user=this.findUserById(userId);
			Session session=factory.getCurrentSession();
			session.delete(user);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public UsersMasterDto findUserByName(String userName,String password) {
		try {
			Session session=factory.getCurrentSession();
			Query query=session.createQuery("from UsersMasterDto ud where ud.name=:un and ud.pwd=:up");
			query.setParameter("un",userName);
			query.setParameter("up",password);
			//System.out.println(query.list());
			if(query.list().size()!=0)
				return (UsersMasterDto)query.list().get(0);
			else
				return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public UsersMasterDto findUserById(int userId) {
		UsersMasterDto obj=null;
		try {
			Session session=factory.getCurrentSession();
			obj=(UsersMasterDto)session.get(UsersMasterDto.class,userId);
			
			return obj;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
		
	}

	@Override
	public List<UsersMasterDto> getAllUsersDetails() {
		List<UsersMasterDto> list=null;
		try {
			Session session=factory.getCurrentSession();
			list=session.createQuery("from UsersMasterDto").list();
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
//	public static void main(String[] args) {
//		UsersMasterDto temp=new UsersMasterDto();
//		temp.setFlag(0);
//		temp.setName("AKshayRaj");
//		temp.setPwd("Akshay@123");
//		temp.setUid(1);
//		
//		System.out.println(new UsersMasterDaoImpl().deleteUsersDetails(1));
//	}
	
}
