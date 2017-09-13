package com.example.saeed.music_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class paymentActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        toolbar = (Toolbar) findViewById(R.id.toolbar_payment);
        toolbar.setTitle(getResources().getString(R.string.app_payment));


        TextView main = (TextView) findViewById(R.id.main_activity_playlist);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(paymentActivity.this, MainActivity.class);
                startActivity(playlistintent);
            }
        });
        TextView playlist = (TextView) findViewById(R.id.PlayList_payment);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playintent = new Intent(paymentActivity.this, PlayListActivity.class);
                startActivity(playintent);
            }
        });

        TextView albums = (TextView) findViewById(R.id.Albums_payment);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent albumintent = new Intent(paymentActivity.this, AlbumsActivity.class);

                startActivity(albumintent);
            }
        });
    }
}
