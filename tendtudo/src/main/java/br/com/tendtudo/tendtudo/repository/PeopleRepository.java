package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    Optional<People> findByUsername(String username);
}
