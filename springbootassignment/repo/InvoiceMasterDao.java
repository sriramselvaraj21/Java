package com.daomodel;

import java.sql.Date;
import java.util.List;

import com.model.InvoiceMasterDto;

public interface InvoiceMasterDao {
	public int insertInvoiceDetails(InvoiceMasterDto InvoiceDetails);
	public boolean updateInvoiceDetails(InvoiceMasterDto InvoiceDetails);
	public boolean deleteInvoiceDetails(int invoiceId);
	//public List<InvoiceMasterDto> findByName(String name);
	public InvoiceMasterDto findInvoiceById(int  invoiceId);
	public List<InvoiceMasterDto> getAllInvoiceDetails();
	public int getInvoicNumber();
	public List<InvoiceMasterDto> getByDate(Date from,Date to);
	public List<InvoiceMasterDto> getInvoiceByCustomer(int custNo);
}
