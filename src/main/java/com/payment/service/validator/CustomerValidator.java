package com.payment.service.validator;

import com.payment.entity.Customer;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface CustomerValidator {
    void checkExistingCustomer(Optional<Customer> existCustomer);
}
