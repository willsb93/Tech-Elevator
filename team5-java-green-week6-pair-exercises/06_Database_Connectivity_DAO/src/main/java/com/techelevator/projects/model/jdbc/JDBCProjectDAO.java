package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Project> getAllActiveProjects() {
		ArrayList<Project> projects = new ArrayList<>();
		String sqlFindProjects = "SELECT * " + "FROM Project"
				+ " WHERE from_date < current_timestamp AND to_date > current_timestamp OR to_date IS NULL AND from_date IS NOT NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindProjects);
		while (results.next()) {
			Project project = mapRowToProject(results);
			projects.add(project);
		}

		return projects;

	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlDeleteEmployeeFromProject = "DELETE FROM project_employee WHERE project_Id = ?"
				+ " AND employee_id = ? ";
		jdbcTemplate.update(sqlDeleteEmployeeFromProject, projectId, employeeId);

	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlInsertEmployeeIntoProject = "INSERT INTO project_employee " + " VALUES(?,?)";
		jdbcTemplate.update(sqlInsertEmployeeIntoProject, projectId, employeeId);

	}

	private Project mapRowToProject(SqlRowSet results) {
		Project projects;
		projects = new Project();
		projects.setId(results.getLong("project_id"));
		projects.setName(results.getString("name"));
		projects.setName(results.getString("name"));
		projects.setStartDate(results.getDate("from_date").toLocalDate());
		if (results.getDate("to_date") != null) {
			projects.setEndDate(results.getDate("to_date").toLocalDate());
		}
		return projects;
	}

}
