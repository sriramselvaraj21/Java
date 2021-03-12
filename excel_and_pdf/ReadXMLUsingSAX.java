package excel_and_pdf;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ReadXMLUsingSAX implements Cloneable, Convertor {
	public static ReadXMLUsingSAX object = null;

	public ReadXMLUsingSAX() {
	}

	public static ReadXMLUsingSAX createObject() {
		if (object == null) {
			object = new ReadXMLUsingSAX();
		}
		return object;
	}

	public ReadXMLUsingSAX getClone() throws Exception {
		return (ReadXMLUsingSAX) super.clone();
	}

	@Override
	public void doConvert(String inputFilePath, String outputFilePath) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

		SAXParser saxParser;
		try {
			saxParser = saxParserFactory.newSAXParser();
			InvoiceHandler handler = new InvoiceHandler();
			saxParser.parse(new File(inputFilePath), handler);

			List<Invoice> invoiceList = handler.getEmpList();

			GenaratePDF.genaratePDF(invoiceList, outputFilePath);
			GenarateExcel.genarateExcel(invoiceList, outputFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("SAX Done");
		}

	}

}
