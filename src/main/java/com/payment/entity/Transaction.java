package com.payment.entity;


import com.payment.constant.MessageConstants;
import com.payment.entity.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE transaction SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Transaction extends BaseEntity {

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Column(nullable = false)
    private TransactionType transactionType;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @DecimalMin(value = "0.00", inclusive = false, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Column(nullable = false)
    private BigDecimal amount;

    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Account account;
}
