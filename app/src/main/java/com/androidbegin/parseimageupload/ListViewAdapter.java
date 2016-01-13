package com.androidbegin.parseimageupload;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 07.01.2016.
 */
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<FriendsList> friendsLists = null;
    private ArrayList<FriendsList> arraylist;

    public ListViewAdapter(Context context,
                           List<FriendsList> friendsList) {
        this.context = context;
        this.friendsLists = friendsList;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<FriendsList>();
        this.arraylist.addAll(friendsList);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder {
        TextView firstName;
        TextView country;
        TextView lastName;
        ImageView photo;
    }

    @Override
    public int getCount() {
        return friendsLists.size();
    }

    @Override
    public Object getItem(int position) {
        return friendsLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_single_item_view, null);
            // Locate the TextViews in listview_item.xml
            holder.firstName = (TextView) view.findViewById(R.id.first_name);
            holder.lastName = (TextView) view.findViewById(R.id.second_name);
            holder.country = (TextView) view.findViewById(R.id.country);
            // Locate the ImageView in listview_item.xml
            holder.photo = (ImageView) view.findViewById(R.id.photo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.firstName.setText(friendsLists.get(position).getFirstName());
        holder.country.setText(friendsLists.get(position).getCountry());
        holder.lastName.setText(friendsLists.get(position).getSecondName());
        // Set the results into ImageView
        imageLoader.DisplayImage(friendsLists.get(position).getPhoto(),
                holder.photo);
        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(context, SingleItemViewActivity.class);
                // Pass all data first_name
                intent.putExtra("first_name",
                        (friendsLists.get(position).getFirstName()));
                // Pass all data country
                intent.putExtra("country",
                        (friendsLists.get(position).getCountry()));
                // Pass all data secondName
                intent.putExtra("last_name",
                        (friendsLists.get(position).getSecondName()));
                // Pass all data photo
                intent.putExtra("photo",
                        (friendsLists.get(position).getPhoto()));
                // Start SingleItemView Class
                context.startActivity(intent);
            }
        });
        return view;
    }



}
