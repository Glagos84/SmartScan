package com.mindweaver.smartscan.drawer;

import android.content.Context;
import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mindweaver.smartscan.data.CleanMail;
import com.mindweaver.smartscan.data.CurrentUser;
import com.mindweaver.smartscan.data.Nodes;
import com.mindweaver.smartscan.data.PhotoPreference;
import com.mindweaver.smartscan.models.NewUser;

/**
 * Created by Gabriel on 22-12-2017.
 */

public class UploadPhoto {

    private Context context;

    public UploadPhoto(Context context) {
        this.context = context;
    }

    public void toFireBase(String path){

        final CurrentUser currentUser = new CurrentUser();
        String folder = new CleanMail().sanitizedEmail(currentUser.email() + "/");
        String photoName = "avatar.jpeg";
        String baseUrl = "gs://smartscan-9739e.appspot.com//avatars/";
        String refUrl = baseUrl + folder + photoName;
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(refUrl);
        storageReference.putFile(Uri.parse(path)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                @SuppressWarnings("VisibleForTests") String[] fullUrl = taskSnapshot.getDownloadUrl().toString().split("&token");
                String url = fullUrl[0];
                new PhotoPreference(context).photoSave(url);
                NewUser user = new NewUser();
                user.setEmail(currentUser.email());
                user.setName(currentUser.getCurrentUser().getDisplayName());
                user.setPhoto_url(url);
                user.setId(currentUser.uid());
                String key = new CleanMail().sanitizedEmail(currentUser.email());
                new Nodes().users().child(key).setValue(user);

            }
        });

        //ADD: photo upload, ADD: user sent to db

    }

}
