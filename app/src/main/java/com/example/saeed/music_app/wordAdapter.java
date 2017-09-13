package com.example.saeed.music_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class wordAdapter extends ArrayAdapter<word> {
    public wordAdapter(Activity context, ArrayList<word> words) {

        super(context, 0, words);
    }
    private static final String LOG_TAG = com.example.saeed.music_app.wordAdapter.class.getSimpleName();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        word currentword = getItem(position);
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentword.getImageResourceId());


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.version_name);
        nameTextView.setText(currentword.getVersionName());

        ImageView iconView1 = (ImageView) listItemView.findViewById(R.id.list_item_1);
        iconView1.setImageResource(currentword.getImageResourceId_1());


        return listItemView;
    }

}

