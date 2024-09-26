package br.com.tendtudo.tendtudo.requests.user;

import br.com.tendtudo.tendtudo.models.AccountType;
import lombok.Data;

@Data
public class UserPutRequestBody {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long cpf;
    private String birthday;
    private String phone;
    private AccountType accountType;
}
