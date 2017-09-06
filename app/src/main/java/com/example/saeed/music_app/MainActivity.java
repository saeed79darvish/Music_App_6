package com.example.saeed.music_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView playlist = (TextView) findViewById(R.id.PlayList);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(playlistintent);
            }
        });


        TextView albums = (TextView) findViewById(R.id.Albums);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsintent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsintent);
            }
        });

    }

}
