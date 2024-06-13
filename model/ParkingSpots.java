package com.chainsys.model;

public class ParkingSpots {
	int UserId;
	String locationName;
	String address;
	String vehicleType;
	String spotNumber;
	String spotStatus;

	public ParkingSpots(int userId, String locationName, String address, String vehicleType, String spotNumber,
			String spotStatus) {
		super();
		UserId = userId;
		this.locationName = locationName;
		this.address = address;
		this.vehicleType = vehicleType;
		this.spotNumber = spotNumber;
		this.spotStatus = spotStatus;
	}

	@Override
	public String toString() {
		return "ParkingSpots [UserId=" + UserId + ", locationName=" + locationName + ", address=" + address
				+ ", vehicleType=" + vehicleType + ", spotNumber=" + spotNumber + ", spotStatus=" + spotStatus
				+ ", getUserId()=" + getUserId() + ", getLocationName()=" + getLocationName() + ", getAddress()="
				+ getAddress() + ", getVehicleType()=" + getVehicleType() + ", getSpotNumber()=" + getSpotNumber()
				+ ", getSpotStatus()=" + getSpotStatus() + "]";
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
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