package com.bajaj.bfhl.controller;

import com.bajaj.bfhl.model.BfhlRequest;
import com.bajaj.bfhl.model.BfhlResponse;
import com.bajaj.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller providing POST and GET endpoints for the BFHL challenge.
 */
@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*") // Enabled CORS for seamless frontend integration
public class BfhlController {

    private final BfhlService bfhlService;

    @Autowired
    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    /**
     * POST endpoint to process numbers and alphabets.
     *
     * @param request the BfhlRequest containing input data array
     * @return ResponseEntity containing the processed BfhlResponse
     */
    @PostMapping
    public ResponseEntity<BfhlResponse> processData(@RequestBody BfhlRequest request) {
        try {
            BfhlResponse response = bfhlService.processRequest(request);
            if (response.isSuccess()) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            // Graceful error handling at the controller level
            BfhlResponse errorResponse = BfhlResponse.builder()
                    .isSuccess(false)
                    .build();
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * GET endpoint returning operation_code as per typical Bajaj challenge requirements.
     *
     * @return ResponseEntity containing operation_code: 1
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }
}
