package com.seysame.model;

import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("Attribute")
public class Attribute extends ParseObject{
	
	private String name;
	

	public Attribute(String name) {
		
		this.name = name;
		put("name", this.name);
	}

	
	public Attribute() {
		
	}
	
	



	public String getName() {
		this.name = (String) get("name");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		put("name", this.name);
	}

	
	
	
}
