package com.shopping.cart.client;

import com.shopping.cart.dto.cart.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductClient {

    public Product getProductById(Integer id) {
        // Здесь будет реализован клиент http-сервиса, а сейчас - заглушка
        return null;
    }
}
