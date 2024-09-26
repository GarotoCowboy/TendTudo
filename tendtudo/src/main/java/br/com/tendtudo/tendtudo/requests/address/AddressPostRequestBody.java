package br.com.tendtudo.tendtudo.requests.address;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddressPostRequestBody {

    private Long cep;

    private String city;

    private String state;

    private String complement;

    private String street;
}
