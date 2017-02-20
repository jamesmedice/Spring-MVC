package com.br.mvc.form.gridView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.br.model.Student;
import com.br.provider.service.StudentService;


@Controller
@RequestMapping("/form/gridView")
@SessionAttributes("formBean") 
public class StudentGridController {

	@Autowired
	StudentService studentService;
	
	@ModelAttribute("students")
	public List<Student> createFormBean() {
		return studentService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET)
	public void resetForm() {
	}


}
