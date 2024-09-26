package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.controller.Dto.address.AddressToPeopleDto;
import br.com.tendtudo.tendtudo.models.Address;
import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.repository.AddressRepository;
import br.com.tendtudo.tendtudo.repository.PeopleRepository;
import br.com.tendtudo.tendtudo.requests.address.AddressPostRequestBody;
import br.com.tendtudo.tendtudo.requests.address.AddressPutRequestBody;
import br.com.tendtudo.tendtudo.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long idAddress) {
        return addressRepository.findById(idAddress)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"Address not found"));
    }

    @Override
    public Address save(AddressPostRequestBody addressPostRequestBody) {
        Address address = Address.builder()
                .cep(addressPostRequestBody.getCep())
                .city(addressPostRequestBody.getCity())
                .state(addressPostRequestBody.getState())
                .complement(addressPostRequestBody.getComplement())
                .street(addressPostRequestBody.getStreet())
                .build();

        return addressRepository.save(address);
    }

    @Override
    public Address replace(AddressPutRequestBody AddressPuttRequestBody) {
        return null;
    }

    @Override
    public void delete(Long addressId) {
        Address address = findById(addressId);
        addressRepository.delete(address);
    }

    @Override
    public Address addPeopleToAddress(AddressToPeopleDto addressToPeopleDto) {
        Address address = addressRepository.findById(addressToPeopleDto.getIdAddress())
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"Address Not found"));
        People people = peopleRepository.findById(addressToPeopleDto.getIdPeople())
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"People not Found"));

        address.setPeople(people);

        return addressRepository.save(address);
    }


}
