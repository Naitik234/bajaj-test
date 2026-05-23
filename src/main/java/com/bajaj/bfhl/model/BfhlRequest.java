package com.bajaj.bfhl.model;

import java.util.List;

/**
 * Request body model representing the incoming JSON array.
 * Uses clean vanilla Java to ensure seamless compatibility across all compilation toolchains.
 */
public class BfhlRequest {
    private List<String> data;

    public BfhlRequest() {
    }

    public BfhlRequest(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
