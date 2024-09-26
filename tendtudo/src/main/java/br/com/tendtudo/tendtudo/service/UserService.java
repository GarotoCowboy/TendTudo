package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.controller.Dto.user.UserFavoriteProductsDto;
import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.models.User;
import br.com.tendtudo.tendtudo.requests.PeoplePostRequestBody;
import br.com.tendtudo.tendtudo.requests.user.UserPostRequestBody;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    User findById(Long idPeople);

    User findByUsername(String username);

    User save(UserPostRequestBody userPostRequestBody);

    User replace(User user);


    void delete(Long userId);

    User addFavoriteProduct(UserFavoriteProductsDto userFavoriteProductsDto);
}
