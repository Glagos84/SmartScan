package com.mindweaver.smartscan.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.mindweaver.smartscan.R;
import com.mindweaver.smartscan.data.Nodes;
import com.mindweaver.smartscan.models.Product;

/**
 * Created by Gabriel on 06-01-2018.
 */

public class ProductAdapter extends FirebaseRecyclerAdapter<Product, ProductAdapter.ProductHolder>{

    private ProductListener productListener;


      public ProductAdapter() {
        super(Product.class, R.layout.list_item_product, ProductHolder.class, new Nodes().scans());
        this.productListener = productListener;
    }

    @Override
    protected void populateViewHolder(final ProductHolder viewHolder, Product model, int position) {
        viewHolder.productName.setText(model.getName());
        viewHolder.productPlace.setText(model.getPlace());
        viewHolder.productPrice.setText(model.getPrice());
        viewHolder.codeBar.setText(model.getCodeBar());
    }

    public static class ProductHolder extends RecyclerView.ViewHolder{

        private TextView productName;
        private TextView productPlace;
        private TextView productPrice;
        private TextView codeBar;

        private ImageView email,detail;

        @SuppressLint("CutPasteId")
        public ProductHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productTv);
            productPlace = itemView.findViewById(R.id.placeTv);
            productPrice = itemView.findViewById(R.id.priceTv);
            codeBar = itemView.findViewById(R.id.codeBarTv);
            email = itemView.findViewById(R.id.emailBtn);
            detail = itemView.findViewById(R.id.productDetailBtn);
        }




    }

}
