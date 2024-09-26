package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.controller.Dto.cart.CartDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.requests.PeoplePostRequestBody;
import br.com.tendtudo.tendtudo.requests.cart.CartPostRequestBody;
import br.com.tendtudo.tendtudo.requests.cart.CartPutRequestBody;

import java.util.List;

public interface CartService {

    List<Cart> findAll();

    Cart findById(Long idCart);

    Cart save(CartPostRequestBody cartPostRequestBody);

    Cart replace(CartPutRequestBody cartPutRequestBody);

    void delete(CartDto cartDto);

    Cart findByUser(Long userId);
}
