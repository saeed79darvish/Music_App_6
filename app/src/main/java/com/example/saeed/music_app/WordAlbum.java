package com.example.saeed.music_app;

public class WordAlbum {

    private int mImageResourceId;
    private String mVersionName;

    public WordAlbum(int imageResourceId, String vName) {
        mImageResourceId = imageResourceId;
        mVersionName = vName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getVersionName() {
        return mVersionName;
    }
}
