package com.seysame.model;

import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("Restriction")
public class Restriction extends ParseObject {

	private String name;


	public Restriction(String name) {
	
		this.name = name;
		put("name", this.name);
	}

	public Restriction() {
	
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
