package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.base.RestApiV1;
import com.example.quanlynhansu.base.VsResponseUtil;
import com.example.quanlynhansu.constant.UrlConstant;
import com.example.quanlynhansu.domain.dto.request.contract.ContractCreationRequest;
import com.example.quanlynhansu.service.ContractService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContractController {

    ContractService contractService;

    @PostMapping(UrlConstant.Contract.CONTRACT_COMMON)
    public ResponseEntity<?> createContract (@Valid @RequestBody ContractCreationRequest request){
        return VsResponseUtil.success(HttpStatus.CREATED, contractService.createContract(request));
    }

    @GetMapping(UrlConstant.Contract.CONTRACT_COMMON)
    public ResponseEntity<?> getAllContracts (){
        return VsResponseUtil.success(HttpStatus.OK, contractService.getAllContract());
    }

    @GetMapping(UrlConstant.Contract.CONTRACT_ID)
    public ResponseEntity<?> getContractById(@PathVariable String id){
        return VsResponseUtil.success(HttpStatus.OK, contractService.getContractById(id));
    }

}
