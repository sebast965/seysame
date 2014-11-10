package com.seysame.model;

import java.util.Date;
import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Card")
public class Card extends ParseObject {

	private String name;
	private String description;
	private int code;
	private Date addedDate;
	private int level;
	private int attack;
	private int defense;


	public Card(String name, String description, int code, Date addedDate,int level, int attack, int defense) {
	
		this.name = name;
		this.description = description;
		this.code = code;
		this.addedDate = addedDate;
		this.level = level;
		this.attack = attack;
		this.defense = defense;
		

		put("name", this.name);
		put("description", this.description);
		put("code", this.code);
		put("addedDate", this.addedDate);
		put("level", this.level);
		put("attack", this.attack);
		put("defense", this.defense);


	}
	public Card() {


	}

	
	
	public String getName() {
		name = (String) get("name");
		return name;
	}
	public void setName(String name) {
		this.name = name;
		put("name", this.name);
	}
	public String getDescription() {
		description = (String) get("description");
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		put("description", this.description);
	}
	public int getCode() {
		code =  getInt("code");
		return code;
	}
	public void setCode(int code) {
		this.code = code;
		put("code", this.code);
	}
	public Date getAddedDate() {
		addedDate =  getDate("addedDate");
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
		put("addedDate", this.addedDate);
	}
	public int getLevel() {
		level =  getInt("level");
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		put("level", this.level);
	}
	public int getAttack() {
		attack =  getInt("attack");
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
		put("attack", this.attack);
	}
	public int getDefense() {
		defense =  getInt("defense");
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
		put("defense", this.defense);
	}
	



}
