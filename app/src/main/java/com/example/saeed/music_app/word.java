package com.example.saeed.music_app;


public class word {

    private int mImageResourceId;
    private String mVersionName;
    private int mImageResourceId_1;

    public word(int imageResourceId, String vName, int imageResourceId_1) {
        mImageResourceId = imageResourceId;
        mVersionName = vName;
        mImageResourceId_1 = imageResourceId_1;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public int getImageResourceId_1() {
        return mImageResourceId_1;
    }

    @Override
    public String toString() {
        return mVersionName;
    }
}
