package com.example.saeed.music_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        TextView main = (TextView) findViewById(R.id.main_activity_albums);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistintent = new Intent(AlbumsActivity.this, MainActivity.class);
                startActivity(playlistintent);
            }
        });
        TextView albums = (TextView) findViewById(R.id.playList_albums);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent albumintent = new Intent(AlbumsActivity.this, PlayListActivity.class);
                startActivity(albumintent);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar_album);
        toolbar.setTitle(getResources().getString(R.string.category_Albums));
        ArrayList<WordAlbum> words_albums = new ArrayList<WordAlbum>();

        words_albums.add(new WordAlbum(R.drawable.adele, "Adele"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.bradpaisley, "BradPaisly"));
        words_albums.add(new WordAlbum(R.drawable.brunomars, "Brunomars"));
        words_albums.add(new WordAlbum(R.drawable.adele, "Adele"));
        words_albums.add(new WordAlbum(R.drawable.justinbeiber, "JustinBeiber"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.luisfonsi, "LuisFonsi"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.maroon5, "Maroon5"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.shakira, "Shakira"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.adele, "adele"));
        words_albums.add(new WordAlbum(R.drawable.maroon5, "Maroon5"));

        WordAdapterAlbums Adapter = new WordAdapterAlbums(this, words_albums);
        GridView gridView = (GridView) findViewById(R.id.albums_activity);
        gridView.setAdapter(Adapter);
    }
}
