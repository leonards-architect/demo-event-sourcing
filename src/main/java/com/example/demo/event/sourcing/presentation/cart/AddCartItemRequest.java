package com.example.demo.event.sourcing.presentation.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddCartItemRequest {

    @JsonProperty("product_code")
    String productCode;

    int quantity;
}
