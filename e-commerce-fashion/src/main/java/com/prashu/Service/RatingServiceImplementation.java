package com.prashu.Service;

import com.prashu.Repository.RatingRepo;
import com.prashu.exceptions.ProductException;
import com.prashu.model.Product;
import com.prashu.model.Rating;
import com.prashu.model.User;
import com.prashu.requests.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImplementation  implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private ProductService productService;

    public RatingServiceImplementation(RatingRepo ratingRepo, ProductService productService) {
        this.ratingRepo = ratingRepo;
        this.productService = productService;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Rating rating = new Rating();
        rating.setRating(req.getRating());
        rating.setUser(user);
        rating.setProduct(product);
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getProductRating(Long productId) {

        return ratingRepo.getAllRatingsOfProduct(productId);
    }
}
