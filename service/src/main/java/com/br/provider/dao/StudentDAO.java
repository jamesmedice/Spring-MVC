package com.br.provider.dao;

import java.util.List;

import com.br.model.Student;

public interface StudentDAO {

	public void insert(Student student);

	public Student findById(int id);

	public List<Student> findAll();

	public List<String> findListNames();

	public String findNameById(int id);

	public void insertBatch(final List<Student> Students);
}
