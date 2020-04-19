package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;

public class HourlyWorkerTest {

	HourlyWorker hourly = new HourlyWorker("", "", 15.0);

	@Test

	public void testHourlyWorkerPay() {
		Assert.assertEquals(622.5, hourly.calculateWeeklyPay(41), 0.01);
		Assert.assertEquals(315.0, hourly.calculateWeeklyPay(21), 0.01);
		Assert.assertEquals(210.0, hourly.calculateWeeklyPay(14), 0.01);
		Assert.assertEquals(480.0, hourly.calculateWeeklyPay(32), 0.01);
		Assert.assertEquals(735.0, hourly.calculateWeeklyPay(46), 0.01);
	}

}
