package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("CardRestriction")
public class CardRestriction extends ParseObject{

	
	private Card card;
	
	private Restriction restriction;
	
	public CardRestriction() {
		
	}
	
	

	public CardRestriction(Card card, Restriction restriction) {
		
		this.card = card;
		this.restriction = restriction;
		put("card", this.card);
		put("restriction", this.restriction);
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

	public Restriction getRestriction() {
		ParseObject object =getParseObject("restriction");

		restriction =new Restriction();

		restriction.setObjectId(object.getObjectId());
		
		return restriction;
	}

	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
		put("restriction", this.restriction);
	}
	
	
}
