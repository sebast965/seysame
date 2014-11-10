package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("Collection")
public class Collection extends ParseObject {

	
	private String name;
	
	
	public Collection() {
		
	}
	
	
	

	public Collection(String name) {
		super();
		this.name = name;
		
		put("name",this.name);

	}




	public String getName() {
		
		this.name = (String) get("name");
		return name;
	}

	public void setName(String name) {
		put("name",this.name);
		this.name = name;
	}

	
	
	
	
}
