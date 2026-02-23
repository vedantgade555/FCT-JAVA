package com.vedant.gade.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbctemplate;
	
	

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	
	@Override
	public void save(Student student) {
		
		String sql = "insert into student(name,email) values (?,?)";
		jdbctemplate.update(sql,student.getName(),student.getEmail());
	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student";
		
		
		
		return jdbctemplate.query(sql,new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs,int rowNum) throws SQLException{
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				return s;
			}
			
		});
	}

	@Override
	public void delete(int id) {
	    String sql = "delete from student where id = ?";
	    jdbctemplate.update(sql, id);
	}
}
