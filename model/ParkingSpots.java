package com.chainsys.model;

public class ParkingSpots {
	int UserId;
	int locationId;
	String locationName;
	String address;
	String spotNumber;
	String spotStatus;

	public ParkingSpots(int userId, int locationId, String locationName, String address, String spotNumber,
			String spotStatus) {
		super();
		UserId = userId;
		this.locationId = locationId;
		this.locationName = locationName;
		this.address = address;
		this.spotNumber = spotNumber;
		this.spotStatus = spotStatus;
	}

	@Override
	public String toString() {
		return "ParkingSpots [UserId=" + UserId + ", locationId=" + locationId + ", locationName=" + locationName
				+ ", address=" + address + ", spotNumber=" + spotNumber + ", spotStatus=" + spotStatus
				+ ", getUserId()=" + getUserId() + ", getLocationId()=" + getLocationId() + ", getLocationName()="
				+ getLocationName() + ", getAddress()=" + getAddress() + ", getSpotNumber()=" + getSpotNumber()
				+ ", getSpotStatus()=" + getSpotStatus() + "]";
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(String spotNumber) {
		this.spotNumber = spotNumber;
	}

	public String getSpotStatus() {
		return spotStatus;
	}

	public void setSpotStatus(String spotStatus) {
		this.spotStatus = spotStatus;
	}

	public ParkingSpots() {
		// TODO Auto-generated constructor stub
	}

}