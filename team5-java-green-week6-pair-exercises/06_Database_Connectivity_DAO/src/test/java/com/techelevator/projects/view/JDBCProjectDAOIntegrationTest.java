package com.techelevator.projects.view;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
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

public class JDBCProjectDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO daoEmployee;
	private JDBCProjectDAO daoProject;
	private String projectTest = "Drink a Beer";

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
		daoProject = new JDBCProjectDAO(dataSource);
		daoEmployee = new JDBCEmployeeDAO(dataSource);
		LocalDate from_date = LocalDate.of(2015, 05, 24);
		LocalDate to_date = LocalDate.of(2018, 12, 21);
		String sqlInsertIntoProject = "INSERT INTO project (name, from_date,to_date) VALUES (?,?,?)";
		jdbcTemplate.update(sqlInsertIntoProject, projectTest, from_date, to_date);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void testGetAllActiveProjects() {
		List<Project> testing = daoProject.getAllActiveProjects();
		assertNotNull(testing);
		assertEquals(2, testing.size());

	}

}
