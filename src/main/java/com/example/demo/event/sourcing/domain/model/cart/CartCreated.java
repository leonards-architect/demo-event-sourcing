package com.example.demo.event.sourcing.domain.model.cart;

import com.example.demo.event.sourcing.domain.model.customer.CustomerCode;

public class CartCreated {

    CartId cartId;

    CustomerCode customerCode;

    public CartCreated(CartId cartId, CustomerCode customerCode) {
        this.cartId = cartId;
        this.customerCode = customerCode;
    }
}
