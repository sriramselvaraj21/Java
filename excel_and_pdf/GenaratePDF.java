package excel_and_pdf;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenaratePDF {
	public static void genaratePDF(List<Invoice> invoiceList, String fileName) {
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			PdfPTable table = new PdfPTable(13);

			table.addCell("BILL NO.");
			table.addCell("DATE");
			table.addCell("CUSTOMER NAME ");
			table.addCell("CUSTOMER NUMBER");
			table.addCell("CUSTOMER ADDRESS");
			table.addCell("ITEM NO");
			table.addCell("ITEM NAME");
			table.addCell("ITEM QUANTITY");
			table.addCell("ITEM PRICE");
			table.addCell("NO. OF UNITS");
			table.addCell("AMOUNT");
			table.addCell("GST");
			table.addCell("NET TOTAL");

			for (Invoice invoice : invoiceList) {
				table.addCell(invoice.getInvno());
				table.addCell(invoice.getInvdate());
				table.addCell(invoice.getCustomername());
				table.addCell(invoice.getCustomernumber());
				table.addCell(invoice.getCustomeraddress());
				table.addCell(invoice.getItemno());
				table.addCell(invoice.getItemname());
				table.addCell(invoice.getItemqty());
				table.addCell(invoice.getItemprice());
				table.addCell(invoice.getUnits());
				table.addCell(invoice.getAmount());
				table.addCell(invoice.getGst());
				table.addCell(invoice.getNet());

			}
			document.add(table);
			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("PDF Genarated");
		}
	}
}
