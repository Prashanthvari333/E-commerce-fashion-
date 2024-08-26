package com.prashu.Repository;

import com.prashu.model.Cart;
import com.prashu.model.CartItem;
import com.prashu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo  extends JpaRepository<CartItem,Long> {

    @Query("SELECT ci From CartItem ci WHERE ci.cart = :cart AND ci.product = :product AND ci.size = :size AND ci.userId = :userId")
    public CartItem isCartItemExist(@Param("cart")Cart cart, @Param("product")Product product,@Param("size") String size , @Param("userId") Long userId);

}
