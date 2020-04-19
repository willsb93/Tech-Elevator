package com.techelevator.model;

import java.math.BigDecimal;

public class Space {

	private int spaceId;
	private int venueId;
	private String spaceName;
	private boolean isAccessible;
	private int openMonth;
	private int closingMonth;
	private BigDecimal dailyRate;
	private int maxCapacity;

	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public boolean isAccessible() {
		return isAccessible;
	}

	public void setAccessible(boolean isAccessible) {
		this.isAccessible = isAccessible;
	}

	public int getOpenMonth() {
		return openMonth;
	}

	public void setOpenMonth(int openMonth) {
		this.openMonth = openMonth;
	}

	public int getClosesMonth() {
		return closingMonth;
	}

	public void setClosesMonth(int closingMonth) {
		this.closingMonth = closingMonth;
	}

	public int getClosingMonth() {
		return closingMonth;
	}

	public void setClosingMonth(int closingMonth) {
		this.closingMonth = closingMonth;
	}

	public BigDecimal getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(BigDecimal dailyRate) {
		this.dailyRate = dailyRate;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}
//