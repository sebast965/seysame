package com.seysame.parse.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.integratingfacebooktutorial.R;
import com.parse.integratingfacebooktutorial.R.string;
import com.seysame.model.UserProfile;

public class SeysameApplication extends Application {

	public static final String TAG = "MyApp";

	@Override
	public void onCreate() {
		super.onCreate();
		final String APPLICATION_ID = getResources().getString(
				R.string.APPLICATION_ID);
		final String CLIENT_KEY = getResources().getString(R.string.CLIENT_KEY);
		ParseObject.registerSubclass(UserProfile.class);
		Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

		// Set your Facebook App Id in strings.xml
		ParseFacebookUtils.initialize(getString(R.string.FACEBOOK_ID));
	}
}
