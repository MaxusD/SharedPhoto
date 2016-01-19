package com.androidbegin.parseimageupload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

public class MainActivity extends Activity {
	/*Button button;
	ProgressDialog prgDialog;
	private static int RESULT_LOAD_IMG = 1;
	RequestParams params = new RequestParams();
	String imgPath, fileName;*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Determine whether the current user is an anonymous user
		if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
			// If user is anonymous, send the user to MainActivity.class
			Intent intent = new Intent(MainActivity.this,
					LoginActivity.class);
			startActivity(intent);
			finish();
		} else {
			// If current user is NOT anonymous user
			// Get current user data from Parse.com
			ParseUser currentUser = ParseUser.getCurrentUser();
			if (currentUser != null) {
				// Send logged in users to Welcome.class
				Intent intent = new Intent(MainActivity.this, ListViewFriendsActivity.class);
				startActivity(intent);
				finish();
			} else {
				// Send user to MainActivity.class
				Intent intent = new Intent(MainActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		}
		/*// Get the view from main.xml
		setContentView(R.layout.main);

		// Locate the button in main.xml
		button = (Button) findViewById(R.id.uploadbtn);

		prgDialog = new ProgressDialog(this);
		prgDialog.setCancelable(false);

		// Capture button clicks
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Locate the image in res > drawable-hdpi
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
						R.drawable.share);
				// Convert it to byte
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				// Compress image to lower quality scale 1 - 100
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
				byte[] image = stream.toByteArray();

				// Create the ParseFile
				ParseFile file = new ParseFile("share.png", image);
				// Upload the image into Parse Cloud
				file.saveInBackground();

				// Create a New Class called "ImageUpload" in Parse
				ParseObject imgupload = new ParseObject("SharedPhoto");
				
				// Create a column named "ImageName" and set the string
				imgupload.put("ImageName", "new photo");
				
				// Create a column named "ImageFile" and insert the image
				imgupload.put("ImageFile", file);
				
				// Create the class and the columns
				imgupload.saveInBackground();

				// Show a simple toast message
				Toast.makeText(MainActivity.this, "Image Uploaded",
						Toast.LENGTH_SHORT).show();*/
	/*		}
		});*/
	}

	/*public void loadImagefromGallery(View view) {
		// Create intent to Open Image applications like Gallery, Google Photos
		Intent galleryIntent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		// Start the Intent
		startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
	}

	// When Image is selected from Gallery
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			// When an Image is picked
			if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data

				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				// Get the cursor
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				// Move to first row
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				imgPath = cursor.getString(columnIndex);
				cursor.close();
				ImageView imgView = (ImageView) findViewById(R.id.imgView);
				// Set the Image in ImageView
				imgView.setImageBitmap(BitmapFactory.decodeFile(imgPath));
				// Get the Image's file name
				String fileNameSegments[] = imgPath.split("/");
				fileName = fileNameSegments[fileNameSegments.length - 1];
				// Put file name in Async Http Post Param which will used in Php web app
				params.put("filename", fileName);

			} else {
				Toast.makeText(this, "You haven't picked Image",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
					.show();
		}

	}*/

	//@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
