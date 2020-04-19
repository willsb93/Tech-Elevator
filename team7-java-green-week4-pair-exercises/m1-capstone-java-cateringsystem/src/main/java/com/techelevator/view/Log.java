package com.techelevator.view;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Log {

	private LocalDate dateOfAction;
	private LocalTime timeOfAction;
	private String actionTaken;
	private BigDecimal newCustomerBalance;

	public Log(LocalDate dateOfAction, LocalTime timeOfAction, String actionTaken, BigDecimal newCustomerBalance) {
		this.dateOfAction = dateOfAction;
		this.timeOfAction = timeOfAction;
		this.actionTaken = actionTaken;
		this.newCustomerBalance = newCustomerBalance;
		// constructor to assign these values to log item
	}

	public LocalDate getDateOfAction() {
		return dateOfAction;
	}

	public LocalTime getTimeOfAction() {
		return timeOfAction;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public BigDecimal getNewCustomerBalance() {
		return newCustomerBalance;
	}
}
