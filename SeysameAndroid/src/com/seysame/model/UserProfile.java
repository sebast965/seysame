package com.seysame.model;

import java.util.Date;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("UserProfile")
public class UserProfile extends ParseObject {

	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String password;
	private String email;
	private String phoneNumber;
	private String location;
	private String gender;
	private String birthday;
	private ParseUser user;

	public UserProfile() {

	}
	
	



	public UserProfile(String id, String firstName, String lastName,
			String fullName, String password, String email, String phoneNumber,
			String location, String gender, String birthday,ParseUser user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.gender = gender;
		this.birthday = birthday;
		put("id", this.id);
		put("firstName", this.firstName);
		put("lastName", this.lastName);
		put("fullName", this.fullName);
		put("password", this.password);
		put("email", this.email);
		put("phoneNumber", this.phoneNumber);
		put("location", this.location);
		put("gender", this.gender);
		put("birthday", this.birthday);
		put("user", this.user);
		
	}





	public String getFirstName() {
		firstName = (String) get("firstName");
		return firstName;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
		put("firstName", this.firstName);
	}





	public String getLastName() {
		lastName = (String) get("lastName");
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
		put("lastName", this.lastName);
	}





	public String getId() {
		id = (String) get("id");
		return id;
	}

	public void setId(String id) {
		this.id = id;
		put("id", this.id);
	}

	public String getFullName() {
		fullName = (String) get("fullName");
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
		put("fullName", this.fullName);
	}

	public String getPassword() {
		password = (String) get("password");
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		put("password", this.password);
	}

	public String getEmail() {
		email = (String) get("email");
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		put("email", this.email);
	}

	public String getPhoneNumber() {
		phoneNumber = (String) get("phoneNumber");
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		put("phoneNumber", this.phoneNumber);
	}

	public String getLocation() {
		location = (String) get("location");
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		put("location", this.location);
	}

	public String getGender() {
		gender = (String) get("gender");
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
		put("gender", this.gender);
	}

	public String getBirthday() {
		birthday = (String) get("birthday");
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
		put("birthday", this.birthday);
	}





	public ParseUser getUser() {
		user = getParseUser("user");
		return user;
	}





	public void setUser(ParseUser user) {
		this.user = user;
		put("user", user);
	}

}
