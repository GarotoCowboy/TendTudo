package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.controller.Dto.cart.CartDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.repository.CartRepository;
import br.com.tendtudo.tendtudo.requests.cart.CartPostRequestBody;
import br.com.tendtudo.tendtudo.requests.cart.CartPutRequestBody;
import br.com.tendtudo.tendtudo.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Long idCart) {
        return cartRepository.findById(idCart)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"Cart not found"));
    }

    @Override
    public Cart findByUser(Long userId) {
        return cartRepository.findCartsByUserIdPeople(userId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"User not found"));
    }

    @Deprecated
    @Override
    @Transactional
    public Cart save(CartPostRequestBody cartPostRequestBody) {

        Cart cart = Cart.builder().allValue(cartPostRequestBody.getAllValue()).build();
        return cartRepository.save(cart);
    }

    @Override
    public Cart replace(CartPutRequestBody cartPutRequestBody) {
        return null;
    }

    @Override
    @Transactional
    public void delete(CartDto cartDto) {
        Cart cart = new Cart();
     cart = findById(cartDto.getCartId());
     cartRepository.delete(cart);

    }
}
