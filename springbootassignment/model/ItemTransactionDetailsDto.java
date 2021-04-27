package com.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="ItemTransactionDetails")
public class ItemTransactionDetailsDto implements Serializable{
	@EmbeddedId
	private InvoiceKey invkey;
	private int qty;
	
	@Transient
	private static ItemTransactionDetailsDto itemtobj;
	public ItemTransactionDetailsDto() {
		
	}
	
	public synchronized ItemTransactionDetailsDto getCloneObj() throws Exception{
		return (ItemTransactionDetailsDto)super.clone();
	}
	
	public static synchronized ItemTransactionDetailsDto getClone() throws Exception{
		if(itemtobj==null) {
			itemtobj=new ItemTransactionDetailsDto();
			return itemtobj;
		}
		return itemtobj;
	}

	public InvoiceKey getInvkey() {
		return invkey;
	}

	public void setInvkey(InvoiceKey invkey) {
		this.invkey = invkey;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public static ItemTransactionDetailsDto getItemtobj() {
		return itemtobj;
	}

	public static void setItemtobj(ItemTransactionDetailsDto itemtobj) {
		ItemTransactionDetailsDto.itemtobj = itemtobj;
	}

	@Override
	public String toString() {
		return "ItemTransactionDetailsDto [invkey=" + invkey + ", qty=" + qty + "]";
	}
	
}
