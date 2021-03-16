package day22;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class ItemInformationDAOImpl implements ItemInformationDAO {

	@Override
	public int insertItemInfo(ItemInformationDTO itemInformationDTO) throws SQLException {
		String itemNumber = itemInformationDTO.getItemNumber();
		String itemDescription = itemInformationDTO.getItemDescription();
		String itemPrice = itemInformationDTO.getItemPrice();
		String itemQuantity = itemInformationDTO.getItemQuantity();

		String query = "insert into ItemInfo_Table values(?,?,?,?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, itemNumber);
		stmt.setString(2, itemDescription);
		stmt.setString(3, itemPrice);
		stmt.setString(4, itemQuantity);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows inserted");
		return 0;
	}

	@Override
	public int deleteItemInfo(int itemNumber) throws SQLException {
		String query = "delete from ItemInfo_Table where cus_Number = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setInt(1, itemNumber);
		int count = stmt.executeUpdate();
		System.out.println(count + "rows deleted");
		return 0;
	}

	@Override
	public int updateItemInfo(ItemInformationDTO itemInformationDTO) throws SQLException {
		String itemNumber = itemInformationDTO.getItemNumber();
		String itemDescription = itemInformationDTO.getItemDescription();
		String itemPrice = itemInformationDTO.getItemPrice();
		String itemQuantity = itemInformationDTO.getItemQuantity();

		String query = "update ItemInfo_Table set(item_number =?,item_description=?,item_price=?,item_quantity=?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, itemNumber);
		stmt.setString(2, itemDescription);
		stmt.setString(3, itemPrice);
		stmt.setString(4, itemQuantity);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows inserted");
		return 0;
	}

	@Override
	public ItemInformationDTO getItemInfo(int itemNumber) throws SQLException {
		String query = "select * from ItemInfo_Table where item_number = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setInt(1, itemNumber);
		ResultSet rs = stmt.executeQuery();
		System.out.println(rs.toString());
		return null;
	}

	@Override
	public Set<ItemInformationDTO> getItemInformationAll() throws SQLException {
		String query = "select * from ItemInfo_Table";
		Statement stmt = DBUtility.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs.toString());
		return null;
	}

}
