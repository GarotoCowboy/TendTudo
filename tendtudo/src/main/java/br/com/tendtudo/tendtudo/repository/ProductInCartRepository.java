package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.Cart;
import br.com.tendtudo.tendtudo.models.ProductInCart;
import br.com.tendtudo.tendtudo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {

    ProductInCart deleteByCarts_CartIdAndProducts(Cart cart, Products products);
}
