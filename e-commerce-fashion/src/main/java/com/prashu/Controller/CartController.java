package com.prashu.Controller;


import com.prashu.Service.CartService;
import com.prashu.Service.UserService;
import com.prashu.exceptions.ProductException;
import com.prashu.exceptions.UserException;
import com.prashu.model.Cart;
import com.prashu.model.User;
import com.prashu.requests.AddItemRequest;
import com.prashu.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
//@Tag(name="Cart Management", description = "find user cart, add item to cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    //@Operation(description = "find cart by user id")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
        //@Operation(description = "add item to cart")
    ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws ProductException,UserException{
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(),req);

        ApiResponse res = new ApiResponse();
        res.setMessage("Item added to cart");
        res.setStatus(true);
        return new ResponseEntity<>(res,HttpStatus.OK);

    }

}
