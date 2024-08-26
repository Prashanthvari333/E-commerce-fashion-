package com.prashu.Service;

import com.prashu.Repository.UserRepo;
import com.prashu.config.JwtProvider;
import com.prashu.exceptions.UserException;
import com.prashu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public JwtProvider jwtProvider;

    public UserServiceImplementation(){

    }

    public UserServiceImplementation(UserRepo userRepo,JwtProvider jwtProvider){
        this.userRepo = userRepo;
        this.jwtProvider = jwtProvider;
    }
    @Override
    public User findUserById(Long userId) throws UserException{
        Optional<User> user = userRepo.findById(userId);

        if(user.isPresent()){
            return user.get();
        }

        throw new UserException("User not found with id : "+userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException{
        String email = jwtProvider.getEmailFromToken(jwt);
        System.out.println("email : "+ email);
        User user = userRepo.findByEmail(email);

        if(user == null){
            throw new UserException("User not found with email "+ email);
        }
        return user;
    }
}
