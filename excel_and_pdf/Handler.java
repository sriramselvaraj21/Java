package excel_and_pdf;

public class Handler {
	public static final String xmlFilePath = "C:\\Users\\AW126XW\\eclipse-workspace\\EY_Learing\\src\\excel_and_pdf\\invoice.xml";
	public static final String domPDFPath = "C:\\Users\\AW126XW\\eclipse-workspace\\EY_Learing\\dom_output.pdf";
	public static final String saxPDFPath = "C:\\Users\\AW126XW\\eclipse-workspace\\EY_Learing\\sax_output.pdf";

	public static void main(String[] args) throws Exception {
		Convertor dompdfwriter = Container.getReadXMLUsingDOM();
		dompdfwriter.doConvert(xmlFilePath, domPDFPath);

		Convertor saxpdfwriter = Container.getReadXMLUsingSAX();
		saxpdfwriter.doConvert(xmlFilePath, saxPDFPath);
	}
}
