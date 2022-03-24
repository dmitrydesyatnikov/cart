package com.shopping.cart.service;

import com.shopping.cart.dto.calculatedCart.CalculatedArrayProducts;
import com.shopping.cart.dto.calculatedCart.CalculatedCart;
import com.shopping.cart.dto.cart.Cart;
import com.shopping.cart.dto.cart.Product;
import com.shopping.cart.loaderFromCache.ProductFromCache;
import com.shopping.cart.serviceInterface.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService implements CartServiceInterface {
    @Autowired
    private ProductFromCache productFromCache;
    @Autowired
    private MathContext mathContext;
    /**
     * Метод расчёта корзины
     *
     */
    @Override
    public CalculatedCart calculatedCart(Cart cart) {
        List<CalculatedArrayProducts> calculatedArrayProducts = cart.getProducts().stream()
                .map(arrayProducts -> {
                    Product product = productFromCache.getProductById(arrayProducts.getId())
                            .orElse(new Product(arrayProducts.getId(), BigDecimal.ZERO));
                    return new CalculatedArrayProducts(arrayProducts.getId(), arrayProducts.getQuantity(),
                            product.getPrice().multiply(BigDecimal.valueOf(arrayProducts.getQuantity()),mathContext));
                }).collect(Collectors.toList());
        return new CalculatedCart(calculatedArrayProducts,calculate(calculatedArrayProducts));
    }

    private BigDecimal calculate(List<CalculatedArrayProducts> calculatedArrayProducts){
        return calculatedArrayProducts.stream()
                .map(CalculatedArrayProducts::getSubtotal)
                .reduce(BigDecimal.ZERO,(productOne, productTwo) -> productOne.add(productTwo,mathContext));
    }
}
