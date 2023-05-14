package com.example.demo.event.sourcing.domain.model.cart;

import com.example.demo.event.sourcing.domain.model.customer.CustomerCode;
import de.huxhorn.sulky.ulid.ULID;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private CartId cartId;

    private CustomerCode customerCode;

    private List<CartItem> cartItems;

    public Cart(CartId cartId, CustomerCode customerCode, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.customerCode = customerCode;
        this.cartItems = new ArrayList<>(cartItems);
    }

    public static Cart create(CustomerCode customerCode) {
        CartId cartId = CartId.of(new ULID().nextValue().timestamp()); // FIXME とりあえず
        return new Cart(cartId, customerCode, new ArrayList<>());
    }

    public CartItemAdded addItem(CartItem cartItem) {
        cartItems.add(cartItem);
        return new CartItemAdded(cartId, cartItem);
    }
}
