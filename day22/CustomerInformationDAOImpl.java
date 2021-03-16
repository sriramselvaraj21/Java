package day22;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class CustomerInformationDAOImpl implements CustomerInformationDAO {

	@Override
	public int insertCustomerInfo(CustomerInformationDTO customerInformationDTO) throws Exception {
		String customerNumber = customerInformationDTO.getCustomerNumber();
		String customerContact = customerInformationDTO.getCustomerContact();
		String customerEmail = customerInformationDTO.getCustomerEmail();
		String customerName = customerInformationDTO.getCustomerAddress();

		String query = "insert into CustomerInfo_Table values(?,?,?,?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, customerNumber);
		stmt.setString(2, customerName);
		stmt.setString(3, customerEmail);
		stmt.setString(4, customerContact);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows inserted");
		return 0;
	}

	@Override
	public int deleteCutomerInfo(int customerNumber) throws Exception {
		String query = "delete from CustomerInfo_Table where cus_Number = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setInt(1, customerNumber);
		int count = stmt.executeUpdate();
		System.out.println(count + "rows deleted");
		return 0;
	}

	@Override
	public int updateCutomerInfo(CustomerInformationDTO customerInformationDTO) throws Exception {
		String customerNumber = customerInformationDTO.getCustomerNumber();
		String customerContact = customerInformationDTO.getCustomerContact();
		String customerEmail = customerInformationDTO.getCustomerEmail();
		String customerName = customerInformationDTO.getCustomerAddress();

		String query = "update CustomerInfo_Table set (cus_Number = ?,cust_name = ?, cust_email = ?,cust_contact = ?)";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setString(1, customerNumber);
		stmt.setString(2, customerName);
		stmt.setString(3, customerEmail);
		stmt.setString(4, customerContact);

		int count = stmt.executeUpdate();
		System.out.println(count + "rows updates");
		return 0;
	}

	@Override
	public CustomerInformationDTO getCustomerInformation(int customerNumber) throws Exception {
		String query = "select * from CustomerInfo_Table where cus_Number = ?";
		PreparedStatement stmt = DBUtility.getConnection().prepareStatement(query);
		stmt.setInt(1, customerNumber);
		ResultSet rs = stmt.executeQuery();
		System.out.println(rs.toString());
		return null;
	}

	@Override
	public Set<CustomerInformationDTO> getCustomerInformationAll() throws Exception {
		String query = "select * from CustomerInfo_Table";
		Statement stmt = DBUtility.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs.toString());
		return null;
	}

}
