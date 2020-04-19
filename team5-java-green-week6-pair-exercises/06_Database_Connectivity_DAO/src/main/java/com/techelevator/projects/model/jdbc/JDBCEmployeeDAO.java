package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetAllEmployees = "SELECT * " + "FROM Employee ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}

		return employees;

	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlFindEmployeeByName = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date "
				+ "FROM employee " + "WHERE first_name LIKE ? AND last_name LIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByName, "%" + firstNameSearch + "%",
				"%" + lastNameSearch + "%");
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> employee = new ArrayList<>();
		String sqlFindEmployeeByDepartmentId = "SELECT * " + "FROM Employee " + "WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByDepartmentId, id);
		while (results.next()) {
			Employee employees = mapRowToEmployee(results);
			employee.add(employees);
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employee = new ArrayList<>();
		String sqlFindEmployeeByDepartmentId = "SELECT * " + "FROM Employee "
				+ "WHERE employee_id NOT IN (SELECT employee_id FROM project_employee)";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByDepartmentId);
		while (results.next()) {
			Employee employees = mapRowToEmployee(results);
			employee.add(employees);
		}
		return employee;
	}

	// SELECT project.name FROM project WHERE to_date < current_timestamp OR
	// from_date IS NULL

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employee = new ArrayList<>();
		String sqlFindEmployeeByProjectId = "SELECT * " + "FROM employee "
				+ "JOIN project_employee ON employee.employee_id = project_employee.employee_id"
				+ " WHERE project_id =  ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByProjectId, projectId);
		while (results.next()) {
			Employee employees = mapRowToEmployee(results);
			employee.add(employees);
		}
		return employee;

	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlUpdateEmployeeDepartment = "UPDATE employee SET department_id = " + departmentId + " WHERE employee_id = " + employeeId;
		jdbcTemplate.update(sqlUpdateEmployeeDepartment);

	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employees;
		employees = new Employee();
		employees.setId(results.getLong("employee_id"));
		employees.setDepartmentId(results.getLong("department_id"));
		employees.setFirstName(results.getString("first_name"));
		employees.setLastName(results.getString("last_name"));
		employees.setBirthDay(results.getDate("birth_date").toLocalDate());
		employees.setHireDate(results.getDate("hire_date").toLocalDate());

		return employees;
	}

}
