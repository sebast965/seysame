package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("CardMonsterType")
public class CardMonsterType extends ParseObject {
	
	
	private Card card;
	
	private MonsterType monsterType;
	
	
	public CardMonsterType() {
		
	}
	
	


	public CardMonsterType(Card card, MonsterType monsterType) {
		
		this.card = card;
		this.monsterType = monsterType;
		put("card", this.card);
		put("monsterType", this.monsterType);
	}




	public Card getCard() {
		ParseObject object =getParseObject("card");
		
		card =new Card();
		
		card.setObjectId(object.getObjectId());
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
		put("card", this.card);
	}


	public MonsterType getMonsterType() {
		
		this.monsterType = (MonsterType) get("monsterType");
		
		return monsterType;
	}


	public void setMonsterType(MonsterType monsterType) {
		this.monsterType = monsterType;
		put("monsterType", this.monsterType);
	}
	
	

}
