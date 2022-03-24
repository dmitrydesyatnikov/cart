package com.shopping.cart.dto.calculated;

import com.shopping.cart.dto.cart.CartPosition;
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
public class CalculatedCartPosition extends CartPosition {

    private final BigDecimal subtotal;

    public CalculatedCartPosition(Integer id, Integer quantity, BigDecimal subtotal) {
        super(id, quantity);
        this.subtotal = subtotal;
    }
}
