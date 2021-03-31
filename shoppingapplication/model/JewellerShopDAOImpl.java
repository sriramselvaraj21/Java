package shoppingapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

public class JewellerShopDAOImpl implements Cloneable, JewellerShopDAO {

	@Override
	public Set<JewellerShopDTO> getAllJewellerShopDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteItem(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItem(JewellerShopDTO jewellerShopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertItem(JewellerShopDTO jewellerShopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JewellerShopDTO getItemByName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<JewellerShopDTO> getJewellerShopDTO(int itemid) {
		ArrayList<JewellerShopDTO> items = null;
		System.out.println("JewellerShopDTO getJewellerShopDTO called");
		try {
			items = new ArrayList<>();
			JewellerShopDTO jewellerShopDTO = new JewellerShopDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from jewelleryshop");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//					System.out.println(rs.getString("itemid"));
//					System.out.println(rs.getString("itemname"));
//					System.out.println(rs.getString("itembrand"));
//					System.out.println(rs.getString("price"));
//					System.out.println(rs.getString("quantity"));
//					System.out.println(rs.getString("picture"));

				jewellerShopDTO = new JewellerShopDTO();
				jewellerShopDTO.setItemId(Integer.parseInt(rs.getString("itemid")));
				jewellerShopDTO.setItemName(rs.getString("itemname"));
				jewellerShopDTO.setItemBrand(rs.getString("itembrand"));
				jewellerShopDTO.setPrice(Integer.parseInt(rs.getString("price")));
				jewellerShopDTO.setQuantity(Integer.parseInt(rs.getString("quantity")));
				jewellerShopDTO.setItemImage(rs.getString("picture"));
				items.add(jewellerShopDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

}
