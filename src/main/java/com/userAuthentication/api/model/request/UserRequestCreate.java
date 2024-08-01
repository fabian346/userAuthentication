package com.userAuthentication.api.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRequestCreate {

    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Name may not be null")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @NotNull(message = "Name may not be null")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @NotNull(message = "Name may not be null")
    private String email;

    @NotBlank(message = "firstName is mandatory")
    @NotNull(message = "Name may not be null")
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    @NotNull(message = "Name may not be null")
    private String lastName;
}
