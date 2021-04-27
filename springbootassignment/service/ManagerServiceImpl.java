package com.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daomodel.InvoiceMasterDao;
import com.daomodel.ItemDetailsMasterDao;
import com.model.InvoiceMasterDto;
import com.model.ItemDetailsMasterDto;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private InvoiceMasterDao imd;
	
	@Autowired
	private ItemDetailsMasterDao itd;
	
	@Override
	public List<InvoiceMasterDto> getInvByDate(Date fromdate, Date todate) {
		return imd.getByDate(fromdate, todate);
	}

	@Override
	public List<InvoiceMasterDto> getInvByCustomerId(int cusId) {
		return imd.getInvoiceByCustomer(cusId);
	}

	@Override
	public InvoiceMasterDto getByInvoiceNo(int invNo) {
		return imd.findInvoiceById(invNo);
	}

	@Override
	public List<ItemDetailsMasterDto> getAllStockDTOs() {
		return itd.getAllItemDetails();
	}

	@Override
	public ItemDetailsMasterDto getStockByItemId(int itemId) {
		return itd.findItemById(itemId);
	}
	
}
