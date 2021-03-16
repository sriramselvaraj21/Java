package day22;

import java.util.Set;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception;

	public int deleteInvoice(int invoiceNumber) throws Exception;

	public int updateInvoice(InvoiceMasterDTO invoiMasterDTO) throws Exception;

	public InvoiceMasterDTO getInvoiceMaster(int invoiceNumber) throws Exception;

	public Set<InvoiceMasterDTO> getInvoiceMasterAll() throws Exception;
}