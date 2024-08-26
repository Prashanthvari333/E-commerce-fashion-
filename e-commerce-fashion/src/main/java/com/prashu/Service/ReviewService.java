package com.prashu.Service;

import com.prashu.exceptions.ProductException;
import com.prashu.model.Review;
import com.prashu.model.User;
import com.prashu.requests.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest req , User user) throws ProductException;

    public List<Review> getAllReview(Long productId);
}
