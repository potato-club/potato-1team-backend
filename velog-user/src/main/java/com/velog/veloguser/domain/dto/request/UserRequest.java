package com.velog.veloguser.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "{email.notBlank}")
    @Size(min = 2, message = "{email.size}")
    private String email;

    @NotBlank(message = "{password.notBlank}")
    @Size(min = 8, message = "{password.size}")
    private String password;

    @NotBlank(message = "{name.notBlank}")
    @Size(min = 2, message = "{name.size}")
    private String name;
}
