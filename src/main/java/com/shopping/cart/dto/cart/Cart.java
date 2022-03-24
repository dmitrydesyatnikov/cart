package com.shopping.cart.dto.cart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.List;
/**
 * Класс объекта - корзина
 *
 * @author Десятников Дмитрий
 * @version 1.0
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Cart {
    /**
     * Поле со значениями массива товаров
     */
    private List<ArrayProducts> products;

    /**
     * Поле со значением - типа оплаты
     */
    private String payType;

    /**
     * Поле со значением - id адреса из адресной книги пользователя (если имеется)
     */
    private Integer addressId;
}
