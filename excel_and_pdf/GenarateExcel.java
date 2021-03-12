package excel_and_pdf;

import java.util.List;

import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

public class GenarateExcel {

	public static void genarateExcel(List<Invoice> invoiceList, String fileName) {
		WritableWorkbook myFirstWbook = null;

		try {
			myFirstWbook = Workbook.createWorkbook(new File("billbook.xls"));
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			for (Invoice invoice : invoiceList) {

				Label label = new Label(1, 1, invoice.toString());
				excelSheet.addCell(label);
				myFirstWbook.write();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (myFirstWbook != null) {
				try {
					myFirstWbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Excel created");
		}

	}
}
