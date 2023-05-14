package com.example.demo.event.sourcing.infrastructure.cart;

import com.example.demo.event.sourcing.domain.model.cart.Cart;
import com.example.demo.event.sourcing.domain.model.cart.CartCreated;
import com.example.demo.event.sourcing.domain.model.cart.CartId;
import com.example.demo.event.sourcing.domain.model.cart.CartItemAdded;
import com.example.demo.event.sourcing.domain.model.cart.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CartDataSource implements CartRepository {

    MongoTemplate mongoTemplate;

    @Override
    public void store(Cart cart, CartCreated cartCreated) {
        mongoTemplate.save(cart);
        mongoTemplate.save(cartCreated);
    }

    @Override
    public void store(Cart cart, CartItemAdded cartItemAdded) {
        mongoTemplate.save(cart);
        mongoTemplate.save(cartItemAdded);
    }

    @Override
    public Optional<Cart> findById(CartId cartId) {
        Query query = new Query(Criteria.where("cartId.value").is(cartId.value()));
        return Optional.ofNullable(mongoTemplate.findOne(query, Cart.class));
    }
}
