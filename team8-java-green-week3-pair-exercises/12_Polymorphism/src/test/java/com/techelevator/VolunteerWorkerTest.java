package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;

public class VolunteerWorkerTest {

	VolunteerWorker volunteer = new VolunteerWorker("", "");

	@Test
	public void testVolunteerPay() {
		Assert.assertEquals(0, volunteer.calculateWeeklyPay(45), 0.1);
		Assert.assertEquals(0, volunteer.calculateWeeklyPay(25), 0.1);
		Assert.assertEquals(0, volunteer.calculateWeeklyPay(1), 0.1);
		Assert.assertEquals(0, volunteer.calculateWeeklyPay(0), 0.1);

	}
}
