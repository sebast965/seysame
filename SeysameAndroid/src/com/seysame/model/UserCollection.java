package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;
@ParseClassName("UserCollection")
public class UserCollection extends ParseObject {

	
	private Collection collection;
	
	private ParseUser user;
	
	public UserCollection() {
		
	}
	
	
	

	public UserCollection(Collection collection, ParseUser user) {
		super();
		this.collection = collection;
		this.user = user;
		put("collection",this.collection);
		put("user",this.user);
	}




	public Collection getCollection() {
		
		this.collection = (Collection) get("collection");
		return this.collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
		put("collection",this.collection);
	}

	public ParseUser getUser() {
		this.user = (ParseUser) get("user");
		return user;
	}

	public void setUser(ParseUser user) {
		put("user",this.user);
		this.user = user;
	}
	
	
	
}
