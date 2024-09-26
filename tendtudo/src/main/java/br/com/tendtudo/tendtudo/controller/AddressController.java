package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.controller.Dto.address.AddressToPeopleDto;
import br.com.tendtudo.tendtudo.models.Address;
import br.com.tendtudo.tendtudo.requests.address.AddressPostRequestBody;
import br.com.tendtudo.tendtudo.service.implementation.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressServiceImp addressServiceImp;

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        return ResponseEntity.ok(addressServiceImp.findAll());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> findById(@PathVariable Long addressId){
        return ResponseEntity.ok(addressServiceImp.findById(addressId));
    }

    @PostMapping()
    public ResponseEntity<Address> save(@RequestBody AddressPostRequestBody addressPostRequestBody){
        return new ResponseEntity<>(addressServiceImp.save(addressPostRequestBody),HttpStatus.CREATED);
    }

    @PutMapping("add/people/to/address")
    public ResponseEntity<Address> addPeopleToAddress(@RequestBody AddressToPeopleDto addressToPeopleDto){
        return new ResponseEntity<>(addressServiceImp.addPeopleToAddress(addressToPeopleDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable Long addressId){
        addressServiceImp.delete(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
