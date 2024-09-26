package br.com.tendtudo.tendtudo.requests.review;

import br.com.tendtudo.tendtudo.models.enums.Rate;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
@Data
public class ReviewPostRequestBody {

    private String comment;
   // private String author;
    private Date date;
    private String imageAddress;
    private Rate rate;
    private Long userId;
    private Long productsId;

}
