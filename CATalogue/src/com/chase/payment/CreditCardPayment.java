package com.chase.payment;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CREDIT_CARD_PAYMENT")
public class CreditCardPayment implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1031262432360962913L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="ID")
		private int id;
		
		@Column(name="CARD_NUM")
		private String creditCardNumber;
		
		@Column(name="EXP_DATE")
		private String expirationDate;
		
		@Column(name="CVV")
		private String cvvCode;
		
		@Column(name="HOLDER_NAME")
		private String cardHolderName;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCreditCardNumber() {
			return creditCardNumber;
		}
		public void setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
		}
		public String getExpirationDate() {
			return expirationDate;
		}
		public void setExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
		}
		public String getCvvCode() {
			return cvvCode;
		}
		public void setCvvCode(String cvvCode) {
			this.cvvCode = cvvCode;
		}
		public String getCardHolderName() {
			return cardHolderName;
		}
		public void setCardHolderName(String cardHolderName) {
			this.cardHolderName = cardHolderName;
		}
	}
