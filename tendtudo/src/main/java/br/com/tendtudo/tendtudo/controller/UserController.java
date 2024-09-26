package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.controller.Dto.user.UserFavoriteProductsDto;
import br.com.tendtudo.tendtudo.models.AccountType;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.User;
import br.com.tendtudo.tendtudo.requests.user.UserPostRequestBody;
import br.com.tendtudo.tendtudo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody UserPostRequestBody userPostRequestBody) {
        userPostRequestBody.setAccountType(AccountType.USER);


        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add/favorite")
    private ResponseEntity<User> addFavoriteProduct(@RequestBody UserFavoriteProductsDto userFavoriteProductsDto) {
        return new ResponseEntity<>(userService.addFavoriteProduct(userFavoriteProductsDto), HttpStatus.CREATED);
    }
}
