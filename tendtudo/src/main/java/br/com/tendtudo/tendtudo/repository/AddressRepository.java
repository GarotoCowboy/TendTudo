package br.com.tendtudo.tendtudo.repository;

import br.com.tendtudo.tendtudo.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
