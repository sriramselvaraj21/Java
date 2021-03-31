package shoppingapplication.model;

import java.util.ArrayList;
import java.util.Set;

public interface JewellerShopDAO {
	public ArrayList<JewellerShopDTO> getJewellerShopDTO(int itemid);

	public Set<JewellerShopDTO> getAllJewellerShopDTO();

	public int deleteItem(int uid);

	public int updateItem(JewellerShopDTO jewellerShopDTO);

	public int insertItem(JewellerShopDTO jewellerShopDTO);

	public JewellerShopDTO getItemByName(String itemName);
}
