package br.com.tendtudo.tendtudo.requests.address;

import lombok.Data;

@Data
public class AddressPutRequestBody {

    private Long addressId;

    private Long cep;

    private String city;

    private String state;

    private String complement;

    private String street;
}
