package com.msa.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class AccountsDto {
    @NotEmpty(message = "계좌번호가 없습니다.")
    @Pattern(regexp = "(^$|[0-9]{11})", message = "계좌 번호를 입력해주세요.")
    @Schema(
            description = "계좌 번호"
    )
    private Long accountNumber;

    @NotEmpty(message = "계좌 타입은 필수 값입니다.")
    @Schema(
            description = "계좌 타입"
    )
    private String accountType;

    @NotEmpty(message = "주소는 필수 값 입니다.")
    @Schema(
            description = "주소"
    )
    private String branchAddress;
}
