package br.com.tendtudo.tendtudo.requests.productInCart;

import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Products;
import lombok.Data;

@Data
public class ProductInCartPutRequestBody {

    private Long productInCartId;

    private int quantity;

    private Long cartId;

    private Long productsId;
}
