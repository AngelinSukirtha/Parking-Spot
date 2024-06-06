package com.chainsys.model;

import java.time.LocalDateTime;

public class Transactions {
	int transactionId;
	int reservationId;
	int amount;
	String paymentMethod;
	LocalDateTime transactionTime;

	public Transactions(int transactionId, int reservationId, int amount, String paymentMethod,
			LocalDateTime transactionTime) {
		super();
		this.transactionId = transactionId;
		this.reservationId = reservationId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.transactionTime = transactionTime;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", reservationId=" + reservationId + ", amount="
				+ amount + ", paymentMethod=" + paymentMethod + ", transactionTime=" + transactionTime
				+ ", getTransactionId()=" + getTransactionId() + ", getReservationId()=" + getReservationId()
				+ ", getAmount()=" + getAmount() + ", getPaymentMethod()=" + getPaymentMethod()
				+ ", getTransactionTime()=" + getTransactionTime() + "]";
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

}
