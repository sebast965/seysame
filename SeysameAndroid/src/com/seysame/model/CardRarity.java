package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("CardRarity")
public class CardRarity extends ParseObject {

	private Card card;

	private Rarity rarity;

	public CardRarity() {

	}

	public CardRarity(Card card, Rarity rarity) {

		this.card = card;
		this.rarity = rarity;
		put("card", this.card);
		put("rarity", this.rarity);
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

	public Rarity getRarity() {
		ParseObject object =getParseObject("rarity");

		rarity =new Rarity();
		rarity.setObjectId(object.getObjectId());
		
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
		put("rarity", this.rarity);
	}

}
