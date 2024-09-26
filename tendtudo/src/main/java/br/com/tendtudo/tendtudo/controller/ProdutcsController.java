package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.requests.products.ProductsPostRequestBody;
import br.com.tendtudo.tendtudo.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produtcs")
@RequiredArgsConstructor
public class ProdutcsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/get/category/{category}")
    public ResponseEntity<List<Products>> findByCategory(@PathVariable String category) {
        return new ResponseEntity<>(productsService.findByCategory(category), HttpStatus.OK);
    }

    @GetMapping("get/name/{name}")
    public ResponseEntity<List<Products>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(productsService.findByName(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Products>> findAll(){
        return new ResponseEntity<>(productsService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("get/id/{productID}")
    public ResponseEntity<Products> findById(@PathVariable Long productID){
        return new ResponseEntity<>(productsService.findById(productID), HttpStatus.OK);
    }

    @GetMapping("get/value/{minValue}/{maxValue}")
    public ResponseEntity<List<Products>> findByValue(@PathVariable BigDecimal minValue,
                                                      @PathVariable BigDecimal maxValue){
        return new ResponseEntity<>(productsService.findByValue(minValue,maxValue), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Products> findByValue(@RequestBody ProductsPostRequestBody productsPostRequestBody){
        return new ResponseEntity<>(productsService.save(productsPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{productsId}")
    public ResponseEntity<Void> delete(@PathVariable Long productsId){
        productsService.delete(productsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
