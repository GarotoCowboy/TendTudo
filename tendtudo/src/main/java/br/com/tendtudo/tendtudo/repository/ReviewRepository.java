package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.Review;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
