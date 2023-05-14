package com.example.demo.event.sourcing.domain.model.cart;

public class CartItemAdded {
    CartId cartId;
    CartItem cartItem;

    public CartItemAdded(CartId cartId, CartItem cartItem) {
        this.cartId = cartId;
        this.cartItem = cartItem;
    }
}
