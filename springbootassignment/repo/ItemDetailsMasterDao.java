package com.daomodel;

import java.util.List;

import com.model.ItemDetailsMasterDto;

public interface ItemDetailsMasterDao {
	public boolean insertItemDetails(ItemDetailsMasterDto itemDetails);
	public boolean updateItemDetails(ItemDetailsMasterDto itemDetails);
	public boolean deleteItemDetails(int itemId);
	public List<ItemDetailsMasterDto> findItemByName(String itemName);
	public List<ItemDetailsMasterDto> findItemByShopId(int shopid);
	public ItemDetailsMasterDto findItemById(int  itemId);
	public List<ItemDetailsMasterDto> getAllItemDetails();
}
