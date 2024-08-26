package com.prashu.Controller;

import com.prashu.Service.RatingService;
import com.prashu.Service.UserService;
import com.prashu.exceptions.ProductException;
import com.prashu.exceptions.UserException;
import com.prashu.model.Rating;
import com.prashu.model.User;
import com.prashu.requests.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req,
                                               @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(jwt);

        Rating rating = ratingService.createRating(req,user);

        return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);
    }


    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductRating(@RequestBody Long productId,
                                                         @RequestHeader("Authorization") String jwt) throws UserException,ProductException{

        User user = userService.findUserProfileByJwt(jwt);

        List<Rating> ratings = ratingService.getProductRating(productId);

        return new ResponseEntity<>(ratings,HttpStatus.CREATED);


    }

}
