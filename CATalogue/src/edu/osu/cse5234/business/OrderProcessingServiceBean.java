package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessor;
import com.chase.payment.PaymentProcessorService;
import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse52234.util.ServiceLocator;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
	
	@PersistenceContext
	EntityManager entityManager;
	
	@WebServiceRef(wsdlLocation =
			 "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
			 private PaymentProcessorService service;
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
    	entityManager.persist(order);
    	entityManager.flush();
    	
    	CreditCardPayment creditCardPayment= new CreditCardPayment();
    	PaymentInfo payment = order.getPayment();
    	creditCardPayment.setCardHolderName(payment.getCardHolderName());
    	creditCardPayment.setCvvCode(payment.getCvvCode());
    	creditCardPayment.setExpirationDate(payment.getExpirationDate());
    	creditCardPayment.setCreditCardNumber(payment.getCreditCardNumber());
    	creditCardPayment.setId(payment.getId());

    	//service.getPaymentProcessorPort().processPayment(creditCardPayment);

    	ShippingInitiationClient client =  new ShippingInitiationClient(shippingResourceURI);
    	
    	String size = Integer.toString(order.getItems().size());
    	
    	JsonObject requestJson = Json.createObjectBuilder()
    			.add("Zip", "43201")
    			.add("Organization", "CATalogue")
    			.add("OrderRefId", "1234")
    			.add("ItemsNumber", size)
    			.build();
    	
    	
    	JsonObject responseJson = client.invokeInitiateShipping(requestJson);
    	System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
    	System.out.println("Shipping Reference Number: " +
    	responseJson.getInt("ShippingReferenceNumber"));
    	
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
