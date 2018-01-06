package com.mindweaver.smartscan.scan;

import com.mindweaver.smartscan.data.CurrentUser;
import com.mindweaver.smartscan.data.Nodes;
import com.mindweaver.smartscan.models.Product;

/**
 * Created by Gabriel on 23-12-2017.
 */

public class SaveProductInfo {

    public void saveData(String codebar, String name, String brand, String price, String place) {

        if (name.trim().length() > 0 && brand.trim().length() > 0 && price.trim().length() > 0
                && place.trim().length() > 0) {

            //String userEmail = new NewUser().getEmail();
            Product product = new Product();
            product.setCodeBar(codebar);
            product.setName(name);
            product.setBrand(brand);
            product.setPrice(price);
            product.setPlace(place);
            //TODO chsnge the field name from id to uid
            product.setUid(new CurrentUser().uid());



            //NewUser user = new NewUser();

            //String key = new CleanMail().sanitizedEmail(user.getUid());

            new Nodes().codeBar(codebar).setValue(product);
            //new Nodes().codeBar().setValue(codeBar);

            //String key = new CleanMail().sanitizedEmail(currentUser.email());
            //new Nodes().users().child(key).setValue(user);







        }
    }

}
