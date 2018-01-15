package com.mindweaver.smartscan.ProductPhoto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.frosquivel.magicalcamera.MagicalCamera;
import com.frosquivel.magicalcamera.MagicalPermissions;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.mindweaver.smartscan.R;
import com.mindweaver.smartscan.drawer.PhotoCallback;
import com.mindweaver.smartscan.drawer.PhotoValidation;
import com.squareup.picasso.Picasso;

/**
 * Created by Gabriel on 06-01-2018.
 */

public class TakeProductPhoto extends AppCompatActivity implements PhotoCallback {

    private MagicalPermissions magicalPermissions;
    private MagicalCamera magicalCamera;

    private int PHOTO_SIZE = 40;
    private CircularImageView product;

    public TakeProductPhoto() {
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] permissions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };


        magicalPermissions = new MagicalPermissions(this, permissions);
        magicalCamera = new MagicalCamera(this, PHOTO_SIZE, magicalPermissions);
        product = findViewById(R.id.productPhotoIv);
        new PhotoValidation(this, this).validate();


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        magicalPermissions.permissionResult(requestCode, permissions, grantResults);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        magicalCamera.resultPhoto(requestCode, resultCode, data,MagicalCamera.ORIENTATION_ROTATE_90);


        if (RESULT_OK == resultCode) {
            Bitmap photo = magicalCamera.getPhoto();
            String path = magicalCamera.savePhotoInMemoryDevice(photo, "Product", "smartscan", MagicalCamera.JPEG, true);
            path = "file://" + path;
            setPhoto(path);

            new UploadProductPhoto(this).UploadFireBase(path); // con esto lo subo a FireBase


        } else {

            requestProductPhoto();

        }

    }

    public void requestProductPhoto(){




        new AlertDialog.Builder(this)
                .setTitle("Saca una Foto al Producto")
                .setMessage("Solo debes tomar la foto del producto, para continuar")
                .setCancelable(false)
                .setPositiveButton("Foto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        magicalCamera.takePhoto();
                        dialog.dismiss();

                    }
                })
                .show();


    }

    private void setPhoto(String url) {

        Picasso.with(this).load(url).centerCrop().fit().into(product);


    }

    @Override
    public void empyPhoto() {

        requestProductPhoto();

    }

    @Override
    public void photoAvailable(String url) {

        setPhoto(url);

    }
}
