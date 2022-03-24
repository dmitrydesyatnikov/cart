package com.shopping.cart.loaderFromCache;

import com.shopping.cart.dto.cart.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class ProductFromCache {

    private final LoadingCache<Integer, Product> cache;

    @Autowired
    public ProductFromCache(LoadingCache<Integer, Product> cache){
        this.cache=cache;
    }

    public Optional<Product> getProductById(Integer id){
        try {
            return Optional.of(cache.get(id));
        } catch (ExecutionException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
