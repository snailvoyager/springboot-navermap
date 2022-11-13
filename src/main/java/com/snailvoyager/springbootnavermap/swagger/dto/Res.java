package com.snailvoyager.springbootnavermap.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res {
    @ApiModelProperty(value = "결과값", example = "0", required = true)
    private int result;

    @ApiModelProperty(value = "response 객체", example = "Body", required = true)
    private Body response;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {
        private String resultCode = "OK";
    }
}
