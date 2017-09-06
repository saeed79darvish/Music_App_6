package com.example.saeed.music_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;


public class AlbumsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        ArrayList<word_album> words_albums = new ArrayList<word_album>();

        words_albums.add(new word_album(R.drawable.adele, "Adele"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.bradpaisley, "BradPaisly"));
        words_albums.add(new word_album(R.drawable.brunomars, "Brunomars"));
        words_albums.add(new word_album(R.drawable.adele, "Adele"));
        words_albums.add(new word_album(R.drawable.justinbeiber, "JustinBeiber"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.luisfonsi, "LuisFonsi"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.maroon5, "Maroon5"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.shakira, "Shakira"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.adele, "adele"));
        words_albums.add(new word_album(R.drawable.maroon5, "Maroon5"));


        wordAdapter_albums Adapter = new wordAdapter_albums(this, words_albums);

        GridView gridView = (GridView) findViewById(R.id.Albums_Activity);

        gridView.setAdapter(Adapter);


    }
}
