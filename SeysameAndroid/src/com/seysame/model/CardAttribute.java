package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("CardAttribute")
public class CardAttribute extends ParseObject {

	private Attribute attribute;

	private Card card;

	public CardAttribute() {

	}

	public CardAttribute(Card card, Attribute attribute) {
		this.attribute = attribute;
		this.card = card;
		put("attribute", this.attribute);
		put("card", this.card);
	}

	public Attribute getAttribute() {

		ParseObject object =getParseObject("attribute");

		attribute =new Attribute();

		attribute.setObjectId(object.getObjectId());
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
		put("attribute", this.attribute);
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

}
