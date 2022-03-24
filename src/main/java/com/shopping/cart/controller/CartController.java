package com.shopping.cart.controller;

import com.shopping.cart.constants.ShoppingMapConstants;
import com.shopping.cart.dto.calculated.CalculatedCart;
import com.shopping.cart.dto.cart.Cart;
import com.shopping.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с корзиной товаров
 *
 * @author Десятников Дмитрий
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class CartController {

    /**
     * Сервис, содержащий методы для работы с вычислением корзины товаров
     */
    private final CartService cartService;

    /**
     * Метод получения корзины товаров для дальнейшего расчёта
     *
     * @param cart это параметр с данными корзины товаров для дальнейшего расчёта
     * @return рассчитанная корзина товаров
     */
    @PostMapping(value = ShoppingMapConstants.CALCULATE_CART)
    public CalculatedCart getCalculatedCart(@RequestBody Cart cart){
        return cartService.getCalculatedCart(cart);
    }
}
