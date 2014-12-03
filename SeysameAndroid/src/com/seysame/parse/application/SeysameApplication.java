package com.seysame.parse.application;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.SaveCallback;
import com.seysame.model.Attribute;
import com.seysame.model.Card;
import com.seysame.model.CardAttribute;
import com.seysame.model.CardCollection;
import com.seysame.model.CardIcon;
import com.seysame.model.CardMonsterType;
import com.seysame.model.CardRace;
import com.seysame.model.CardRarity;
import com.seysame.model.CardRestriction;
import com.seysame.model.CardType;
import com.seysame.model.Collection;
import com.seysame.model.Icon;
import com.seysame.model.MonsterType;
import com.seysame.model.Race;
import com.seysame.model.Rarity;
import com.seysame.model.Request;
import com.seysame.model.Restriction;
import com.seysame.model.Type;
import com.seysame.model.UserCollection;
import com.seysame.model.UserProfile;
import com.seysame.parse.R;
import com.seysame.parse.R.string;

public class SeysameApplication extends Application {

	public static final String TAG = "SeysameApplication";

	@Override
	public void onCreate() {
		super.onCreate();
		final String APPLICATION_ID = getResources().getString(R.string.APPLICATION_ID);
		final String CLIENT_KEY = getResources().getString(R.string.CLIENT_KEY);
		classRegistration();

		Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

		// Set your Facebook App Id in strings.xml
		ParseFacebookUtils.initialize(getString(R.string.FACEBOOK_ID));
		
		//subcribeBroadcastChannel();
	}

	public void subcribeBroadcastChannel(){
		
		ParsePush.subscribeInBackground("", new SaveCallback() {

			@Override
			public void done(ParseException e) {
				 if (e != null) {
				      Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
				    } else {
				    	
				      Log.e("com.parse.push", "failed to subscribe for push" ,e);
				    }

			}
		});
	}

	public void classRegistration(){
		ParseObject.registerSubclass(Attribute.class);
		ParseObject.registerSubclass(Card.class);
		ParseObject.registerSubclass(CardAttribute.class);
		ParseObject.registerSubclass(CardCollection.class);
		ParseObject.registerSubclass(CardIcon.class);
		ParseObject.registerSubclass(CardMonsterType.class);
		ParseObject.registerSubclass(CardRace.class);
		ParseObject.registerSubclass(CardRarity.class);
		ParseObject.registerSubclass(CardRestriction.class);
		ParseObject.registerSubclass(CardType.class);
		ParseObject.registerSubclass(Collection.class);
		ParseObject.registerSubclass(Icon.class);
		ParseObject.registerSubclass(MonsterType.class);
		ParseObject.registerSubclass(Race.class);
		ParseObject.registerSubclass(Rarity.class);
		ParseObject.registerSubclass(Request.class);
		ParseObject.registerSubclass(Restriction.class);
		ParseObject.registerSubclass(Type.class);
		ParseObject.registerSubclass(UserCollection.class);
		ParseObject.registerSubclass(UserProfile.class);

	}
}
