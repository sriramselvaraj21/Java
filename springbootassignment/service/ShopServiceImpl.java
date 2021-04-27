package com.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daomodel.InvoiceMasterDao;
import com.daomodel.ItemDetailsMasterDao;
import com.daomodel.ItemTransactionDetailsDao;
import com.model.InvoiceMasterDto;
import com.model.ItemDetailsMasterDto;
import com.model.ItemTransactionDetailsDto;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ItemDetailsMasterDao idm;
	@Autowired
	private InvoiceMasterDao imd;
	@Autowired
	private ItemTransactionDetailsDao itdo;
	@Override
	public ArrayList<ItemDetailsMasterDto> getDetails(int shopid) {
		List<ItemDetailsMasterDto> temp=idm.findItemByShopId(shopid);
		return new ArrayList<ItemDetailsMasterDto>(temp);
	}
	
	
	@Override
	public void addItems(List<ItemDetailsMasterDto> data) {
		try {
			Iterator<ItemDetailsMasterDto> iterator=data.iterator();
			while(iterator.hasNext()) {
				ItemDetailsMasterDto data1= iterator.next();
				idm.insertItemDetails(data1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int addIteminInvoice(ItemTransactionDetailsDto itm) {
		try {
			itdo.insertItemTransactionDetails(itm);
			return 0;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int getInvoiceNumber() {
		return imd.getInvoicNumber()+1;
	}

	@Override
	public int addInvoiceMaster(int custno) {
		try {
			InvoiceMasterDto invm=InvoiceMasterDto.getClone();
			invm.setCustomerno(custno);
			invm.setInvDate(Date.valueOf(LocalDate.now()));
			//invm.setInvno(invno);
			return imd.insertInvoiceDetails(invm);
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public void updateItemUnits(int itemNo,int units) {
		try {
			ItemDetailsMasterDto dto =  idm.findItemById(itemNo);
			dto.setItemunits(dto.getItemunits() - units);
			idm.updateItemDetails(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ItemDetailsMasterDto getItemDetails(int itemid) {
		return idm.findItemById(itemid);
	}


	@Override
	public void addListToInvoice(int invno, ArrayList<ArrayList<String>> data) {
		InvoiceMasterDto inv=imd.findInvoiceById(invno);
		inv.setInvdata(data);
		imd.updateInvoiceDetails(inv);
		
		System.out.println("--------------"+inv);
	}
	
	

}
