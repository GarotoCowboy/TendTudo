package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.requests.PeoplePostRequestBody;
import br.com.tendtudo.tendtudo.requests.PeoplePutRequestBody;
import br.com.tendtudo.tendtudo.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/peoples")
@RequiredArgsConstructor
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public ResponseEntity<List<People>> findAll() {
        return new ResponseEntity<>(peopleService.findAll(),HttpStatus.OK);
    }

    @GetMapping(path = "{idPeople}")
    public ResponseEntity<People> findByUsername(@PathVariable Long idPeople) {
        return new ResponseEntity<>(peopleService.findById(idPeople), HttpStatus.FOUND);
    }

    @GetMapping("get/username/{username}")
    public ResponseEntity<People> findByUsername(@PathVariable String username) {
        return new ResponseEntity<>(peopleService.findByUsername(username), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<People> save(@RequestBody PeoplePostRequestBody people) {
        return new ResponseEntity<>(peopleService.save(people),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long idPeople) {
        peopleService.delete(idPeople);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<Void> replace(@RequestBody PeoplePutRequestBody peoplePutRequestBody) {
        peopleService.replace(peoplePutRequestBody);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
        //return new ResponseEntity<>(peopleService.replace(peoplePutRequestBody),HttpStatus.CREATED);
    }
}
