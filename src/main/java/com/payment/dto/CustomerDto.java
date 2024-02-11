package com.payment.dto;


import com.payment.constant.MessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CustomerDto extends BaseDto {

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Size(max = 50 , min = 2 , message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String name;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Size(max = 50 , min = 2 , message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String surname;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Size(max = 5 , min = 5, message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String identityNo;
}
