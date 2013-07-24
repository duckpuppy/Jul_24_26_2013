package com.aci.annotations;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="car" class="com.aci.annotations.Car"/> 
@Component
@Scope(value="prototype")
public class Car {
	
	private Map<String, String> attributes;
	private String color;
	private Engine engine;
	
	@Value("#{carProps.color}")
	public void setColor(String color) {
		this.color = color;
	}
	@Resource(name="carProps")
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
		//<property name="engine" ref="engine"/>
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Engine getEngine() {
		return engine;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public String getColor() {
		return color;
	}
	

}
