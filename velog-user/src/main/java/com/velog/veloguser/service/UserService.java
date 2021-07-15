package com.velog.veloguser.service;

import com.velog.veloguser.domain.dto.request.UserRequest;
import com.velog.veloguser.domain.dto.response.UserResponse;
import com.velog.veloguser.domain.entity.User;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserResponse createUser(UserRequest request) throws NotFoundException;
}
