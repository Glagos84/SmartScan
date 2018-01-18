package com.mindweaver.smartscan.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mindweaver.smartscan.MainActivity;
import com.mindweaver.smartscan.ProductPhoto.TakeProdPhoto;
import com.mindweaver.smartscan.R;
import com.mindweaver.smartscan.scan.SaveProductInfo;

public class ProductActivity extends AppCompatActivity {

    public ProductActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        final String codebar = getIntent().getStringExtra("Code");
        final TextView code = findViewById(R.id.codeBarDetail);
        code.setText(codebar);

        // busco las vistas del xml, sobre el llenado de data del producto

        final EditText nameProduct = findViewById(R.id.nameProductTv);
        final EditText brand = findViewById(R.id.nameBrandTv);
        final EditText price = findViewById(R.id.detailPrice);
        final EditText place = findViewById(R.id.placeEt);
        final Button   uploadProductPhoto = findViewById(R.id.saveProductPhoto);
        final Button saveProduct = findViewById(R.id.saveBtn);


        saveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new SaveProductInfo().saveData(code.getText().toString(),nameProduct.getText().toString(),brand.getText().toString()
                        ,price.getText().toString(),place.getText().toString());
                Intent BackToDrawerFragment = new Intent(view.getContext(), MainActivity.class);
                startActivity(BackToDrawerFragment);
                //finish();





            }
        });


        uploadProductPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               TakeProductPhoto();

            }
        });





    }

    public void TakeProductPhoto(){


        Intent intent = new Intent(this, TakeProdPhoto.class);
        startActivity(intent);
        finish();// finalizar la activity dentro de un fragmento
        //new TakeProductPhoto().requestProductPhoto();

    }




}
