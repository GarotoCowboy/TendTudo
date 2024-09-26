package br.com.tendtudo.tendtudo.requests.review;

import br.com.tendtudo.tendtudo.models.enums.Rate;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewPutRequestBody {

    private Long reviewId;

    private String comment;
    private String author;
    private Date date;
    private String imageAddress;

    private Rate rate;

}
