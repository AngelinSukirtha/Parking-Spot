package com.chainsys.model;

public class ParkingSpots {
	int locationId;
	String locationName;
	String address;
	String spotNumber;
	String spotStatus;

	public ParkingSpots(int locationId, String locationName, String address, String spotNumber, String spotStatus) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.address = address;
		this.spotNumber = spotNumber;
		this.spotStatus = spotStatus;
	}

	public ParkingSpots() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ParkingSpots [locationId=" + locationId + ", locationName=" + locationName + ", address=" + address
				+ ", spotNumber=" + spotNumber + ", spotStatus=" + spotStatus + ", getLocationId()=" + getLocationId()
				+ ", getLocationName()=" + getLocationName() + ", getAddress()=" + getAddress() + ", getSpotNumber()="
				+ getSpotNumber() + ", getSpotStatus()=" + getSpotStatus() + "]";
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

}