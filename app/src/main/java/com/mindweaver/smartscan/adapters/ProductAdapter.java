package com.mindweaver.smartscan.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;
import com.mindweaver.smartscan.models.Product;

/**
 * Created by Gabriel on 06-01-2018.
 */

public class ProductAdapter extends FirebaseRecyclerAdapter<Product, ProductAdapter.ProductHolder>{


      public ProductAdapter(Class<Product> modelClass, int modelLayout, Class<ProductHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    @Override
    protected void populateViewHolder(ProductHolder viewHolder, Product model, int position) {

    }

    public static class ProductHolder extends RecyclerView.ViewHolder{

        private TextView email;
        private TextView productName;
        private TextView price;

        public ProductHolder(View itemView) {
            super(itemView);
        }
        //TODO allow user to make a photo from the product


    }

}
