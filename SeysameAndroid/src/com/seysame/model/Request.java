package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("Request")
public class Request extends ParseObject{

	private CardCollection cardCollection;
	private UserProfile user;
	private String state;
	
	public Request() {
		super();
	}
	
	
	

	public Request(CardCollection cardCollection, UserProfile user, String state) {
		super();
		this.cardCollection = cardCollection;
		this.user = user;
		this.state = state;
		put("cardCollection", cardCollection);
		put("user", user);
		put("state", state);
	}




	public CardCollection getCardCollection() {
		this.cardCollection = (CardCollection) get("cardCollection");
		return cardCollection;
	}

	public void setCardCollection(CardCollection cardCollection) {
		this.cardCollection = cardCollection;
		put("cardCollection", cardCollection);
	}

	public UserProfile getUser() {
		this.user = (UserProfile) get("user");
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
		put("user", user);
	}

	public String getState() {
		this.state = (String) get("state");
		return state;
	}

	public void setState(String state) {
		this.state = state;
		put("state", state);
	}
	
	
	
}
