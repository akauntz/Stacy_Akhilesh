package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import edu.osu.cse5234.model.Item;


public class Inventory implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4741276659145606965L;
	private List<Item> items = new ArrayList<>();

	public List<Item> getItemsInv() {
		return items;
	}

	public void setItemsInv(List<Item> items) {
		this.items = items;
	}
	
}
