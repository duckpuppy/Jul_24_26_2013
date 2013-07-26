package com.aci;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFormController {

	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String processIndexPage(@RequestParam("name")String name,
			@RequestParam("age")int age,HttpSession session){
		String message = "Hi " + name + "!!! Age: " + age;
		session.setAttribute("msg", message);
		return "results";
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
}
