package com.example.demo.event.sourcing.domain.model.cart;

import java.util.Optional;

public interface CartRepository {

    Optional<Cart> findById(CartId cartId);

    void store(Cart cart, CartCreated cartCreated);

    void store(Cart cart, CartItemAdded cartItemAdded);
}
