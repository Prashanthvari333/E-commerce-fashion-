package com.prashu.Controller;

import com.prashu.Repository.UserRepo;
import com.prashu.Service.CustomUserService;
import com.prashu.exceptions.UserException;
import com.prashu.requests.LoginRequest;
import com.prashu.config.JwtProvider;
import com.prashu.model.User;
import com.prashu.responses.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserService customUserService;

    public  AuthController(){

    }
    public AuthController(UserRepo repo,CustomUserService customUserService,PasswordEncoder passwordEncoder,JwtProvider jwtProvider) {
        this.repo = repo;
        this.customUserService = customUserService;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }




    @GetMapping("/hey")
    public String login(){
        return "Welcome User";
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandle(@RequestBody User user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        System.out.println("Im here...");

        User isEmailExist = repo.findByEmail(email);

        if(isEmailExist!=null){
            throw new UserException("Email is Already Used with another account");
        }

        System.out.println("Im here...to");

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        User savedUser = repo.save(newUser);

        System.out.println("Im here...till userCreation");

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signup Success");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandle(@RequestBody LoginRequest loginRequest){
        System.out.println("Hey u r here in signin");
        String userName = loginRequest.getEmail();
        System.out.println("userName : "+userName);
        String password = loginRequest.getPassword();
        System.out.println("password : "+password );
        Authentication authentication = authenticate(userName,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse(token,"Signin Success");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

    }

    private Authentication authenticate(String userName, String password) {
        UserDetails userDetails = customUserService.loadUserByUsername(userName);

        if(userDetails==null){
            throw  new BadCredentialsException("User not found");
        }
        System.out.println("UserDetail Password: " + userDetails.getPassword());
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid Password prashu");
        }
        return  new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

    }

}
