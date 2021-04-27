package com.daomodel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ItemDetailsMasterDto;

@SuppressWarnings("unchecked")
@Repository
public class ItemDetailsMasterDaoImpl implements ItemDetailsMasterDao{
	@Autowired
	public SessionFactory factory;
	@Override
	public boolean insertItemDetails(ItemDetailsMasterDto itemDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.save(itemDetails);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItemDetails(ItemDetailsMasterDto itemDetails) {
		try {
			Session session=factory.getCurrentSession();
			session.update(itemDetails);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItemDetails(int itemId) {
		try {
			ItemDetailsMasterDto idm=this.findItemById(itemId);
			Session session=factory.getCurrentSession();
			session.delete(idm);
			
			return true;
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ItemDetailsMasterDto> findItemByName(String itemName) {
		List<ItemDetailsMasterDto> list;
		try {
			Session session=factory.getCurrentSession();
			Query query=session.createQuery("from ItemDetailsMasterDto as idm where idm.itemdescription=:na");
			query.setParameter("na", itemName);
			list=query.list();
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<ItemDetailsMasterDto> findItemByShopId(int shopid) {
		List<ItemDetailsMasterDto> list;
		try {
			Session session=factory.getCurrentSession();
			Query query=session.createQuery("from ItemDetailsMasterDto as idm where idm.shopid=:na");
			query.setParameter("na", shopid);
			list=query.list();
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ItemDetailsMasterDto findItemById(int itemId) {
		try {
			Session session=factory.getCurrentSession();
			ItemDetailsMasterDto itemDetails=(ItemDetailsMasterDto)session.get(ItemDetailsMasterDto.class, itemId);
			
			return itemDetails;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ItemDetailsMasterDto> getAllItemDetails() {
		List<ItemDetailsMasterDto> list=null;
		try {
			Session session=factory.getCurrentSession();
			Query query=session.createQuery("from ItemDetailsMasterDto");
			list=query.list();
			
			return list;
		}catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		ItemDetailsMasterDto idm=new ItemDetailsMasterDto();
//		idm.setImageurl("some url11");
//		idm.setItemdescription("Hello11");
//		idm.setItemno(1);
//		idm.setItemprice(6765);
//		idm.setItemunits(89);
//		idm.setShopid(1);
//		new ItemDetailsMasterDaoImpl().deleteItemDetails(1);
//	}
}
