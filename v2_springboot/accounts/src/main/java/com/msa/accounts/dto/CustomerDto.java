package com.msa.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Schema(
        name = "Customer",
        description = "Schema Customer and Account"
)
public class CustomerDto {

    @NotEmpty(message = "이름을 입력해주세요.")
    @Schema(
            description = "Name of the customer", example = "Sidle"
    )
    @Size(min = 5, max = 30, message = "이름은 5 ~ 30자로 입력해주세요.")
    private String name;

    @Schema(
            description = "email of the customer", example = "wodud4019@gmail.com"
    )
    @NotEmpty(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @Schema(
            description = "mobile number of the customer", example = "01033334444"
    )
    @Pattern(regexp = "(^$|[0-9]{11})", message = "휴대폰 번호를 입력해주세요.")
    private String mobileNumber;

    @Schema(
            description = "mobile account info of the customer"
    )
    private AccountsDto accountsDto;

}
