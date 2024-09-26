package br.com.tendtudo.tendtudo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long demandId;

    private Date date;

    private boolean paid;

   @ManyToMany
    @JoinTable(name ="demanded_products",
            joinColumns = @JoinColumn(name = "order_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_in_cart_fk"))
    private List<ProductInCart> productInCart;
}
