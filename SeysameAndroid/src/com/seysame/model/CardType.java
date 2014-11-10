package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;



@ParseClassName("CardType")
public class CardType extends ParseObject {

	private Card card;

	private Type type;

	public CardType() {

	}

	public CardType(Card card, Type type) {

		this.card = card;
		this.type = type;
		put("card", this.card);
		put("type", this.type);
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

	public Type getType() {
	
		ParseObject object =getParseObject("type");
		
		type =new Type();
		
		type.setObjectId(object.getObjectId());
		
		return type;
	}

	public void setType(Type type) {
		this.type = type;
		put("type", this.type);
	}
}
