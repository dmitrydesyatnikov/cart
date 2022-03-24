package com.shopping.cart.arguments;

import com.shopping.cart.dto.calculated.CalculatedCart;
import com.shopping.cart.dto.calculated.CalculatedCartPosition;
import com.shopping.cart.dto.cart.Cart;
import com.shopping.cart.dto.cart.CartPosition;
import com.shopping.cart.dto.cart.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.jupiter.params.provider.Arguments;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CartServiceTestArgumentCreator {

    private static final String DEFAULT_PAYMENT_TYPE = "CARD";
    private static final Integer DEFAULT_ADDRESS_ID = 1;

    private static final CartPosition FIRST_POSITION = new CartPosition(1, 1);
    private static final CartPosition SECOND_POSITION = new CartPosition(2, 2);
    private static final CartPosition THIRD_POSITION = new CartPosition(3, 4);

    private static final Product FIRST_PRODUCT = new Product(FIRST_POSITION.getId(), BigDecimal.valueOf(330d));
    private static final Product SECOND_PRODUCT = new Product(SECOND_POSITION.getId(), BigDecimal.valueOf(154d));
    private static final Product THIRD_PRODUCT = new Product(THIRD_POSITION.getId(), BigDecimal.valueOf(737d));

    private static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);

    public static Stream<Arguments> generateGetCalculatedCartTestArguments() {
        return Stream.of(
                Arguments.of(
                        new Cart(List.of(FIRST_POSITION, SECOND_POSITION), DEFAULT_PAYMENT_TYPE, DEFAULT_ADDRESS_ID),
                        List.of(FIRST_PRODUCT, SECOND_PRODUCT, THIRD_PRODUCT),
                        new CalculatedCart(
                                List.of(
                                        new CalculatedCartPosition(FIRST_POSITION.getId(), FIRST_POSITION.getQuantity(), FIRST_PRODUCT.getPrice().multiply(BigDecimal.valueOf(1), MATH_CONTEXT)),
                                        new CalculatedCartPosition(SECOND_POSITION.getId(), SECOND_POSITION.getQuantity(), SECOND_PRODUCT.getPrice().multiply(BigDecimal.valueOf(2), MATH_CONTEXT))
                                ),
                                BigDecimal.valueOf(638).multiply(BigDecimal.valueOf(1), MATH_CONTEXT)
                        )
                ),
                Arguments.of(
                        new Cart(List.of(FIRST_POSITION), DEFAULT_PAYMENT_TYPE, DEFAULT_ADDRESS_ID),
                        List.of(FIRST_PRODUCT, SECOND_PRODUCT, THIRD_PRODUCT),
                        new CalculatedCart(
                                List.of(
                                        new CalculatedCartPosition(FIRST_POSITION.getId(), FIRST_POSITION.getQuantity(), FIRST_PRODUCT.getPrice().multiply(BigDecimal.valueOf(1), MATH_CONTEXT))
                                ),
                                BigDecimal.valueOf(330).multiply(BigDecimal.valueOf(1), MATH_CONTEXT)
                        )
                )
        );
    }
}
