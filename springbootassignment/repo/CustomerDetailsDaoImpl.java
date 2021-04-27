package com.daomodel;


import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.CustomerDetailsDto;


@SuppressWarnings("unchecked")
@Repository
public class CustomerDetailsDaoImpl implements CustomerDetailsDao{
	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean insertCustomerDetails(CustomerDetailsDto customerdetails) {
		try {
			Session session=factory.getCurrentSession();
			session.save(customerdetails);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCustomerDetails(CustomerDetailsDto customerdetails) {
		try {
			Session session=factory.getCurrentSession();
			session.update(customerdetails);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean deleteCustomerDetails(int customerId) {
		try {
			CustomerDetailsDto cust=this.findCustomerById(customerId);
			Session session=factory.getCurrentSession();
			session.delete(cust);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override	
	public List<CustomerDetailsDto> findCustomerByName(String name) {
		try {
			Session session=factory.getCurrentSession();
			Query q=session.createQuery("from CustomerDetailsDto cd where cd.name=:n");
			q.setParameter("n", name);
			List<CustomerDetailsDto> list=q.list();
			//System.out.println(list);
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CustomerDetailsDto findCustomerById(int customerId) {
		CustomerDetailsDto obj=null;
		try {
			Session session=factory.getCurrentSession();
			obj=(CustomerDetailsDto)session.get(CustomerDetailsDto.class, customerId);
			
			return obj;
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDetailsDto> getAllCustomerDetails() {
		List<CustomerDetailsDto> list=null;
		try {
			Session session=factory.getCurrentSession();
			list=(List<CustomerDetailsDto>)session.createQuery("from CustomerDetailsDto").list();
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		System.out.println(new CustomerDetailsDaoImpl().findCustomerByName("some name"));
//	}
}
