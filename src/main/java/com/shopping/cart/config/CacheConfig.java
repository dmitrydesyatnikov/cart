package com.shopping.cart.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shopping.cart.client.ProductClient;
import com.shopping.cart.dto.cart.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CacheConfig {

    private final ProductClient productClient;

    @Bean
    public LoadingCache<Integer, Product> getGuavaProductCache(){
        return CacheBuilder.newBuilder().build(new CacheLoader<Integer, Product>() {
            @Override
            public Product load(Integer key) throws Exception {
                return productClient.getProductById(key);
            }
        });
    }
}
