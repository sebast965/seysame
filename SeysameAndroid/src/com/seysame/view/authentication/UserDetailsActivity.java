package com.seysame.view.authentication;



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
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.seysame.model.UserProfile;
import com.seysame.parse.R;
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

		setContentView(R.layout.activity_userdetails);

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

					ParseUser currentUser = ParseUser.getCurrentUser();

					try {
						currentUser.put("id", (String) user.getId());
						currentUser.put("fullName",
								(String) user.getName());

						if (user.getProperty("first_name") != null) {

							currentUser.put("firstName", (String) user
									.getProperty("first_name"));
						}
						if (user.getProperty("last_name") != null) {

							currentUser.put("lastName", (String) user
									.getProperty("last_name"));
						}

						if (user.getProperty("gender") != null) {

							currentUser.put("gender",
									(String) user.getProperty("gender"));
						}
						if (user.getProperty("email") != null) {

							currentUser.put("email",
									(String) user.getProperty("email"));

						}

						if (user.getProperty("birthday") != null) {
							currentUser.put("birthday", (String) user
									.getProperty("birthday"));

						}
						if (user.getProperty("location") != null) {
							JSONObject location = (JSONObject) user
									.getProperty("location");
							String locationName = (String) location
									.get("name");

							currentUser.put("location", locationName);
						}
						currentUser.saveInBackground(new SaveCallback() {

							@Override
							public void done(ParseException e) {
								ParseUser currentUser = ParseUser.getCurrentUser();
								ParseInstallation.getCurrentInstallation().put("user",currentUser);
								ParseInstallation.getCurrentInstallation().saveInBackground();
								ParsePush.subscribeInBackground("");
								

							}
						});



						// Show the user info
						updateViewsWithProfileInfo();
					} catch (JSONException e) {
						Log.d(SeysameApplication.TAG,
								"Error parsing returned user data. "
										+ e);
					}

				} else if (response.getError() != null) {
					if ((response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_RETRY)
							|| (response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_REOPEN_SESSION)) {
						Log.d(SeysameApplication.TAG,
								"The facebook session was invalidated."
										+ response.getError());
						onLogoutButtonClicked();
					} else {
						Log.d(SeysameApplication.TAG,
								"Some other error: "
										+ response.getError());
					}
				}
			}
		});
		request.executeAsync();
	}

	private void updateViewsWithProfileInfo() {
		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser.has("id")) {
			userProfilePictureView.setProfileId(currentUser.getString("id"));
		} else {
			// Show the default, blank user profile picture
			userProfilePictureView.setProfileId(null);
		}

		if (currentUser.has("name")) {
			userNameView.setText(currentUser.getString("fullName"));
		} else {
			userNameView.setText("");
		}

		if (currentUser.has("gender")) {
			userGenderView.setText(currentUser.getString("gender"));
		} else {
			userGenderView.setText("");
		}

		if (currentUser.has("email")) {
			userEmailView.setText(currentUser.getString("email"));
		} else {
			userEmailView.setText("");
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
		// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}
