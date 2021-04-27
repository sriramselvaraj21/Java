package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="ItemDetailsMaster")
public class ItemDetailsMasterDto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemno;
	private String itemdescription;
	private int itemunits;
	private int itemprice;
	private int shopid;
	private String imageurl;
	
	@Transient
	private static ItemDetailsMasterDto itemdobj;
	private ItemDetailsMasterDto() {
		
	}
	
	public synchronized ItemDetailsMasterDto getCloneObj() throws Exception{
		return (ItemDetailsMasterDto)super.clone();
	}
	
	public static synchronized ItemDetailsMasterDto getClone() throws Exception{
		if(itemdobj==null) {
			itemdobj=new ItemDetailsMasterDto();
			return itemdobj;
		}
		return itemdobj;
	}
	
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getItemdescription() {
		return itemdescription;
	}
	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public int getItemunits() {
		return itemunits;
	}
	public void setItemunits(int itemunits) {
		this.itemunits = itemunits;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() {
		return "ItemDetailsMasterDto [itemno=" + itemno + ", itemdescription=" + itemdescription + ", itemunits="
				+ itemunits + ", itemprice=" + itemprice + ", shopid=" + shopid + ", imageurl=" + imageurl + "]";
	}
}
