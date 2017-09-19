package com.example.saeed.music_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicDetailsActivity extends AppCompatActivity {
    Toolbar mtoolbar;
    ImageView artistImage;
    TextView tvArtist;
    TextView tvArtist_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);

        mtoolbar = (Toolbar) findViewById(R.id.toolbar_1);
        mtoolbar.setTitle(getResources().getString(R.string.app_nowplaying));

        artistImage = (ImageView) findViewById(R.id.image_artist);
        tvArtist = (TextView) findViewById(R.id.artist_name_1);
        tvArtist_1 = (TextView) findViewById(R.id.artist_name_2);

        TextView main = (TextView) findViewById(R.id.main_activity_playlist);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(MusicDetailsActivity.this, MainActivity.class);
                startActivity(playlistintent);
            }
        });
        TextView playlist = (TextView) findViewById(R.id.playList_payment);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playintent = new Intent(MusicDetailsActivity.this, PlayListActivity.class);
                startActivity(playintent);
            }
        });

        TextView albums = (TextView) findViewById(R.id.albums_payment);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent albumintent = new Intent(MusicDetailsActivity.this, AlbumsActivity.class);
                startActivity(albumintent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            tvArtist.setText(bundle.getString("ArtistName"));
            tvArtist_1.setText(bundle.getString("ArtistName"));


            if (tvArtist.getText().toString().equalsIgnoreCase("Shakira")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.shakira));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("BradPaisley")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.bradpaisley));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("Brunomars")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.brunomars));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("Justinbeiber")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.justinbeiber));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("Maroon5")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.maroon5));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("adele")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.adele));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("Adele")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.adele));
            }
            if (tvArtist.getText().toString().equalsIgnoreCase("Luisfonsi")) {
                artistImage.setImageDrawable(getResources().getDrawable(R.drawable.luisfonsi));
            }
        }
    }
}
