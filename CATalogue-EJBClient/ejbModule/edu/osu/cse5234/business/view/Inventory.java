package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import edu.osu.cse5234.model.LineItem;

public class Inventory implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4741276659145606965L;
	private List<LineItem> items = new ArrayList<>();

	public List<LineItem> getItemsInv() {
		return items;
	}

	public void setItemsInv(List<LineItem> items) {
		this.items = items;
	}
	
}
