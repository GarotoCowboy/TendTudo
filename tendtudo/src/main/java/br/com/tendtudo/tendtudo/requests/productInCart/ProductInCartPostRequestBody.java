package br.com.tendtudo.tendtudo.requests.productInCart;

import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Products;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductInCartPostRequestBody {

    private int quantity;

    //private Long cartId;

    private Long userId;

    private String productName;

    private Long productsId;
}
