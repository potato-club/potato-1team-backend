package com.velog.veloguser.controller;

import com.velog.veloguser.domain.utils.Result;
import com.velog.veloguser.domain.dto.request.UserRequest;
import com.velog.veloguser.domain.dto.response.UserResponse;
import com.velog.veloguser.service.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("createUser")
    public Result<UserResponse> createUser(@RequestBody @Valid UserRequest request) throws NotFoundException {
        return Result.success(userService.createUser(request));
    }
}
