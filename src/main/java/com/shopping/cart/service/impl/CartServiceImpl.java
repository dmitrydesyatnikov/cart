package com.shopping.cart.service.impl;

import com.shopping.cart.dto.calculated.CalculatedCartPosition;
import com.shopping.cart.dto.calculated.CalculatedCart;
import com.shopping.cart.dto.cart.CartPosition;
import com.shopping.cart.dto.cart.Cart;
import com.shopping.cart.dto.cart.Product;
import com.shopping.cart.cache.ProductCache;
import com.shopping.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class CartServiceImpl implements CartService {

    private final ProductCache productCache;

    private final MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);

    public CartServiceImpl(ProductCache productCache) {
        this.productCache = productCache;
    }

    /**
     * Метод расчёта корзины
     *
     */
    @Override
    public CalculatedCart getCalculatedCart(Cart cart) {
        List<CalculatedCartPosition> calculatedArrayProducts = cart.getProducts().stream()
                .map(this::calculateCartPositions)
                .collect(Collectors.toList());
        return new CalculatedCart(calculatedArrayProducts, calculate(calculatedArrayProducts));
    }

    private CalculatedCartPosition calculateCartPositions(CartPosition cartPosition) {
        Product product = productCache.getProductById(cartPosition.getId())
                .orElse(new Product(cartPosition.getId(), BigDecimal.ZERO));
        return new CalculatedCartPosition(cartPosition.getId(), cartPosition.getQuantity(),
                product.getPrice().multiply(BigDecimal.valueOf(cartPosition.getQuantity()), mathContext));
    }

    private BigDecimal calculate(List<CalculatedCartPosition> calculatedCartPositions){
        return calculatedCartPositions.stream()
                .map(CalculatedCartPosition::getSubtotal)
                .reduce(BigDecimal.ZERO, (productOne, productTwo) -> productOne.add(productTwo, mathContext));
    }
}
