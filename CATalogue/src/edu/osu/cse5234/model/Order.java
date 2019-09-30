package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Item> items = new ArrayList<>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
