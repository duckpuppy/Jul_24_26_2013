package com.aci;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyFormController {
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String processIndexPage(@RequestParam("name") String name, @RequestParam("age") int age, HttpSession session) {
		session.setAttribute("msg", String.format("Hi %s!!! Age: %s", name, age));
		return "results";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
}
