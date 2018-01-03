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

    public String keyEmail(){
        String currentEmail = new CurrentUser().email();
        List<String> emails = new ArrayList<>();
        emails.add(sanitizedEmail(currentEmail));

        Collections.sort(emails);

        return emails.get(0) + " - " + emails.get(1);

    }


}
