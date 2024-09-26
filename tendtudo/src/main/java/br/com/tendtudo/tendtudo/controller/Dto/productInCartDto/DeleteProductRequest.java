package br.com.tendtudo.tendtudo.controller.Dto.productInCartDto;

import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Products;
import lombok.Data;

@Data
public class DeleteProductRequest {

    private Cart cart;
    private Products products;
}
