package com.daomodel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.InvoiceKey;
import com.model.ItemTransactionDetailsDto;


@SuppressWarnings("unchecked")
@Repository
public class ITemTransactionDetailsDaoImpl implements ItemTransactionDetailsDao{
	@Autowired
	public SessionFactory factory;
	@Override
	public boolean insertItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.save(ItemTransactionDetails);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.update(ItemTransactionDetails);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItemTransactionDetails(int invid,int itemId) {
		try {
			ItemTransactionDetailsDto itd=this.findTransactionById(invid,itemId);
			Session session=factory.getCurrentSession();
			session.delete(itd);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ItemTransactionDetailsDto findTransactionById(int invid,int itemId) {
		try {
			Session session=factory.getCurrentSession();
			InvoiceKey ikey=new InvoiceKey();
			ikey.setInvno(invid);
			ikey.setItemno(itemId);
			ItemTransactionDetailsDto trans=(ItemTransactionDetailsDto)session.get(ItemTransactionDetailsDto.class, ikey);
			
			return trans;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ItemTransactionDetailsDto> getAllItemTransactionDetails(int invno) {
		List<ItemTransactionDetailsDto> list=null;
		try {
			Session session=factory.getCurrentSession();
			Query query=session.createQuery("from ItemTransactionDetailsDto itdd where itdd.invkey.invno=:cc");
			query.setInteger("cc",invno);
			list=query.list();
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		ItemTransactionDetailsDto temp=new ItemTransactionDetailsDto();
//		temp.setQty(504323);
//		InvoiceKey ik=new InvoiceKey();
//		ik.setInvno(1);
//		ik.setItemno(19);
//		temp.setInvkey(ik);
//		
//		new ITemTransactionDetailsDaoImpl().deleteItemTransactionDetails(19, 1);
//	}
}
