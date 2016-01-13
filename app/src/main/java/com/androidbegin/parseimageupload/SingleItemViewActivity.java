package com.androidbegin.parseimageupload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemViewActivity extends Activity {

    // Declare Variables
    String firstName;
    String country;
    String secondName;
    String photo;
    String city;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.activity_single_item_view);

        Intent i = getIntent();
        // Get the result of firstName
        firstName = i.getStringExtra("firstName");
        // Get the result of secondName
        secondName = i.getStringExtra("secondName");
        // Get the result of country
        country = i.getStringExtra("country");
        // Get the result of photo
        photo = i.getStringExtra("photo");

        // Locate the TextViews in singleitemview.xml
        TextView firstNameTextView = (TextView) findViewById(R.id.first_name);
        TextView secondNameTextView = (TextView) findViewById(R.id.second_name);
        TextView countryTextView = (TextView) findViewById(R.id.country);

        // Locate the ImageView in singleitemview.xml
        ImageView photoIV = (ImageView) findViewById(R.id.photo);

        // Set results to the TextViews
        firstNameTextView.setText(firstName);
        secondNameTextView.setText(secondName);
        countryTextView.setText(country);


        // Capture city and set results to the ImageView
        // Passes photo images URL into ImageLoader.class
        imageLoader.DisplayImage(photo, photoIV);
    }

}
