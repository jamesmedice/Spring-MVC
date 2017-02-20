package com.br.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	
	@RequestMapping("/simpleRequest")
	public @ResponseBody String simple() {
		return "Request Method Controler.";
	}

	@RequestMapping("/simpleRequestParam")
	public @ResponseBody String simpleRequest(@RequestParam(required = false) String name) {
		return "Request Method Controler. Param: " + name;
	}

}
