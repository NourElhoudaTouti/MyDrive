package com.example.projectmiltone.Controller;

import com.example.projectmiltone.Data.dtos.Cart;
import com.example.projectmiltone.Data.dtos.Trip;
import com.example.projectmiltone.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.test.context.support.WithMockUser;

@RestController
@RequestMapping("/rest/Cart")
@WithMockUser
public class CartRestController {

    @Autowired
    private CartService cartService;

    @GetMapping("/get")
    public Cart getCart(/* Authentication auth */){
        //auth.getPrinciple()
        long userId = 1; //To be removed
        System.out.println(cartService);
        return cartService.getCart(userId);
    }

    @PatchMapping("/decreaseTripsAvailableseats")
    public Cart addTrip(@RequestBody Trip dto){
        //Retrieve userId from JWT-based security context
        //auth.getPrinciple()
        long userId = 1; //To be removed
        Cart cart=cartService.getCart(userId);
        return cartService.addTrip(cart,userId, dto.getId(), dto.getSavailableseats());
    }
    @PatchMapping("/removeTrip")
    public Cart removeProduct(@RequestBody Trip dto){
        //auth.getPrinciple()
        long userId = 1; //To be removed
        Cart cart = cartService.getCart(userId);
        return cartService.removeTrip(cart,userId, dto.getId());
    }
}
