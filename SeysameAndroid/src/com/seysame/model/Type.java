package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Type")
public class Type extends ParseObject {
	
	private String name;
	
	
	public Type(String name) {
		
		this.name = name;
		put("name", this.name);
	}
	
	public Type() {

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
