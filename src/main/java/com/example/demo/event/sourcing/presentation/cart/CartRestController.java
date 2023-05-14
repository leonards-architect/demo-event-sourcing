package com.example.demo.event.sourcing.presentation.cart;

import com.example.demo.event.sourcing.application.cart.CartCommandProcessor;
import com.example.demo.event.sourcing.domain.model.cart.Cart;
import com.example.demo.event.sourcing.domain.model.cart.CartId;
import com.example.demo.event.sourcing.domain.model.cart.CartItem;
import com.example.demo.event.sourcing.domain.model.customer.CustomerCode;
import com.example.demo.event.sourcing.domain.model.product.ProductCode;
import com.example.demo.event.sourcing.domain.type.Quantity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CartRestController {

    CartCommandProcessor cartCommandProcessor;

    @PostMapping("/v1/carts")
    public ResponseEntity<Cart> create() {
        // FIXME: とりあえず顧客コードはカート生成時に作り出す。つまり、毎回異なる顧客がカートを作っているという設定...
        CustomerCode customerCode = CustomerCode.of(UUID.randomUUID().toString());
        return cartCommandProcessor.create(customerCode).map(cart -> {
            // TODO URI
            return ResponseEntity.ok(cart);
        }).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/v1/carts/{cartId}/cart_items")
    public ResponseEntity<Cart> addItem(@PathVariable long cartId, @RequestBody AddCartItemRequest request) {
        Optional<Cart> cartOptional = cartCommandProcessor.addItem(
                CartId.of(cartId),
                new CartItem(ProductCode.of(request.productCode), Quantity.of(request.quantity)));
        return cartOptional.map(cart -> {
            // TODO URI
            return ResponseEntity.ok(cart);
        }).orElse(ResponseEntity.badRequest().build());
    }
}
