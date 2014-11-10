package com.seysame.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
@ParseClassName("UserCollection")
public class UserCollection extends ParseObject {

	
	private Collection collection;
	
	private UserProfile user;
	
	public UserCollection() {
		
	}
	
	
	

	public UserCollection(Collection collection, UserProfile user) {
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

	public UserProfile getUser() {
		this.user = (UserProfile) get("user");
		return user;
	}

	public void setUser(UserProfile user) {
		put("user",this.user);
		this.user = user;
	}
	
	
	
}
