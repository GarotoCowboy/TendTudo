package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.controller.Dto.user.UserFavoriteProductsDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.models.User;
import br.com.tendtudo.tendtudo.repository.ProductsRepository;
import br.com.tendtudo.tendtudo.repository.UserRepository;
import br.com.tendtudo.tendtudo.requests.user.UserPostRequestBody;
import br.com.tendtudo.tendtudo.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor
@Data
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long idPeople) {
        return userRepository.findById(idPeople)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "User not found"));
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User save(UserPostRequestBody userPostRequestBody) {

        User user = User.builder()
                .name(userPostRequestBody.getName())
                .surname(userPostRequestBody.getSurname())
                .email(userPostRequestBody.getEmail())
                .cpf(userPostRequestBody.getCpf())
                .phone(userPostRequestBody.getPhone())
                .birthday(userPostRequestBody.getBirthday())
                .username(userPostRequestBody.getUsername())
                .password(userPostRequestBody.getPassword())
                .accountType(userPostRequestBody.getAccountType())
                .cart(new Cart())
                .build();


        return userRepository.save(user);
    }

    @Override
    public User replace(User user) {
        return null;
    }

    @Override
    public void delete(Long userId) {
    userRepository.deleteById(userId);
    }

    @Override
    public User addFavoriteProduct(UserFavoriteProductsDto userFavoriteProductsDto) {

        Optional<User> userOptional = userRepository.findById(userFavoriteProductsDto.getUserId());
        Optional<Products> productsOptional = productsRepository.findById(userFavoriteProductsDto.getProductId());

        if (userOptional.isPresent() && productsOptional.isPresent()) {
            User user = userOptional.get();
            Products products = productsOptional.get();

            List<Products>  favoriteProducts = user.getFavoriteProduct();
            if(!favoriteProducts.contains(products)) {
                favoriteProducts.add(products);
            }
            userRepository.save(user);

            return user;
        }
        throw new ResponseStatusException(BAD_REQUEST, "User or Product not found");
    }

}
