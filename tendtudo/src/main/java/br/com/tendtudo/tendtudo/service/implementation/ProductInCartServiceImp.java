package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.controller.Dto.productInCartDto.ProductsInCartSetQuantityDto;
import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.ProductInCart;
import br.com.tendtudo.tendtudo.models.Products;
import br.com.tendtudo.tendtudo.models.User;
import br.com.tendtudo.tendtudo.repository.CartRepository;
import br.com.tendtudo.tendtudo.repository.ProductInCartRepository;
import br.com.tendtudo.tendtudo.repository.ProductsRepository;
import br.com.tendtudo.tendtudo.requests.productInCart.ProductInCartPostRequestBody;
import br.com.tendtudo.tendtudo.requests.productInCart.ProductInCartPutRequestBody;
import br.com.tendtudo.tendtudo.service.ProductInCartService;
import br.com.tendtudo.tendtudo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Service
public class ProductInCartServiceImp implements ProductInCartService {

    @Autowired
    private ProductInCartRepository productInCartRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;

    public List<ProductInCart> findAll(){
        return productInCartRepository.findAll();
    }

    @Override
    public ProductInCart findById(Long productInCartId) {
        return productInCartRepository.findById(productInCartId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"ProductInCartId not Found"));
    }

    @Override
    public ProductInCart save(ProductInCartPostRequestBody productInCartPostRequestBody) {

        Optional<Products> productOptional = productsRepository.findById(productInCartPostRequestBody.getProductsId());
        Optional<User> userOptional = Optional.ofNullable(userService.findById(productInCartPostRequestBody.getUserId()));
        Optional<Cart> cartOptional = cartRepository.findById(userOptional.get().getCart().getCartId());



        if(productOptional.isPresent() && cartOptional.isPresent()){
            Products item = productOptional.get();
            Cart cart = cartOptional.get();

            if(cart.getAllValue() == null){
                cart.setAllValue(BigDecimal.ZERO);
            }

            ProductInCart productInCart = new ProductInCart();

            if(productInCartPostRequestBody.getQuantity() > 0){
                cart.setAllValue(cart.getAllValue().add(item.getValue()
                        .multiply(new BigDecimal(productInCartPostRequestBody.getQuantity()))
                        .setScale(2, RoundingMode.HALF_UP)));
            }else {
                throw new IllegalArgumentException("quantity cannot be less than 1 ");
            }

            productInCart.setProducts(item);
            productInCart.setCarts(cart);
            productInCart.setQuantity(productInCartPostRequestBody.getQuantity());
            productInCart.setProductName(productOptional.get().getName());
            return productInCartRepository.save(productInCart);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product or Cart not Found");
        }


    }

    @Override
    public ProductInCart replace(ProductInCartPutRequestBody productInCartPutRequestBody) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long productInCartId) {
       ProductInCart productInCart = findById(productInCartId);


       Cart cart = cartRepository.findById(productInCart.getCarts().getCartId()).
               orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"CartId not Found"));

       cart.setAllValue(cart.getAllValue().subtract(productInCart.getProducts().getValue()
               .multiply(new BigDecimal(productInCart.getQuantity()).setScale(2,RoundingMode.HALF_UP))));
       cartRepository.save(cart);
       productInCartRepository.delete(productInCart);
    }

/*esse metodo faz com que seja possivel alterar a quantidade de um determinado produto no carrinho
caso o valor seja maior que 0 ele alterará, caso seja igual a zero irá remover do carrinho e lançar um OK,
caso menor que zero irá lançar um badRequest.
 */
    @Transactional
    @Override
    public ProductInCart changeQuantityItemFromCart(ProductsInCartSetQuantityDto productsInCartSetQuantityDto) {

        ProductInCart productInCart = productInCartRepository.findById(productsInCartSetQuantityDto.getProductsInCartId())
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Product isn't in the cart"));

        Products products = productInCart.getProducts();
        Cart cart = productInCart.getCarts();

        int oldValue = productInCart.getQuantity();
        int newValue = productsInCartSetQuantityDto.getQuantity();

       // Cart cart = cartOptional.get();
       // ProductInCart productInCart = productInCartOptional.get();

        if(productsInCartSetQuantityDto.getQuantity() > 0){

            cart.setAllValue(cart.getAllValue().subtract(products.getValue().multiply(new BigDecimal(oldValue))
                    .setScale(2, RoundingMode.HALF_UP)));

            cart.setAllValue(cart.getAllValue().add(products.getValue().multiply(new BigDecimal(newValue)
                    .setScale(2, RoundingMode.HALF_UP))));

            productInCart.setProducts(products);
            productInCart.setCarts(cart);
            productInCart.setQuantity(productsInCartSetQuantityDto.getQuantity());
           return productInCartRepository.save(productInCart);

        } else if (productsInCartSetQuantityDto.getQuantity() == 0) {
            cart.setAllValue(cart.getAllValue().subtract(products.getValue().multiply(new BigDecimal(oldValue)
                    .setScale(2, RoundingMode.HALF_UP))));

            productInCart.setCarts(cart);
            productInCart.setQuantity(productsInCartSetQuantityDto.getQuantity());
            productInCartRepository.delete(productInCart);

            return null;
        }

        throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Quantity out of bounds");
    }
}
