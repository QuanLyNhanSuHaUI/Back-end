package com.example.quanlynhansu.service;

import com.example.quanlynhansu.domain.dto.request.contract.ContractCreationRequest;
import com.example.quanlynhansu.domain.dto.response.ContractResponse;

import java.util.List;

public interface ContractService {

    ContractResponse createContract(ContractCreationRequest request);

    List<ContractResponse> getAllContract();

    ContractResponse getContractById(String id);

    List<ContractResponse> getContractByEmployeeName(String name);

}
