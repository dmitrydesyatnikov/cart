package com.shopping.cart.serviceInterface;

import com.shopping.cart.dto.calculatedCart.CalculatedCart;
import com.shopping.cart.dto.cart.Cart;

public interface CartServiceInterface {
    CalculatedCart calculatedCart(Cart cart);
}
