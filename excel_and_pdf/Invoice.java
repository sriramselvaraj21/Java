package excel_and_pdf;


public class Invoice {
	private int id;
	private String invno;
	private String invdate;
	private String customername;
	private String customernumber;
	private String customeraddress;
	private String itemno;
	private String itemname;
	private String itemprice;
	private String itemqty;
	private String amount;
	private String units;
	private String gst;
	private String net;

	public String getInvno() {
		return invno;
	}

	public void setInvno(String invno) {
		this.invno = invno;
	}

	public String getInvdate() {
		return invdate;
	}

	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomernumber() {
		return customernumber;
	}

	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemprice() {
		return itemprice;
	}

	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}

	public String getItemqty() {
		return itemqty;
	}

	public void setItemqty(String itemqty) {
		this.itemqty = itemqty;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [ invno=" + invno + ", invdate=" + invdate + ", customername=" + customername + ", customernumber="
				+ customernumber + ", customeraddress=" + customeraddress + ", itemno=" + itemno + ", itemname="
				+ itemname + ", itemprice=" + itemprice + ", itemqty=" + itemqty + ", amount=" + amount + ", units="
				+ units + ", gst=" + gst + ", net=" + net + "]";
	}
}
