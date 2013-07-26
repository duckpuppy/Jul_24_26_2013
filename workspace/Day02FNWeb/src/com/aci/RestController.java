package com.aci;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	@RequestMapping(value="/seeya/{name}/{message}", method=RequestMethod.GET)
	@ResponseBody
	public String seeya(@PathVariable("name") String name, @PathVariable("message") String msg) {
		return String.format("%s %s", msg, name);
	}
	
	@RequestMapping(value="/hi/{name}", method=RequestMethod.GET)
	@ResponseBody
	public String hi(@PathVariable("name") String name) {
		return String.format("Hi %s", name);
	}
}
