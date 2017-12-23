package com.mindweaver.smartscan.scan;

import com.mindweaver.smartscan.models.Product;

/**
 * Created by Gabriel on 23-12-2017.
 */

public interface UploadCodeBarCallback {

    void codeBarExists(Product product);
    void codeBarNoExists(String codeBar);
}
