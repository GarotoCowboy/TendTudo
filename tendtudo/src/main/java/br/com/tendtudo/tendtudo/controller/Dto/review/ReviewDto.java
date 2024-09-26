package br.com.tendtudo.tendtudo.controller.Dto.review;

import br.com.tendtudo.tendtudo.models.enums.Rate;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {

    private Long reviewId;

    private String comment;
    private String author;
    private Date date;
    private String imageAddress;

    private Rate rate;
}
