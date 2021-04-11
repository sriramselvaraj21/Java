package jpashoppingapp.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InvoiceInfoDTO {
	public InvoiceInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String invoiceNumber;
	private String invoicedate;
	private String custName;
	private String totalAmont;

	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTotalAmont() {
		return totalAmont;
	}

	public void setTotalAmont(String totalAmont) {
		this.totalAmont = totalAmont;
	}

	@Override
	public String toString() {
		return "InvoiceInfoDTO [invoiceNumber=" + invoiceNumber + ", invoicedate=" + invoicedate
				+ ", custName=" + custName + ", totalAmont=" + totalAmont + "]";
	}

}
