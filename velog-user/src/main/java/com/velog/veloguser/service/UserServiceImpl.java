package com.velog.veloguser.service;

import com.velog.veloguser.domain.dto.request.UserRequest;
import com.velog.veloguser.domain.dto.response.UserResponse;
import com.velog.veloguser.domain.entity.User;
import com.velog.veloguser.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserResponse createUser(UserRequest request) throws NotFoundException {
        String encodedPassword = UserServiceUtils.encodePassword(passwordEncoder, request.getPassword());
        UserServiceUtils.validateEmail(userRepository, request.getEmail());

        User user = User.of(request.getEmail(), request.getPassword(), request.getName(), UUID.randomUUID().toString(), encodedPassword);

        User savedUser = userRepository.save(user);
        return UserResponse.of(savedUser.getEmail(), savedUser.getName(), savedUser.getUserId());
    }


}
