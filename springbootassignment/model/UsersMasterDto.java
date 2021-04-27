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
@Table(name="UsersMaster")
public class UsersMasterDto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	int admin;
	String name;
	String pwd;
	int flag;
	
	@Transient
	private static UsersMasterDto usersmobj;
	private UsersMasterDto() {
		
	}
	
	public synchronized UsersMasterDto getCloneObj() throws Exception{
		return (UsersMasterDto)super.clone();
	}
	
	public static synchronized UsersMasterDto getClone() throws Exception{
		if(usersmobj==null) {
			usersmobj=new UsersMasterDto();
			return usersmobj;
		}
		return usersmobj;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "UsersMasterDto [uid=" + uid + ", admin=" + admin + ", name=" + name + ", pwd=" + pwd + ", flag=" + flag
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + admin;
		result = prime * result + flag;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersMasterDto other = (UsersMasterDto) obj;
		if (admin != other.admin)
			return false;
		if (flag != other.flag)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
}
