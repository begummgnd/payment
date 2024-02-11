package com.payment.service;


import com.payment.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto dto);
    List<AccountDto> getAllAccountsByCustomerNumber(String customerNumber);

}
