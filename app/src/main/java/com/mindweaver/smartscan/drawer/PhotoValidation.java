package com.mindweaver.smartscan.drawer;

import android.content.Context;

import com.mindweaver.smartscan.data.PhotoPreference;

/**
 * Created by Gabriel on 22-12-2017.
 */

public class PhotoValidation {

    private Context context;
    private PhotoCallback callback;

    public PhotoValidation(Context context, PhotoCallback photoCallback) {
        this.context = context;
        this.callback = photoCallback;
    }

    public void validate(){

        String url = new PhotoPreference(context).getPhoto();
        if (url != null){

            callback.photoAvailable(url);

        }else {

            callback.empyPhoto();

        }



    }

}
