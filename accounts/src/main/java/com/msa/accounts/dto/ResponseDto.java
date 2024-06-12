package com.msa.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Data @AllArgsConstructor
public class ResponseDto {
    // 상태 코드
    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    // 메세지
    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;

}
