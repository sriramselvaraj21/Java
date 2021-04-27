package com.service;

import java.util.ArrayList;

public interface InvoiceService {
	public ArrayList<ArrayList<String>> getInvoice(int invno);
	public void send(String recipient,String fileloc);
}
