package br.com.tendtudo.tendtudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productInCartId;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private Cart carts;

    @ManyToOne
    @JoinColumn(name = "produtcs_id", nullable = false)
    @JsonIgnore
    private Products products;

    private String productName;

   @ManyToMany(mappedBy = "productInCart")
    @JsonIgnore
    private List<Demand> orders;

}
