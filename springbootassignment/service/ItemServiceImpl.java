package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daomodel.ItemDetailsMasterDao;
import com.model.ItemDetailsMasterDto;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDetailsMasterDao itemaccessobj;
	
	public synchronized final ItemDetailsMasterDao getItemaccessobj() {
		return itemaccessobj;
	}

	public synchronized final void setItemaccessobj(ItemDetailsMasterDao itemaccessobj) {
		this.itemaccessobj = itemaccessobj;
	}

	@Override
	public boolean addItem(ItemDetailsMasterDto item) {
		try {
			item.setItemno(1);
			return itemaccessobj.insertItemDetails(item);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItem(ItemDetailsMasterDto item) {
		try {
			String itemname=item.getItemdescription();
			System.out.println("Serive---ItemName---"+itemname);
			ItemDetailsMasterDto temp=itemaccessobj.findItemByName(itemname).get(0);
			System.out.println("Service----ItemObj----"+temp);
			temp.setImageurl(item.getImageurl());
			temp.setItemdescription(item.getItemdescription());
			temp.setItemprice(item.getItemprice());
			temp.setItemunits(item.getItemunits());
			temp.setShopid(item.getShopid());
			return itemaccessobj.updateItemDetails(temp);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItem(ItemDetailsMasterDto item) {
		try {
			String itemname=item.getItemdescription();
			ItemDetailsMasterDto temp=itemaccessobj.findItemByName(itemname).get(0);
			return itemaccessobj.deleteItemDetails(temp.getItemno());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ItemDetailsMasterDto> getAllItems() {
		
		return itemaccessobj.getAllItemDetails();
	}

}
