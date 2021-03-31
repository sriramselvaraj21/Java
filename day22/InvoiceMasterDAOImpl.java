package day22;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	@Override
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception {
		String invoiceNumber = invoiceMasterDTO.getInvoiceNumber();
		Date invoiceDate = invoiceMasterDTO.getInvoiceDate();
		String customerNumber = invoiceMasterDTO.getCustomerNumber();

		String query = "insert into Invoice_Master values(?,?,?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, invoiceNumber);
		stmt.setDate(2, invoiceDate);
		stmt.setString(3, customerNumber);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows inserted");

		return 0;
	}

	@Override
	public int deleteInvoice(String invoiceNumber) throws Exception {
		String query = "delete from Invoice_Master where invNo = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, invoiceNumber);
		int count = stmt.executeUpdate();
		System.out.println(count + "rows deleted");
		return 0;
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception {
		String invoiceNumber = invoiceMasterDTO.getInvoiceNumber();
		Date invoiceDate = invoiceMasterDTO.getInvoiceDate();
		String customerNumber = invoiceMasterDTO.getCustomerNumber();

		String query = "update Invoice_Master set invoice_number = ? ,invoice_date=?, customer_number=?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, invoiceNumber);
		stmt.setDate(2, invoiceDate);
		stmt.setString(3, customerNumber);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows updated");
		return 0;
	}

	@Override
	public InvoiceMasterDTO getInvoiceMaster(String invoiceNumber) throws Exception {
		String query = "select * from Invoice_Master where invoice_number = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, invoiceNumber);
		ResultSet rs = stmt.executeQuery();
		System.out.println(rs.toString());
		return null;
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() throws SQLException {
		String query = "select * from Invoice_Master";
		Statement stmt = DBUtility.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs.toString());
		return null;
	}
}