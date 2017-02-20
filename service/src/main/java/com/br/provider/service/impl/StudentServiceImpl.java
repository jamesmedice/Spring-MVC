package com.br.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.model.Student;
import com.br.provider.dao.StudentDAO;
import com.br.provider.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	public void saveStudent(Student student) {
		studentDAO.insert(student);
	}

	public Student findById(int id) {
		return studentDAO.findById(id);
	}

	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	public List<String> findListNames() {
		return studentDAO.findListNames();
	}

	public String findNameById(int id) {
		return studentDAO.findNameById(id);
	}

	public void insertBatch(List<Student> students) {
		studentDAO.insertBatch(students);
	}

}
