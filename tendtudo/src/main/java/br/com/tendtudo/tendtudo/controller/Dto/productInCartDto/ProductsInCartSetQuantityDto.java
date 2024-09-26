package br.com.tendtudo.tendtudo.controller.Dto.productInCartDto;

import lombok.Data;

@Data
public class ProductsInCartSetQuantityDto {

    private Long ProductsInCartId;
    private Integer quantity;
}
