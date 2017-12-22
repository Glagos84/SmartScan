package com.mindweaver.smartscan.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gabriel on 21-12-2017.
 */

public class CleanMail {

    public String sanitizedEmail(String email){
        return email.replace("@","AT").replace(".", "DOT");  /*hago replace por esos caracteres
        no son validos para los nombres de las carpetas en firebase*/

    }

    public String keyEmail(String otherEmail){
        String currentEmail = new CurrentUser().email();
        List<String> emails = new ArrayList<>();
        emails.add(sanitizedEmail(currentEmail));
        emails.add(sanitizedEmail(otherEmail));
        Collections.sort(emails);
     /*   List<LocalUser> localUsers = new ArrayList<>();
        Collections.sort(localUsers, new Comparator<LocalUser>() {
            @Override
            public int compare(LocalUser t1, LocalUser t2) {
                return t1.getName().compareTo(t2.getName());
            }
        });*/

        return emails.get(0) + " - " + emails.get(1);

    }


}
