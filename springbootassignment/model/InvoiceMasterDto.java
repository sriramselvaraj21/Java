package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="InvoiceMaster")
@NamedQueries({
	@NamedQuery(name = "getInvbyDate" , query = "from InvoiceMasterDto where invDate >=: fromdate and invDate <=: todate"),
	@NamedQuery(name = "getByCus" , query = "from InvoiceMasterDto where customerno =: customerno")
})
public class InvoiceMasterDto implements Serializable,Cloneable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invno;
	private Date invDate;
	private long customerno;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private ArrayList<ArrayList<String>> invdata;
	@Transient
	private static InvoiceMasterDto invmobj;
	private InvoiceMasterDto() {
		
	}
	
	public synchronized InvoiceMasterDto getCloneObj() throws Exception{
		return (InvoiceMasterDto)super.clone();
	}
	
	public static synchronized InvoiceMasterDto getClone() throws Exception{
		if(invmobj==null) {
			invmobj=new InvoiceMasterDto();
			return invmobj;
		}
		return invmobj;
	}
	
	
	public int getInvno() {
		return invno;
	}

	public void setInvno(int invno) {
		this.invno = invno;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public long getCustomerno() {
		return customerno;
	}

	public void setCustomerno(long customerno) {
		this.customerno = customerno;
	}

	public static InvoiceMasterDto getInvmobj() {
		return invmobj;
	}

	public static void setInvmobj(InvoiceMasterDto invmobj) {
		InvoiceMasterDto.invmobj = invmobj;
	}

	public ArrayList<ArrayList<String>> getInvdata() {
		return invdata;
	}

	public void setInvdata(ArrayList<ArrayList<String>> invdata) {
		this.invdata = invdata;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDto [invno=" + invno + ", invDate=" + invDate + ", customerno=" + customerno + ", invdata="
				+ invdata + "]";
	}

	
}
