package com.seysame.model;

import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("MonsterType")
public class MonsterType extends ParseObject{

	private String name;

	

	public MonsterType(String name) {
		
		this.name = name;
		put("name", this.name);
	}


	public MonsterType() {
	
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
