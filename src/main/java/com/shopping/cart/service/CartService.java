package com.shopping.cart.service;

import com.shopping.cart.dto.calculated.CalculatedCart;
import com.shopping.cart.dto.cart.Cart;

public interface CartService {

    CalculatedCart getCalculatedCart(Cart cart);
}
