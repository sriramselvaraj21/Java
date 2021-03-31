package excel_and_pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ReadXMLUsingDOM implements Convertor, Cloneable {
	public static ReadXMLUsingDOM object = null;

	public ReadXMLUsingDOM() {
		// TODO Auto-generated constructor stub
	}

	public static ReadXMLUsingDOM createObject() {
		if (object == null) {
			object = new ReadXMLUsingDOM();
		}
		return object;
	}

	public ReadXMLUsingDOM getClonedObject() throws Exception {
		return (ReadXMLUsingDOM) super.clone();
	}

	@Override
	public void doConvert(String inputFilePath, String outputFilePath) {
		SAXBuilder builder = new SAXBuilder();

		Document jdomDoc;
		try {
			jdomDoc = (Document) builder.build(inputFilePath);
			Element root = jdomDoc.getRootElement();
			List<Element> listOfInvoices = root.getChildren("invoice");
			List<Invoice> invoiceList = new ArrayList<>();
			for (Element element : listOfInvoices) {
				Invoice invoice = new Invoice();
				invoice.setId(Integer.parseInt((element.getAttributeValue("id"))));
				invoice.setInvno(element.getChildText("invo"));
				invoice.setInvdate(element.getChildText("invdate"));
				invoice.setCustomername(element.getChildText("customername"));
				invoice.setCustomernumber(element.getChildText("customernumber"));
				invoice.setCustomeraddress(element.getChildText("customeraddress"));
				invoice.setItemno(element.getChildText("itemno"));
				invoice.setItemname(element.getChildText("itemname"));
				invoice.setItemprice(element.getChildText("itemprice"));
				invoice.setItemqty(element.getChildText("itemqty"));
				invoice.setAmount(element.getChildText("amount"));
				invoice.setUnits(element.getChildText("units"));
				invoice.setGst(element.getChildText("gst"));
				invoice.setNet(element.getChildText("net"));
				invoiceList.add(invoice);
			}

			GenaratePDF.genaratePDF(invoiceList, outputFilePath);
			GenarateExcel.genarateExcel(invoiceList, outputFilePath);
//			for (Invoice invoice : invoiceList) {
//				System.out.println(invoice);
//			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("DOM Done");
		}

	}
}
