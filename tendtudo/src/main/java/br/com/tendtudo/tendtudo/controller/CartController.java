package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.controller.Dto.cart.CartDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.requests.cart.CartPostRequestBody;
import br.com.tendtudo.tendtudo.service.CartService;
import br.com.tendtudo.tendtudo.service.implementation.CartServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartServiceImp cartService;

    @GetMapping
    private ResponseEntity<List<Cart>> findAll(){
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("get/{cartId}")
    private ResponseEntity<Cart> findById(@PathVariable Long cartId){
        return new ResponseEntity<>(cartService.findById(cartId), HttpStatus.OK);
    }

    @GetMapping("get/user/{userId}/cart")
    private ResponseEntity<Cart> findByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(cartService.findByUser(userId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Cart> findById(@RequestBody CartPostRequestBody cartPostRequestBody){
        return new ResponseEntity<>(cartService.save(cartPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping
    private ResponseEntity<Void> delete(@RequestBody CartDto cart){
        cartService.delete(cart);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
