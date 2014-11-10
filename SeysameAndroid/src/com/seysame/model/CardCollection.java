package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("CardCollection")
public class CardCollection extends ParseObject{

	
	private UserCollection userCollection;
	
	private Card card;
	
	private double price;
	
	private int quantity;
	
	public CardCollection() {
		super();
	}
	
	

	public CardCollection(UserCollection userCollection, Card card,double price, int quantity) {
		super();
		this.userCollection = userCollection;
		this.card = card;
		this.price = price;
		this.quantity = quantity;
		put("userCollection",this.userCollection);
		put("card",this.card);
		put("price",this.price);
		put("quantity",this.quantity);
		
		
	}



	public UserCollection getUserCollection() {
		this.userCollection = (UserCollection) get("userCollection");
		
		return userCollection;
	}

	public void setUserCollection(UserCollection userCollection) {
		this.userCollection = userCollection;
		put("userCollection",this.userCollection);
	}

	public Card getCard() {
		this.card = (Card) get("card");
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
		put("card",this.card);
	}

	public double getPrice() {
		this.price = (Double) get("price");
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		put("price",this.price);
	}

	public int getQuantity() {
		this.quantity = (Integer) get("quantity");
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		put("quantity",this.quantity);
	}
	
	
	
	
	
}
