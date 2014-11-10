package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("CardIcon")
public class CardIcon extends ParseObject {


	private Card card;

	private Icon icon;


	public CardIcon() {

	}



	public CardIcon(Card card, Icon icon) {

		this.card = card;
		this.icon = icon;

		put("card", this.card);
		put("icon", this.icon);
		
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


	public Icon getIcon() {
		
		this.icon = (Icon) get("icon");
		
		return icon;
	}


	public void setIcon(Icon icon) {
		this.icon = icon;
		put("icon", this.icon);
	}



}
