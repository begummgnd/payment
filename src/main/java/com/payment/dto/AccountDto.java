package com.payment.dto;

import com.payment.constant.MessageConstants;
import com.payment.entity.enums.AccountType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AccountDto extends BaseDto {
    @DecimalMin(value = "0.00", message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    private BigDecimal balance;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String accountName;

    private String accountNumber;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String customerIdentityNo;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private AccountType type;

    @Valid
    private Set<TransactionDto> transaction;
}
