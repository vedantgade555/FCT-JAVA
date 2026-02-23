package com.vedant.gade.Dao;

import java.util.List;


public interface StudentDao {
	void save(Student student);
	List<Student> findAll();
	void delete(int id);
	
}
