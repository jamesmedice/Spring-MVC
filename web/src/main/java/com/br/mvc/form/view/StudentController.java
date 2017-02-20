package com.br.mvc.form.view;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.model.Student;
import com.br.provider.service.StudentService;


@Controller
@RequestMapping("/form/view")
@SessionAttributes("formBean")
//@ComponentScan("com.br.provider.service")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@ModelAttribute("student")
	public Student createFormBean() {
		return new Student();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
	    binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@Valid Student student, BindingResult result,
			Model model, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			return null;
		}
		String message = "Status Success";

		studentService.saveStudent(student);

		redirectAttrs.addFlashAttribute("message", message);
		redirectAttrs.addFlashAttribute("studentSql", student);
		return "redirect:/form/view";

	}

}
