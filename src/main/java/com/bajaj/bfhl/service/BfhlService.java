package com.bajaj.bfhl.service;

import com.bajaj.bfhl.model.BfhlRequest;
import com.bajaj.bfhl.model.BfhlResponse;

/**
 * Service interface for processing BFHL requests.
 */
public interface BfhlService {
    BfhlResponse processRequest(BfhlRequest request);
}
