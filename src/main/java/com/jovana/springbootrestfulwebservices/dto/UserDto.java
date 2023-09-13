package com.jovana.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record UserDto(Long id,
                      @NotEmpty(message = "User first name must not be null or empty.")
                      String firstName,
                      @NotEmpty(message = "User last name must not be null or empty.")
                      String lastName,
                      @NotEmpty(message = "User email must not be null or empty.")
                      @Email(message = "Email address must be valid.")
                      String email) {
    
}
