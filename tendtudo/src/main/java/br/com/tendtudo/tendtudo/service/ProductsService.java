package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.requests.products.ProductsPostRequestBody;
import br.com.tendtudo.tendtudo.requests.products.ProductsPutRequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface ProductsService {
    Products save(ProductsPostRequestBody productsPostRequestBody);

    void replace(ProductsPutRequestBody productsPutRequestBody);

    void delete(Long productsId);

    List<Products> findAllProducts();
    List<Products> findByName(String productName);
    Products findById(Long productID);
    List<Products> findByCategory(String category);
    List<Products> findByValue(BigDecimal minValue, BigDecimal maxValue);
}
