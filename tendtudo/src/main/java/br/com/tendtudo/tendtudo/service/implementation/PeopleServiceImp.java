package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.repository.PeopleRepository;
import br.com.tendtudo.tendtudo.requests.PeoplePostRequestBody;
import br.com.tendtudo.tendtudo.requests.PeoplePutRequestBody;
import br.com.tendtudo.tendtudo.service.PeopleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeopleServiceImp implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;


    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public People findById(Long idPeople) {
        return peopleRepository.findById(idPeople)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "People with id %d not found"));
    }

    @Override
    public People findByUsername(String username) {
        return peopleRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "People with username %d not found"));
    }

    @Override
    @Transactional
    public People save(PeoplePostRequestBody peoplePostRequestBody) {
        People people = People.builder()
                .username(peoplePostRequestBody.getUsername())
                .cpf(peoplePostRequestBody.getCpf())
                .email(peoplePostRequestBody.getEmail())
                .phone(peoplePostRequestBody.getPhone())
                .name(peoplePostRequestBody.getName())
                .surname(peoplePostRequestBody.getSurname())
                .birthday(peoplePostRequestBody.getBirthday())
                .password(peoplePostRequestBody.getPassword()).build();
        //.accountType(peoplePostRequestBody.getAccountType()).build();

        return peopleRepository.save(people);
    }

    @Override
    @Transactional
    public void replace(PeoplePutRequestBody peoplePutRequestBody) {

       peopleRepository.findById(peoplePutRequestBody.getIdPeople())
                .ifPresent(people1 -> {
                    people1.setUsername(peoplePutRequestBody.getUsername());
                    people1.setCpf(peoplePutRequestBody.getCpf());
                    people1.setEmail(peoplePutRequestBody.getEmail());
                    people1.setPhone(peoplePutRequestBody.getPhone());
                    people1.setName(peoplePutRequestBody.getName());
                    people1.setSurname(peoplePutRequestBody.getSurname());
                    people1.setPassword(peoplePutRequestBody.getPassword());
                    peopleRepository.save(people1);
                });


        //return peopleRepository.save(newPeople);
    }

    @Override
    public void delete(Long peopleId) {
        peopleRepository.deleteById(peopleId);
    }


}

