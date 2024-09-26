package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findCartsByUserIdPeople(Long userId);
}
