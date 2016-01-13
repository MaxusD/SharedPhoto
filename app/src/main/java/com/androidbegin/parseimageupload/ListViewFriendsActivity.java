package com.androidbegin.parseimageupload;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ListViewFriendsActivity extends Activity {

    /*ListView friendsListView;
    List<ParseObject> obj;
    ProgressDialog progressDialog;*/
   // ListVewAdapter adapterListVew;

    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<FriendsList> viewFriendsList = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(ListViewFriendsActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Loading images. Wait a bit");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            viewFriendsList = new ArrayList<FriendsList>();
            try {
                // Locate the class table named "SharedPhoto" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                        "SharedPhoto");

                query.orderByAscending("first_name");
                ob = query.find();
                for (ParseObject friendList : ob) {
                    // Locate images in flag column
                    ParseFile image = (ParseFile) friendList.get("photo");

                    FriendsList map = new FriendsList();
                    map.setFirstName((String) friendList.get("first_name"));
                    map.setSecondName((String) friendList.get("second_name"));
                    map.setCountry((String) friendList.get("country"));
                    map.setPhoto(image.getUrl());
                    viewFriendsList.add(map);
                    Log.d("viewFriendsList", map.getSecondName());
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(ListViewFriendsActivity.this,
                    viewFriendsList);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }

    /*private List<FriendsList> friendsList = null;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_friends);

        // находим список
        friendsListView = (ListView) findViewById(R.id.friendsListView);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        friendsListView.setAdapter(adapter);


    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(ListViewFriendsActivity.this);
            progressDialog.setTitle("User's list - Shared Photo");
            progressDialog.setMessage("Loading... wait a bit");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            friendsList = new ArrayList<FriendsList>();

            try {
                // Locate the class table named "Friends" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Friends");
                query.orderByAscending("Second_name");
                obj = query.find();

                for (ParseObject friend: obj) {
                    ParseFile image = (ParseFile) friend.get("Photo");

                    FriendsList friendsArray = new FriendsList();
                    friendsArray.setFirstName((String) friend.get("first_name"));
                    friendsArray.setSecondName((String) friend.get("second_name"));
                    friendsArray.setBirthday((Date) friend.get("birthday"));
                    friendsArray.setCity((String) friend.get("city"));
                    friendsArray.setCountry((String) friend.get("country"));
                    friendsArray.setId((Long) friend.get("id"));
                    friendsArray.setHobbie((String) friend.get("hobbie"));
                    friendsArray.setPhone((String) friend.get("phone"));
                    friendsArray.setPhoto(image.getUrl());

                    friendsList.add(friendsArray);

                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //super.onPostExecute(aVoid);
            friendsListView = (ListView) findViewById(R.id.friendsListView);
            adapterListVew = new ListViewAdapter();
        }
    }*/
}