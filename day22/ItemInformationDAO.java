package day22;

import java.sql.SQLException;
import java.util.Set;

public interface ItemInformationDAO {
	public int insertItemInfo(ItemInformationDTO itemInformationDTO) throws SQLException;

	public int deleteItemInfo(int itemNumber) throws SQLException;

	public int updateItemInfo(ItemInformationDTO itemInformationDTO) throws SQLException;

	public ItemInformationDTO getItemInfo(int itemNumber) throws SQLException;

	public Set<ItemInformationDTO> getItemInformationAll() throws SQLException;
}
