package com.prashu.Repository;

import com.prashu.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Query("SELECT c from Cart c Where c.user.id = :userId")
    public Cart findByUserId(@Param("userId") Long userId);
}
