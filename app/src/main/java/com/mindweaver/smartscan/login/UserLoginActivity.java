package com.mindweaver.smartscan.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;
import com.mindweaver.smartscan.MainActivity;
import com.mindweaver.smartscan.R;
import com.mindweaver.smartscan.scan.ScanActivity;

import java.util.Arrays;

/**
 * Created by Gabriel on 21-12-2017.
 */

public class UserLoginActivity extends AppCompatActivity implements UserLoginCallback {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        new UserLoginPresenter(this).login();
    }

    @Override
    public void loggedUser() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }



    @Override
    public void signUser() {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(
                                Arrays.asList(

                                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build())
                        )
                        .build(),
                RC_SIGN_IN);


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RC_SIGN_IN == requestCode) {

            if (ResultCodes.OK == resultCode) {

                loggedUser();
                Toast.makeText(this, "Sesión Iniciada :D", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ScanActivity.class);
                startActivity(intent);
                finish();

            }



        }
    }
}
