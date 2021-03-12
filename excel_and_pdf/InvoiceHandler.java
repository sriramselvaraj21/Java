package excel_and_pdf;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class InvoiceHandler extends DefaultHandler {

	private boolean hasinvno = false;
	private boolean hasinvdate = false;
	private boolean hascustomername = false;
	private boolean hascustomernumber = false;
	private boolean hascustomeraddress = false;
	private boolean hasitemno = false;
	private boolean hasitemname = false;
	private boolean hasitemprice = false;
	private boolean hasitemqty = false;
	private boolean hasamount = false;
	private boolean hasunits = false;
	private boolean hasgst = false;
	private boolean hasnet = false;

	private List<Invoice> invoiceList = null;
	private Invoice invoice = null;

	public List<Invoice> getEmpList() {
		return invoiceList;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("invoice")) {
			String id = attributes.getValue("id");
			invoice = new Invoice();
			invoice.setId(Integer.parseInt(id));
			if (invoiceList == null)
				invoiceList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("invno")) {
			hasinvno = true;
		} else if (qName.equalsIgnoreCase("invdate")) {
			hasinvdate = true;
		} else if (qName.equalsIgnoreCase("customername")) {
			hascustomername = true;
		} else if (qName.equalsIgnoreCase("customernumber")) {
			hascustomernumber = true;
		} else if (qName.equalsIgnoreCase("customeraddress")) {
			hascustomeraddress = true;
		} else if (qName.equalsIgnoreCase("itemno")) {
			hasitemno = true;
		} else if (qName.equalsIgnoreCase("itemname")) {
			hasitemname = true;
		} else if (qName.equalsIgnoreCase("itemprice")) {
			hasitemprice = true;
		} else if (qName.equalsIgnoreCase("itemqty")) {
			hasitemqty = true;
		} else if (qName.equalsIgnoreCase("amount")) {
			hasamount = true;
		} else if (qName.equalsIgnoreCase("units")) {
			hasunits = true;
		} else if (qName.equalsIgnoreCase("gst")) {
			hasgst = true;
		} else if (qName.equalsIgnoreCase("net")) {
			hasnet = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("invoice")) {
			invoiceList.add(invoice);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (hasinvno) {
			invoice.setInvno(new String(ch, start, length));
			hasinvno = false;
		} else if (hasinvdate) {
			invoice.setInvdate(new String(ch, start, length));
			hasinvdate = false;
		} else if (hascustomername) {
			invoice.setCustomername(new String(ch, start, length));
			hascustomername = false;
		} else if (hascustomernumber) {
			invoice.setCustomernumber(new String(ch, start, length));
			hascustomernumber = false;
		} else if (hascustomeraddress) {
			invoice.setCustomeraddress(new String(ch, start, length));
			hascustomeraddress = false;
		} else if (hasitemno) {
			invoice.setItemno(new String(ch, start, length));
			hasitemno = false;
		} else if (hasitemname) {
			invoice.setItemname(new String(ch, start, length));
			hasitemname = false;
		} else if (hasitemprice) {
			invoice.setItemprice(new String(ch, start, length));
			hasitemprice = false;
		} else if (hasamount) {
			invoice.setAmount(new String(ch, start, length));
			hasamount = false;
		} else if (hasitemqty) {
			invoice.setItemqty(new String(ch, start, length));
			hasitemqty = false;
		} else if (hasunits) {
			invoice.setUnits(new String(ch, start, length));
			hasunits = false;
		} else if (hasgst) {
			invoice.setGst(new String(ch, start, length));
			hasgst = false;
		} else if (hasnet) {
			invoice.setNet(new String(ch, start, length));
			hasnet = false;
		}
	}

}
