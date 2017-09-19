package com.example.saeed.music_app;

public class wordalbum {

    private int mImageResourceId;
    private String mVersionName;

    public wordalbum(int imageResourceId, String vName) {
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
