package com.payment.service;


import com.payment.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto dto);

    CustomerDto getCustomerByIdentityNo(String identityNo);

    List<CustomerDto> getAllCustomers(String search);
}
