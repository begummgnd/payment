package com.payment.entity;

import com.payment.constant.MessageConstants;
import com.payment.dto.AccountDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE customer SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Customer extends BaseEntity {

    @Column(nullable = false, length = 50)
    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Size(max = 50 , message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String name;

    @Column(nullable = false, length = 50)
    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Size(max = 50 , message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String surname;


    @Column(nullable = false, length = 5, updatable = false)
    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Size(max = 5 , min = 5, message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String identityNo;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Account> accounts;
}
