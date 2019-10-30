package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse52234.util.ServiceLocator;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
//    	InventoryService iS = ServiceLocator.getInventoryService();
//    	if(iS.validateQuantity(order.getItems())) {
//    		iS.updateInventory(order.getItems());
//    	}
//    	return "8030";
    	entityManager.persist(order);
    	entityManager.flush();
    	return "hi";
    }

    public boolean validateItemAvailability(Order order) {
//    	InventoryService iS = ServiceLocator.getInventoryService();
//    	return(iS.validateQuantity(order.getItems()));
    	
    	List<Item> itemList = new ArrayList<>();
    	for(LineItem i : order.getItems()) {
    		Item item = new Item();
    		item.setAvailableQuantity(i.getQuantity());
    		//item.setDescription(i.getDescription());
    		item.setId(i.getId());
    		item.setItemNumber(i.getItemNumber());
    		item.setName(i.getItemName());
    		item.setUnitPrice(i.getPrice());
    		itemList.add(item);
    	}
    	
    	
    	return ServiceLocator.getInventoryService().validateQuantity(itemList);
    	
    }
    
}
