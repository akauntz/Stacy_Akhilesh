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
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("order", getInitialOrder());
		return "OrderEntryForm"; 
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}


	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());	
		return "ShippingEntryForm"; 
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return "ViewOrder"; 
	}
	
	private Order getInitialOrder(){
		List<Item> items = new ArrayList<>();
		Order order = new Order();
		Item cat_1 = new Item();
		cat_1.setName("Extra fluffy cat");
		cat_1.setPrice("5.00");
		
		items.add(cat_1);

		Item cat_2 = new Item();
		cat_2.setName("Extra extra fluffy cat");
		cat_2.setPrice("5.50");
		items.add(cat_2);
		
		Item cat_3 = new Item();
		cat_3.setName("Soft cat");
		cat_3.setPrice("3.00");
		order.setItems(items);
		items.add(cat_3);
		
		Item cat_4 = new Item();
		cat_4.setName("Super soft cat");
		cat_4.setPrice("3.50");
		order.setItems(items);
		items.add(cat_4);

		Item cat_5 = new Item();
		cat_5.setName("Nice cat");
		cat_5.setPrice("1.00");
		items.add(cat_5);
		
		
		order.setItems(items);
		return order;
	}

	@RequestMapping(path = "confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewConfirmation"; 
	}
}
