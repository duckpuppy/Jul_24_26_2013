package com.aci;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/form2")
public class MyForm2Controller {
	@RequestMapping(method=RequestMethod.POST)
	public String addPerson(@Valid Person person,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			return "form2/index";
		}
		session.setAttribute("message", person.getName());
		return "form2/results";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("person", new Person());
		return "form2/index";
	}
}
