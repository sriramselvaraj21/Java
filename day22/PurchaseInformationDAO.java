package day22;

import java.util.Set;

public interface PurchaseInformationDAO {
	public int insertPurchaseInfo(PurchaseInformationDTO purchaseInformationDTO) throws Exception;

	public int deletePurchaseInfo(String invoiceNumber) throws Exception;

	public int updatePurchaseInfo(PurchaseInformationDTO purchaseInformationDTO) throws Exception;

	public PurchaseInformationDTO getPurchaseInformation(String invoiceNumber) throws Exception;

	public Set<PurchaseInformationDTO> getPurchaseInformationAll() throws Exception;
}
