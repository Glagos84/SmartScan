package com.mindweaver.smartscan.login;

import com.mindweaver.smartscan.data.CurrentUser;

/**
 * Created by Gabriel on 21-12-2017.
 */

public class UserLoginPresenter {

    private UserLoginCallback callback;

    public UserLoginPresenter(UserLoginCallback callback) {
        this.callback = callback;
    }

    public void login() {

        if (new CurrentUser().getCurrentUser() != null) {

            callback.loggedUser();
        } else {

            callback.signUser();


        }


    }

}
