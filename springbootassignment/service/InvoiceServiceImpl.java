package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daomodel.CustomerDetailsDao;
import com.daomodel.InvoiceMasterDao;
import com.daomodel.ItemDetailsMasterDao;
import com.daomodel.ItemTransactionDetailsDao;
import com.model.CustomerDetailsDto;
import com.model.InvoiceMasterDto;
import com.model.ItemDetailsMasterDto;
import com.model.ItemTransactionDetailsDto;

@Service
@Transactional
public class InvoiceServiceImpl implements Cloneable, InvoiceService {
	@Autowired
	InvoiceMasterDao db;
	@Autowired
	CustomerDetailsDao cdb;
	@Autowired
	ItemTransactionDetailsDao idtl;
	@Autowired
	ItemDetailsMasterDao idml;
	
	public synchronized final InvoiceMasterDao getDb() {
		return db;
	}

	public synchronized final void setDb(InvoiceMasterDao db) {
		this.db = db;
	}

	public synchronized final CustomerDetailsDao getCdb() {
		return cdb;
	}

	public synchronized final void setCdb(CustomerDetailsDao cdb) {
		this.cdb = cdb;
	}

	public synchronized final ItemTransactionDetailsDao getIdtl() {
		return idtl;
	}

	public synchronized final void setIdtl(ItemTransactionDetailsDao idtl) {
		this.idtl = idtl;
	}

	public synchronized final ItemDetailsMasterDao getIdml() {
		return idml;
	}

	public synchronized final void setIdml(ItemDetailsMasterDao idml) {
		this.idml = idml;
	}

	@Override
	public ArrayList<ArrayList<String>> getInvoice(int invno) {
		
		ArrayList<ArrayList<String>> fdata=new ArrayList<ArrayList<String>>();
		ArrayList<String> tdata=new ArrayList<String>();
		ArrayList<String> heading=new ArrayList<String>();
		try {
		
		InvoiceMasterDto master=db.findInvoiceById(invno);
		heading.add(Integer.toString(0));
		tdata.add("Invoice Number");
		tdata.add("Invoice Date");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		tdata.add(Long.toString(master.getInvno()));
		tdata.add(master.getInvDate().toString());
		fdata.add(tdata);
		tdata=null;
		tdata=new ArrayList<String>();
		
		CustomerDetailsDto data=cdb.findCustomerById((int)master.getCustomerno());
		heading.add(Integer.toString(2));
		tdata.add("Customer Name");
		tdata.add("Customer Address");
		tdata.add("Customer Email");
		tdata.add("Customer Phone");
		fdata.add(tdata);
		tdata=null;
		tdata=new ArrayList<String>();
		tdata.add(data.getName());
		tdata.add(data.getAddress());
		tdata.add(data.getEmail());
		tdata.add(data.getPhone());
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		
		List<ItemTransactionDetailsDto> ss=idtl.getAllItemTransactionDetails(invno);
		heading.add(Integer.toString(4));
		tdata.add("Item Number");
		tdata.add("Item Description");
		tdata.add("Item Units");
		tdata.add("Item price");
		tdata.add("Item Quantity");
		tdata.add("Amount");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		
		double total=0;
		int c=0;
		for(ItemTransactionDetailsDto temp:ss) {
			ItemDetailsMasterDto test=idml.findItemById(temp.getInvkey().getItemno());
			tdata.add(Integer.toString(test.getItemno()));
			tdata.add(test.getItemdescription());
			tdata.add(Integer.toString(test.getItemunits()));
			tdata.add(Integer.toString(test.getItemprice()));
			tdata.add(Integer.toString(temp.getQty()));
			double unitprice=test.getItemprice()/test.getItemunits();
			double amt=unitprice*temp.getQty();
			total+=amt;
			tdata.add(Double.toString(amt));
			fdata.add(tdata);
			tdata=null;
			tdata=new ArrayList<String>();
			c++;
			
		}
		heading.add(Integer.toString(5+c));
		tdata.add("Total");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		tdata.add(Double.toString(total));
		fdata.add(tdata);
		fdata.add(heading);
		System.out.println(fdata);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return fdata;
}
	@Override
	public void send(String recipient, String fileloc) {
				
	}
}
