package com.jovana.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
@Schema(
        description = "UserDto info"
)
public record UserDto(Long id,
                      @Schema(
                              description = "User First Name"
                      )
                      @NotEmpty(message = "User first name must not be null or empty.")
                      String firstName,
                      
                      @Schema(
                              description = "User Last Name"
                      )
                      @NotEmpty(message = "User last name must not be null or empty.")
                      String lastName,
                      @NotEmpty(message = "User email must not be null or empty.")
                      @Email(message = "Email address must be valid.")
                      String email) {
    
}
