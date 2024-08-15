package com.prashu.Service;

import com.prashu.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findUserById(Long userId) throws ExecutionControl.UserException;

    public User findUserProfileByJwt(String jwt) throws ExecutionControl.UserException;
}
