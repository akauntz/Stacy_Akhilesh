package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse52234.util.ServiceLocator;
import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class)
public class OrderProcessingServiceBean {
	
	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;
	
	@Resource(lookup="jms/emailQ")
	private Queue queue;

	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    private void notifyUser() {
    	String message = "akhileshgulati94@gmail.com" + ":" +
		"Your order was successfully submitted. " +
		"You will hear from us when items are shipped. " + new Date();
		System.out.println("Sending message: " + message);
		jmsContext.createProducer().send(queue, message);
		System.out.println("Message Sent!");
    }
    
    public String processOrder(Order order) {
//    	InventoryService iS = ServiceLocator.getInventoryService();
//    	if(iS.validateQuantity(order.getItems())) {
//    		iS.updateInventory(order.getItems());
//    	}
//    	return "8030";
    	entityManager.persist(order);
    	entityManager.flush();
    	notifyUser();
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
