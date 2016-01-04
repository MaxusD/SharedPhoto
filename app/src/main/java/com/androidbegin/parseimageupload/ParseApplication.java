package com.androidbegin.parseimageupload;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "EOvbitVJkE1GUmXd92A4viwdnc7WQHuJp6GQeH7f", "6Cit9gR7ZEqW1b8q6PjwKFFWHYEL8pGWdYeQa7z0");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}