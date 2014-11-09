package com.seysame.authentication;

import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.Button;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.integratingfacebooktutorial.R;
import com.seysame.parse.application.SeysameApplication;

public class LoginActivity extends Activity implements SurfaceTextureListener {

	private Button loginButton;
	private Dialog progressDialog;
	private MediaPlayer mp;
	private TextureView textureView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		mp = new MediaPlayer();
		textureView = (TextureView) findViewById(R.id.textureView);
	    textureView.setSurfaceTextureListener(this);

		loginButton = (Button) findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onLoginButtonClicked();
			}
		});

		// Check if there is a currently logged in user
		// and it's linked to a Facebook account.
		ParseUser currentUser = ParseUser.getCurrentUser();
		if ((currentUser != null) && ParseFacebookUtils.isLinked(currentUser)) {
			// Go to the user info activity
			showUserDetailsActivity();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	private void onLoginButtonClicked() {
		LoginActivity.this.progressDialog = 
				ProgressDialog.show(LoginActivity.this, "", "Logging in...", true);
		
		//List<String> permissions = Arrays.asList("public_profile", "email","user_birthday","user_location");
		
		List<String>permissions =Arrays.asList(getResources().getStringArray(R.array.permissions));
		// NOTE: for extended permissions, like "user_about_me", your app must be reviewed by the Facebook team
		// (https://developers.facebook.com/docs/facebook-login/permissions/)
		
		ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				LoginActivity.this.progressDialog.dismiss();
				if (user == null) {
					Log.d(SeysameApplication.TAG, "Uh oh. The user cancelled the Facebook login.");
				} else if (user.isNew()) {
					Log.d(SeysameApplication.TAG, "User signed up and logged in through Facebook!");
					showUserDetailsActivity();
				} else {
					Log.d(SeysameApplication.TAG, "User logged in through Facebook!");
					showUserDetailsActivity();
				}
			}
		});
	}

	private void showUserDetailsActivity() {
		Intent intent = new Intent(this, UserDetailsActivity.class);
		startActivity(intent);
		mp.stop();
    	mp.release();
	}

	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width,
			int height) {
		 Surface surface = new Surface(surfaceTexture);

		    try {
		       // AssetFileDescriptor afd = getAssets().openFd(FILE_NAME);
		    	Uri video = Uri.parse("android.resource://" + getPackageName() + "/"+ R.raw.video);
		        mp = new MediaPlayer();
		        mp.setDataSource(this,video);
		        mp.setSurface(surface);
		        mp.setLooping(true);
		        mp.prepareAsync();

		        // Play video when the media source is ready for playback.
		        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
		            @Override
		            public void onPrepared(MediaPlayer mediaPlayer) {
		                mediaPlayer.start();
		            }
		        });

		    } catch (IllegalArgumentException e) {
		        Log.d( LoginActivity.class.getName(),e.getMessage());
		    } catch (SecurityException e) {
		        Log.d(LoginActivity.class.getName(), e.getMessage());
		    } catch (IllegalStateException e) {
		        Log.d(LoginActivity.class.getName(), e.getMessage());
		    } catch (IOException e) {
		        Log.d(LoginActivity.class.getName(), e.getMessage());
		    }
		
	}

	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture surface) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	    if (mp != null) {
	    	mp.stop();
	    	mp.release();
	    	mp = null;
	    }
	}
}
