package shoppingapplication.model;

import java.util.ArrayList;
import java.util.Set;

public interface FruitShopDAO {
	public ArrayList<FruitShopDTO> getFruitShopDTO(int itemid);

	public Set<FruitShopDTO> getAllFruitShopDTO();

	public int deleteItem(int itemId);

	public int updateItem(FruitShopDTO fruitShopDTO);

	public int insertItem(FruitShopDTO fruitShopDTO);

	public FruitShopDTO getItemByName(String itemName);
}
