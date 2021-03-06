package com.mindweaver.smartscan.scan;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mindweaver.smartscan.data.Nodes;
import com.mindweaver.smartscan.models.Product;

/**
 * Created by Gabriel on 23-12-2017.
 */

public class UploadCodeBar extends AppCompatActivity {

    private UploadCodeBarCallback callback;

    public UploadCodeBar(UploadCodeBarCallback callback) {
        this.callback = callback;
    }

    public void toFireBase(final String codebar) {
        new Nodes().codeBar(codebar).child(codebar).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Product product = dataSnapshot.getValue(Product.class);
                    callback.codeBarExists(product);


                    //TODO callback to show the product and allow the user to add a new price pass the product in the callback
                } else {
                    //todo callbcak create  activity pass the codebar back
                    callback.codeBarNoExists(codebar);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
