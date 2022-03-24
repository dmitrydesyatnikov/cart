package com.shopping.cart.dto.calculatedCart;

import com.shopping.cart.dto.cart.ArrayProducts;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Класс объекта рассчитанный массив товаров
 *
 * @author Десятников Дмитрий
 * @version 1.0
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class CalculatedArrayProducts extends ArrayProducts {
    private BigDecimal subtotal;

    public CalculatedArrayProducts(Integer id, Integer quantity, BigDecimal subtotal) {
        super(id, quantity);
        this.subtotal = subtotal;
    }
}
