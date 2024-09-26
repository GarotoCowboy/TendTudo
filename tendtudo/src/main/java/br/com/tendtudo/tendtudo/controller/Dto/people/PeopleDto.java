package br.com.tendtudo.tendtudo.controller.Dto.people;

import lombok.Data;

import java.util.Calendar;

@Data
public class PeopleDto {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Long cpf;
    private Calendar birthday;
    private String phone;
}
