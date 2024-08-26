package com.prashu.Service;

import com.prashu.exceptions.ProductException;
import com.prashu.model.Rating;
import com.prashu.model.User;
import com.prashu.requests.RatingRequest;

import java.util.List;


public interface RatingService {

    public Rating createRating(RatingRequest req , User user) throws ProductException;
    public List<Rating> getProductRating(Long productId);

}
