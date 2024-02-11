package com.payment.service.mapper;


import com.payment.dto.CustomerDto;
import com.payment.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true),
 nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
}
