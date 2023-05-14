package com.example.demo.event.sourcing.domain.model.product;

public record ProductCode(String value) {

    public static ProductCode of(String value) {
        return new ProductCode(value);
    }

}
