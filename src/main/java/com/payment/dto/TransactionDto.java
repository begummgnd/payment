package com.payment.dto;

import com.payment.constant.MessageConstants;
import com.payment.entity.enums.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TransactionDto extends BaseDto {
    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private TransactionType transactionType;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @DecimalMin(value = "0.00", inclusive = false, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    private BigDecimal amount;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String accountNumber;
    private String description;

}
