package br.com.tendtudo.tendtudo.requests.user;

import br.com.tendtudo.tendtudo.models.AccountType;
import br.com.tendtudo.tendtudo.models.Cart;
import lombok.Data;

@Data
public class UserPostRequestBody {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long cpf;
    private String birthday;
    private String phone;
    private AccountType accountType;
    //private Cart cart;
}
