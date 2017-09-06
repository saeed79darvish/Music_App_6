package com.example.saeed.music_app;

public class word_album {

    private int mImageResourceId;

    private String mVersionName;


    public word_album(int imageResourceId, String vName) {
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
