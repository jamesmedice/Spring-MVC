package com.br.provider.service;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import com.br.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/test-applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class ServicesTests {

	@Autowired
	private ConfigurableApplicationContext context;

	@Autowired
	StudentService studentService;
	Student student;

	@Before
	public void setup() throws Exception {
		student = new Student();
	}

	private void getStudent() {
		student.setName("John Robert Medici");
		student.setAge(25);
		student.setBirthDate(new GregorianCalendar(1983, 0, 31).getTime());
		student.setPhone("(19) 9153-1253");
		student.setSalary(new BigDecimal("1500.0"));
	}

	@Test
	@Transactional
	@Rollback
	public void serviceRequest() throws Exception {
		getStudent();
		studentService.saveStudent(student);
	}

}
