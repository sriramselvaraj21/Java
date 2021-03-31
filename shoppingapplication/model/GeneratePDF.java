package shoppingapplication.model;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Geneate PDF Action Called");
		String fileName = "<path>";
		Document document = new Document();
		try {
			HttpSession session = request.getSession();

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			PdfPTable table = new PdfPTable(4);

			table.addCell("BILL NO.");
			table.addCell("DATE");
			table.addCell("CUSTOMER NAME ");
			table.addCell("NET TOTAL");

			table.addCell("1");
			table.addCell((String) session.getAttribute("billdate"));
			table.addCell((String) session.getAttribute("username"));
			table.addCell("350");

			document.add(table);
			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("PDF Genarated successfully");
		}
		return "generatepdf.success";
	}

}
