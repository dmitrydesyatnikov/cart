package com.shopping.cart;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shopping.cart.client.ProductClient;
import com.shopping.cart.dto.cart.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    @Autowired
    private ProductClient productClient;
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
