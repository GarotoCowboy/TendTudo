package br.com.tendtudo.tendtudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class User extends People {

    @ManyToMany
    @JoinTable(name ="user_favorite_products",
                joinColumns = @JoinColumn(name = "user_fk"),
                 inverseJoinColumns = @JoinColumn(name = "product_fk"))
    private List<Products> favoriteProduct;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",referencedColumnName = "cart_id")
    private Cart cart;

}
