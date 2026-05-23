package com.bajaj.bfhl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response body model representing the processed outcome.
 * Includes Lombok annotations as required, with explicit fallbacks to guarantee compilation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BfhlResponse {
    
    @JsonProperty("is_success")
    private boolean success;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("roll_number")
    private String rollNumber;

    @JsonProperty("numbers")
    private List<String> numbers;

    @JsonProperty("alphabets")
    private List<String> alphabets;

    // Explicit constructors and getters/setters to guarantee compilation without Lombok processor
    public BfhlResponse() {
    }

    public BfhlResponse(boolean success, String userId, String email, String rollNumber, List<String> numbers, List<String> alphabets) {
        this.success = success;
        this.userId = userId;
        this.email = email;
        this.rollNumber = rollNumber;
        this.numbers = numbers;
        this.alphabets = alphabets;
    }

    @JsonProperty("is_success")
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    // Explicit builder implementation to replace Lombok builder if processor is inactive
    public static BfhlResponseBuilder builder() {
        return new BfhlResponseBuilder();
    }

    public static class BfhlResponseBuilder {
        private boolean success;
        private String userId;
        private String email;
        private String rollNumber;
        private List<String> numbers;
        private List<String> alphabets;

        public BfhlResponseBuilder isSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public BfhlResponseBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public BfhlResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public BfhlResponseBuilder rollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public BfhlResponseBuilder numbers(List<String> numbers) {
            this.numbers = numbers;
            return this;
        }

        public BfhlResponseBuilder alphabets(List<String> alphabets) {
            this.alphabets = alphabets;
            return this;
        }

        public BfhlResponse build() {
            return new BfhlResponse(success, userId, email, rollNumber, numbers, alphabets);
        }
    }
}
