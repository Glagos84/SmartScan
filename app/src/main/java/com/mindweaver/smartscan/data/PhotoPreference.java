package com.mindweaver.smartscan.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Gabriel on 22-12-2017.
 */

public class PhotoPreference {

    private static final String GROUP_PHOTO = "com.mindweaver.smartscan.data.KEY.GROUP_PHOTO";
    private static final String KEY_PHOTO = "com.mindweaver.smartscan.data.KEY.KEY_PHOTO";
    private Context context;

    public PhotoPreference(Context context) {
        this.context = context;
    }

    public void photoSave(String url) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(GROUP_PHOTO, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(KEY_PHOTO, url);
        prefEditor.apply();
    }

    public String getPhoto() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(GROUP_PHOTO, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PHOTO, null);
    }

}
