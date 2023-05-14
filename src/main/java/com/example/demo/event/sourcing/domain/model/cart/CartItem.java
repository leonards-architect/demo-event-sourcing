package com.example.demo.event.sourcing.domain.model.cart;


import com.example.demo.event.sourcing.domain.model.product.ProductCode;
import com.example.demo.event.sourcing.domain.type.Quantity;

public record CartItem(ProductCode productCode, Quantity quantity) {
}
