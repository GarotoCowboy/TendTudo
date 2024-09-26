package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByName(String name);
    List<Products> findByCategory(String category);
    List<Products> findByAmountBetween(BigDecimal min, BigDecimal max);
}
