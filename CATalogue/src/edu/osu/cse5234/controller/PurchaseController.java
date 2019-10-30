//package edu.osu.cse5234.controller;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import edu.osu.cse52234.util.ServiceLocator;
//import edu.osu.cse5234.business.OrderProcessingServiceBean;
//import edu.osu.cse5234.business.view.Inventory;
//import edu.osu.cse5234.business.view.InventoryService;
//import edu.osu.cse5234.model.Item;
//import edu.osu.cse5234.model.LineItem;
//import edu.osu.cse5234.model.Order;
//import edu.osu.cse5234.model.PaymentInfo;
//import edu.osu.cse5234.model.ShippingInfo;
//
//
//@Controller
//@RequestMapping("/purchase")
//public class PurchaseController {
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setAttribute("order", getInitialOrder());
//		return "OrderEntryForm"; 
//	}
//	
//	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
//	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
//		request.getSession().setAttribute("order", order);
//		OrderProcessingServiceBean opsb =ServiceLocator.getOrderProcessingService();
//		if(opsb.validateItemAvailability(order)) {
//			return "redirect:/purchase/shippingEntry";
//		} else {
//			String resub= "Please resubmit item quantities";
//			request.getSession().setAttribute("resubmit", resub);
//			return "redirect:/purchase";
//		}
//	}
//
//
//	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
//	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("paymentInfo", new PaymentInfo());	
//		return "PaymentEntryForm";
//	}
//
//	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
//	public String submitPayment(@ModelAttribute("PaymentInfo") PaymentInfo PaymentInfo, HttpServletRequest request, HttpServletResponse response) {
//		Order ord = (Order) request.getSession().getAttribute("order");
//		ord.setPayment(PaymentInfo);
////		request.getSession().setAttribute("shippingInfo", shippingInfo);
//		return "redirect:/purchase/shippingEntry";
//	}
//	
//	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
//	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setAttribute("shippingInfo", new ShippingInfo());	
//		return "ShippingEntryForm"; 
//	}
//	
//	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
//	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Order ord = (Order) request.getSession().getAttribute("order");
//		ord.setShipping(shippingInfo);
////		request.getSession().setAttribute("shippingInfo", shippingInfo);
//		return "redirect:/purchase/viewOrder";
//	}
//	
//	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
//	public String viewOrderEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {		
//		return "ViewOrder"; 
//	}
//	
//	private Order getInitialOrder(){
//		InventoryService iS = ServiceLocator.getInventoryService();
//		Inventory inv = iS.getAvailableInventory();
////		List<LineItem> items = inv.getItemsInv();
//		
//		List<LineItem> lineItemList = new ArrayList<>();
//		for(Item i : iS.getAvailableInventory().getItemsInv()) {
//			LineItem lineItem = new LineItem();
//			lineItem.setId(i.getId());
//			lineItem.setItemName(i.getName());
//			lineItem.setItemNumber(i.getItemNumber());
//			lineItem.setPrice(i.getUnitPrice());
//			lineItem.setQuantity(0);
//			lineItemList.add(lineItem);
//		}
//		
//		Order order = new Order();
//		order.setItems(lineItemList);
//
//		return order;
//	}
//
//	@RequestMapping(path = "confirmOrder", method = RequestMethod.POST)
//	public String confirmOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
////		OrderProcessingServiceBean opsb= new OrderProcessingServiceBean();
////		String conf = opsb.processOrder(getInitialOrder());
////		request.getSession().setAttribute("confirmationNo",conf);
//		Order order = (Order) request.getSession().getAttribute("order");
//		request.getSession().setAttribute("confirmation", ServiceLocator.getOrderProcessingService().processOrder(order));
//		return "redirect:/purchase/viewConfirmation";
//	}
//	
//	@RequestMapping(path = "viewConfirmation", method = RequestMethod.GET)
//	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		return "ViewConfirmation"; 
//	}
//}

package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
//import edu.osu.cse5234.util.ServiceLocator;
import edu.osu.cse52234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		
		
		List<LineItem> i1 = new ArrayList<>();
    	for(Item i : ServiceLocator.getInventoryService().getAvailableInventory().getItemsInv()) {
    		LineItem item = new LineItem();
    		item.setQuantity(0);
    		item.setId(i.getId()); 
    		item.setItemNumber(i.getItemNumber());
    		item.setItemName(i.getName());
    		item.setPrice(i.getUnitPrice());
			i1.add(item);
    	}
		
		order.setItems(i1);
		request.setAttribute("order", order);
		return "OrderEntryForm"; 
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("error", null);

		if(ServiceLocator.getOrderProcessingService().validateItemAvailability(order)) {
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/paymentEntry";
		} else {
			request.getSession().setAttribute("error", "Please enter a valid amount");
			return "redirect:/purchase";
		}
	}


	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "PaymentEntryForm";
	}

//	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
//	public String submitPayment(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) {
//		request.getSession().setAttribute("shippingInfo", shippingInfo);
//		return "redirect:/purchase/shippingEntry";
//	}
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("PaymentInfo") PaymentInfo PaymentInfo, HttpServletRequest request, HttpServletResponse response) {
		Order ord = (Order)request.getSession().getAttribute("order");
		ord.setPayment(PaymentInfo);
		//request.getSession().setAttribute("shippingInfo", new ShippingInfo());
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());	
		return "ShippingEntryForm"; 
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getSession().setAttribute("shippingInfo", shippingInfo);
		Order ord = (Order)request.getSession().getAttribute("order");
		ord.setShipping(shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return "ViewOrder"; 
	}

	@RequestMapping(path = "confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = (Order) request.getSession().getAttribute("order");
		request.getSession().setAttribute("confirmation", ServiceLocator.getOrderProcessingService().processOrder(order));
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewConfirmation"; 
	}
}