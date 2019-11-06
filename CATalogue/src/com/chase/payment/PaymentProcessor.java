package com.chase.payment;

public class PaymentProcessor {

	public String ping() {
		return "The bank is up and running for business";
	}
	
	public String processPayment(CreditCardPayment creditCardPayment) {
		return "12345";
	}
	
}
