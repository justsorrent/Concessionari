package it.nttdata.concessionari.repositories;

import it.nttdata.concessionari.model.Dealership;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DealershipRepository extends CrudRepository<Dealership, Long> {

    @Query("select count(distinct region) from Dealership")
    Integer countRegion();
}
