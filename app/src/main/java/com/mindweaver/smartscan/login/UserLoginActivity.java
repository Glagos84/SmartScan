package com.mindweaver.smartscan.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.mindweaver.smartscan.MainActivity;
import com.mindweaver.smartscan.R;

import java.util.Arrays;

/**
 * Created by Gabriel on 21-12-2017.
 */

public class UserLoginActivity extends AppCompatActivity implements UserLoginCallback{

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
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
}
