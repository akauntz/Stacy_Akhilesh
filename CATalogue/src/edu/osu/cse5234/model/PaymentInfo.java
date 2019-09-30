package edu.osu.cse5234.model;

public class PaymentInfo {
	private String creditCardNumber;
	private String expirationDate;
	private String cvvCode;
	private String cardHolder;
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
}
