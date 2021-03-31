package shoppingapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

public class GroceryShopDAOImpl implements Cloneable, GroceryShopDAO {

	@Override
	public Set<GroceryShopDTO> getAllGroceryShopDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteItem(int itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItem(GroceryShopDTO groceryShopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertItem(GroceryShopDTO groceryShopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GroceryShopDTO getItemByName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GroceryShopDTO> getGroceryShopDTO(int itemid) {
		ArrayList<GroceryShopDTO> items = null;
		System.out.println("GroceryShopDTO getFruitShopDTO called");
		try {
			items = new ArrayList<>();
			GroceryShopDTO groceryShopDTO = new GroceryShopDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from groceryshop");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				System.out.println(rs.getString("itemid"));
//				System.out.println(rs.getString("itemname"));
//				System.out.println(rs.getString("itembrand"));
//				System.out.println(rs.getString("price"));
//				System.out.println(rs.getString("quantity"));
//				System.out.println(rs.getString("picture"));

				groceryShopDTO = new GroceryShopDTO();
				groceryShopDTO.setItemId(Integer.parseInt(rs.getString("itemid")));
				groceryShopDTO.setItemName(rs.getString("itemname"));
				groceryShopDTO.setItemBrand(rs.getString("itembrand"));
				groceryShopDTO.setPrice(Integer.parseInt(rs.getString("price")));
				groceryShopDTO.setQuantity(Integer.parseInt(rs.getString("quantity")));
				groceryShopDTO.setItemImage(rs.getString("picture"));
				items.add(groceryShopDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

}
