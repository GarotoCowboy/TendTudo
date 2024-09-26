package br.com.tendtudo.tendtudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String type;

    @Column(nullable = false, length = 10)
    private String size;

    @Column(nullable = false, length = 20)
    private String color;

    @Column(nullable = false, length = 1000)
    private String image;

    @Column(nullable = false, length = 20)
    private String producer;

    @Column(nullable = false, length = 20)
    private String category;

    @Column(nullable = false, length = 20)
    private String subCategory;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private int amount;

    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductInCart> products;

    @ManyToMany(mappedBy = "favoriteProduct")
    @JsonIgnore
    private List<User> userList;

    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviewList;
}
