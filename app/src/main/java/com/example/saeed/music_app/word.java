package com.example.saeed.music_app;


import android.content.Context;

public class word   {

    private int mImageResourceId;

    private String mVersionName;

    private int mImageResourceId_1;

    private int mAudioResourceId;

    /*
    * Create a new AndroidFlavor object.
    *
    * @param vName is the name of the Android version (e.g. Gingerbread)
    * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
    * @param image is drawable reference ID that corresponds to the Android version
    * */
    public word(int imageResourceId,String vName,  int imageResourceId_1,int audioResourceId)
    {
        mImageResourceId = imageResourceId;
        mVersionName = vName;
        mImageResourceId_1 = imageResourceId_1;
        mAudioResourceId = audioResourceId;
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


    public int getAudioResourceId() {
        return  mAudioResourceId;
    }




}