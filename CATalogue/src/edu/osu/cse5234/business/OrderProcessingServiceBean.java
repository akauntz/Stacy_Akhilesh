package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse52234.util.ServiceLocator;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService iS = ServiceLocator.getInventoryService();
    	if(iS.validateQuantity(order.getItems())) {
    		iS.updateInventory(order.getItems());
    	}
    	return "";
    }

    public boolean validateItemAvailability(Order order) {
    	InventoryService iS = ServiceLocator.getInventoryService();
    	return(iS.validateQuantity(order.getItems()));
    	
    }
    
}
