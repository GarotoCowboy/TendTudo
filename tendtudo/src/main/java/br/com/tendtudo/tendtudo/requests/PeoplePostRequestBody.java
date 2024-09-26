package br.com.tendtudo.tendtudo.requests;

import br.com.tendtudo.tendtudo.models.Cart;
import lombok.Data;

@Data
public class PeoplePostRequestBody {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long cpf;
    private String birthday;
    private String phone;
    //private AccountType accountType;
}
