package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.controller.Dto.review.ReviewDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.models.Review;
import br.com.tendtudo.tendtudo.models.User;
import br.com.tendtudo.tendtudo.repository.ProductsRepository;
import br.com.tendtudo.tendtudo.repository.ReviewRepository;
import br.com.tendtudo.tendtudo.repository.UserRepository;
import br.com.tendtudo.tendtudo.requests.review.ReviewPostRequestBody;
import br.com.tendtudo.tendtudo.requests.review.ReviewPutRequestBody;
import br.com.tendtudo.tendtudo.service.ProductsService;
import br.com.tendtudo.tendtudo.service.ReviewService;
import br.com.tendtudo.tendtudo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductsService productsService;


    @Override
    public Review findById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"REVIEW NOT FOUND"));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
//ta salvando com -1 os enums
    //resolver
    @Override
    public Review save(ReviewPostRequestBody reviewPostRequestBody) {

       User user = userService.findById(reviewPostRequestBody.getUserId());
       Products products = productsService.findById(reviewPostRequestBody.getProductsId());



       Review newReview = Review.builder()
               .date(reviewPostRequestBody.getDate())
               .rate(reviewPostRequestBody.getRate())
               .author(user.getName())
               .user(user)
               .products(products)
               .imageAddress(reviewPostRequestBody.getImageAddress())
               .comment(reviewPostRequestBody.getComment())
               .build();

            return reviewRepository.save(newReview);



    }

    @Override
    public Cart replace(ReviewPutRequestBody reviewPutRequestBody) {
        return null;
    }

    @Override
    public void delete(ReviewDto reviewDto) {
        reviewRepository.deleteById(reviewDto.getReviewId());
    }


}
