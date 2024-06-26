package com.chainsys.model;

public class Transactions {
	int userId;
	int reservationId;
	int transactionId;
	int price;
	String paymentMethod;
	String transactionTime;
	String paymentStatus;

	public Transactions(int userId, int reservationId, int transactionId, int price, String paymentMethod,
			String transactionTime, String paymentStatus) {
		super();
		this.userId = userId;
		this.reservationId = reservationId;
		this.transactionId = transactionId;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.transactionTime = transactionTime;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Transactions [userId=" + userId + ", reservationId=" + reservationId + ", transactionId="
				+ transactionId + ", price=" + price + ", paymentMethod=" + paymentMethod + ", transactionTime="
				+ transactionTime + ", paymentStatus=" + paymentStatus + ", getUserId()=" + getUserId()
				+ ", getReservationId()=" + getReservationId() + ", getTransactionId()=" + getTransactionId()
				+ ", getPrice()=" + getPrice() + ", getPaymentMethod()=" + getPaymentMethod()
				+ ", getTransactionTime()=" + getTransactionTime() + ", getPaymentStatus()=" + getPaymentStatus() + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Transactions() {
	}

}
