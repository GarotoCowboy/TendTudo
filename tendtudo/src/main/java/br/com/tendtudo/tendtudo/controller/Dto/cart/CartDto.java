package br.com.tendtudo.tendtudo.controller.Dto.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDto {

    private Long cartId;

    private BigDecimal allValue;
}
