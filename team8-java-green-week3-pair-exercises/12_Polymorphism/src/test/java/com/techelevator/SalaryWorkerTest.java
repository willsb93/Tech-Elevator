package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;

public class SalaryWorkerTest {
	SalaryWorker salary = new SalaryWorker("", "", 43000.00);

	@Test
	public void testSalaryWorkerPay() {

		Assert.assertEquals(826.92, salary.calculateWeeklyPay(31), 0.1);
		Assert.assertEquals(826.92, salary.calculateWeeklyPay(1), 0.1);
		Assert.assertEquals(826.92, salary.calculateWeeklyPay(100), 0.1);
		Assert.assertEquals(826.92, salary.calculateWeeklyPay(0), 0.1);
	}
}
