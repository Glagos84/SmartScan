package com.mindweaver.smartscan.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gabriel on 22-12-2017.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();// referencia raiz
    public DatabaseReference users(){

        return root.child("users");
    }

    public DatabaseReference user(String key){

        return users().child(key);

    }

    public DatabaseReference scanProducts(){

        return root.child("scans");

    }

}
