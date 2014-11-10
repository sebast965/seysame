package com.seysame.model;

import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("Rarity")
public class Rarity extends ParseObject{

	private String name;

	

	public Rarity(String name) {
		
		this.name = name;
		put("name", this.name);
	}

	public Rarity() {
		
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
