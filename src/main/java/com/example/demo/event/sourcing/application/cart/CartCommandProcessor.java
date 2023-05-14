package com.example.demo.event.sourcing.application.cart;

import com.example.demo.event.sourcing.domain.model.cart.Cart;
import com.example.demo.event.sourcing.domain.model.cart.CartCreated;
import com.example.demo.event.sourcing.domain.model.cart.CartId;
import com.example.demo.event.sourcing.domain.model.cart.CartItem;
import com.example.demo.event.sourcing.domain.model.cart.CartItemAdded;
import com.example.demo.event.sourcing.domain.model.cart.CartRepository;
import com.example.demo.event.sourcing.domain.model.customer.CustomerCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartCommandProcessor {

    CartRepository cartRepository;

    public Optional<Cart> create(CustomerCode customerCode) {
        Cart cart = Cart.create(customerCode);
        cartRepository.store(cart, new CartCreated(cart.getCartId(), customerCode));
        return Optional.of(cart);
    }

    public Optional<Cart> addItem(CartId cartId, CartItem cartItem) {
        Optional<Cart> cartOpt = cartRepository.findById(cartId);
        return cartOpt.map(cart -> {
            CartItemAdded cartItemAdded = cart.addItem(cartItem);
            cartRepository.store(cart, cartItemAdded);
            return cart;
        });
    }
}
