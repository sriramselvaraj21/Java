package day22;

import java.util.Set;

public interface PurchaseInformationDAO {
	public int insertPurchaseInfo(PurchaseInformationDTO purchaseInformationDTO) throws Exception;

	public int deletePurchaseInfo(int invoiceNumber) throws Exception;

	public int updatePurchaseInfo(PurchaseInformationDTO purchaseInformationDTO) throws Exception;

	public PurchaseInformationDTO getPurchaseInformation(int invoiceNumber) throws Exception;

	public Set<PurchaseInformationDTO> getPurchaseInformationAll() throws Exception;
}
