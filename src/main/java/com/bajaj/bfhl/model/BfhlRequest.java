package com.bajaj.bfhl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request body model representing the incoming JSON array.
 * Includes Lombok annotations as required, with explicit fallbacks to guarantee compilation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BfhlRequest {
    private List<String> data;

    // Explicit constructor, getters, and setters to guarantee compilation
    // even if Lombok annotation processor is disabled.
    public BfhlRequest(List<String> data) {
        this.data = data;
    }

    public BfhlRequest() {
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
