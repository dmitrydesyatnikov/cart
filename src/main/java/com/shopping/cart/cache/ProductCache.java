package com.shopping.cart.cache;

import com.shopping.cart.dto.cart.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class ProductCache {

    private final LoadingCache<Integer, Product> cache;

    @Autowired
    public ProductCache(LoadingCache<Integer, Product> cache){
        this.cache=cache;
    }

    public Optional<Product> getProductById(Integer id){
        try {
            return Optional.of(cache.get(id));
        } catch (ExecutionException e) {
            log.error("Error while getting product from cache", e);
            return Optional.empty();
        }
    }
}
