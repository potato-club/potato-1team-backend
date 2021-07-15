package com.velog.veloguser.service;

import com.velog.veloguser.domain.entity.User;
import com.velog.veloguser.exception.AlreadyExistException;
import com.velog.veloguser.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceUtils {

    public static String encodePassword(PasswordEncoder passwordEncoder, String password){
       return passwordEncoder.encode(password);
    }

    public static void validateEmail(UserRepository userRepository, String email) throws NotFoundException {
        User findUser = userRepository.findUserByEmail(email).orElse(null);
        if(!(findUser == null)){
            throw new AlreadyExistException("이미 존재하는 계정입니다.");
        }
    }
}
