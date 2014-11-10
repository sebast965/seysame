package com.seysame.model;

import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Race")
public class Race extends ParseObject {

	private String name;


	public Race(String name) {
	
		this.name = name;
		put("name", this.name);
	}


	public Race() {
	
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
