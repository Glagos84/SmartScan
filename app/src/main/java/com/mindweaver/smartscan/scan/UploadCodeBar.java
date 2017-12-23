package com.mindweaver.smartscan.scan;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mindweaver.smartscan.data.Nodes;
import com.mindweaver.smartscan.models.Product;

/**
 * Created by Gabriel on 23-12-2017.
 */

public class UploadCodeBar implements UploadCodeBarCallback{



    public void toFireBase(String codebar) {
        new Nodes().scanProducts().child(codebar).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Product product = dataSnapshot.getValue(Product.class);

                    codeBarExists();
                    //TODO callback to show the product and allow the user to add a new price pass the product in the callback
                } else {
                    //todo callbcak create  activity pass the codebar back
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void codeBarExists() {

        

    }

    @Override
    public void codeBarNoExists() {

    }
}
