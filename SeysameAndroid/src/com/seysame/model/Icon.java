package com.seysame.model;

import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Icon")
public class Icon extends ParseObject {

	private String name;


	public Icon(String name) {
		
		this.name = name;
		put("name", this.name);
	}

	public Icon() {
		
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
