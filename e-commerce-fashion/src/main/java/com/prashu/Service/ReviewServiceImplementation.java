package com.prashu.Service;

import com.prashu.Repository.ProductRepo;
import com.prashu.Repository.ReviewRepo;
import com.prashu.exceptions.ProductException;
import com.prashu.model.Product;
import com.prashu.model.Review;
import com.prashu.model.User;
import com.prashu.requests.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService{

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private  ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    public ReviewServiceImplementation(ReviewRepo reviewRepo, ProductService productService, ProductRepo productRepo) {
        this.reviewRepo = reviewRepo;
        this.productService = productService;
        this.productRepo = productRepo;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepo.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepo.getAllReviewsOfProduct(productId);
    }
}
