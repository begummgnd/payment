package com.payment.service.impl;


import com.payment.constant.MessageConstants;
import com.payment.dto.CustomerDto;
import com.payment.entity.Customer;
import com.payment.exception.ApiException;
import com.payment.repository.CustomerRepository;
import com.payment.service.CustomerService;
import com.payment.service.mapper.CustomerMapper;
import com.payment.service.validator.CustomerValidator;
import com.payment.specifications.SpecificationsBuilder;
import com.payment.specifications.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final SpecificationsBuilder specificationsBuilder;
    private final CustomerMapper mapper;

    private final CustomerValidator validator;

    protected CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper,
                                  CustomerValidator validator,
                                  SpecificationsBuilder specificationsBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
        this.specificationsBuilder = specificationsBuilder;
    }

    @Override
    @Transactional
    public CustomerDto createCustomer(CustomerDto dto) {
        Optional<Customer> existCustomer = repository.findByIdentityNo(dto.getIdentityNo());
        validator.checkExistingCustomer(existCustomer);
        return mapper.entityToDto(repository.save(mapper.dtoToEntityForSave(dto)));
    }

    @Override
    public CustomerDto getCustomerByIdentityNo(String identityNo) {
        return mapper.entityToDto(repository.findByIdentityNo(identityNo).orElseThrow(
                () -> {
                    throw new ApiException(MessageConstants.RENTACAR_DATA_NOT_FOUND, HttpStatus.NOT_FOUND);

                }
        ));
    }

    @Override
    public List<CustomerDto> getAllCustomers(String search) {
        Specification<Customer> spec = specificationsBuilder.getSpecificationByCriteria(search);
        return mapper.entityListToDtoList(repository.findAll());
    }
}
