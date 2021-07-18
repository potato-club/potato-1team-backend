package com.velog.veloguser.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "{email.notBlank}")
    @Size(min = 2, message = "{email.size}")
    @Email
    private String email;

    @NotBlank(message = "{password.notBlank}")
    @Size(min = 8, message = "{password.size}")
    private String password;

}
