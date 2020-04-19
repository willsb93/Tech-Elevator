package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.view.Log;

import org.junit.Assert;

public class LogTest {

	Log logTest = new Log(java.time.LocalDate.now(), java.time.LocalTime.now(), "Action Taken", new BigDecimal(25));

	@Test
	public void testGetDateOfAction() {
		Assert.assertEquals(java.time.LocalDate.now(), logTest.getDateOfAction());
	}

	@Test
	public void testGetTimeOfAction() {
		Assert.assertEquals(java.time.LocalTime.now(), logTest.getTimeOfAction());
	}

	@Test
	public void testGetActionTaken() {
		Assert.assertEquals("Action Taken", logTest.getActionTaken());
	}
	@Test
	public void testGetNewCustomerBalance() {
		Assert.assertEquals(new BigDecimal (25), logTest.getNewCustomerBalance());
	}
}
