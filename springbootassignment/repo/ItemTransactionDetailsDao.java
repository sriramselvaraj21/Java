package com.daomodel;

import java.util.List;

import com.model.ItemTransactionDetailsDto;

public interface ItemTransactionDetailsDao {
	public boolean insertItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails);
	public boolean updateItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails);
	public boolean deleteItemTransactionDetails(int itemId,int invid);
	//public List<ItemTransactionDetailsDto> findTransactionByName(String name);
	public ItemTransactionDetailsDto findTransactionById(int itemId,int invid);
	public List<ItemTransactionDetailsDto> getAllItemTransactionDetails(int invno);
}
