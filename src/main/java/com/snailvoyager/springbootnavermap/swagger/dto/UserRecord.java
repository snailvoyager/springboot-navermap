package com.snailvoyager.springbootnavermap.swagger.dto;

import jakarta.validation.constraints.Max;

public record UserRecord(String name, @Max(40) Integer age, Boolean adult) {
    public UserRecord(String name, Integer age, Boolean adult) {
        this.name = name;
        this.age = age != null ? age : 10;
        this.adult = adult != null ? adult : false;
    }
}
