package com.payment.service.mapper;

import com.payment.dto.TransactionDto;
import com.payment.entity.Transaction;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TransactionMapper extends BaseMapper<Transaction, TransactionDto> {
}
