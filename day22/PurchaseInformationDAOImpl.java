package day22;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class PurchaseInformationDAOImpl implements PurchaseInformationDAO {

	@Override
	public int insertPurchaseInfo(PurchaseInformationDTO purchaseInformationDTO) throws SQLException {
		String invoiceNumber = purchaseInformationDTO.getInvoiceNumber();
		String itemNumber = purchaseInformationDTO.getItemNumber();
		int itemUnit = purchaseInformationDTO.getItemUnit();

		String query = "insert into PurchaseInfo_Table values(?,?,?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, invoiceNumber);
		stmt.setString(2, itemNumber);
		stmt.setInt(3, itemUnit);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows inserted");
		return 0;
	}

	@Override
	public int deletePurchaseInfo(int invoiceNumber) throws SQLException {
		String query = "delete from PurchaseInfo_Table where ItemInfo_Table = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setInt(1, invoiceNumber);
		int count = stmt.executeUpdate();
		System.out.println(count + "rows deleted");
		return 0;
	}

	@Override
	public int updatePurchaseInfo(PurchaseInformationDTO purchaseInformationDTO) throws SQLException {
		String invoiceNumber = purchaseInformationDTO.getInvoiceNumber();
		String itemNumber = purchaseInformationDTO.getItemNumber();
		int itemUnit = purchaseInformationDTO.getItemUnit();

		String query = "update PurchaseInfo_Table set(inv_number = ?,item_number = ?,item_unit = ?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, invoiceNumber);
		stmt.setString(2, itemNumber);
		stmt.setInt(3, itemUnit);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows inserted");
		return 0;
	}

	@Override
	public PurchaseInformationDTO getPurchaseInformation(int invoiceNumber) throws SQLException {
		String query = "select * from PurchaseInfo_Table where item_number = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setInt(1, invoiceNumber);
		ResultSet rs = stmt.executeQuery();
		System.out.println(rs.toString());
		return null;
	}

	@Override
	public Set<PurchaseInformationDTO> getPurchaseInformationAll() throws SQLException {
		String query = "select * from PurchaseInfo_Table";
		Statement stmt = DBUtility.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs.toString());
		return null;

	}
}
