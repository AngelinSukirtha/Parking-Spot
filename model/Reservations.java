package com.chainsys.model;

import java.time.LocalDateTime;

public class Reservations {
	int reservationId;
	int userId;
	LocalDateTime startTime;
	LocalDateTime endTime;
	String reservationStatus;
	String paymentStatus;

	public Reservations(int reservationId, int userId, LocalDateTime startTime, LocalDateTime endTime,
			String reservationStatus, String paymentStatus) {
		super();
		this.reservationId = reservationId;
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reservationStatus = reservationStatus;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Reservations [reservationId=" + reservationId + ", userId=" + userId + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", reservationStatus=" + reservationStatus + ", paymentStatus="
				+ paymentStatus + ", getReservationId()=" + getReservationId() + ", getUserId()=" + getUserId()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + ", getReservationStatus()="
				+ getReservationStatus() + ", getPaymentStatus()=" + getPaymentStatus() + "]";
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
