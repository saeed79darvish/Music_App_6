package com.example.saeed.music_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        TextView main = (TextView) findViewById(R.id.main_activity_playlist);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(PlayListActivity.this, MainActivity.class);
                startActivity(playlistintent);
            }
        });
        TextView albums = (TextView) findViewById(R.id.albums_playlist);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumintent = new Intent(PlayListActivity.this, AlbumsActivity.class);
                startActivity(albumintent);
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.category_PlayList));

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word(R.drawable.adele, "Adele", R.drawable.ic_play));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play));
        words.add(new word(R.drawable.bradpaisley, "BradPaisley", R.drawable.ic_play));
        words.add(new word(R.drawable.brunomars, "BrunoMars", R.drawable.ic_play));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play));
        words.add(new word(R.drawable.justinbeiber, "JustinBeiber", R.drawable.ic_play));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play));
        words.add(new word(R.drawable.luisfonsi, "LuisFonsi", R.drawable.ic_play));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play));
        words.add(new word(R.drawable.maroon5, "Maroon5", R.drawable.ic_play));
        words.add(new word(R.drawable.shakira, "Shakira", R.drawable.ic_play));

        wordAdapter Adapter = new wordAdapter(PlayListActivity.this, words);
        final ListView listView = (ListView) findViewById(R.id.Playlist);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(PlayListActivity.this, MusicDetailsActivity.class);
                intent.putExtra("ArtistName", listView.getItemAtPosition(position).toString());
                startActivity(intent);
                word word = words.get(position);
            }
        });
    }
}











