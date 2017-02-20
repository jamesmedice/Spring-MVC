package com.br.provider.service;

import java.util.List;

import com.br.model.Student;

public interface StudentService {

	abstract void saveStudent(Student student);

	abstract Student findById(int id);

	abstract List<Student> findAll();

	abstract List<String> findListNames();

	abstract String findNameById(int id);

	abstract void insertBatch(final List<Student> Students);
}
