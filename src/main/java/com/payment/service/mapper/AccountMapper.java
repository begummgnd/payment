package com.payment.service.mapper;


import com.payment.dto.AccountDto;
import com.payment.entity.Account;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", uses = {TransactionMapper.class}, builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper extends BaseMapper<Account, AccountDto> {
}
