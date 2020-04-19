package com.techelevator.projects.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCEmployeeDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO daoDepartment;
	private JDBCEmployeeDAO daoEmployee;
	private JDBCProjectDAO daoProject;
	private final String employeeFirstName = "Lemon";
	private final String employeeLastName = "Lemonade";

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
		LocalDate birthDay = LocalDate.of(1983, 11, 23);
		LocalDate hireDate = LocalDate.of(2013, 10, 13);
		String sqlNewEmployee = "INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date)"
				+ "VALUES (5, ?, ? , ? , ? , ?)";
		jdbcTemplate.update(sqlNewEmployee, employeeFirstName, employeeLastName, birthDay, 'M', hireDate);
		daoDepartment = new JDBCDepartmentDAO(dataSource);
		daoEmployee = new JDBCEmployeeDAO(dataSource);
		daoProject = new JDBCProjectDAO(dataSource);

	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> testing = daoEmployee.getAllEmployees();
		Assert.assertNotNull(testing);
		Assert.assertEquals(13, testing.size());

	}

	@Test
	public void testSearchEmployeeByName() {
		List<Employee> testing = daoEmployee.searchEmployeesByName("Lemon", "Lemonade");
		Assert.assertNotNull(testing);
		Assert.assertEquals("Lemon", testing.get(0).getFirstName());
		Assert.assertEquals("Lemonade", testing.get(0).getLastName());
	}

	@Test
	public void testGetEmployeeById() {
		List<Employee> testing = daoEmployee
				.getEmployeesByProjectId(daoEmployee.searchEmployeesByName("Lemon", "Lemonade").get(0).getId());
		Assert.assertNotNull(testing);
		Assert.assertEquals(0, testing.size());
	}

	@Test
	public void testGetEmployeesWithoutProject() {
		List<Employee> testing = daoEmployee.getEmployeesWithoutProjects();
		Assert.assertNotNull(testing);
		Assert.assertEquals(4, testing.size());
	}

	@Test
	public void testGetEmployeeByProjectId() {
		List<Employee> testing = daoEmployee.getEmployeesByProjectId(daoProject.getAllActiveProjects().get(1).getId());
		Assert.assertNotNull(testing);
		Assert.assertEquals(3, testing.size());
	}

	@Test
	public void ChangeEmployeeFromDepartment() {
		daoEmployee.changeEmployeeDepartment((daoEmployee.searchEmployeesByName("Lemon", "Lemonade").get(0).getId()),
				daoDepartment.getAllDepartments().get(0).getId());

		Long deptIdWhereEmployeeWorks = daoEmployee.searchEmployeesByName("Lemon", "Lemonade").get(0).getDepartmentId();
		Long departmentId = daoDepartment.getAllDepartments().get(0).getId();
		Assert.assertEquals(deptIdWhereEmployeeWorks, departmentId);
	}

	// use a daoDepartment to change departments? test if the department was
	// changed, if it contains the employee id
}
