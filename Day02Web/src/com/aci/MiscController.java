package com.aci;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiscController {
	
	@RequestMapping(value="/store")
	@ResponseBody
	public String storeCountries(@RequestBody List<Country> countries){
		return "Cool";
	}
	
	@ResponseBody
	@RequestMapping(value="/country",produces="application/json",
		method=RequestMethod.GET)
	public List<Country> getCountries(){
		//Gson
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(new Country("USA","Washington"));
		countries.add(new Country("India","New Delhi"));
		countries.add(new Country("France","Paris"));
		return countries;
	}
	
	@RequestMapping("/action1")
	public String index(){
		return "forward:action3";
		//return "redirect:action2";
	}
	@RequestMapping("/action3")
	@ResponseBody
	public String action3(){
		return "Forwarded to action 3";
	}
	
	@RequestMapping("/action2")
	@ResponseBody
	public String action2(){
		return "This is action 2";
	}
}
