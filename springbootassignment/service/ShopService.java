package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.ItemDetailsMasterDto;
import com.model.ItemTransactionDetailsDto;


public interface ShopService {
	public ArrayList<ItemDetailsMasterDto> getDetails(int shopid);
	public int addIteminInvoice(ItemTransactionDetailsDto itm);
	public int getInvoiceNumber();
	public int addInvoiceMaster(int custno);
	public ItemDetailsMasterDto getItemDetails(int itemid);
	public void addItems(List<ItemDetailsMasterDto> data);
	public void updateItemUnits(int itemNo,int units);
	public void addListToInvoice(int invno,ArrayList<ArrayList<String>> data);
}
