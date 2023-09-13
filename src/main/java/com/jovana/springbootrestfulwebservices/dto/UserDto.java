package com.jovana.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record UserDto(Long id,
                      @NotEmpty // should not be null or empty
                      String firstName,
                      @NotEmpty String lastName,
                      @NotEmpty @Email String email) {

}
