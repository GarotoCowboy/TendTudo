package br.com.tendtudo.tendtudo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeople;

    @Column(unique = true)
    private String username;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private Long cpf;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private String phone;

    //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "people",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses;
}
