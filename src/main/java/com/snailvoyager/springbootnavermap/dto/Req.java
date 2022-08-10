package com.snailvoyager.springbootnavermap.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req {
    @ApiModelProperty(value = "x값", example = "0", required = true)
    private int x;

    @ApiModelProperty(value = "y값", example = "0", required = true)
    private int y;
}
