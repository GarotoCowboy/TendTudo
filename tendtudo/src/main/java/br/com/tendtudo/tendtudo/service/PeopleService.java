package br.com.tendtudo.tendtudo.service;


import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.requests.PeoplePostRequestBody;
import br.com.tendtudo.tendtudo.requests.PeoplePutRequestBody;

import java.util.List;

public interface PeopleService {

    List<People> findAll();

    People findById(Long idPeople);

    People findByUsername(String username);

    People save(PeoplePostRequestBody peoplePostRequestBody);

    void replace(PeoplePutRequestBody peoplePutRequestBody);


    void delete(Long peopleId);

}
