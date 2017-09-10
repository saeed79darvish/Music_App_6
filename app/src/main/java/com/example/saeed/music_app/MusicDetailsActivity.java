package com.example.saeed.music_app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicDetailsActivity extends AppCompatActivity {
    Toolbar mtoolbar;
    ImageView artistImage;
    TextView tvArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);
        mtoolbar = (Toolbar) findViewById(R.id.toolbar_1);
        artistImage = (ImageView) findViewById(R.id.image_artist);
        tvArtist = (TextView) findViewById(R.id.Attist_name_1);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            tvArtist.setText(bundle.getString("ArtistName"));
            mtoolbar.setTitle(bundle.getString("ArtistName"));

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
