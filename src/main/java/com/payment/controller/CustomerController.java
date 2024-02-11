package com.payment.controller;


import com.payment.constant.ApiConstants;
import com.payment.constant.MessageConstants;
import com.payment.dto.CustomerDto;
import com.payment.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiConstants.CUSTOMER)
@Validated
public class CustomerController {

    private final CustomerService service;

    protected CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto dto) {
        return new ResponseEntity<>(service.createCustomer(dto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<CustomerDto> getCustomerByIdentityNo(@RequestParam
                                                        @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD) String identityNo) {
        return new ResponseEntity<>(service.getCustomerByIdentityNo(identityNo), HttpStatus.OK);
    }

    @GetMapping(ApiConstants.ALL)
    ResponseEntity<List<CustomerDto>> getAllCustomersByCriteria(@RequestParam(required = false) String search) {
        return new ResponseEntity<>(service.getAllCustomers(search), HttpStatus.OK);
    }
}
