package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.repository.ProductsRepository;
import br.com.tendtudo.tendtudo.requests.products.ProductsPostRequestBody;
import br.com.tendtudo.tendtudo.requests.products.ProductsPutRequestBody;
import br.com.tendtudo.tendtudo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ProductsServiceImp implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products save(ProductsPostRequestBody productsPostRequestBody) {

        Products products = Products.builder()
                .name(productsPostRequestBody.getName())
                .description(productsPostRequestBody.getDescription())
                .color(productsPostRequestBody.getColor())
                .size(productsPostRequestBody.getSize())
                .category(productsPostRequestBody.getCategory())
                .subCategory(productsPostRequestBody.getSubCategory())
                .producer(productsPostRequestBody.getProducer())
                .value(productsPostRequestBody.getValue())
                .amount(productsPostRequestBody.getAmount())
                .type(productsPostRequestBody.getType())
                .image(productsPostRequestBody.getImage())
                .build();

        return productsRepository.save(products);
    }

    @Override
    public void replace(ProductsPutRequestBody productsPutRequestBody) {

    }

    @Override
    public void delete(Long productsId) {
        productsRepository.deleteById(productsId);
    }

    @Override
    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findByName(String productName) {
        return productsRepository.findByName(productName);
    }

    @Override
    public Products findById(Long productID) {
        return productsRepository.findById(productID)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Product not found"));
    }

    @Override
    public List<Products> findByCategory(String category) {
        return productsRepository.findByCategory(category);
    }

    @Override
    public List<Products> findByValue(BigDecimal maxValue, BigDecimal minValue) {
        return productsRepository.findByAmountBetween(maxValue, minValue);
    }
}
