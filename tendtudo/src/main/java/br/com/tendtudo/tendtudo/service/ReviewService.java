package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.controller.Dto.cart.CartDto;
import br.com.tendtudo.tendtudo.controller.Dto.review.ReviewDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Review;
import br.com.tendtudo.tendtudo.requests.cart.CartPostRequestBody;
import br.com.tendtudo.tendtudo.requests.cart.CartPutRequestBody;
import br.com.tendtudo.tendtudo.requests.review.ReviewPostRequestBody;
import br.com.tendtudo.tendtudo.requests.review.ReviewPutRequestBody;

import java.util.List;

public interface ReviewService {

    Review findById(Long reviewId);

    List<Review> findAll();

    Review save(ReviewPostRequestBody reviewPostRequestBody);

    Cart replace(ReviewPutRequestBody reviewPutRequestBody);

    void delete(ReviewDto reviewDto);
}
