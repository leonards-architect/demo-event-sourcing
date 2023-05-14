package com.example.demo.event.sourcing.domain.model.customer;

public record CustomerCode(String value) {
    public static CustomerCode of(String value) {
        return new CustomerCode(value);
    }
}
