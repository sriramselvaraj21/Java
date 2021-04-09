package day_08_04_21.compositepack;

import java.io.Serializable;

public class CompKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int inv_id;
	private int item_id;

	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

}