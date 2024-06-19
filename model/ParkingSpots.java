package com.chainsys.model;

public class ParkingSpots {
	int userId;
	int spotId;
	String locationName;
	String address;
	String vehicleType;
	String spotNumber;
	int countSpotNumber;
	boolean spotStatus = true;

	public ParkingSpots(int userId, int spotId, String locationName, String address, String vehicleType,
			String spotNumber, boolean spotStatus) {
		super();
		this.userId = userId;
		this.spotId = spotId;
		this.locationName = locationName;
		this.address = address;
		this.vehicleType = vehicleType;
		this.spotNumber = spotNumber;
		this.spotStatus = spotStatus;
	}

	@Override
	public String toString() {
		return "ParkingSpots [countSpotNumber=" + countSpotNumber + ", userId=" + userId + ", spotId=" + spotId
				+ ", locationName=" + locationName + ", address=" + address + ", vehicleType=" + vehicleType
				+ ", spotNumber=" + spotNumber + ", spotStatus=" + spotStatus + ", getUserId()=" + getUserId()
				+ ", getSpotId()=" + getSpotId() + ", getLocationName()=" + getLocationName() + ", getAddress()="
				+ getAddress() + ", getVehicleType()=" + getVehicleType() + ", getSpotNumber()=" + getSpotNumber()
				+ ", getSpotStatus()=" + getSpotStatus() + ", getCountSpotNumber()=" + getCountSpotNumber() + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(String spotNumber) {
		this.spotNumber = spotNumber;
	}

	public boolean getSpotStatus() {
		return spotStatus;
	}

	public void setSpotStatus(boolean spotStatus) {
		this.spotStatus = spotStatus;
	}

	public int getCountSpotNumber() {
		return countSpotNumber;
	}

	public void setCountSpotNumber(int countSpotNumber) {
		this.countSpotNumber = countSpotNumber;
	}

	public ParkingSpots() {
	}

	public ParkingSpots(String spotNumber2) {
	}

}