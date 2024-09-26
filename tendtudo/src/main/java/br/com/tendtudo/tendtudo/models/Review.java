package br.com.tendtudo.tendtudo.models;

import br.com.tendtudo.tendtudo.models.enums.Rate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String comment;
    private String author;
    private Date date;
    private String imageAddress;

    @Enumerated(EnumType.ORDINAL)
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "user_fk", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "products_fk", nullable = false)
    @JsonIgnore
    private Products products;

}
