package com.techelevator.projects.view;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCDepartmentDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private String deptTest = "Department of fruits";

	/*
	 * Before any tests are run, this method initializes the datasource for testing.
	 */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCDepartmentDAO(dataSource);
		String sqlInsertDept = "INSERT INTO Department (name) VALUES (?)";
		jdbcTemplate.update(sqlInsertDept, deptTest);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void getAllDepartmentTest() {
		List<Department> testing = dao.getAllDepartments();
		assertNotNull(testing);
		assertEquals(9, testing.size());

	}

	@Test
	public void getDepartmentByIdTest() {
		Department departmentTest = new Department();
		departmentTest.setName("Department of Fruits");
		dao.createDepartment(departmentTest);
		Department departmentCreated = dao.getDepartmentById(departmentTest.getId());
		assertNotNull(departmentCreated);
		assertDepartmentsAreEqual(departmentTest, departmentCreated);
	}

	@Test
	public void getDepartmentByNameTest() {
		Department departmentTest = new Department();
		departmentTest.setName("Department of Fruits");
		dao.createDepartment(departmentTest);
		List<Department> departmentCreated = dao.searchDepartmentsByName(departmentTest.getName());
		assertDepartmentsAreEqual(departmentTest, departmentCreated.get(0));
	}

	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}

// The correct way to do it is to set up the setup well to avoid repeating code in each method, create jdcb better access data across tables;
}
