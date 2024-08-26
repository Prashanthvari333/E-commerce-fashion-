package com.prashu.Service;

import com.prashu.exceptions.UserException;
import com.prashu.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;


public interface UserService {

    public User findUserById(Long userId) throws  UserException;

    public User findUserProfileByJwt(String jwt) throws  UserException;
}
