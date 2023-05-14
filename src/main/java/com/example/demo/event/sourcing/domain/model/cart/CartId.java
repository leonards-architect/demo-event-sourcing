package com.example.demo.event.sourcing.domain.model.cart;

public record CartId(long value) {
    public static CartId of(long value) {
        return new CartId(value);
    }
}
