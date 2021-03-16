package day22;

import java.util.Set;

public interface CustomerInformationDAO {
	public int insertCustomerInfo(CustomerInformationDTO customerInformationDTO) throws Exception;

	public int deleteCutomerInfo(int customerNumber) throws Exception;

	public int updateCutomerInfo(CustomerInformationDTO customerInformationDTO) throws Exception;

	public CustomerInformationDTO getCustomerInformation(int customerNumber) throws Exception;

	public Set<CustomerInformationDTO> getCustomerInformationAll() throws Exception;
}
