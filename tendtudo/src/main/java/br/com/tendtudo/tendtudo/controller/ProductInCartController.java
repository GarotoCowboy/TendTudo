package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.controller.Dto.productInCartDto.DeleteProductRequest;
import br.com.tendtudo.tendtudo.controller.Dto.productInCartDto.ProductsInCartSetQuantityDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.ProductInCart;
import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.requests.productInCart.ProductInCartPostRequestBody;
import br.com.tendtudo.tendtudo.service.ProductInCartService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item/in/cart")
@RequiredArgsConstructor
public class ProductInCartController {

    private final ProductInCartService productInCartService;

    @GetMapping
    public ResponseEntity<List<ProductInCart>> findAll(){
        return new ResponseEntity<>(productInCartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("get/{productInCartId}")
    public ResponseEntity<ProductInCart> findById(@PathVariable Long productInCartId){
        return new ResponseEntity<>(productInCartService.findById(productInCartId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductInCart> save(@RequestBody ProductInCartPostRequestBody productInCartPostRequestBody){
        return new ResponseEntity<>(productInCartService.save(productInCartPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{productInCartId}")
    public ResponseEntity<Void> delete(@PathVariable Long productInCartId){
        productInCartService.delete(productInCartId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<ProductInCart> changeItemQuantity(@RequestBody ProductsInCartSetQuantityDto productsInCartSetQuantityDto){
        return new ResponseEntity<>(productInCartService.changeQuantityItemFromCart(productsInCartSetQuantityDto),
                                    HttpStatus.OK);
    }

}
