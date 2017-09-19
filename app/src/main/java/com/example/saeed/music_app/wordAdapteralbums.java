package com.example.saeed.music_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class wordAdapteralbums extends ArrayAdapter<wordalbum> {
    public wordAdapteralbums(Activity context, ArrayList<wordalbum> words_album) {

        super(context, 0, words_album);
    }

    private static final String LOG_TAG = wordAdapteralbums.class.getSimpleName();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.gride_item_, parent, false);
        }
        wordalbum currentword = getItem(position);
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentword.getImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.version_name);
        nameTextView.setText(currentword.getVersionName());
        return listItemView;
    }
}

