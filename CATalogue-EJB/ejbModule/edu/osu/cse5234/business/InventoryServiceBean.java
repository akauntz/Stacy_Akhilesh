package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager entityManager;
	
	String MY_QUERY = "Select i from Item i";
	
//	public EntityManager getEntityManager() {
//		return entityManager;
//	}
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
	
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Inventory getAvailableInventory() {

    	List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
    	
		Inventory inv = new Inventory();
		inv.setItemsInv(items);
		
		return inv;
    }
    
	public boolean validateQuantity(List<Item> items) {
		
		List<Item> available = getAvailableInventory().getItemsInv();
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getAvailableQuantity() > available.get(i).getAvailableQuantity()) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean updateInventory(List<Item> items) {
		return true;
	}

}
