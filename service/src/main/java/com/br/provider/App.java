package com.br.provider;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.br.model.Student;
import com.br.provider.service.StudentService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService service = (StudentService) context.getBean("studentService");

		Student student = new Student();
		student.setName("John Alfio Medici");
		student.setAge(25);
		student.setBirthDate(new GregorianCalendar(1983, 0, 31).getTime());
		student.setPhone("(19) 9153-1253");
		student.setSalary(new BigDecimal("1500.0"));

		service.saveStudent(student);
	}
}
