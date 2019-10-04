package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/home")
public class MainController {
	@RequestMapping(method = RequestMethod.GET)
	public String viewHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setAttribute("order", getInitialOrder());
		return "Home"; 
	}
	
	
	@RequestMapping(path = "/aboutus", method = RequestMethod.GET)
	public String viewAboutUs(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "AboutUs";
	}
	
	@RequestMapping(path = "/contactus", method = RequestMethod.GET)
	public String viewContactUs(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "ContactUs";
	}
}
