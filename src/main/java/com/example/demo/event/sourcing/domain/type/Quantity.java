package com.example.demo.event.sourcing.domain.type;

public record Quantity(int value) {
    public static Quantity of(int value) {
        return new Quantity(value);
    }
}
