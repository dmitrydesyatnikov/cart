package com.shopping.cart.service;

import com.shopping.cart.cache.ProductCache;
import com.shopping.cart.dto.calculated.CalculatedCart;
import com.shopping.cart.dto.cart.Cart;
import com.shopping.cart.dto.cart.Product;
import com.shopping.cart.service.impl.CartServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private ProductCache productCache;

    @InjectMocks
    private CartServiceImpl cartService;

    @ParameterizedTest
    @MethodSource("com.shopping.cart.arguments.CartServiceTestArgumentCreator#generateGetCalculatedCartTestArguments")
    void getCalculatedCartTest(Cart cart, Collection<Product> products, CalculatedCart expectedCalculatedCart) {
        when(productCache.getProductById(anyInt())).thenAnswer(
                (Answer<Optional<Product>>) invocationOnMock -> findProductById(products, invocationOnMock.getArgument(0)));

        CalculatedCart actualCalculatedCart = cartService.getCalculatedCart(cart);
        assertEquals(expectedCalculatedCart, actualCalculatedCart);
    }

    private Optional<Product> findProductById(Collection<Product> products, Integer id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
