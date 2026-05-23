package com.bajaj.bfhl.service;

import com.bajaj.bfhl.model.BfhlRequest;
import com.bajaj.bfhl.model.BfhlResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for processing BFHL requests.
 */
@Service
public class BfhlServiceImpl implements BfhlService {

    @Value("${user.id}")
    private String userId;

    @Value("${user.email}")
    private String email;

    @Value("${user.roll.number}")
    private String rollNumber;

    @Override
    public BfhlResponse processRequest(BfhlRequest request) {
        try {
            List<String> numbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();

            if (request != null && request.getData() != null) {
                for (String item : request.getData()) {
                    if (item == null) {
                        continue;
                    }
                    String trimmed = item.trim();
                    // Regex for numbers: checks if the string is numeric (digits only)
                    if (trimmed.matches("^\\d+$")) {
                        numbers.add(trimmed);
                    } 
                    // Regex for alphabets: checks if the string consists of letters only
                    else if (trimmed.matches("^[a-zA-Z]+$")) {
                        alphabets.add(trimmed);
                    }
                }
            }

            return BfhlResponse.builder()
                    .isSuccess(true)
                    .userId(userId)
                    .email(email)
                    .rollNumber(rollNumber)
                    .numbers(numbers)
                    .alphabets(alphabets)
                    .build();

        } catch (Exception e) {
            // Handle error using try-catch as requested by the user
            return BfhlResponse.builder()
                    .isSuccess(false)
                    .userId(userId)
                    .email(email)
                    .rollNumber(rollNumber)
                    .numbers(new ArrayList<>())
                    .alphabets(new ArrayList<>())
                    .build();
        }
    }
}
