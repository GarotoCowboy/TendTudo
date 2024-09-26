package br.com.tendtudo.tendtudo.requests;

import lombok.Data;

import java.util.Calendar;

@Data
public class PeoplePutRequestBody {
    private Long idPeople;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long cpf;
    private Calendar birthday;
    private String phone;
    //private AccountType accountType;
}
