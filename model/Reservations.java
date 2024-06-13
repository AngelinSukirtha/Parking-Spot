package com.chainsys.model;

public class Reservations {
	int userId;
	String numberPlate;
	String startDateTime;
	String endDateTime;
	String reservationStatus;

	public Reservations(int userId, String numberPlate, String startDateTime, String endDateTime,
			String reservationStatus) {
		super();
		this.userId = userId;
		this.numberPlate = numberPlate;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.reservationStatus = reservationStatus;
	}

	public Reservations() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reservations [userId=" + userId + ", numberPlate=" + numberPlate + ", startDateTime=" + startDateTime
				+ ", endDateTime=" + endDateTime + ", reservationStatus=" + reservationStatus + ", getUserId()="
				+ getUserId() + ", getNumberPlate()=" + getNumberPlate() + ", getStartDateTime()=" + getStartDateTime()
				+ ", getEndDateTime()=" + getEndDateTime() + ", getReservationStatus()=" + getReservationStatus() + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}
