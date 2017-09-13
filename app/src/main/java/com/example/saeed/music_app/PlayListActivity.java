package com.example.saeed.music_app;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);

                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        releaseMediaPlayer();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.category_PlayList));

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word(R.drawable.adele, "Adele", R.drawable.ic_play, R.raw.hello));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play, R.raw.hello));
        words.add(new word(R.drawable.bradpaisley, "BradPaisley", R.drawable.ic_play, R.raw.brad_paisley));
        words.add(new word(R.drawable.brunomars, "BrunoMars", R.drawable.ic_play, R.raw.bruno_mars));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play, R.raw.hello));
        words.add(new word(R.drawable.justinbeiber, "JustinBeiber", R.drawable.ic_play, R.raw.justin_beiber));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play, R.raw.hello));
        words.add(new word(R.drawable.luisfonsi, "LuisFonsi", R.drawable.ic_play, R.raw.luis_fonsi));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play, R.raw.hello));
        words.add(new word(R.drawable.adele, "adele", R.drawable.ic_play, R.raw.hello));
        words.add(new word(R.drawable.maroon5, "Maroon5", R.drawable.ic_play, R.raw.maroon5));
        words.add(new word(R.drawable.shakira, "Shakira", R.drawable.ic_play, R.raw.shakira_waka));
        releaseMediaPlayer();
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


                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    releaseMediaPlayer();
                    mediaPlayer = MediaPlayer.create(PlayListActivity.this, word.getAudioResourceId());
                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        releaseMediaPlayer();

    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
        TextView main = (TextView) findViewById(R.id.main_activity_playlist);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainintent = new Intent(PlayListActivity.this, MainActivity.class);
                startActivity(mainintent);
            }
        });

        TextView albums = (TextView) findViewById(R.id.albums_playlist);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainintent = new Intent(PlayListActivity.this, AlbumsActivity.class);

                startActivity(mainintent);
            }
        });
    }
}

