package com.mindweaver.smartscan.scan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;
import com.mindweaver.smartscan.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{


    private static final int RC_CAMERA_PERMISSION = 343;
    private ZXingScannerView mScannerView;


    @SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startScanner();
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, RC_CAMERA_PERMISSION);
        }


    }

    public void startScanner(){
        mScannerView = findViewById(R.id.scannerXz);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }


    @Override
    public void handleResult(Result result) {

        // Do something with the result here
        Toast.makeText(this, result.getText(), Toast.LENGTH_SHORT).show();
        Log.v("codigo", result.getText());
        Log.v("formato", result.getBarcodeFormat().name());

        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (RC_CAMERA_PERMISSION == requestCode && PackageManager.PERMISSION_GRANTED == grantResults[0]) {
            startScanner();
        }
    }

}
