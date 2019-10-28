package edu.osu.cse5234.business.view;

import java.util.List;

//import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;

public interface InventoryService {

	public Inventory getAvailableInventory();
	public boolean validateQuantity(List<LineItem> items);
	public boolean updateInventory(List<LineItem> items);

	
}
