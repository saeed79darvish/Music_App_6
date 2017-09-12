package com.example.saeed.music_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class AlbumsActivity extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        toolbar = (Toolbar) findViewById(R.id.toolbar_album);
        toolbar.setTitle(getResources().getString(R.string.category_Albums));
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

        final TextView main = (TextView) findViewById(R.id.main_activity_Albums);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainintent = new Intent(AlbumsActivity.this, MainActivity.class);
                startActivity(mainintent);
            }
        });
        TextView playlist = (TextView) findViewById(R.id.PlayList_Albums);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playintent = new Intent(AlbumsActivity.this, PlayListActivity.class);
                startActivity(playintent);
            }
        });
    }
}
