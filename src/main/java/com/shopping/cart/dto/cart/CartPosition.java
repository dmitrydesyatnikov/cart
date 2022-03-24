package com.shopping.cart.dto.cart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Класс объекта массив товаров
 *
 * @author Десятников Дмитрий
 * @version 1.0
 */

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class CartPosition {

    /**
     * Поле со значением - id товара
     */
    private final Integer id;

    /**
     * Поле со значением - количество товаров
     */
    private final Integer quantity;
}
