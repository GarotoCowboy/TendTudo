package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
}
