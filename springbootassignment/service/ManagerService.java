package com.service;

import java.sql.Date;
import java.util.List;
import com.model.InvoiceMasterDto;
import com.model.ItemDetailsMasterDto;

public interface ManagerService {
	
	public List<InvoiceMasterDto> getInvByDate(Date fromdate,Date todate);
	public List<InvoiceMasterDto> getInvByCustomerId(int cusId);
	public InvoiceMasterDto getByInvoiceNo(int invNo);
	public List<ItemDetailsMasterDto> getAllStockDTOs();
	public ItemDetailsMasterDto getStockByItemId(int itemId);
	
}
