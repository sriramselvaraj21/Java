package shoppingapplication.model;

import java.util.ArrayList;
import java.util.Set;

public interface GroceryShopDAO {
	public ArrayList<GroceryShopDTO> getGroceryShopDTO(int itemid);

	public Set<GroceryShopDTO> getAllGroceryShopDTO();

	public int deleteItem(int itemId);

	public int updateItem(GroceryShopDTO groceryShopDTO);

	public int insertItem(GroceryShopDTO groceryShopDTO);

	public GroceryShopDTO getItemByName(String itemName);
}
