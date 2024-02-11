package com.payment.service.validator.impl;

import com.payment.constant.MessageConstants;
import com.payment.entity.Customer;
import com.payment.exception.ApiException;
import com.payment.service.validator.CustomerValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerValidatorImpl implements CustomerValidator {
    @Override
    public void checkExistingCustomer(Optional<Customer> existCustomer) {
        if(existCustomer.isPresent()){
            throw new ApiException(MessageConstants.RENTACAR_EXISTING_RECORD, HttpStatus.BAD_REQUEST);
        }
    }
}
