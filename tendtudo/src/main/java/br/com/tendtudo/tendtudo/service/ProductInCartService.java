package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.controller.Dto.productInCartDto.ProductsInCartSetQuantityDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.ProductInCart;
import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.requests.productInCart.ProductInCartPostRequestBody;
import br.com.tendtudo.tendtudo.requests.productInCart.ProductInCartPutRequestBody;

import java.util.List;

public interface ProductInCartService {

    List<ProductInCart> findAll();

    ProductInCart findById(Long ProductInCartId);

    ProductInCart save(ProductInCartPostRequestBody productInCartPostRequestBody);

    ProductInCart replace(ProductInCartPutRequestBody productInCartPutRequestBody);


    void delete(Long productInCartId);

   ProductInCart changeQuantityItemFromCart(ProductsInCartSetQuantityDto productsInCartSetQuantityDto);
}
