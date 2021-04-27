package com.service;

import java.util.List;

import com.model.ItemDetailsMasterDto;

public interface ItemService {
	public boolean addItem(ItemDetailsMasterDto item);
	public boolean updateItem(ItemDetailsMasterDto item);
	public boolean deleteItem(ItemDetailsMasterDto item);
	public List<ItemDetailsMasterDto> getAllItems();
}
