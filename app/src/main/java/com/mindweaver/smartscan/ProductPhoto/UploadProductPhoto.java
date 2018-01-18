package com.mindweaver.smartscan.ProductPhoto;

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
 * Created by Gabriel on 06-01-2018.
 */

public class UploadProductPhoto {

    private Context context;

    public UploadProductPhoto(Context context) {
        this.context = context;
    }

    public void UploadFireBase(String path){

        /*es lo mismo que para la selfi del usuario pero deja la foto del
        usuario en otra carpeta en el Storage*/

        final CurrentUser currentUser = new CurrentUser();
        String folder = new CleanMail().sanitizedEmail(currentUser.email() + "/");
        String ProductNamePhoto = "product.jpeg";
        String baseUrl = "gs://smartscan-9739e.appspot.com/products/";
        String refUrl = baseUrl + folder + ProductNamePhoto;

        StorageReference storageReference = FirebaseStorage.getInstance().getReference(refUrl);
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


    }

}
