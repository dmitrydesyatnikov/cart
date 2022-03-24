package com.shopping.cart.dto.cart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "массив товаров не может быть пустым")
    private final List<CartPosition> products;

    /**
     * Поле со значением - типа оплаты
     */
    @NotNull(message = "требуется указать тип оплаты, в будущем это может повлиять на расчёт")
    private final String payType;

    /**
     * Поле со значением - id адреса из адресной книги пользователя (если имеется)
     */
    private final Integer addressId;
}
