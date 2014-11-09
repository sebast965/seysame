package com.seysame.authentication;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;
import com.parse.ParseFacebookUtils;

import com.parse.ParseUser;

import com.parse.integratingfacebooktutorial.R;
import com.seysame.model.UserProfile;

import com.seysame.parse.application.SeysameApplication;

public class UserDetailsActivity extends Activity {

	private ProfilePictureView userProfilePictureView;
	private TextView userNameView;
	private TextView userGenderView;
	private TextView userEmailView;
	private Button logoutButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.userdetails);

		userProfilePictureView = (ProfilePictureView) findViewById(R.id.userProfilePicture);
		userNameView = (TextView) findViewById(R.id.userName);
		userGenderView = (TextView) findViewById(R.id.userGender);
		userEmailView = (TextView) findViewById(R.id.userEmail);
		logoutButton = (Button) findViewById(R.id.logoutButton);
		logoutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onLogoutButtonClicked();
			}
		});

		// Fetch Facebook user info if the session is active
		Session session = ParseFacebookUtils.getSession();
		if (session != null && session.isOpened()) {
			makeMeRequest();
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {
			// Check if the user is currently logged
			// and show any cached content
			updateViewsWithProfileInfo();
		} else {
			// If the user is not logged in, go to the
			// activity showing the login view.
			startLoginActivity();
		}
	}

	private void makeMeRequest() {
		Request request = Request.newMeRequest(ParseFacebookUtils.getSession(),
				new Request.GraphUserCallback() {
			@Override
			public void onCompleted(GraphUser user, Response response) {
				if (user != null) {
					// Create a JSON object to hold the profile info
					JSONObject userProfile = new JSONObject();
					// Save the user profile info in a user property
					ParseUser currentUser = ParseUser.getCurrentUser();
			
					UserProfile profile = new UserProfile();
					
					try {
						// Populate the JSON object
						userProfile.put("facebookId", user.getId());
						userProfile.put("name", user.getName());
						profile.setId(user.getId());
						profile.setFullName(user.getName());
						
						if (user.getProperty("first_name") != null) {
							profile.setFirstName(((String) user.getProperty("first_name")));
						}
						if (user.getProperty("last_name") != null) {
							profile.setLastName(((String) user.getProperty("last_name")));
						}
						
						if (user.getProperty("gender") != null) {
							userProfile.put("gender", (String) user.getProperty("gender"));
							profile.setGender((String) user.getProperty("gender"));
						}
						if (user.getProperty("email") != null) {
							userProfile.put("email", (String) user.getProperty("email"));
							currentUser.put("email",(String) user.getProperty("email") );
							profile.setEmail((String) user.getProperty("email"));
						}

						if (user.getProperty("birthday") != null) {
							userProfile.put("birthday", (String) user.getProperty("birthday"));
							profile.setBirthday((String) user.getProperty("birthday"));
						}
						if (user.getProperty("location") != null) {
							JSONObject location =(JSONObject) user.getProperty("location");
							String locationName =(String) location.get("name");
							userProfile.put("location", locationName);
							profile.setLocation(locationName);
						}
						
						currentUser.put("profile", userProfile);
						currentUser.saveInBackground();
						profile.put("user", currentUser);
						profile.saveInBackground();

						// Show the user info
						updateViewsWithProfileInfo();
					} catch (JSONException e) {
						Log.d(SeysameApplication.TAG, "Error parsing returned user data. " + e);
					}

				} else if (response.getError() != null) {
					if ((response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_RETRY) || 
							(response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_REOPEN_SESSION)) {
						Log.d(SeysameApplication.TAG, "The facebook session was invalidated." + response.getError());
						onLogoutButtonClicked();
					} else {
						Log.d(SeysameApplication.TAG, 
								"Some other error: " + response.getError());
					}
				}
			}
		}
				);
		request.executeAsync();
	}

	private void updateViewsWithProfileInfo() {
		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser.has("profile")) {
			JSONObject userProfile = currentUser.getJSONObject("profile");
			try {

				if (userProfile.has("facebookId")) {
					userProfilePictureView.setProfileId(userProfile.getString("facebookId"));
				} else {
					// Show the default, blank user profile picture
					userProfilePictureView.setProfileId(null);
				}

				if (userProfile.has("name")) {
					userNameView.setText(userProfile.getString("name"));
				} else {
					userNameView.setText("");
				}

				if (userProfile.has("gender")) {
					userGenderView.setText(userProfile.getString("gender"));
				} else {
					userGenderView.setText("");
				}

				if (userProfile.has("email")) {
					userEmailView.setText(userProfile.getString("email"));
				} else {
					userEmailView.setText("");
				}

			} catch (JSONException e) {
				Log.d(SeysameApplication.TAG, "Error parsing saved user data.");
			}
		}
	}

	private void onLogoutButtonClicked() {
		// Log the user out
		ParseUser.logOut();

		// Go to the login view
		startLoginActivity();
	}

	private void startLoginActivity() {
		Intent intent = new Intent(this, LoginActivity.class);
		//intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}
