package com.formbeans;

public class TableBean {
	private String desc;
	private int qty;
	public synchronized final String getDesc() {
		return desc;
	}
	public synchronized final void setDesc(String desc) {
		this.desc = desc;
	}
	public synchronized final int getQty() {
		return qty;
	}
	public synchronized final void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "TableBean [desc=" + desc + ", qty=" + qty + "]";
	}
}
