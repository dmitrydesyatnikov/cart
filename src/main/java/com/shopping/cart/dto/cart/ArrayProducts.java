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
public class ArrayProducts {
    /**
     * Поле со значением - id товара
     */
    private Integer id;

    /**
     * Поле со значением - количество товаров
     */
    private Integer quantity;
}
