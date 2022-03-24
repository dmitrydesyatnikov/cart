package com.shopping.cart.dto.cart;

import lombok.*;

import java.math.BigDecimal;

/**
 * Класс объекта продукт - для выявления по id стоимость товаров
 *
 * @author Десятников Дмитрий
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Product {

    private Integer id;
    private BigDecimal price;
}
