package com.aci;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/form2")
public class MyForm2Controller {
	@RequestMapping(method=RequestMethod.POST)
	public String addPerson(@Valid Person person,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			return "form2/index";
		}
		session.setAttribute("message", person.getName() + ", " + person.getAddress().getStreet());
		return "form2/results";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		Person p1 = new Person();
		p1.setAddress(new Address());
		model.addAttribute("person", p1);
		return "form2/index";
	}
}
