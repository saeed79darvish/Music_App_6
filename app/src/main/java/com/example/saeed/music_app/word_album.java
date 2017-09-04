package com.example.saeed.music_app;

/**
 * Created by saeed on 8/24/2017.
 */

public class word_album {

    private int mImageResourceId;

    private String mVersionName;



    /*
    * Create a new AndroidFlavor object.
    *
    * @param vName is the name of the Android version (e.g. Gingerbread)
    * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
    * @param image is drawable reference ID that corresponds to the Android version
    * */
    public word_album(int imageResourceId,String vName)
    {
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
