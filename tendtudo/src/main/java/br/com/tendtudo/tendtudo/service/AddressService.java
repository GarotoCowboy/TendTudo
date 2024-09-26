package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.controller.Dto.address.AddressToPeopleDto;
import br.com.tendtudo.tendtudo.models.Address;
import br.com.tendtudo.tendtudo.models.People;
import br.com.tendtudo.tendtudo.requests.PeoplePostRequestBody;
import br.com.tendtudo.tendtudo.requests.address.AddressPostRequestBody;
import br.com.tendtudo.tendtudo.requests.address.AddressPutRequestBody;

import java.util.List;

public interface AddressService {

    List<Address> findAll();

    Address findById(Long idAddress);


    Address save(AddressPostRequestBody addressPostRequestBody);

    Address replace(AddressPutRequestBody AddressPuttRequestBody);

    void delete(Long addressId);

    Address addPeopleToAddress(AddressToPeopleDto addressToPeopleDto);

}
