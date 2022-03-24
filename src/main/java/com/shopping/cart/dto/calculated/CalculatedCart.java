package com.shopping.cart.dto.calculated;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * Класс объекта расчитанная корзина
 *
 * @author Десятников Дмитрий
 * @version 1.0
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class CalculatedCart {

    /**
     * Поле со значениями - рассчитанного массива товаров
     */
    private final List<CalculatedCartPosition> products;

    /**
     * Поле со значением - общая сумма
     */
    private final BigDecimal totalSum ;

}
