package com.daomodel;

import java.sql.Date;
//import java.time.LocalDate;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.InvoiceMasterDto;

@SuppressWarnings("unchecked")
@Repository
public class InvoiceMasterDaoImpl implements InvoiceMasterDao{
	@Autowired
	public SessionFactory factory;
	@Override
	public int insertInvoiceDetails(InvoiceMasterDto InvoiceDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.save(InvoiceDetails);
			
			return InvoiceDetails.getInvno();
		}catch(Exception e) {
			
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public boolean updateInvoiceDetails(InvoiceMasterDto InvoiceDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.update(InvoiceDetails);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteInvoiceDetails(int invoiceId) {
		try {
			InvoiceMasterDto inv=this.findInvoiceById(invoiceId);
			Session session=factory.getCurrentSession();
			session.delete(inv);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public InvoiceMasterDto findInvoiceById(int invoiceId) {
		InvoiceMasterDto invoice=null;
		try {
			Session session=factory.getCurrentSession();
			invoice =(InvoiceMasterDto)session.get(InvoiceMasterDto.class, invoiceId);
			
			return invoice;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public List<InvoiceMasterDto> getAllInvoiceDetails() {
		List<InvoiceMasterDto> list=null;
		try {
			Session session=factory.getCurrentSession();
			Query query=session.createQuery("from InvoiceMasterDto");
			list=(List<InvoiceMasterDto>)query.list();
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	

	@Override
	public int getInvoicNumber() {
		try {
			Session session=factory.getCurrentSession();
			Criteria c = session.createCriteria(InvoiceMasterDto.class);
			c.addOrder(Order.desc("invno"));
			c.setMaxResults(1);
			InvoiceMasterDto a=(InvoiceMasterDto)c.uniqueResult();
			return a.getInvno();
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public List<InvoiceMasterDto> getByDate(Date fromdate,Date todate) {
		Session session = factory.getCurrentSession();
		Query query = session.getNamedQuery("getInvbyDate");
		query.setDate("fromdate", fromdate);
		query.setDate("todate", todate);
		List<InvoiceMasterDto> result = query.list();
		return result;
	}
	
	@Override
	public List<InvoiceMasterDto> getInvoiceByCustomer(int custNo){
		Session session = factory.getCurrentSession();
		Query query = session.getNamedQuery("getByCus");
		query.setInteger("customerno", custNo);
		List<InvoiceMasterDto> result = query.list();
		return result;
	}
//	public static void main(String[] args) {
//		InvoiceMasterDto temp=new InvoiceMasterDto();
//		temp.setCustomerno(11);
//		temp.setInvDate(LocalDate.now());
//		temp.setInvno(1);
//		
//		new InvoiceMasterDaoImpl().deleteInvoiceDetails(1);
//	}

}
