package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.controller.Dto.cart.CartDto;
import br.com.tendtudo.tendtudo.controller.Dto.review.ReviewDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Review;
import br.com.tendtudo.tendtudo.requests.cart.CartPostRequestBody;
import br.com.tendtudo.tendtudo.requests.review.ReviewPostRequestBody;
import br.com.tendtudo.tendtudo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    private ResponseEntity<List<Review>> findAll(){
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("get/{reviewId}")
    private ResponseEntity<Review> findById(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.findById(reviewId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Review> findById(@RequestBody ReviewPostRequestBody reviewPostRequestBody){
        return new ResponseEntity<>(reviewService.save(reviewPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping
    private ResponseEntity<Void> delete(@RequestBody ReviewDto review){
        reviewService.delete(review);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
