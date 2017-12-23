package com.mindweaver.smartscan.models;

import java.io.Serializable;

/**
 * Created by Gabriel on 23-12-2017.
 */

public class Product implements Serializable {

    private String codeBar, formatCodeBar;

    public Product() {
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    public String getFormatCodeBar() {
        return formatCodeBar;
    }

    public void setFormatCodeBar(String formatCodeBar) {
        this.formatCodeBar = formatCodeBar;
    }
}
