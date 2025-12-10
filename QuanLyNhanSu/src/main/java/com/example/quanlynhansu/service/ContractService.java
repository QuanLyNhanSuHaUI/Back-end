package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.contract.ContractCreationRequest;
import com.example.quanlynhansu.domain.dto.response.ContractResponse;

public interface ContractService {

    ContractResponse createContract(ContractCreationRequest request);

}
