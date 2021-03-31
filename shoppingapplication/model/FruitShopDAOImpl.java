package shoppingapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

public class FruitShopDAOImpl implements Cloneable, FruitShopDAO {

	@Override
	public Set<FruitShopDTO> getAllFruitShopDTO() {
		try {
			// FruitShopDTO fruitshopDTO = new FruitShopDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from fruitshop");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.toString());
			// return (Set<FruitShopDTO>) fruitshopDTO;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteItem(int itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItem(FruitShopDTO fruitShopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertItem(FruitShopDTO fruitShopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FruitShopDTO getItemByName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FruitShopDTO> getFruitShopDTO(int itemid) {
		ArrayList<FruitShopDTO> items = null;
		System.out.println("FruitShopDTO getFruitShopDTO called");
		try {
			items = new ArrayList<>();
			FruitShopDTO fruitShopDTO = new FruitShopDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from fruitshop");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				System.out.println(rs.getString("itemid"));
//				System.out.println(rs.getString("itemname"));
//				System.out.println(rs.getString("itembrand"));
//				System.out.println(rs.getString("price"));
//				System.out.println(rs.getString("quantity"));
//				System.out.println(rs.getString("picture"));

				fruitShopDTO = new FruitShopDTO();
				fruitShopDTO.setItemId(Integer.parseInt(rs.getString("itemid")));
				fruitShopDTO.setItemName(rs.getString("itemname"));
				fruitShopDTO.setItemBrand(rs.getString("itembrand"));
				fruitShopDTO.setPrice(Integer.parseInt(rs.getString("price")));
				fruitShopDTO.setQuantity(Integer.parseInt(rs.getString("quantity")));
				fruitShopDTO.setItemImage(rs.getString("picture"));
				items.add(fruitShopDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

//	public static void main(String[] args) {
//		FruitShopDAOImpl f = new FruitShopDAOImpl();
//		System.out.println("sd");
//		System.out.println(f.getFruitShopDTO(1));
//	}
}
