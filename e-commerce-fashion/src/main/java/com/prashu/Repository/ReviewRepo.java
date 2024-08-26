package com.prashu.Repository;

import com.prashu.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {

    @Query("SELECT r from Review r Where r.product.id = :productId")
    public List<Review> getAllReviewsOfProduct(@Param("productId") Long productId);

}
