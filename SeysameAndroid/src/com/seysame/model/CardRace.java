package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("CardRace")
public class CardRace extends ParseObject {
	
	private Card card;
	
	private Race race;
	
	public CardRace() {
		
	}

	public CardRace(Card card, Race race) {
		
		this.card = card;
		this.race = race;
		put("card", this.card);
		put("race", this.race);
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

	public Race getRace() {
		
		this.race = (Race) get("race");
		
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
		put("race", this.race);
	}

	
	
}
