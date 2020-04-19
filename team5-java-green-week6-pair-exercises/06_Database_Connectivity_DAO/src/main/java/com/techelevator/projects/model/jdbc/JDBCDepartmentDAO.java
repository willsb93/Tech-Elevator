package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {

		ArrayList<Department> departments = new ArrayList<>();
		String sqlFindDepartmentByDepartmentCode = "SELECT department_id, name " + "FROM Department ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentByDepartmentCode);
		while (results.next()) {
			Department department = mapRowToDepartment(results);
			departments.add(department);
		}

		return departments;

	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlFindDepartmentByDepartmentName = "SELECT department_id, name " + "FROM Department "
				+ "WHERE name LIKE ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentByDepartmentName, "%" + nameSearch + "%");
		while (results.next()) {
			Department department = mapRowToDepartment(results);
			departments.add(department);
		}

		return departments;

	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department SET name = ? WHERE department_id = ?";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(), updatedDepartment.getId());

	}

//	@Override
//	public Department createDepartment(Department newDepartment) {
//		String sqlInsertDepartment = "INSERT INTO department (department_id, name)" + "VALUES(?,?)";
//		newDepartment.setId(getNextDepartmentId());
//		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
//
//		return newDepartment;
//	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(name) " + "Values(?)";
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getName());

		return retrieveNextDepId(newDepartment);
	}

//	@Override
//	public Department getDepartmentById(Long id) {
//		Department department = null;
//
//		String sqlFindDepartmentById = "SELECT department_id, name" + "FROM department" + "WHERE deparment_id = ?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDepartmentById, id);
//		if (results.next()) {
//			department = mapRowToDepartment(results);
//		}
//		return department;
//	}

	@Override
	public Department getDepartmentById(Long id) {
		Department department = null;
		String sqlGetDepartmentById = "SELECT name, department_id " + "FROM department " + "WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartmentById, id);
		while (results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
	}

	// private long getNextDepartmentId() {
	// SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT
	// nextval('seq_department_id')");
	// if (nextIdResult.next()) {
	// return nextIdResult.getLong(1);
	// } else {
	// throw new RuntimeException("Something went wrong while getting an id for the
	// new department");
	// }
	// }

	private Department retrieveNextDepId(Department department) {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if (nextIdResult.next()) {
			department.setId(nextIdResult.getLong(1) - 1L);
		}
		return department;
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department;
		department = new Department();
		department.setId(results.getLong("department_id"));
		department.setName(results.getString("name"));

		return department;
	}

}
