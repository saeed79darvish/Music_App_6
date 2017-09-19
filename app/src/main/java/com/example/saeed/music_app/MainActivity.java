package com.example.saeed.music_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getResources().getString(R.string.app_name));


        TextView playlist = (TextView) findViewById(R.id.play_list_btn);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(playlistintent);
            }
        });
        TextView albums = (TextView) findViewById(R.id.albums_btn);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainintent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(mainintent);
            }
        });

        Button payment = (Button) findViewById(R.id.payment_paypal);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, paymentActivity.class);
                startActivity(intent);

            }
        });
    }
}
