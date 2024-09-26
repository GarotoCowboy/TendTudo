package br.com.tendtudo.tendtudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    private BigDecimal allValue;

    @OneToMany(mappedBy = "carts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductInCart> carts;

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_user")
    @JsonIgnore
    private User user;
}
