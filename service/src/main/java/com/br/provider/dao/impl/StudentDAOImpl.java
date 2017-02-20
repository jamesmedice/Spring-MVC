package com.br.provider.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.br.model.Student;
import com.br.provider.dao.StudentDAO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Student student) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO STUDENT (NAME, AGE, BIRTHDATE, PHONE, SALARY) VALUES (?,?,?,?,?)";

		jdbcTemplate.update(
				sql,
				new Object[] { student.getName(), student.getAge(),
						student.getBirthDate(), student.getPhone(),
						student.getSalary() });

	}

	public Student findById(int id) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM STUDENT WHERE ID = ?";

		Student student = (Student) jdbcTemplate.queryForObject(sql,
				new Object[] { id }, new BeanPropertyRowMapper(Student.class));

		return student;
	}

	public List<Student> findAll() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM STUDENT group by name";

		List<Student> students = new ArrayList<Student>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Student student = new Student();
			student.setId(String.valueOf(row.get("ID")));
			student.setName((String) row.get("NAME"));
			student.setAge(Integer.parseInt(String.valueOf(row.get("AGE"))));
			student.setBirthDate((Date) row.get("BIRTHDATE"));
			student.setPhone((String) row.get("PHONE"));
			student.setSalary(new BigDecimal(row.get("SALARY").toString()));
			students.add(student);
		}

		return students;
	}

	public List<String> findListNames() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT name FROM STUDENT";
		List<String> names = jdbcTemplate.queryForList(sql, String.class);
		return names;
	}

	public String findNameById(int id) {

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			String sql = "SELECT NAME FROM STUDENT WHERE ID = ?";

			String name = (String) jdbcTemplate.queryForObject(sql,
					new Object[] { id }, String.class);

			return name;
		} catch (DataAccessException e) {
			return null;
		}
	}

	private void insertBatchSQL(final String sql) {
		jdbcTemplate.batchUpdate(new String[] { sql });
	}

	public void insertBatch(final List<Student> students) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO STUDENT "
				+ "(ID, NAME, AGE) VALUES (?, ?, ?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Student student = students.get(i);
				ps.setString(1, student.getId());
				ps.setString(2, student.getName());
				ps.setInt(3, student.getAge());
				ps.setDate(4, (java.sql.Date) student.getBirthDate());
				ps.setString(5, student.getPhone());
				ps.setBigDecimal(6, student.getSalary());
			}

			public int getBatchSize() {
				return students.size();
			}
		});
	}

}
